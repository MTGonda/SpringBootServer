package maciej.gonda.springbootserver.services;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import maciej.gonda.springbootserver.DTO.DoctorDTO;
import maciej.gonda.springbootserver.DTO.RaportDTO;
import maciej.gonda.springbootserver.entities.Doctor;
import maciej.gonda.springbootserver.entities.Raport;
import maciej.gonda.springbootserver.repositories.DoctorRepo;
import maciej.gonda.springbootserver.repositories.RaportRepo;
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
}
