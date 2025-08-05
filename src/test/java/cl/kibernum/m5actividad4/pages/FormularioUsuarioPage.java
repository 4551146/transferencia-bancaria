package cl.kibernum.m5actividad4.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FormularioUsuarioPage {

    private WebDriver driver;
    private WebDriverWait wait;

    //Localizadores

    private By nombreInput = By.id("text");

    private By apellidoInput = By.xpath("//*[@input='text']");

    private By emailInput = By.xpath("//*[@input='email']");

    private By edadInput = By.xpath("//*[@input='number']");

    private By btnDatos = By.id("btn-imprimir-datos");

    private By resultadoDatosText = By.id("resultado-transferencia");

    public FormularioUsuarioPage(WebDriver driver) {
    this.driver = driver;
    this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
  }

  public void ingresoSitioWebDatos() {
    driver.get("https://web-actividad-4.netlify.app/");
   }

   //Métodos de ingreso de datos

    public void ingresoNombre(String nombre){
        WebElement nombreElement = wait.until(ExpectedConditions.elementToBeClickable(nombreInput));
        nombreElement.clear();
        nombreElement.sendKeys(nombre);
   }

   public void ingresoApellido(String apellido){
        WebElement apellidoElement = wait.until(ExpectedConditions.elementToBeClickable(apellidoInput));
        apellidoElement.clear();
        apellidoElement.sendKeys(apellido);
   }

   public void ingresoEmail(String email){
        WebElement emailElement = wait.until(ExpectedConditions.elementToBeClickable(emailInput));
        emailElement.clear();
        emailElement.sendKeys(email);
   }

   public void ingresoEdad(String edad){
        WebElement edadElement = wait.until(ExpectedConditions.elementToBeClickable(edadInput));
        edadElement.clear();
        edadElement.sendKeys(edad);
   }

   public void clickImprimirDatos(){
        WebElement btnDatosElement = wait.until(ExpectedConditions.elementToBeClickable(btnDatos));
        btnDatosElement.click();
   }

   private void ingresarDatosUsuario(String nombre, String apellido, String email, String edad){
        ingresoNombre(nombre);
        ingresoApellido(apellido);
        ingresoEmail(email);
        ingresoEdad(edad);
        clickImprimirDatos();


   }


}
