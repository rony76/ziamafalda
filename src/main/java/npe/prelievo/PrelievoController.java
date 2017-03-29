package npe.prelievo;

import npe.modello.Ciclista;
import npe.modello.CiclistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
    public String inserisci(Map<String, Object> model) {
        model.put("time", new Date());
        model.put("operatore", "Marione");
        return "marione";
    }

    @PostMapping("/marione-inserisci.html")
    public String salvaNuovoPrelievo(Ciclista ciclista, Map<String, Object> model) {
        try {
            ciclistaRepository.save(ciclista);
            return "redirect:marione-visualizza.html#visualizza";
        } catch (Exception e) {
            model.put("risultatoOperazionePrecedente", "fallimento: " + e.getMessage());
            return inserisci(model);
        }
    }

    @GetMapping("/marione-visualizza.html")
    public String visualizza(Map<String, Object> model) {
        return "visualizza";
    }
}
