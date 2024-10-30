package fish.payara.starter.test.e2e.specs;

import fish.payara.starter.test.e2e.pages.*;
import com.microsoft.playwright.*;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import com.microsoft.playwright.junit.UsePlaywright;
import java.nio.file.Paths;
import org.junit.jupiter.api.*;

@UsePlaywright
public class GenerationAppTest {
    static Playwright playwright;
    static Browser browser;
    BrowserContext context;
    Page page;

    @BeforeAll
    static void launchBrowser() {
      playwright = Playwright.create();
      browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
    }
    
    @AfterAll
    static void closeBrowser(){
        playwright.close();
    }
    
    @BeforeEach
    void createPage(){
        context = browser.newContext();
        page = context.newPage();
        page.navigate("https://aidemo.start.payara.fish/");
        page.waitForSelector("div.hero", new Page.WaitForSelectorOptions().setTimeout(120000));
    }
    
    @AfterEach
    void closePage(){
        context.close();
    }
    
    @Test
    void shouldGenerateSimpleApp() throws InterruptedException {
        assertThat(page).hasTitle("Generate Payara Application");
        StarterPage starterPage = new StarterPage(page);
        starterPage.chooseBuild("Gradle");  
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("screenshot-select-gradle.png")));
        PlaywrightAssertions.assertThat(starterPage.getGradleCheckbox()).isChecked();
        PlaywrightAssertions.assertThat(starterPage.getMavenCheckbox()).not().isChecked();
        //assertThat(page).hasTitle("Generate Payara Application");

        starterPage.fillGroupId("fish.payara.playwrighttest");
        starterPage.fillArtifactId("PlaywrightTest");

        PlaywrightAssertions.assertThat(starterPage.getGroupId()).hasValue("fish.payara.playwrighttest");
        PlaywrightAssertions.assertThat(starterPage.getArtifactId()).hasValue("PlaywrightTest");
    }
}
