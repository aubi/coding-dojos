package fish.payara.starter.test.e2e.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.junit.UsePlaywright;
import com.microsoft.playwright.options.AriaRole;

import java.util.Locale;


@UsePlaywright
public class StarterPage {
    private final Page page;

    public StarterPage(Page page) {
        this.page = page;
    }

    public void chooseBuild(String value) throws InterruptedException {
        String mavenRadio = "label[for='maven']";
        String gradleRadio = "label[for='gradle']";

        switch (value) {
            case "Maven":
                page.locator(mavenRadio).click();
                break;
            case "Gradle":
                page.locator(gradleRadio).click();
                break;
            default:
                throw new IllegalArgumentException("Invalid value: " + value);
        }

        Thread.sleep(6000);
    }
}
