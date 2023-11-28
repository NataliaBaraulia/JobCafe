package pages;
import consts.Consts;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage{
    private static final String LOGO_IMG ="//div[@id='heroCarousel']";
    public static final String GIRLS_PHOTO_LOGO ="//img[@src='/img/why-us.jpg']";
    public static final String fileName ="w_logo.png";
    private static final String ABOUT_US ="//a[@id='2']";
    private static final String FIND_JOBS ="//a[@id='3']";

    public void navigateToHomePage(){
        webDriver.get(Consts.MAIN_URL);
    }
    public boolean isLogoVisible(){
        return elementExists(LOGO_IMG);
    }
//    public WebElement comingSoonImg(String knownXpath, String relativeXpath){
//        return findElementByRelativeLocator(knownXpath,relativeXpath);
//    }
    public void worldLogo( String fileName){
       captureElementScreenshot(findElementByXpath(GIRLS_PHOTO_LOGO), fileName);
    }
    public AboutUsPage openAboutUsPage(){
        findElementByRelativeLocator(LOGO_IMG, ABOUT_US).click();
        return new AboutUsPage();
    }
    public JobsPage openJobsPage(){
        findElementByRelativeLocator(LOGO_IMG, FIND_JOBS).click();
        return new JobsPage();
    }

}
