package activities.calculator;

import controles.Button;
import controles.Label;
import org.openqa.selenium.By;

public class MainScreen {
    public Button inicialButton = new Button(By.id("android:id/button1"));
    public Button twoButton = new Button(By.id("com.miui.calculator:id/btn_2_s"));
    public Button plusButton = new Button(By.id("com.miui.calculator:id/btn_plus_s"));
    public Button fiveButton = new Button(By.id("com.miui.calculator:id/btn_5_s"));
    public Button equalsButton = new Button(By.id("com.miui.calculator:id/btn_equal_s"));
    public Label resultLabel = new Label(By.id("com.miui.calculator:id/result"));
}

