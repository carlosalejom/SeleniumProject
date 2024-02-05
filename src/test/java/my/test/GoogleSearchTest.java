package my.test;
import static org.junit.Assert.assertEquals;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearchTest {

	private WebDriver driver;
	
	@Before
	public void setUp() throws Exception{
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/Chromedriver/chromedriver.exe"); /* Primero buscar el driver*/
		driver = new ChromeDriver(); /*Intanciar el driver*/
		driver.manage().window().maximize(); /*abrir el dirver en una ventana y mazimixarlo*/
		driver.get("https://www.google.com"); /*abrir la pagina o url que se desea */
	}
	
	@Test
	public void testGooglePage() {
		WebElement searchBox = driver.findElement(By.name("q")); /*Buscar un elemento web por su name*/
		searchBox.clear();/*limpiar ese elemento*/
		searchBox.sendKeys("Test Automation for Selenium"); /*Texto que quiero que escriba en el elemento*/
		searchBox.submit();/*Enviar el texto*/
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);/*tiempo de respueta maximo*/
		assertEquals("Test Automation for Selenium - Buscar con Google", driver.getTitle());/*Si lo que esta en el texto encontro el test paso*/
	}
	
	@After 	
	public void closeTest() {
		driver.quit(); /*cerrar la venta despue de finlizar el test*/
	}
	
}
