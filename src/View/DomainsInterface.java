package View;

import Controller.FXMLDomainsController;
import Controller.PersonDto;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class DomainsInterface extends Stage{


    public void init(PersonDto personDto){
        Parent root;
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../FXML/FXMLDomains.fxml"));
            root = loader.load();
            ((FXMLDomainsController)loader.getController()).initDomainsTable(personDto);

            Scene scene = new Scene(root);
            scene.getStylesheets().add("CSS/domainsStyle1.css");
            setTitle("Domains");
            setScene(scene);
            initModality(Modality.APPLICATION_MODAL);
            setResizable(false);
            showAndWait();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}
