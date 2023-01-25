package maciej.gonda.springbootserver.controlers;


import lombok.RequiredArgsConstructor;
import maciej.gonda.springbootserver.DTO.DoctorDTO;
import maciej.gonda.springbootserver.DTO.PatientCreationDTO;
import maciej.gonda.springbootserver.DTO.PatientDTO;
import maciej.gonda.springbootserver.services.PatientService;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController @RequestMapping("/patientController") @RequiredArgsConstructor
public class PatientController {

    private final PatientService patientService;

    @GetMapping("/getAll")
    public ResponseEntity<List<PatientDTO>> getAllPatients(){
        return ResponseEntity.ok().body(patientService.getAllPatients());
    }
    @GetMapping("/get/{id}")
        public ResponseEntity<PatientDTO> getPatientById(@PathVariable(value = "id") Long id){
        return  ResponseEntity.ok().body(patientService.findPatientById(id));
    }
    @GetMapping("/get/{Pesel}")
        public ResponseEntity<PatientDTO> getPatientByPesel(@PathVariable(value = "Pesel")String Pesel){
        return ResponseEntity.ok().body(patientService.findPatientByPesel(Pesel));
    }

    @PostMapping("/create")
        public ResponseEntity<PatientDTO> createPatientCard(@RequestBody PatientCreationDTO patientCreationDTO) {
        try {
            PatientDTO response = patientService.createPatientCard(patientCreationDTO);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception exception){
            return ResponseEntity.status(500).body(new PatientDTO());
        }
    }

}
