package maciej.gonda.springbootserver.controlers;

import lombok.RequiredArgsConstructor;
import maciej.gonda.springbootserver.DTO.*;
import maciej.gonda.springbootserver.entities.Doctor;
import maciej.gonda.springbootserver.services.VisitService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/visitController")
@RequiredArgsConstructor

public class VisitController {

    private final VisitService visitService;

    @GetMapping("/getAll")
    public ResponseEntity<List<VisitDTO>> getAllVisits(){
        return ResponseEntity.ok().body(visitService.getAllVisit());
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<VisitDTO> getVisitById(@PathVariable(value = "id") Long id){
        return ResponseEntity.ok().body(visitService.findVisitbyID(id));
    }
    @PostMapping("/createVisit")
    public ResponseEntity<VisitDTO> createVisit(@RequestBody VisitCreationByPatinetDTO visitCreationByPatinetDTO, PatientDTO patientDTO, DoctorDTO doctorDTO) throws Exception{
        try {
            VisitDTO response = visitService.createVisit(visitCreationByPatinetDTO, patientDTO, doctorDTO);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception exception){
            return ResponseEntity.status(500).body(new VisitDTO());
        }
    }

}
