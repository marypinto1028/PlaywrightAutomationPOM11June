package utilities;

import com.microsoft.playwright.Page;

import java.nio.file.Paths;

public class ScreenshotUtil {

    public static String takeScreenshot(Page page, String testName) {

        String path = "reports/screenshots/" + testName + ".png";

        page.screenshot(new Page.ScreenshotOptions()
                .setPath(Paths.get(path))
                .setFullPage(true));

        return path;
    }
}