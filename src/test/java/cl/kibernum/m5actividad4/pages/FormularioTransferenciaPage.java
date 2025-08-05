package cl.kibernum.m5actividad4.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FormularioTransferenciaPage {

  private WebDriver driver;
  private WebDriverWait wait;

  // Localizadores

  //Transferencia
  private By montoInput = By.id("monto");

  private By destinoInput = By.id("cuenta");
 
  private By btnTransferir = By.xpath("//button[contains(text(), 'Enviar transferencia')]");

  private By resultadoTransferenciaText = By.id("resultado-transferencia");

  public FormularioTransferenciaPage(WebDriver driver) {
    this.driver = driver;
    this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
  }

  public void navigateTo() {
    driver.get("https://web-actividad-4.netlify.app/");
   }
   // Métodos para la transferencia
 
  public void ingresarMonto(double monto) {
    WebElement montoElement = wait.until(ExpectedConditions.elementToBeClickable(montoInput));
    montoElement.clear();
    montoElement.sendKeys(String.valueOf(monto));
  }
 
  public void ingresarDestino(String destino) {
    WebElement destinoElement = wait.until(ExpectedConditions.elementToBeClickable(destinoInput));
    destinoElement.clear();
    destinoElement.sendKeys(destino);
  }
  
  public void clickBotonTransferir(){
    WebElement btnTransferirElement = wait.until(ExpectedConditions.elementToBeClickable(btnTransferir));
    btnTransferirElement.click();
  }
  
  public String obtenerMensajeTransferencia(){
    WebElement mensajeTransferenciaElement = wait.until(ExpectedConditions.visibilityOfElementLocated(resultadoTransferenciaText));
    return mensajeTransferenciaElement.getText().replaceAll("<.*?>", "").trim();
  }
  
  public void transferir(double monto, String destino){
    ingresarMonto(monto);
    ingresarDestino(destino);
    clickBotonTransferir();
  }

  
  public void ingresarNombre(String nombre){
    WebElement nombreElement = wait.until(ExpectedConditions.elementToBeClickable(nombreInput));
    nombreElement.clear();
    nombreElement.sendKeys(String.valueOf(nombre));
  }

  public void ingresarApellido(String apellido){
    WebElement apellidoElement = wait.until(ExpectedConditions.elementToBeClickable(apellidoInput));
    apellidoElement.clear();
    apellidoElement.sendKeys(String.valueOf(apellido));
  }

  public void ingresarEmail(String email){
    WebElement emailElement = wait.until(ExpectedConditions.elementToBeClickable(emailInput));
    emailElement.clear();
    emailElement.sendKeys(String.valueOf(email));
  }

  public void ingresarEdad(String edad){
    WebElement edadElement = wait.until(ExpectedConditions.elementToBeClickable(edadInput));
    edadElement.clear();
    edadElement.sendKeys(String.valueOf(edad));
  }

 

  

    
}
