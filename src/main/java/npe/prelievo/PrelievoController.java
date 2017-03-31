package npe.prelievo;

import npe.modello.Ciclista;
import npe.modello.CiclistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.Date;
import java.util.Map;

@Controller
public class PrelievoController {
    @Autowired
    private CiclistaRepository ciclistaRepository;

    @GetMapping("/")
    public String index(Map<String, Object> model) {
        return "index";
    }

    @GetMapping("/marione-inserisci.html")
    public String inserisci(@ModelAttribute("ciclista") Ciclista ciclista, BindingResult bindingResult, Map<String, Object> model) {
        model.put("time", new Date());
        model.put("operatore", "Marione");
        return "marione";
    }

    @PostMapping("/marione-inserisci.html")
    public String salvaNuovoPrelievo(@Valid @ModelAttribute("ciclista") Ciclista ciclista, BindingResult bindingResult, Map<String, Object> model) {
        if (bindingResult.hasErrors()) {
            return inserisci(ciclista, bindingResult, model);
        }

        try {
            ciclistaRepository.save(ciclista);
            return "redirect:marione-visualizza.html#visualizza";
        } catch (Exception e) {
            model.put("risultatoOperazionePrecedente", "fallimento: " + e.getMessage());
            return inserisci(ciclista, bindingResult, model);
        }
    }

    @GetMapping("/marione-visualizza.html")
    public String visualizza(Map<String, Object> model) {
        model.put("ciclisti", ciclistaRepository.findAll());
        return "visualizza";
    }
}
