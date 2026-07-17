package base;

import java.nio.file.Files;
import java.nio.file.Paths;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.Tracing;

public class BaseTest {

    protected Playwright playwright;
    protected Browser browser;
    protected BrowserContext context;
    protected Page page;

    public Page getPage() {
        return page;
    }

    @BeforeMethod
    public void setup() throws Exception {

        playwright = Playwright.create();

        browser = playwright.chromium()
                .launch(new BrowserType.LaunchOptions()
                        .setHeadless(false));

        // Create Browser Context
        context = browser.newContext();

        // Start Trace Recording
        context.tracing().start(
                new Tracing.StartOptions()
                        .setScreenshots(true)
                        .setSnapshots(true)
                        .setSources(true));

        // Create Page from Context
        page = context.newPage();

        page.navigate("https://opensource-demo.orangehrmlive.com");
    }

    @AfterMethod
    public void tearDown() throws Exception {

        // Create traces folder if it does not exist
        Files.createDirectories(Paths.get("Traces"));

        // Save trace
        context.tracing().stop(
                new Tracing.StopOptions()
                        .setPath(Paths.get("Traces/Trace" + System.currentTimeMillis() + ".zip")));//To avoid overwriting the same trace file every run, you can use:

        browser.close();
        playwright.close();
    }
}