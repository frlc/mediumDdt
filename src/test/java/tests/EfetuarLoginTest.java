package tests;

import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

@RunWith(DataDrivenTestRunner.class)
@DataLoader(filePaths = "InfUsuariosTestData.csv")
public class EfetuarLoginTest {

    private WebDriver navegador;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "/home/crazydogretro/IdeaProjects/drivers/chromedriver");
        navegador = new ChromeDriver();
        navegador.manage().window().maximize();
        navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        navegador.get("http://automationpractice.com/index.php?controller=authentication");
    }

    @Test
    public void testLoginUsuario(@Param(name="email") String email, @Param(name="password") String senha){

        //Inserir o valor do email no campo email
        navegador.findElement(By.id("email")).sendKeys(email);

        //Inserir o valor do password no campo password
        navegador.findElement(By.id("passwd")).sendKeys(senha);

        //Clicar no botão Sign in
        navegador.findElement(By.id("SubmitLogin")).click();


    }

    @After
    public void tearDown(){
        //Fechar o navegador
        navegador.quit();

    }

}
