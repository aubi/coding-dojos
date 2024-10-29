package fish.payara.starter.test.e2e.pages;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.junit.UsePlaywright;


@UsePlaywright
public class StarterPage {
  private final Page page;

    public StarterPage(Page page) {
        this.page = page;
    }

    void chooseBuild(String value) {
        //locate radio button
        //choose Maven or Gradle based on value
    }
}
