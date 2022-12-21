package maciej.gonda.springbootserver.services;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import maciej.gonda.springbootserver.DTO.DoctorDTO;
import maciej.gonda.springbootserver.entities.Doctor;
import maciej.gonda.springbootserver.entities.Specialization;
import maciej.gonda.springbootserver.repositories.DoctorRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service @RequiredArgsConstructor @Transactional @Slf4j
public class DoctorService {

    @Autowired
    private ModelMapper modelMapper;
    private final DoctorRepo doctorRepo;


    public List<DoctorDTO> getAllDoctors(){
        return doctorRepo.findAll().stream().map(doctor -> modelMapper.map(doctor, DoctorDTO.class)).toList();
    }

    public DoctorDTO findDoctorById(Long id){
        Optional<Doctor> databaseResult = doctorRepo.findById(id);
        if(databaseResult.isEmpty()){
            return null;
        }
        return modelMapper.map(databaseResult.get(), DoctorDTO.class);
    }
    public DoctorDTO findPatientByImieAndNazwisko(String imie, String nazwisko){
        Optional<Doctor> databaseResult = doctorRepo.findByImieAndNazwisko(imie,nazwisko);
        if (databaseResult.isEmpty()){
            return null;
        }
        return modelMapper.map(databaseResult.get(), DoctorDTO.class);
    }

}
