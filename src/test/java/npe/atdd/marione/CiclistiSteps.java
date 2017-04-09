package npe.atdd.marione;

import com.thoughtworks.gauge.Gauge;
import com.thoughtworks.gauge.Step;
import npe.atdd.driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.hamcrest.Matchers.equalToIgnoringCase;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class CiclistiSteps {
    @Step("Vai alla pagina di inserimento ciclisti")
    public void gotoInsertBikerPage() throws InterruptedException {
        WebElement gotoInsertButton = Driver.webDriver.findElement(By.id("inserisci-button"));
        assertThat(gotoInsertButton, is(notNullValue()));
        Gauge.writeMessage("Clicking on '%s'", gotoInsertButton.getText());

        gotoInsertButton.click();
    }

    @Step("Inserisci un nuovo ciclista di nome <nome>, cognome <cognome> e telefono <telefono>")
    public void insertBiker(String nome, String cognome, String telefono) {
        insertIntoTextInput("nome", nome);
        insertIntoTextInput("cognome", cognome);
        insertIntoTextInput("telefono", telefono);

        WebElement submitButton = Driver.webDriver.findElement(By.id("submit-button"));
        assertThat(submitButton, is(notNullValue()));
        submitButton.click();
    }

    private void insertIntoTextInput(String inputId, String newValue) {
        WebElement input = Driver.webDriver.findElement(By.id(inputId));
        assertThat(input, is(notNullValue()));
        assertThat(input.getTagName(), equalToIgnoringCase("input"));
        input.sendKeys(newValue);
    }

    @Step("Verifica che il ciclista di nome <nome> e cognome <cognome> sia nella lista dei ciclisti")
    public void checkBikerExists(String nome, String cognome) {
        List<WebElement> elements = Driver.webDriver.findElements(By.xpath("//table[@id='ciclisti']/tbody/tr"));
        assertTrue(elements.stream().map(Ciclista::fromTr).anyMatch(c ->
                c.getNome().equals(nome) && c.getCognome().equals(cognome)));
    }

    private static class Ciclista {
        private final String nome, cognome, telefono;

        private Ciclista(String nome, String cognome, String telefono) {
            this.nome = nome;
            this.cognome = cognome;
            this.telefono = telefono;
        }

        public static Ciclista fromTr(WebElement tr) {
            List<WebElement> tds = tr.findElements(By.tagName("td"));
            assertThat(tds.size(), is(3));
            return new Ciclista(tds.get(0).getText(), tds.get(1).getText(), tds.get(2).getText());
        }

        public String getNome() {
            return nome;
        }

        public String getCognome() {
            return cognome;
        }

        public String getTelefono() {
            return telefono;
        }
    }
}
