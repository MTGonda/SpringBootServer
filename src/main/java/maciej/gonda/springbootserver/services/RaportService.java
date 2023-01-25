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

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class RaportService {
    @Autowired
    private ModelMapper modelMapper;
    private final RaportRepo raportRepo;
    private final PatientRepo patientRepo;
    private final DoctorRepo doctorRepo;
    private final VisitRepo visitRepo;



    public List<RaportDTO> getAllRaports(){
        return raportRepo.findAll().stream().map(raport -> modelMapper.map(raport, RaportDTO.class)).toList();
    }

}
