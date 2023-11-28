
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.AboutUsPage;
import pages.HomePage;
import pages.JobsPage;
import utils.UseCaseBase;
import static org.junit.jupiter.api.Assertions.*;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;



public class HomePageTest extends UseCaseBase {
    private static HomePage homePage;
    private static final Logger logger = LogManager.getLogger(String.valueOf(HomePageTest.class));
    @BeforeAll
    public static void classSetup(){
        homePage = new HomePage();
    }
    @BeforeEach
    public void beforeTest(){
        homePage.navigateToHomePage();
    }
    @Test
    public void homePageLoadTest(){
        logger.info("Home Page Load test ");
        boolean success = homePage.isLogoVisible();
        assertTrue(success);
    }
    @Test
    public void worldLogoTest() {
        homePage.worldLogo(HomePage.fileName);
    }
    @Test
    public void openAboutUsPage(){
        AboutUsPage aboutUsPage = homePage.openAboutUsPage();
        boolean isLoaded = aboutUsPage.isPageTitleVisible();
        assertTrue(isLoaded);
    }
    @Test
    public void openJobsPage(){
        JobsPage jobsPage = homePage.openJobsPage();
        boolean isLoaded = jobsPage.isPageTitleVisible();
        assertTrue(isLoaded);
    }



}
