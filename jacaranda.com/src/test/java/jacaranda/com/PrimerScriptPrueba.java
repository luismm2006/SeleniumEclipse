package jacaranda.com;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
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
	@Test // La Prueba: Aquí va el código de navegación y validación
	public void verificarTituloPaginaTest() {
		driver.get("https://www.example.com");
	// ¡TEMPORALMENTE para demostración visual!
		try {
			Thread.sleep(5000); // Pausa el script por 5 segundos (5000 milisegundos)
			WebElement link = driver.findElement(By.linkText("Learn more"));
			link.click();
			// Pausa el script por 5 segundos (5000 milisegundos)
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	// Aquí iría una validación (ej. Assert.assertEquals(driver.getTitle(),
	//"Ejemplo Dominio");)
		assertEquals(driver.getCurrentUrl(), "https://www.iana.org/help/example-domains");
		
		assertTrue(driver.findElement(By.tagName("h2")).getText().equals("Further Reading"));
	}
	@AfterClass // Limpieza: Se ejecuta al final
	public void teardown() {
		driver.quit();
	}
}
