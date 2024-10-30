package fish.payara.starter.test.e2e.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.junit.UsePlaywright;

@UsePlaywright
public class StarterPage {
    private static final String MAVEN_RADIO = "label[for='maven']";
    private static final String GRADLE_RADIO = "label[for='gradle']";
    private static final String GROUP_ID_INPUT_BOX = "label[for='groupId']";
    private static final String ARTIFACT_ID_INPUT_BOX = "label[for='artifactId']";

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
    
    
    public void fillGroupId(String value) throws InterruptedException {
        getGroupId().clear();
        getGroupId().fill(value);
    }

    public void fillArtifactId (String value) throws InterruptedException {
        getArtifactId().clear();
        getArtifactId().fill(value);
    }

    public Locator getGradleCheckbox() {
        return page.locator(GRADLE_RADIO);
    }

    public Locator getMavenCheckbox() {
        return page.locator(MAVEN_RADIO);
    }

    public Locator getGroupId() {
        return page.locator(GROUP_ID_INPUT_BOX);
    }

    public Locator getArtifactId() {
        return page.locator(ARTIFACT_ID_INPUT_BOX);
    }
}
