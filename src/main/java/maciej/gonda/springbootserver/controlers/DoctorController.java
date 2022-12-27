package maciej.gonda.springbootserver.controlers;

import lombok.RequiredArgsConstructor;
import maciej.gonda.springbootserver.DTO.DoctorDTO;
import maciej.gonda.springbootserver.services.DoctorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;

@RestController @RequestMapping("/doctorController") @RequiredArgsConstructor
public class DoctorController {
    private final DoctorService doctorService;

    @GetMapping("/getAll")
    public ResponseEntity<List<DoctorDTO>> getAllDoctors(){
        return ResponseEntity
                .ok()
                .body(doctorService.getAllDoctors());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<DoctorDTO> getDoctorById(@PathVariable(value = "id") Long id){
    return ResponseEntity.ok().body(doctorService.findDoctorById(id));
    }
    @GetMapping("/get/{imie}/{nazwisko}")
    public ResponseEntity<DoctorDTO> findPatientByImieAndNazwiskoAndSpecjalizacja(String imie, String nazwisko, String specjalizacja) {
        return ResponseEntity.ok().body(doctorService.findPatientByImieAndNazwiskoAndSpecjalizacja(imie,nazwisko,specjalizacja));
    }



}
