package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class LoginPage {


private Page page;

private Locator username;
private Locator password;
private Locator loginBtn;

public LoginPage(Page page) {

    this.page = page;

    username = page.locator("input[name='username']");
    password = page.locator("input[name='password']");
    loginBtn = page.locator("button[type='submit']");
}

public void login(String user, String pass) {

    username.fill(user);
    password.fill(pass);
    loginBtn.click();
}


}
