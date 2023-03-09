package View;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;


public class PersonInterface extends Stage {
    public void init() {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("../FXML/FXMLPerson.fxml"));

            Scene scene = new Scene(root);
            scene.getStylesheets().add("CSS/AuthenticationPersonStyle.css");
            setTitle("Person");
            setScene(scene);
            setResizable(false);
            show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
