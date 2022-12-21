package maciej.gonda.springbootserver.services;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import maciej.gonda.springbootserver.DTO.PatientCreationDTO;
import maciej.gonda.springbootserver.DTO.PatientDTO;
import maciej.gonda.springbootserver.DTO.UserDTO;
import maciej.gonda.springbootserver.entities.Patient;
import maciej.gonda.springbootserver.entities.Role;
import maciej.gonda.springbootserver.entities.User;
import maciej.gonda.springbootserver.repositories.PatientRepo;
import maciej.gonda.springbootserver.repositories.RoleRepo;
import maciej.gonda.springbootserver.repositories.UserRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class UserService {

    @Autowired
    private ModelMapper modelMapper;
}
