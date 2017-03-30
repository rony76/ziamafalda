package npe.prelievo;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class PrelievoControllerTest {
    @Test
    public void qualsiasi() throws Exception {
        PrelievoController controller = new PrelievoController();
        Map<String, Object> model = new HashMap<>();
        String nomeVista = controller.index(model);

        assertThat(nomeVista, is("index"));
    }
}