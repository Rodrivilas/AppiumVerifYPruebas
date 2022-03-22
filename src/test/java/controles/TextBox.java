package controles;

import org.openqa.selenium.By;

import java.net.MalformedURLException;

public class TextBox extends AppiumControl{
    public TextBox(By locator) {
        super(locator);
    }

    public void setValue(String value) throws MalformedURLException {
        this.find();
        this.control.sendKeys(value);
    }

    public void cleanAndSetValue(String value) throws MalformedURLException {
        this.find();
        this.control.clear();
        this.control.sendKeys(value);
    }
}
