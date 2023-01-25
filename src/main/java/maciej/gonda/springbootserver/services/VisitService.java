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


import javax.print.Doc;
import java.sql.Time;
import java.util.ArrayList;
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


    public List<VisitDTO> getAllVisit(){
        return visitRepo.findAll().stream().map(visit -> modelMapper.map(visit, VisitDTO.class)).toList();
    }

    public VisitDTO findVisitbyID(Long id){
        Optional< Visit> databaseResult = visitRepo.findById(id);
        if ((databaseResult.isEmpty())){
            return null;
        }
        return modelMapper.map(databaseResult.get(), VisitDTO.class);
    }
    /*
       public String createVisitReservation(VisitCreationByPatientDTO vcbd) {

           Patient patient = patientRepo.findPatientByPesel(vcbd.getPatientPESEL()).get();
           if (patient == null) return "Wynik - Brak pacjenta";
           Time startNowejWizyty=vcbd.getGodzinawizyty();
           Time koniecNowejWizyty=vcbd.getKoniecwizyty();
           Collection<Visit> wizytyPacjenta=patient.getVisits();//lepsze rozwiązanie

           System.out.println(" Wizyty pobrane od wyszukanego pacjenta: "+wizytyPacjenta.toString());
                   Collection<Visit> wizytyPacjenta1 = visitRepo.findAllByPatientAndDatawizyty(patient,
                           vcbd.getDatawizyty());//niepotrzebna strata czasu

           System.out.println(" Wizyty pacjenta wyszukane w bazie danych: "
                   +wizytyPacjenta1.toString());
   //przeglądanie wizyt pobranych od wyszukanego pacjenta

           Visit patientReservedVisit=null;
           for(Visit v: wizytyPacjenta){
               Time startWizyty = v.getStartwizyty();
               Time koniecWizyty = v.getKoniecwizyty();
   //p1<k i p1>=p lub k1>p i k1=<k - brak spełnienia tego warunki oznacza, że pacjent jest zajęty
               if(!((koniecNowejWizyty.before(startWizyty))||(startNowejWizyty.after(koniecWizyty))))
               { patientReservedVisit=v;
                   break; }
           }
           if(patientReservedVisit!=null) return "Wynik - Pacjent jest zajety";
           Visit doctorReservedVisit=null;
           Doctor doctor = doctorRepo.findByNumerAndSpecjalizacja(vcbd.getNumerlekarza(), vcbd.getSpecjalizacjaLekarza()).get();
   
           if (doctor == null) return "Wynik - Brak lekarza";
           Collection<Visit> wizytyLekarza = doctor.getVisits(); //lepsze rozwiązanie

           System.out.println(" Wizyty pobrane od wyszukanego lekarza "+wizytyLekarza);

           Collection<Visit> wizytyLekarza1 = visitRepo.findAllByDoctorAndDatawizyty(doctor,
                   vcbd.getDatawizyty());//niepotrzebna strata czasu

           System.out.println(" Wizyty lekarza pobrane z bazy danych"+wizytyLekarza1);
   //przeglądanie wizyt pobranych od wyszukanego pacjenta
   //czas rozpoczęcia wizyty i jej zakończenia musi być taki sam, jak termin wizyty lekarza

           for(Visit v: wizytyLekarza){
               Time startWizyty = v.getStartwizyty();
               Time koniecWizyty = v.getKoniecwizyty();
               if((startNowejWizyty.equals(startWizyty) && koniecNowejWizyty.equals(koniecWizyty))){
                   doctorReservedVisit=v;
                   break; }
           }
           if(doctorReservedVisit==null) return "Wynik - Brak wizyty u lekarza ";
           else
           if (doctorReservedVisit.getPatient()!=null) return "Wynik - Wizyta lekarza zajeta";
           doctorReservedVisit.setPatient(patient);
           Visit result = visitRepo.save(doctorReservedVisit);
           return modelMapper.map(result,VisitDTO.class).toString();
       }





       public VisitDTO visitReservation(VisitCreationByPatientDTO vcbd) {
           Patient patient = patientRepo.findPatientByPesel(vcbd.getPatientPESEL()).get();
           if (patient == null) {
               return null;
           }

           Time startNowejWizyty=vcbd.getGodzinawizyty();
           Time koniecNowejWizyty=vcbd.getKoniecwizyty();

           Collection<Visit> wizytyPacjenta = visitRepo.findAllByPatientAndDatawizyty(patient,vcbd.getDatawizyty());
           for(Visit v: wizytyPacjenta){
               Time startWizyty = v.getStartwizyty();
               Time koniecWizyty = v.getKoniecwizyty();
               if(startWizyty.before(koniecNowejWizyty) && startNowejWizyty.before(koniecWizyty)){
                   return null;
               }
               if(startNowejWizyty.after(koniecNowejWizyty)){
                   return null;
               }
           }


           Doctor doctor = doctorRepo.findByImieAndNazwiskoAndSpecjalizacja(vcbd.getImieLekarza(), vcbd.getNazwiskoLekarza(), vcbd.getSpecjalizacjaLekarza()).get();
           if (doctor == null) {
               return null;
           }

           Collection<Visit> wizytyLekarza = visitRepo.findAllByDoctorAndDatawizyty(doctor, vcbd.getDatawizyty());
           for(Visit v: wizytyLekarza){
               Time startWizyty = v.getStartwizyty();
               Time koniecWizyty = v.getKoniecwizyty();
               if(startWizyty.before(koniecNowejWizyty) && startNowejWizyty.before(koniecWizyty)){
                   return null;
               }
               if(startNowejWizyty.after(koniecNowejWizyty)){
                   return null;
               }
           }


           Visit visit = new Visit(null, vcbd.getDatawizyty(), vcbd.getGodzinawizyty(), vcbd.getKoniecwizyty(), vcbd.getRodzajwizyty(), "...", doctor, null, patient, null);
           Visit result = visitRepo.save(visit);
           return modelMapper.map(result, VisitDTO.class);

       }

    public RaportDTO createRaport(CreateRaportFromVisitDTO createRaportFromVisitDTO){

        Doctor doctor = doctorRepo.findByImieAndNazwiskoAndSpecjalizacja(createRaportFromVisitDTO.getImieLekarzaprowadzacego()
                ,createRaportFromVisitDTO.getNazwiskoLekarzaprowadzacego()
                , createRaportFromVisitDTO.getSpecjalizacjaLekarzaprowadzacego()).get();







        Visit wizytyLekarza = visitRepo.findByDoctorAndDatawizyty(doctor,createRaportFromVisitDTO.getDataodbywanejwizyty()).get();
        if(wizytyLekarza== null){
            return null;
        }

        Patient patient = patientRepo.findPatientByPesel(createRaportFromVisitDTO.getNumerpatientPESEL()).get();
        if(patient == null){
            return null;

        }
        Visit wizytyPacjenta = visitRepo.findByPatientAndDatawizyty(patient,createRaportFromVisitDTO.getDataodbywanejwizyty()).get();

        if(wizytyPacjenta== null){
            return null;
        }


        Raport raport = new Raport(null, createRaportFromVisitDTO.getTresc(), wizytyPacjenta,patient,doctor);
        Raport result = raportRepo.save(raport);
        return modelMapper.map(result,RaportDTO.class);


    }*/
}

