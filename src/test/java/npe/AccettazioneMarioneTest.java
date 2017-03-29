package npe;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AccettazioneMarioneTest {

    @Autowired
    private TestRestTemplate restTemplate;


    @Test
    public void name() throws Exception {
        String body = restTemplate.getForObject("/marione.html", String.class);
        assertThat(body).contains("Ciao Marione !");
    }
}
