package cl.kibernum.m5actividad4.steps;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import cl.kibernum.m5actividad4.pages.FormularioUsuarioPage;
import dev.failsafe.internal.util.Assert;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DatosUsuarioSteps {

    private WebDriver driver;
    private FormularioUsuarioPage formularioUsuarioPage;
    
    @Before
    public void setUp() {
        WebDriverManager.chromedriver().clearDriverCache().setup();
        ChromeOptions options = new ChromeOptions();
        //options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        formularioUsuarioPage = new FormularioUsuarioPage(driver);
    }

    @After
    public void tearDown() {
        if (driver != null) driver.quit(); {    
        }
    }

    @Given("que el usuario está en el formulario de completar datos")
    public void queElUsuarioAccedeAlFormularioDeDatos() {
        formularioUsuarioPage.ingresoSitioWebDatos();
    }

    @When("completa los siguientes datos:")
    public void completarDatos(DataTable dataTable) {
        
        Map<String, String> datos = dataTable.asMap(String.class, String.class);
        
        for (Map.Entry<String, String> entry : datos.entrySet()) {
            // Imprime en consola el campo y valor
            
            switch (entry.getKey()) {
                case "nombre":
                    System.out.println("Desde Mapa: " + entry.getValue());
                    System.out.println("Desde Pagina: " + formularioUsuarioPage.obtenerValorCampo("1"));
                    assertEquals(entry.getValue(), formularioUsuarioPage.obtenerValorCampo("1"), "Valores no coindicen");
                    break;
                case "apellido":
                    System.out.println("Desde Mapa: " + entry.getValue());
                    System.out.println("Desde Pagina: " + formularioUsuarioPage.obtenerValorCampo("1"));
                    assertEquals(entry.getValue(), formularioUsuarioPage.obtenerValorCampo("2"), "Valores no coindicen");
                    break;
                case "email":
                    System.out.println("Desde Mapa: " + entry.getValue());
                    System.out.println("Desde Pagina: " + formularioUsuarioPage.obtenerValorCampo("1"));
                    assertEquals(entry.getValue(), formularioUsuarioPage.obtenerValorCampo("3"), "Valores no coindicen");
                    break;
                case "edad":
                    System.out.println("Desde Mapa: " + entry.getValue());
                    System.out.println("Desde Pagina: " + formularioUsuarioPage.obtenerValorCampo("1"));
                    assertEquals(entry.getValue(), formularioUsuarioPage.obtenerValorCampo("4") , "Valores no coindicen");
                    break;
            }
        }
        
    }


    
}
