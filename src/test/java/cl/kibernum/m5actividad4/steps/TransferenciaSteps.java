package cl.kibernum.m5actividad4.steps;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import cl.kibernum.m5actividad4.pages.FormularioTransferenciaPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TransferenciaSteps {
    
    private WebDriver driver;
    private FormularioTransferenciaPage formularioTransferenciaPage;

  @Before
    public void setUp() {
    WebDriverManager.chromedriver().clearDriverCache().setup();
    ChromeOptions options = new ChromeOptions();
    driver = new ChromeDriver(options);
    formularioTransferenciaPage = new FormularioTransferenciaPage(driver);
  }

  @After
  public void tearDown() {
    if(driver != null) driver.quit();
  }


  @Given("que el usuario ha iniciado sesión")
  public void que_el_usuario_accede_al_formulario_de_pago() {
    formularioTransferenciaPage.navigateTo();
  }

  // (\\d+|-\\d+) sirve para capturar un numero positivo (\\d+), negativo (-\\d+)
  @When("transfiere {double} a la cuenta {string}")
  public void ingresa_el_monto_y_destino(double monto, String destino) {
    formularioTransferenciaPage.transferir(monto, destino);
  }

  @Then("debería ver el mensaje {string}")
  public void el_sistema_deberia_mostrar_el_mensaje(String mensajeEsperado) {
    String mensajeReal = formularioTransferenciaPage.obtenerMensajeTransferencia();
    assertTrue(mensajeReal.contains(mensajeEsperado), "EL mensaje real no contiene el esperado, Esperado: '" + mensajeEsperado + "', Real: '" + mensajeReal + "'");
  }

}
