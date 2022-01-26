package TestRunner;

import Pages.Login;
import Setup.Setup;
import Utils.Utils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTestRunner extends Setup {

    @Test
    public void doUserLogin() throws Exception {
        Login login =  new Login(driver);
        driver.get("http://automationpractice.com");
        Utils utils = new Utils(driver);
        utils.readJSONArray(0);
        String user = login.doLogin(utils.getEmail(), utils.getPassword());
        Assert.assertEquals(user, "Test User");
    }

    @Test
    public void loginWithInvalidEmail() throws Exception {
        Login login =  new Login(driver);
        driver.get("http://automationpractice.com");
        Utils utils = new Utils(driver);
        utils.readJSONArray(1);
        String errorMessage = login.loginWithInvalidEmail(utils.getEmail(), utils.getPassword());
        Assert.assertEquals(errorMessage, "Invalid email address");
    }

    @Test
    public void loginWithInvalidPassword() throws Exception {
        Login login =  new Login(driver);
        driver.get("http://automationpractice.com");
        Utils utils = new Utils(driver);
        utils.readJSONArray(2);
        String errorMessage = login.loginWithInvalidPassword(utils.getEmail(), utils.getPassword());
        Assert.assertEquals(errorMessage, "Authentication failed");
    }

}
