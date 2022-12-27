package maciej.gonda.springbootserver.services;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import maciej.gonda.springbootserver.DTO.SpecializationDTO;
import maciej.gonda.springbootserver.entities.Doctor;
import maciej.gonda.springbootserver.entities.Specialization;
import maciej.gonda.springbootserver.repositories.DoctorRepo;
import maciej.gonda.springbootserver.repositories.SpecializationRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class SpecializationService {
    @Autowired
    private ModelMapper modelMapper;
    private final DoctorRepo doctorRepo;
    private final SpecializationRepo specializationRepo;


    public SpecializationDTO findSpecializationByNazwa(String nazwa){
        Optional<Specialization> temp = specializationRepo.findSpecializationByNazwa(nazwa);
        if(temp.isEmpty()){
            return null;
        } else return modelMapper.map(temp.get(), SpecializationDTO.class);
    }

    public SpecializationDTO addSpecializationToDoctor(String imie, String nazwisko, String nazwaSpecjalizacji){
        Optional<Doctor> tempDoc = doctorRepo.findByImieAndNazwisko(imie,nazwisko);
        if(tempDoc.isEmpty()){
            return null;
        }

        Optional<Specialization> tempSpec = specializationRepo.findSpecializationByNazwa(nazwaSpecjalizacji);
        if(tempSpec.isEmpty()){
            return null;
        }

        Doctor doctor = tempDoc.get();
        Collection<Specialization> specializacje = doctor.getSpecializations();
        specializacje.add(tempSpec.get());
        return modelMapper.map(tempSpec.get(), SpecializationDTO.class);
    }

}
