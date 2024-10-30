package fish.payara.starter.test.e2e.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.junit.UsePlaywright;

@UsePlaywright
public class StarterPage {
    private static final String MAVEN_RADIO = "label[for='maven']";
    private static final String GRADLE_RADIO = "label[for='gradle']";

    private final Page page;

    public StarterPage(Page page) {
        this.page = page;
    }

    public void chooseBuild(String value) throws InterruptedException {

        switch (value) {
            case "Maven":
                getMavenCheckbox().click();
                break;
            case "Gradle":
                getGradleCheckbox().click();
                break;
            default:
                throw new IllegalArgumentException("Invalid value: " + value);
        }
        Thread.sleep(6000);
    }

    public Locator getGradleCheckbox() {
        return page.locator(GRADLE_RADIO);
    }

    public Locator getMavenCheckbox() {
        return page.locator(MAVEN_RADIO);
    }
}
