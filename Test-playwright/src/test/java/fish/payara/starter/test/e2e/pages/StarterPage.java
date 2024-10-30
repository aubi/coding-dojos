package fish.payara.starter.test.e2e.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.junit.UsePlaywright;
import com.microsoft.playwright.options.AriaRole;


@UsePlaywright
public class StarterPage {
  private final Page page;

    public StarterPage(Page page) {
        this.page = page;
    }

    public void chooseBuild(String value) {
        Locator mavenRadio = page.getByRole(AriaRole.RADIO, new Page.GetByRoleOptions().setName("Maven") );
        Locator gradleRadio = page.getByRole(AriaRole.RADIO, new Page.GetByRoleOptions().setName("Gradle") );
        
        if (value.equals("Gradle")){
            gradleRadio.click();
        }
        else mavenRadio.click();        
    }
}
