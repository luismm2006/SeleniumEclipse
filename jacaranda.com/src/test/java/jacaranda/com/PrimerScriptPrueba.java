package jacaranda.com;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PrimerScriptPrueba {
	WebDriver driver;
	// Configuración: Se ejecuta primero
	@BeforeClass
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize(); // Recomendado maximizar la ventana
	}
	@Test // 
	public void verificarInicioSesion() {
		driver.get("https://www.saucedemo.com/");
		String newUrl = "";
		try {
			WebElement username = driver.findElement(By.id("user-name"));
			WebElement password = driver.findElement(By.id("password"));
			WebElement button = driver.findElement(By.id("login-button"));
			username.sendKeys("standard_user");
			password.sendKeys("secret_sauce");
			button.click();
			newUrl = driver.getCurrentUrl();
			
		} catch (NoSuchElementException e) {
			Thread.currentThread().interrupt();
		}
		assertEquals("https://www.saucedemo.com/inventory.html", newUrl);
		
	}
	
	@Test
	public void verificarTituloPaginaTest() {
		driver.get("https://www.saucedemo.com/");
		String message = null;
		try {
			WebElement username = driver.findElement(By.id("user-name"));
			WebElement password = driver.findElement(By.id("password"));
			WebElement button = driver.findElement(By.id("login-button"));
			username.sendKeys("standard");
			password.sendKeys("secret");
			button.click();
			Thread.sleep(5000); // Pausa el script por 5 segundos (5000 milisegundos)
			// Pausa el script por 5 segundos (5000 milisegundos)
			WebElement errorDiv = driver.findElement(By.className("error-message-container"));
			WebElement messageError = errorDiv.findElement(By.tagName("h3"));
			message = messageError.getText();
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
		assertEquals("Your username is invalid!", message );
	
	}
	@Test
	public void esperarHelloWorld() {
		driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
		String message = "";
		try {
			WebElement buttonDiv = driver.findElement(By.id("start"));
			WebElement button = buttonDiv.findElement(By.tagName("button"));
			button.click();
			Thread.sleep(6000); // Pausa el script por 5 segundos (5000 milisegundos)
			WebElement messageHelloWorld = driver.findElement(By.id("finish"));
			
			// Pausa el script por 5 segundos (5000 milisegundos)
			message = messageHelloWorld.getText();
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
		assertEquals("Hello World", message);
	
	}
		@Test
		public void esperarEnlace() {
			driver.get("https://the-internet.herokuapp.com/");
			try {
				WebElement enlaceAthentication = driver.findElement(By.linkText("Form Authentication"));
				Thread.sleep(5000); // Pausa el script por 5 segundos (5000 milisegundos)
				// Pausa el script por 5 segundos (5000 milisegundos)
				
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
				Assert.assertTrue(false);
			}
			Assert.assertTrue(true);
		
		}
	@AfterClass // Limpieza: Se ejecuta al final
	public void teardown() {
		driver.quit();
	}
}
