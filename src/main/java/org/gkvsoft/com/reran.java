package org.gkvsoft.com;

import com.microsoft.playwright.*;




public class reran {
    public static <JavascriptExecutor, await> void main(String[] args) {
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

            Locator Crossbutton = page.locator("//span[@class='HamburgerButton_hamburgerButtonClickable__5zbBe']");
            Crossbutton.click();


            page.locator("//a[@href='/list/best-foods/ranker-food']//div[@class='RerankedItem_contentWrapper__WVghA']").scrollIntoViewIfNeeded();

            Locator RRlist = page.locator("//img[@alt='If You Could Only Eat One Food for the Rest of Your Life...']");
            RRlist.click();

            //new list page opened

            page.locator("//button[normalize-space()='rank it your way']");

            Locator RRIYW = page.locator("//button[normalize-space()='rank it your way']");
            RRIYW.click();

            //required minimum 3 node to be select to publish list

            Locator node1 = page.locator("//input[@type='next'])[1]");
            node1.click();








            Thread.sleep(5000);





            page.close();
            browser.close();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}