package testClean;

import activities.whendo.EditTareaScreen;
import activities.whendo.ListScreen;
import activities.whendo.NewTareaScreen;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import session.Session;

import java.net.MalformedURLException;

public class WhenDoTareaTest {
    String nombre="Rotis";

    ListScreen listScreen = new ListScreen();
    NewTareaScreen newtareaScreen = new NewTareaScreen();
    EditTareaScreen editTareaScreen= new EditTareaScreen();

    @Test
    public void createTarea() throws MalformedURLException, InterruptedException {
        String expected="Rotis";

        listScreen.newTareaButton.click();
        newtareaScreen.nameTareaTxtBox.setValue(nombre);
        newtareaScreen.descriptionTxtBox.setValue("descripcion");
        newtareaScreen.saveTareaButton.click();
        String actual = listScreen.tituloTarea(nombre).getText();
        Thread.sleep(2000);

        Assertions.assertEquals(expected,actual,"ERROR los elementos de la lista no son el mismo");

    }

    @Test
    public void deleteTarea() throws MalformedURLException, InterruptedException {


        listScreen.newTareaButton.click();
        newtareaScreen.nameTareaTxtBox.setValue(nombre);
        newtareaScreen.descriptionTxtBox.setValue("descripcion");
        newtareaScreen.saveTareaButton.click();

        listScreen.tituloTarea(nombre).click();
        editTareaScreen.borrar.click();
        editTareaScreen.aceptar.click();

        Thread.sleep(2000);

        Assertions.assertFalse(listScreen.tituloTarea(nombre).isControlDisplayed());
    }

    @AfterEach
    public void closeApp() throws MalformedURLException {
        Session.getInstance().closeSession();
    }
}
