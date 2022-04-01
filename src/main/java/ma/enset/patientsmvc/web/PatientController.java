package ma.enset.patientsmvc.web;

import lombok.AllArgsConstructor;
import ma.enset.patientsmvc.repositories.PatientRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
@AllArgsConstructor

public class PatientController {

    private PatientRepository patientRepository;

    @GetMapping (path = "/index")
    public String Patient(){
        return  "patients";
    }


}
