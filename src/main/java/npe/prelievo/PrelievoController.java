package npe.prelievo;

import npe.modello.Ciclista;
import npe.modello.CiclistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Date;
import java.util.Map;

@Controller
public class PrelievoController {
    @Autowired
    private CiclistaRepository ciclistaRepository;

    @GetMapping("/")
    public String welcome(Map<String, Object> model) {
        model.put("time", new Date());
        model.put("operatore", "Marione");
        return "nuovo-prelievo";
    }

    @PostMapping("/nuovo-prelievo.html")
    public String salvaNuovoPrelievo(Ciclista ciclista, Map<String, Object> model) {
        try {
            ciclistaRepository.save(ciclista);
            model.put("risultato-operazione-precedente", "successo");
        } catch (Exception e) {
            model.put("risultato-operazione-precedente", "fallimento: " + e.getMessage());
        }

        return welcome(model);
    }
}
