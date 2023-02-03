package maciej.gonda.springbootserver.services;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import maciej.gonda.springbootserver.DTO.*;
import maciej.gonda.springbootserver.entities.*;
import maciej.gonda.springbootserver.repositories.DoctorRepo;
import maciej.gonda.springbootserver.repositories.PatientRepo;
import maciej.gonda.springbootserver.repositories.RaportRepo;
import maciej.gonda.springbootserver.repositories.VisitRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.sql.Time;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class VisitService {

    @Autowired
    private ModelMapper modelMapper;
    private final VisitRepo visitRepo;
    private final DoctorRepo doctorRepo;
    private final PatientRepo patientRepo;
    private final RaportRepo raportRepo;

    //pomocniczy kod
    public List<VisitDTO> getAllVisit(){
        List<Visit> visits= visitRepo.findAll();
        List<VisitDTO> visitsDTO=  Arrays.asList(modelMapper.map(visits, VisitDTO[].class));
        int i=0;
        for(Visit visit: visits)
        {
            if(visit.getPatient()!=null)
                visitsDTO.get(i).setPeselPacjenta(visit.getPatient().getPesel());
            visitsDTO.get(i).setNumerLekarza(visit.getDoctor().getNumer());
            i++;
        }
        return visitsDTO;
    }
    public VisitDTO findVisitbyID(Long id){
        Optional< Visit> databaseResult = visitRepo.findById(id);
        if ((databaseResult.isEmpty())){
            return null;
        }
        return modelMapper.map(databaseResult.get(), VisitDTO.class);
    }
    //koniec pomocniczego kodu
    public String createVisitReservation(VisitCreationByPatientDTO vcbd) {
        Patient patient = patientRepo.findPatientByPesel(vcbd.getPatientPESEL()).get();
        if (patient == null)                                     return "Wynik - Brak pacjenta";
        Time startNowejWizyty=vcbd.getGodzinawizyty();
        Time koniecNowejWizyty=vcbd.getKoniecwizyty();
        Collection<Visit> wizytyPacjenta=patient.getVisits();//lepsze rozwiązanie
        System.out.println("  Wizyty pobrane od wyszukanego pacjenta: "+wizytyPacjenta.toString());
        Collection<Visit> wizytyPacjenta1 = visitRepo.findAllByPatientAndDatawizyty(patient,vcbd.getDatawizyty());//niepotrzebna strata czasu
        System.out.println("  Wizyty pacjenta wyszukane w bazie danych: "+wizytyPacjenta1.toString());
        //przeglądanie wizyt pobranych od wyszukanego pacjenta
        Visit patientReservedVisit=null;
        for(Visit v: wizytyPacjenta){
            Time startWizyty = v.getStartwizyty();
            Time koniecWizyty = v.getKoniecwizyty();
            //p1 <k   i    p1>=p  lub    k1>p   i   k1=<k - brak spełnienia tego warunki oznacza, że pacjent jest zajęty
            if(!((koniecNowejWizyty.before(startWizyty))||(startNowejWizyty.after(koniecWizyty))))
            {  patientReservedVisit=v;
                break; }
        }
        if(patientReservedVisit!=null)                            return "Wynik - Pacjent jest zajety";

        Visit doctorReservedVisit=null;
        Doctor doctor = doctorRepo.findByNumerAndSpecjalizacja(vcbd.getNumerLekarza(), vcbd.getSpecjalizacjaLekarza()).get();
        if (doctor == null)                                       return "Wynik - Brak lekarza";
        Collection<Visit> wizytyLekarza = doctor.getVisits(); //lepsze rozwiązanie
        System.out.println("  Wizyty pobrane od wyszukanego lekarza "+wizytyLekarza);
        Collection<Visit> wizytyLekarza1 = visitRepo.findAllByDoctorAndDatawizyty(doctor, vcbd.getDatawizyty());//niepotrzebna strata czasu
        System.out.println("  Wizyty lekarza pobrane z bazy danych"+wizytyLekarza1);
        //przeglądanie wizyt pobranych od wyszukanego pacjenta
        //czas rozpoczęcia wizyty i jej zakończenia musi być identyczny, jak terminy wizyt danego lekarza
        for(Visit v: wizytyLekarza){
            Time startWizyty = v.getStartwizyty();
            Time koniecWizyty = v.getKoniecwizyty();
            if((startNowejWizyty.equals(startWizyty) && koniecNowejWizyty.equals(koniecWizyty))){
                doctorReservedVisit=v;
                break; }
        }
        if(doctorReservedVisit==null)                             return "Wynik - Brak wizyty u lekarza ";
        else
        if (doctorReservedVisit.getPatient()!=null)           return "Wynik - Wizyta lekarza zajeta";
        doctorReservedVisit.setPatient(patient);
        Visit result = visitRepo.save(doctorReservedVisit);
        return "Wynik - Wizyta zarezerwowana";
    }

    public String createRaport(CreateRaportFromVisitDTO createRaportFromVisitDTO){
        if(createRaportFromVisitDTO.getVisitCreationByPatientDTO()==null) return "brak wizyty pacjenta";
        Doctor doctor = doctorRepo.findByNumerAndSpecjalizacja(createRaportFromVisitDTO.getVisitCreationByPatientDTO().getNumerLekarza(),
                createRaportFromVisitDTO.getVisitCreationByPatientDTO().getSpecjalizacjaLekarza()).get();
        if(doctor==null) {
            return "";
        }

        Collection<Visit> doctorVisit = doctor.getVisits();
        Time startodbywanejwizyty = createRaportFromVisitDTO.getVisitCreationByPatientDTO().getGodzinawizyty();
        Time koniecodbywanejwizyty = createRaportFromVisitDTO.getVisitCreationByPatientDTO().getKoniecwizyty();

        Visit doctorReservedVisit=null;
        for(Visit visit: doctorVisit){
            Time startwizyty = visit.getStartwizyty();
            Time koniecwizyty = visit.getKoniecwizyty();
            if((startodbywanejwizyty.equals(startwizyty) && koniecodbywanejwizyty.equals(koniecwizyty))){
                doctorReservedVisit=visit;
                break; }
        }
        if(doctorReservedVisit == null){
            return "";
        }
Patient patient = doctorReservedVisit.getPatient();
        if(patient == null){
            return "Brak pacjenta" ; }
        else {
            if(!patient.getPesel().equals(createRaportFromVisitDTO.getVisitCreationByPatientDTO().getPatientPESEL())){
                return "Nie ten pacjent";
            }
        }

        /*Patient patient = patientRepo.findPatientByPesel(createRaportFromVisitDTO.getVisitCreationByPatientDTO().getPatientPESEL()).get();
        if(patient==null)
            return "Brak pacjenta";*/


    /*    Collection<Visit> patientVisit = patient.getVisits();
        Time startwizytypacjenta = createRaportFromVisitDTO.getVisitCreationByPatientDTO().getGodzinawizyty();
        Time koniecwizytypacjenta = createRaportFromVisitDTO.getVisitCreationByPatientDTO().getKoniecwizyty();

        Visit patinetReservedVisit = null;
        for (Visit visit: patientVisit ){
            Time startwizyty = visit.getStartwizyty();
            Time koniecwizyty = visit.getKoniecwizyty();
            if((startwizytypacjenta.equals(startwizyty) && koniecwizytypacjenta.equals(koniecwizyty))){
                patinetReservedVisit=visit;
                break; }
        }
        if (patinetReservedVisit == null){
            return "";
        }*/

        Raport raport = doctorReservedVisit.getRaport();


        if(raport != null){
            raport.setTresc(createRaportFromVisitDTO.getTresc());
            Raport result1 = raportRepo.save(raport);
            System.out.println("Uzupełnienie raportu: "+result1);
            return result1.toString();
        }
        else
        {
            Raport raport1 = new Raport(null,createRaportFromVisitDTO.getTresc(),doctorReservedVisit,patient,doctor);
            Raport result = raportRepo.save(raport1);
            System.out.println("Tworzenie nowego raportu: "+result);
            return result.toString();
        }



      // return  result.toString();

    }
}




       /*     Visit wizytyLekarza = visitRepo.findByDoctorAndDatawizyty(doctor,createRaportFromVisitDTO.getVisitCreationByPatientDTO().getDatawizyty()).get();
        if(wizytyLekarza== null){      return null;    }
        Patient patient = patientRepo.findPatientByPesel(createRaportFromVisitDTO.getVisitCreationByPatientDTO().getPatientPESEL()).get();
        if(patient == null){ return null;  }
        Visit wizytyPacjenta = visitRepo.findByPatientAndDatawizyty(patient,createRaportFromVisitDTO.getVisitCreationByPatientDTO().getDatawizyty()).get();
        if(wizytyPacjenta== null){ return null; }
         */
//     Raport raport = new Raport(null, createRaportFromVisitDTO.getTresc(), wizytyPacjenta,patient,doctor);

//modelMapper.map(result,RaportDTO.class);