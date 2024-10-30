package fish.payara.starter.test.e2e.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.junit.UsePlaywright;

@UsePlaywright
public class StarterPage {

    private static final String PROJECT_DESCRIPTION_BLOCK = "fieldset[id='stb0-st0']";
    private static final String MAVEN_RADIO = "label[for='maven']";
    private static final String GRADLE_RADIO = "label[for='gradle']";
    private static final String GROUP_ID_INPUT_BOX = "#groupId";
    private static final String ARTIFACT_ID_INPUT_BOX = "#artifactId";
    private static final String VERSION_INPUT_BOX = "#version";
    private static final String NEXT_BUTTON_TO_JAKARTAEE = "a[href='#stb0-st1']";
    private static final String JAKARTAEE_VERSION_LABEL = "label[for='jakartaEEVersion']";

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
    }
    
    
    public void fillGroupId(String value) throws InterruptedException {
        getGroupId().clear();
        getGroupId().fill(value);
    }

    public void fillArtifactId (String value) throws InterruptedException {
        getArtifactId().clear();
        getArtifactId().fill(value);
    }

    public void fillVersion (String value) throws InterruptedException {
        getVersion().clear();
        getVersion().fill(value);
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

    public Locator getVersion() {
        return page.locator(VERSION_INPUT_BOX);
    }

    public Locator getNextButtonToJakartaEE() {
        return page.locator(PROJECT_DESCRIPTION_BLOCK).locator(NEXT_BUTTON_TO_JAKARTAEE);
    }

    public Locator getJakartaEEVersion() {
        return page.locator(JAKARTAEE_VERSION_LABEL);
    }
}
