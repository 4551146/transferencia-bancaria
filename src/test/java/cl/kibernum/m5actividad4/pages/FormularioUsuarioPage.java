package cl.kibernum.m5actividad4.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FormularioUsuarioPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public FormularioUsuarioPage(WebDriver driver) {
    this.driver = driver;
    this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
  }

  public void ingresoSitioWebDatos() {
    driver.get("https://web-actividad-4.netlify.app/");
   }

   //Métodos de ingreso de datos

   public String obtenerValorCampo(String valor){
     By xpath = By.xpath("(//tbody[@id=\"tabla-datos\"]//input)[" + valor + "]");
     WebElement element = driver.findElement(xpath);
     return element.getAttribute("value");
   }

}
