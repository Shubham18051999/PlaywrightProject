package org.gkvsoft.com;

import com.microsoft.playwright.*;

public class signup {

    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(
                    new BrowserType.LaunchOptions().setHeadless(false)
            );

            Page page = browser.newPage();
            page.navigate("http://www.ranker.com");

            Locator hamburger = page.locator("(//span[@class='HamburgerButton_hamburgerButtonClickable__5zbBe'])[1]");
            hamburger.click();

            page.locator("(//button[normalize-space()='Sign Up'])[1]").click();
            String uniqueEmail = generateUniqueEmail();
            String uniqueUsername = generateUniqueUsername();

            Locator Username = page.locator("(//input[@placeholder='Your Username'])[2]");
            Username.fill(uniqueUsername);



            Locator email = page.locator("(//input[@name='email'])[1]");
            email.fill(uniqueEmail);

            Locator password = page.locator("(//input[@placeholder='Your Password'])[2]");
            password.fill("yourPassword123");

            Locator signUpButton = page.locator("(//button[normalize-space()='sign up!'])[1]");
            signUpButton.click();

            Thread.sleep(5000);

            page.close();
            browser.close();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private static String generateUniqueUsername() {
        return "user" + System.currentTimeMillis();
    }

    private static String generateUniqueEmail() {
        return "user" + System.currentTimeMillis() + "@example.com";
    }
}