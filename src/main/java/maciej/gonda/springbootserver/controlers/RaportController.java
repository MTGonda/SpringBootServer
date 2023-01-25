package maciej.gonda.springbootserver.controlers;


import lombok.RequiredArgsConstructor;
import maciej.gonda.springbootserver.DTO.RaportDTO;
import maciej.gonda.springbootserver.services.RaportService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/raportController")
public class RaportController {

    private final RaportService raportService;

    @GetMapping("/getAll")
    public ResponseEntity<List<RaportDTO>> getAllRaports(){
        return ResponseEntity.ok().body(raportService.getAllRaports());
    }

}
