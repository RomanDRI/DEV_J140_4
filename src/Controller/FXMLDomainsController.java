package Controller;

import Model.Domains;
import View.AuthenticationInterface;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class FXMLDomainsController implements Initializable {

    @FXML
    private TableView<Domains> domainsTable;
    @FXML
    private Button changeStyle;

    @FXML
    public void handleButtonActionChangeStyle(ActionEvent actionEvent) {
        Scene scene = changeStyle.getScene();
        switch (scene.getStylesheets().toString()) {
            case "[CSS/domainsStyle1.css]":
                scene.getStylesheets().clear();
                scene.getStylesheets().add("CSS/domainsStyle2.css");
                break;
            case "[CSS/domainsStyle2.css]":
                scene.getStylesheets().clear();
                scene.getStylesheets().add("CSS/domainsStyle1.css");
                break;
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        domainsTable.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("id"));
        domainsTable.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("webName"));
        domainsTable.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("domainName"));
        domainsTable.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("ip"));
        domainsTable.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("dateReg"));
        domainsTable.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("countryReg"));
        domainsTable.getColumns().get(6).setCellValueFactory(new PropertyValueFactory<>("personId"));
    }

    public void initDomainsTable(PersonDto personDto) {
        ObservableList<Domains> obsDomains = FXCollections.observableArrayList(personDto.getDomains());
        domainsTable.setItems(obsDomains);
    }
}
