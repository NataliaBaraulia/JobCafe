package pages;

import consts.Consts;
import org.openqa.selenium.WebElement;

public class JobsPage extends BasePage {
    public static String POSITION_FILTER ="//input[@placeholder='position']";
    public static String COMPANY_FILTER ="//input[@placeholder='company']";
    public static String LOCATION_FILTER ="//input[@placeholder='location']";
    public static String BUTTON_SEARCH ="//button[text()='search']";
    public static String BUTTON_RESET ="//button[text()='reset']";
    public static String SECTION_JOBS ="//section[@id='jobs']";

    public boolean isPageTitleVisible(){
        return elementExists(POSITION_FILTER);}

    public void navigateToJobsPage(){
        webDriver.get(Consts.JOB_PAGE_URL);
    }
    public WebElement searchButton(){
        return findElementByRelativeLocator(POSITION_FILTER,BUTTON_SEARCH);
    }
    public WebElement resetButton(){
        return findElementByRelativeLocator(POSITION_FILTER,BUTTON_RESET);
    }
    public WebElement companyFilter(){
        return findElementByRelativeLocator(POSITION_FILTER,COMPANY_FILTER);
    }
    public WebElement locationFilter(){
        return findElementByRelativeLocator(POSITION_FILTER,LOCATION_FILTER);
    }
    public WebElement sectionJobs(){
        return findElementByXpath(SECTION_JOBS);
    }
    public void positionSearchResults(String fileName){
        captureElementScreenshot(sectionJobs(), fileName);
    }
    public void searchForPosition( String text){
        sendTextToElementByXpath(POSITION_FILTER, text);
    }
    public void searchForCompany( String text){
        sendTextToElementByXpath(COMPANY_FILTER, text);
    }
    public void searchForLocation( String text){
        sendTextToElementByXpath(LOCATION_FILTER, text);
    }


}

