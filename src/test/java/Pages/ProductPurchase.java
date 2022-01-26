package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class ProductPurchase {
    WebDriver driver;
    @FindBy(css = "img")
    List<WebElement> imgProducts;
    @FindBy(name = "add-to-cart")
    WebElement btnAddCart;
    @FindBy(xpath = "//a[contains(text(),\"View cart\")]")
   // @FindBy(tagName = "a")
    List<WebElement> viewCart;
    @FindBy(name = "product_cat")
    WebElement dropdown;
    @FindBy(className = "fa-search")
    WebElement searchIcon;
    @FindBy(xpath = "//a[contains(text(),\"Proceed to checkout\")]")
    WebElement btnCheckout;
    public ProductPurchase(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void selectProduct() throws InterruptedException {
        Select select = new Select(dropdown);
        select.selectByIndex(3);
        Thread.sleep(2000);
        searchIcon.click();
        imgProducts.get(1).click();
        Thread.sleep(2000);
    }
    public void addCart() throws InterruptedException {
        btnAddCart.click();
        Thread.sleep(2000);
        // viewCart.get(30).click();
        viewCart.get(2).click();
        Thread.sleep(2000);
        btnCheckout.click();
    }
}
