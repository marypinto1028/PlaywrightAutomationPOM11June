package base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class BaseTest {

    protected Playwright playwright;
    protected Browser browser;
    protected Page page;
    public Page getPage() {
        return page;
    }

    @BeforeMethod
    public void setup() {

        playwright = Playwright.create();

        browser = playwright.chromium()
                .launch(new BrowserType.LaunchOptions()
                .setHeadless(false));

        page = browser.newPage();

        page.navigate(
          "https://opensource-demo.orangehrmlive.com");
    }

    @AfterMethod
    public void tearDown() {

        browser.close();
        playwright.close();
        
        
        
    }
}