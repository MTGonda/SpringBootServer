package maciej.gonda.springbootserver.controlers;

import lombok.RequiredArgsConstructor;
import maciej.gonda.springbootserver.DTO.*;
import maciej.gonda.springbootserver.services.VisitService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/visitController")
@RequiredArgsConstructor

public class VisitController {

    private final VisitService visitService;
    private final ModelMapper modelMapper;

    @GetMapping("/getAll")
    public ResponseEntity<List<VisitDTO>> getAllVisits(){
        return ResponseEntity.ok().body(visitService.getAllVisit());
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<VisitDTO> getVisitById(@PathVariable(value = "id") Long id){
        return ResponseEntity.ok().body(visitService.findVisitbyID(id));
    }
    @PostMapping("/createVisitReservation")
    public ResponseEntity<VisitDTO> createVisitReservation(@RequestBody VisitCreationByPatientDTO visitCreationByPatientDTO)
    { //VisitDTO response = visitService.createVisitReservation(visitCreationByPatientDTO);
        String response = visitService.createVisitReservation(visitCreationByPatientDTO);
        if (response!=null)
            return new ResponseEntity<>(new VisitDTO(), HttpStatus.OK);
        else
            return ResponseEntity.status(500).body(new VisitDTO());
    }
    @PostMapping("/createRaport")
    public ResponseEntity<RaportDTO> createRaport(@RequestBody CreateRaportFromVisitDTO createRaportFromVisitDTO){
        String response = visitService.createRaport(createRaportFromVisitDTO);
        if(response != null)
            return new ResponseEntity<>(modelMapper.map(response,RaportDTO.class), HttpStatus.OK);
        else
            return ResponseEntity.status(500).body(new RaportDTO());
    }

}
