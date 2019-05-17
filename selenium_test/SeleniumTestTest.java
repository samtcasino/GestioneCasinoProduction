import com.google.common.collect.ImmutableMap;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

class SeleniumTestTest {
    String URL = "http://cashyland.tk/";
    WebDriver driver = null;

    void home(){
        WebElement home = null;
        home = driver.findElement(By.linkText("Home"));
        home.click();
        waitMillis(1000);
        System.out.println(driver.getTitle());
        assertEquals("CashyLand - Home",driver.getTitle());
    }

    void accedi(){
        WebElement accedi = null;
        accedi = driver.findElement(By.linkText("Accedi"));
        accedi.click();
        waitMillis(1000);
        System.out.println(driver.getTitle());
        assertEquals("CashyLand - Login",driver.getTitle());
    }

    void registrati(){
        WebElement registrati = null;
        registrati = driver.findElement(By.name("register"));
        registrati.click();
        waitMillis(1000);
        System.out.println(driver.getTitle());
        assertEquals("CashyLand - Registrazione",driver.getTitle());
    }

    void forgot(){
        WebElement forgot = null;
        forgot = driver.findElement(By.linkText("Hai dimenticato la password?"));
        forgot.click();
        waitMillis(1000);
        System.out.println(driver.getTitle());
        assertEquals("CashyLand - Password Smarrita?",driver.getTitle());
    }

    void giochi(){
        WebElement giochi = null;
        giochi = driver.findElement(By.linkText("Giochi"));
        giochi.click();
        waitMillis(1000);
        System.out.println(driver.getTitle());
        assertEquals("CashyLand - Giochi",driver.getTitle());
    }

    void sale(){
        WebElement sale = null;
        sale = driver.findElement(By.linkText("Sale"));
        sale.click();
        waitMillis(1000);
        System.out.println(driver.getTitle());
        assertEquals("CashyLand - Sale",driver.getTitle());
    }

    void map(){
        WebElement map = null;
        map = driver.findElement(By.linkText("Clicca qui per aprire la mappa"));
        map.click();
        waitMillis(1000);
        System.out.println(driver.getTitle());
        assertEquals("Mandalay Bay Resort and Casino - Google Maps",driver.getTitle());
    }

    @Test
    void test() {
        final File firefoxPath = new File(System.getProperty("lmportal.deploy.firefox.path", "/usr/bin/firefox"));
       
        //String Xport = System.getProperty("lmportal.xvfb.id", ":2");

        /*driver = new FirefoxDriver( new GeckoDriverService.Builder()
            .usingDriverExecutable(new File("/usr/bin/geckodriver"))
            .usingFirefoxBinary(new FirefoxBinary(firefoxPath))
            .withEnvironment(ImmutableMap.of("DISPLAY", Xport)).build());*/
	driver = new FirefoxDriver();

        driver.get(URL);
	WebDriverWait wait = new WebDriverWait(driver, 60);
	wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Accedi")));        
waitMillis(1000);
        System.out.println(driver.getTitle());
        assertEquals("CashyLand - Home",driver.getTitle());
	
        accedi();
System.out.println("Pagina di login");
        registrati();
        accedi();
        forgot();
        accedi();
        home();
        giochi();
        home();
        sale();
        home();

        WebElement giochi = null;
        giochi = driver.findElement(By.linkText("Clicca qui per scoprirne di pìù"));
        giochi.click();
        waitMillis(1000);
        System.out.println(driver.getTitle());
        assertEquals("CashyLand - Giochi",driver.getTitle());

        home();
        map();
        System.out.println("OK");

        driver.quit();
    }

    public void waitMillis(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
