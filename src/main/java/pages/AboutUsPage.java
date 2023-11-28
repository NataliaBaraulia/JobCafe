package pages;
import consts.Consts;



public class AboutUsPage extends BasePage {
    public static String ABOUT_US_PHOTO ="//img[@src='/img/about.jpg']";

    public boolean isPageTitleVisible(){
        return elementExists(ABOUT_US_PHOTO);}
}
