package View;

import Controller.DataController;
import Controller.PersonDto;
import Model.Domains;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.sql.Timestamp;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class DomainsInterface extends Stage {
    public void init(Integer id){
        Button styleButton = new Button("Изменение стиля");

        DataController dataController = new DataController();
        PersonDto personDto = new PersonDto(id);
        TableView<Domains> tableDomains = new TableView<>(dataController.getDomainsByPerson(personDto));

        TableColumn<Domains, Integer> idDomainsColumn = new TableColumn<>("id");
        idDomainsColumn.setMinWidth(50);
        idDomainsColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        tableDomains.getColumns().add(idDomainsColumn);

        TableColumn<Domains, String> webNameColumn = new TableColumn<>("Имя");
        webNameColumn.setMinWidth(150);
        webNameColumn.setCellValueFactory(new PropertyValueFactory<>("webName"));
        tableDomains.getColumns().add(webNameColumn);

        TableColumn<Domains, String> domainNameColumn = new TableColumn<>("Имя домена");
        domainNameColumn.setMinWidth(150);
        domainNameColumn.setCellValueFactory(new PropertyValueFactory<>("domainName"));
        tableDomains.getColumns().add(domainNameColumn);

        TableColumn<Domains, String> ipColumn = new TableColumn<>("ip");
        ipColumn.setMinWidth(100);
        ipColumn.setCellValueFactory(new PropertyValueFactory<>("ip"));
        tableDomains.getColumns().add(ipColumn);

        TableColumn<Domains, Timestamp> dateRegColumn = new TableColumn<>("Дата регистрации");
        dateRegColumn.setMinWidth(150);
        dateRegColumn.setCellValueFactory(new PropertyValueFactory<>("dateReg"));
        tableDomains.getColumns().add(dateRegColumn);

        TableColumn<Domains, String> countryRegColumn = new TableColumn<>("Страна регистрации");
        countryRegColumn.setMinWidth(100);
        countryRegColumn.setCellValueFactory(new PropertyValueFactory<>("countryReg"));
        tableDomains.getColumns().add(countryRegColumn);

        TableColumn<Domains, Integer> personIDColumn = new TableColumn<>("id владельца");
        personIDColumn.setMinWidth(50);
        personIDColumn.setCellValueFactory(new PropertyValueFactory<>("personId"));
        tableDomains.getColumns().add(personIDColumn);
              
        VBox vb = new VBox();
              
        StackPane root = new StackPane();
        root.getChildren().add(tableDomains);
        
        vb.setAlignment(Pos.CENTER);
        vb.getChildren().addAll(tableDomains, styleButton);
        
        Scene scene = new Scene(vb,795,200);       
        scene.getStylesheets().add("view/domainsStyle1.css");
       
          styleButton.setOnAction(e -> {
              switch (scene.getStylesheets().toString()) {
                  case "[view/domainsStyle1.css]":
                      scene.getStylesheets().clear();
                      scene.getStylesheets().add("view/domainsStyle2.css");
                        break;
                  case "[view/domainsStyle2.css]":
                      scene.getStylesheets().clear();
                      scene.getStylesheets().add("view/domainsStyle1.css");
                        break;
              }
        });
                  
        setTitle("Person");
        setScene(scene);
        initModality(Modality.APPLICATION_MODAL);
        setResizable(false);
        showAndWait();
    }
}
