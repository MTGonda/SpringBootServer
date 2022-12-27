package maciej.gonda.springbootserver.services;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import maciej.gonda.springbootserver.DTO.DoctorDTO;
import maciej.gonda.springbootserver.DTO.PatientCreationDTO;
import maciej.gonda.springbootserver.DTO.PatientDTO;
import maciej.gonda.springbootserver.entities.Doctor;
import maciej.gonda.springbootserver.entities.Patient;
import maciej.gonda.springbootserver.entities.Role;
import maciej.gonda.springbootserver.entities.User;
import maciej.gonda.springbootserver.repositories.PatientRepo;
import maciej.gonda.springbootserver.repositories.RoleRepo;
import maciej.gonda.springbootserver.repositories.UserRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class PatientService {

    @Autowired
    private ModelMapper modelMapper;
    private final PatientRepo patientRepo;
    private final UserRepo userRepo;
    private final RoleRepo roleRepo;


    public List<PatientDTO> getAllPatients() {
        return patientRepo.findAll().stream().map(patient -> modelMapper.map(patient, PatientDTO.class)).toList();
    }

    public PatientDTO findPatientById(Long id) {
        Optional<Patient> databaseResult = patientRepo.findById(id);
        if (databaseResult.isEmpty()) {
            return null;
        }
        return modelMapper.map(databaseResult.get(), PatientDTO.class);
    }

    public PatientDTO findPatientByPesel(String Pesel) {
        Optional<Patient> databaseResult = patientRepo.findPatientByPesel(Pesel);
        if (databaseResult.isEmpty()) {
            return null;
        }
        return modelMapper.map(databaseResult.get(), PatientDTO.class);
        //TODO zastanowić się nad komunikatem który zostanie wyświetlony przy null
        // aby nie było błędu
    }

    public PatientDTO createPatientCard(PatientCreationDTO pcd) {
        if (patientRepo.findPatientByPesel(pcd.getPesel()).isPresent()) {
            return null;
        }
        {

            Role patientRole = roleRepo.findRoleByName("Pacjent").get();
            User newUser = new User(null, pcd.getLogin(), pcd.getPassword(), patientRole);
            User patientUser = userRepo.save(newUser);

            Patient newPatient = new Patient(null, pcd.getImie(), pcd.getNazwisko(), pcd.getNumertelefonu(), pcd.getPesel(),
                    pcd.getDataurodzenia(), null, patientUser, new ArrayList<>(), new ArrayList<>(), new ArrayList<>());

            Patient result = patientRepo.save(newPatient);

            return modelMapper.map(result, PatientDTO.class);
        }

    }
}
