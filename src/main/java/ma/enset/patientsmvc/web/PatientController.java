package ma.enset.patientsmvc.web;

import lombok.AllArgsConstructor;
import ma.enset.patientsmvc.entities.Patient;
import ma.enset.patientsmvc.repositories.PatientRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
@AllArgsConstructor
public class PatientController {

    private PatientRepository patientRepository;

    @GetMapping(path = "/index")
    public String Patient(Model model,
                          @RequestParam(name = "page", defaultValue = "0") int page,
                          @RequestParam(name = "size", defaultValue = "5") int size,
                          @RequestParam(name = "keyword", defaultValue = "") String keyword) {
        Page<Patient> patientsPages = patientRepository.findPatientsByNomContains(keyword,PageRequest.of(page, size));

        model.addAttribute("patients", patientsPages.getContent());
        model.addAttribute("pages", new int[patientsPages.getTotalPages()]);
        model.addAttribute("currentPage", page);
        model.addAttribute("keyword",keyword);

        return "patients";
    }

    @GetMapping(path = "/delete")
    public String delete(Long id,String keyword,int page){
        patientRepository.deleteById(id);
        return  "redirect:/index?page="+page+"&keyword="+keyword;
    }

    @GetMapping(path = "/")
    public String home(){
        return  "redirect:/index";
    }

    @GetMapping(path = "/patients")
    @ResponseBody
    public List<Patient> patients(){
        return  patientRepository.findAll();
    }


}
