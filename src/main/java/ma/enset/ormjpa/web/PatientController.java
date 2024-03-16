package ma.enset.ormjpa.web;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import ma.enset.ormjpa.entities.Patient;
import ma.enset.ormjpa.repository.PatientRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

// pour qu'il soit un spring mvc
@Controller
@AllArgsConstructor
public class PatientController {
    private PatientRepository patientRepository;

    // pour le tester on va utiliser le lien suivant: http://localhost:8085/index?page=0&size=3
    @GetMapping("/user/index")
    public String index(Model model,
                        @RequestParam(name = "page",defaultValue = "0") int page,
                        @RequestParam(name = "size",defaultValue = "5")int size,
                        @RequestParam(name = "keyword",defaultValue = "")String mc) {
        //affichage seuelement 5 patients
        //On utilise la pagination
        Page<Patient> pagePatient = patientRepository.findByNomContains(mc, PageRequest.of(page, size));

        //stocker les patients dans le model
        model.addAttribute("patients", pagePatient.getContent());
        // getTotalPages() return le nombre total des pages
        //pour stocker le nombre des  pages
        model.addAttribute("pages", new int[pagePatient.getTotalPages()]);
        model.addAttribute("currentPage", page);
        model.addAttribute("keyword", mc);
        return "patients";
    }
    @GetMapping("/admin/delete")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String supprimer(Long id, String keyword, int page) {
        patientRepository.deleteById(id);
        return "redirect:/user/index?page="+page+"&keyword="+keyword;
    }

    @GetMapping("/")
    public String home() {
        return "redirect:/user/index";
    }

    
    @GetMapping("/patients")
    @ResponseBody
    public List<Patient> lispatients() {
        return patientRepository.findAll();
    }

    @GetMapping("/admin/formPatients")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String formPatient(Model model) {
        model.addAttribute("patient", new Patient());
        return "formPatients";
    }

    @PostMapping(path="/admin/save")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String save(Model model, @Valid Patient patient, BindingResult bindingResult,
                       @RequestParam(defaultValue = "0") int page,
                       @RequestParam(defaultValue = "") String keyword) {
        // il va faire la validation, s'il y a une erreur il va le stocker dans binfingResult
        if (bindingResult.hasErrors()) return "formPatients";
        patientRepository.save(patient);
        return "redirect:/user/index?page="+page+"&keyword="+keyword;
    }

    @GetMapping("/admin/editPatient")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String editPatient(Model model,Long id, String keyword, int page) {
        Patient p = patientRepository.findById(id).orElse(null);
        if (p == null) throw new RuntimeException("Patient not found");
        model.addAttribute("patient", p);
        model.addAttribute("page", page);
        model.addAttribute("keyword", keyword);

        return "editPatient";
    }

}
