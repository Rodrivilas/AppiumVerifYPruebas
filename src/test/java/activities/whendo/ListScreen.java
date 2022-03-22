package activities.whendo;

import controles.Button;
import controles.Label;
import org.openqa.selenium.By;

public class ListScreen {


    public Button newTareaButton = new Button(By.id("com.vrproductiveapps.whendo:id/fab"));

    public Label tituloTarea(String nombre) {
        Label titleTarea = new Label(By.xpath("//android.widget.TextView[@text=\"" + nombre + "\"]"));
        return titleTarea;
    }

}
