package maciej.gonda.springbootserver.services;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import maciej.gonda.springbootserver.DTO.*;
import maciej.gonda.springbootserver.entities.Doctor;
import maciej.gonda.springbootserver.entities.Patient;
import maciej.gonda.springbootserver.entities.Raport;
import maciej.gonda.springbootserver.entities.Visit;
import maciej.gonda.springbootserver.repositories.DoctorRepo;
import maciej.gonda.springbootserver.repositories.PatientRepo;
import maciej.gonda.springbootserver.repositories.RaportRepo;
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
public class RaportService {
    @Autowired
    private ModelMapper modelMapper;
    private final RaportRepo raportRepo;
    private final DoctorRepo doctorRepo;
    private final PatientRepo patientRepo;
    private final VisitRepo visitRepo;


    public List<RaportDTO> getAllDoctors(){
        return raportRepo.findAll().stream().map(raport -> modelMapper.map(raport, RaportDTO.class)).toList();
    }

    public RaportDTO findDoctorById(Long id){
        Optional<Raport> databaseResult = raportRepo.findById(id);
        if(databaseResult.isEmpty()){
            return null;
        }
        return modelMapper.map(databaseResult.get(), RaportDTO.class);
    }

//    public RaportDTO takeVisit(VisitTakePlaceDTO visitTakePlaceDTO, PatientDTO patientDTO, DoctorDTO doctorDTO, VisitDTO visitDTO){
//
//        Doctor doctorInCharge = doctorRepo.findByImieAndNazwiskoAndSpecializations(doctorDTO.getImie(),doctorDTO.getNazwisko()).get();
//        if(doctorInCharge == null){
//            return null;
//        }
//
//        Visit visitCheck = visitRepo.findByDatawizytyAndGodzinawizytyAndDoctor(visitTakePlaceDTO.getDatawizyty(),visitTakePlaceDTO.getGodzinawizyty(),doctorInCharge).get();
//        if (visitCheck == null){
//            return null;
//        }
//        Patient patient = patientRepo.findPatientByPesel(patientDTO.getPesel()).get();
//        if (patient == null){
//            return null;
//        }
//        Visit visitPatientCheck = visitRepo.findByDatawizytyAndGodzinawizytyAndPatient(visitTakePlaceDTO.getDatawizyty(),visitTakePlaceDTO.getGodzinawizyty(),patient).get();
//        if(visitPatientCheck == null){
//            return null;
//        }
//        Raport raport = raportRepo
//
//
//    }




}
