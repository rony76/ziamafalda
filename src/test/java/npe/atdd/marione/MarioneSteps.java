package npe.atdd.marione;

import com.thoughtworks.gauge.Gauge;
import com.thoughtworks.gauge.Step;
import npe.atdd.driver.Driver;

import static org.junit.Assert.assertTrue;

public class MarioneSteps {
    @Step("Vai alla pagina di amministrazione per Marione")
    public void openMarioneHome() {
        String baseURL = System.getenv("atdd.app.base.url");
        String marionePath = System.getenv("atdd.admin.path");
        Driver.webDriver.get(baseURL + marionePath);

        Gauge.writeMessage("Title of the admin page is %s", Driver.webDriver.getTitle());

        assertTrue(Driver.webDriver.getTitle().contains("Zia Mafalda"));
    }

}
