package org.gkvsoft.com;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;


public class App {
    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(
                    new BrowserType.LaunchOptions().setHeadless(false)
            );
            Page page = browser.newPage();
            page.navigate("http://www.ranker.com");

            Locator hamburger = page.locator("(//span[@class='HamburgerButton_hamburgerButtonClickable__5zbBe'])[1]");
            hamburger.click();

            page.locator("(//button[normalize-space()='Sign In'])[1]").click();

            Locator Username = page.locator("(//input[@type='text'])[1]");
            Username.fill("abcd77@gmail.com");


            Locator Password = page.locator("(//input[@type='password'])[1]");
            Password.fill("123456789");

            Locator signin = page.locator("(//button[normalize-space()='sign in!'])[1]");
            signin.click();

            Thread.sleep(5000);





            page.close();
            browser.close();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}