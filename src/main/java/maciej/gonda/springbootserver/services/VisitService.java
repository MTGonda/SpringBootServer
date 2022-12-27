package maciej.gonda.springbootserver.services;


import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import maciej.gonda.springbootserver.DTO.*;
import maciej.gonda.springbootserver.entities.*;
import maciej.gonda.springbootserver.repositories.DoctorRepo;
import maciej.gonda.springbootserver.repositories.PatientRepo;
import maciej.gonda.springbootserver.repositories.VisitRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
//    public VisitDTO createVisit(VisitCreationByPatientDTO vcbd, PatientDTO patientDTO, DoctorDTO doctorDTO, SpecializationDTO specializationDTO) {
//        Patient patient = patientRepo.findPatientByPesel(patientDTO.getPesel()).get();
//
//        if(patient==null){
//           return null;}
//
//
//
//        Doctor doctor = doctorRepo.findByImieAndNazwiskoAndSpecializations(doctorDTO.getImie(),doctorDTO.getNazwisko(),).get();
//        if(doctor == null){
//        return null;}
//
//        Visit visitDoctorCheck = visitRepo.findByDatawizytyAndGodzinawizytyAndDoctor(vcbd.getDatawizyty(),vcbd.getGodzinawizyty(),doctor).get();
//
//        if (visitDoctorCheck == null) {
//            return null;
//        }
//
//        if(visitDoctorCheck.getPatient() !=null)
//            return null;
//        Visit visit1 = visitRepo.findByDatawizytyAndGodzinawizytyAndPatient(vcbd.getDatawizyty(),vcbd.getGodzinawizyty(),patient).get();
//        if(visit1 !=null)
//            return null;
//        visitDoctorCheck.setPatient(patient);
//        visitRepo.save(visitDoctorCheck);
//
//        return modelMapper.map(patient,VisitDTO.class);



      /*  if(doctorRepo.findByImieAndNazwiskoAndSpecializations(doctorDTO.getImie(),doctorDTO.getNazwisko(),doctorDTO.getSpecializations()).isEmpty()) {
            throw new Exception("Doktor o imieniu: " + doctorDTO.getImie() + " nazwisku: " + doctorDTO.getNazwisko() + " i specjaliacji: " + doctorDTO.getSpecializations());
        }

            Doctor doctor = doctorRepo.findByImieAndNazwiskoAndSpecializations(vcbd.getDoctor().getImie(),vcbd.getDoctor().getNazwisko(),vcbd.getDoctor().getSpecializations()).get();



        if(visitRepo.findByDatawizyty(vcbd.getDatawizyty()).isPresent()){
        throw new Exception("Termin wizyty: " + vcbd.getDatawizyty() + " jest zajęty");
        }
            Visit visit = visitRepo.findByDatawizyty(vcbd.getDatawizyty()).get();


            Visit newVisit = new Visit(null,visit,null,null,1,150,null,doctor,new Raport(),patient,new TypeOfVisit());

            Visit visit1 = visitRepo.save(newVisit);
*/

//    }


    }


