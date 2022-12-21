package maciej.gonda.springbootserver.controlers;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import maciej.gonda.springbootserver.DTO.RaportDTO;
import maciej.gonda.springbootserver.services.RaportService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/raportController")
public class RaportController {

    private final RaportService raportService;

    @GetMapping("/getAll")
    public ResponseEntity<List<RaportDTO>> getAllRaports(){
        return ResponseEntity.ok().body(raportService.getAllDoctors());
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<RaportDTO> getDoctorById(@PathVariable(value = "id")Long id){
        return ResponseEntity.ok().body(raportService.findDoctorById(id));
    }
}
