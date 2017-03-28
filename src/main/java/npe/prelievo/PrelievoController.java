package npe.prelievo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Date;
import java.util.Map;

/**
 * Created by macbookpro on 28/03/17.
 */
@Controller
public class PrelievoController {
    @GetMapping("/")
    public String welcome(Map<String, Object> model) {
        model.put("time", new Date());
        model.put("operatore", "Marione");
        return "nuovo-prelievo";
    }
}
