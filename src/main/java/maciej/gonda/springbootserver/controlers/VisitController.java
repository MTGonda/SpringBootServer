package maciej.gonda.springbootserver.controlers;

import lombok.RequiredArgsConstructor;
import maciej.gonda.springbootserver.DTO.*;
import maciej.gonda.springbootserver.services.VisitService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.sql.Time;
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
    public ResponseEntity<String> createVisitReservation(@RequestBody VisitCreationByPatientDTO visitCreationByPatientDTO)
    { //VisitDTO response = visitService.createVisitReservation(visitCreationByPatientDTO);
        String response = visitService.createVisitReservation(visitCreationByPatientDTO);
        if (response!=null)
            return new ResponseEntity<>(response, HttpStatus.OK);
        else
            return ResponseEntity.status(500).body("");
    }
    @PostMapping("/createRaport")
    public ResponseEntity<String> createRaport(@RequestBody CreateRaportFromVisitDTO createRaportFromVisitDTO){
        String response = visitService.createRaport(createRaportFromVisitDTO);
        if(response != null) {
            System.out.println("RaportController");
            return new ResponseEntity<String>(response, HttpStatus.OK);
        }
        else
            return ResponseEntity.status(500).body("");
    }


    // metoda testowa do sprawdzenia formatu danych
    @GetMapping("/result")
        public CreateRaportFromVisitDTO createRaportFromVisitDTOResponseEntity(){
        String tr="mmmmmmmmmmm";
        CreateRaportFromVisitDTO createRaportFromVisitDTO = new CreateRaportFromVisitDTO();
        VisitCreationByPatientDTO visitCreationByPatientDTO = new VisitCreationByPatientDTO(new Date(1673478000000L),new Time(16,00,00),new Time(17,00,00),"Badanie","99040145523","1","Alergolog");
        createRaportFromVisitDTO.setVisitCreationByPatientDTO(visitCreationByPatientDTO);
        createRaportFromVisitDTO.setTresc(tr);
        return createRaportFromVisitDTO;
    }

}
