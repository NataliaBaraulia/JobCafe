import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.WebElement;
import pages.HomePage;
import pages.JobsPage;
import utils.UseCaseBase;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class JobsPageTest extends UseCaseBase {
    private static JobsPage jobsPage;
    private static HomePage homePage;
    private static final Logger logger = LogManager.getLogger(String.valueOf(HomePageTest.class));
    @BeforeAll
    public static void classSetup(){
        jobsPage = new JobsPage();
        homePage = new HomePage();
    }
    @BeforeEach
    public void beforeTest(){
        homePage.navigateToHomePage();
        homePage.openJobsPage();

    }
    @Test
    public void jobsPageLoadTest(){
        logger.info("Jobs Page Load test ");
        boolean success = jobsPage.isPageTitleVisible();
        assertTrue(success);}
    @Test
    public void buttonSearchTest(){
        WebElement element = jobsPage.searchButton();
        assertNotNull(element);
    }
    @Test
    public void buttonResetTest(){
        WebElement element = jobsPage.resetButton();
        assertNotNull(element);
    }
    @Test
    public void sectionJobsTest(){
        WebElement element = jobsPage.sectionJobs();
        assertNotNull(element);
    }
    @Test
    public void companyFilter(){
        WebElement element = jobsPage.companyFilter();
        assertNotNull(element);
    }
    @Test
    public void locationFilter(){
        WebElement element = jobsPage.locationFilter();
        assertNotNull(element);
    }


    @ParameterizedTest
    @MethodSource("inputTestData")
    public void positionsParametrizedTest(String text, String fileName) throws InterruptedException {
        jobsPage.searchForPosition(text);
        jobsPage.searchButton().click();
        Thread.sleep(10000);
        jobsPage.positionSearchResults(fileName);
        jobsPage.resetButton().click();

    }
    public static Stream<Arguments> inputTestData(){
        return Stream.of(
                Arguments.of("QA", "file_1.png"), //position titles
                Arguments.of("Developer", "file_2.png"), // fileName
                Arguments.of("Project Manager","file_3.png") // fileName
        );
    }
    @ParameterizedTest
    @MethodSource("inputCompanyNameTestData")
    public void companiesParametrizedTest(String text, String fileName) throws InterruptedException {
        jobsPage.searchForCompany(text);
        jobsPage.searchButton().click();
        Thread.sleep(10000);
        jobsPage.positionSearchResults(fileName);
        jobsPage.resetButton().click();

    }
    public static Stream<Arguments> inputCompanyNameTestData(){
        return Stream.of(
                Arguments.of("Apple", "Apple.png"),
                Arguments.of("Facebook", "Facebook.png"),
                Arguments.of("Google","Google.png")
        );
    }
    @ParameterizedTest
    @MethodSource("inputCombinedSearchTestData")
    public void combinedSearchParametrizedTest(String position,String company,String location, String fileName) throws InterruptedException {
        jobsPage.searchForPosition(position);
        jobsPage.searchForCompany(company);
        jobsPage.searchForLocation(location);
        jobsPage.searchButton().click();
        Thread.sleep(10000);
        jobsPage.positionSearchResults(fileName);
        jobsPage.resetButton().click();

    }public static Stream<Arguments> inputCombinedSearchTestData(){
        return Stream.of(
                Arguments.of("Manager","Google","USA", "CombinedSearch.png")
        );
    }
    @Test
    public void errorMessageTest() throws InterruptedException {
        jobsPage.searchForPosition("abracadabra");
        jobsPage.searchButton().click();
        Thread.sleep(5000);
        jobsPage.positionSearchResults("ErrorMessage.png");
    }
    @Test
    public void resetTest(){
        jobsPage.searchForPosition("test");
        jobsPage.searchForLocation("test");
        jobsPage.searchForCompany("test");
        jobsPage.resetButton().click();
        jobsPage.positionSearchResults("ResetTest.png");
    }




}

