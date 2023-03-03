package View;

import Controller.DataController;
import Controller.PersonDto;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;



public class PersonInterface extends Stage {
    public void init() {

        DataController dataController = new DataController();
        TableView<PersonDto> table = new TableView<>(dataController.getPerson());


        TableColumn<PersonDto, Integer> idColumn = new TableColumn<>("ID");
        idColumn.setMinWidth(50);
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        table.getColumns().add(idColumn);

        TableColumn<PersonDto, String> jobTitleColumn = new TableColumn<>("Должность");
        jobTitleColumn.setMinWidth(200);
        jobTitleColumn.setCellValueFactory(new PropertyValueFactory<>("jobTitle"));
        table.getColumns().add(jobTitleColumn);

        TableColumn<PersonDto, String> firstNameLastNameColumn = new TableColumn<>("ФИО");
        firstNameLastNameColumn.setMinWidth(200);
        firstNameLastNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstNameLastName"));
        table.getColumns().add(firstNameLastNameColumn);

        TableColumn<PersonDto, String> phoneColumn = new TableColumn<>("Телефон");
        phoneColumn.setMinWidth(150);
        phoneColumn.setCellValueFactory(new PropertyValueFactory<>("phone"));
        table.getColumns().add(phoneColumn);

        TableColumn<PersonDto, String> emailColumn = new TableColumn<>("Эл. почта");
        emailColumn.setMinWidth(200);
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
        table.getColumns().add(emailColumn);

        TableColumn<PersonDto, Integer> countColumn = new TableColumn<>("Кол-во доменов");
        countColumn.setMinWidth(50);
        countColumn.setCellValueFactory(new PropertyValueFactory<>("domainsCount"));
        table.getColumns().add(countColumn);

        table.setOnMouseClicked(e -> {
            if(e.getClickCount()==2) {
                Integer id = table.getSelectionModel().getSelectedItem().getId();
                new DomainsInterface().init(id);
            }
        });

        StackPane root = new StackPane();
        root.getChildren().add(table);

        Scene scene = new Scene(root, 915, 800);

        scene.getStylesheets().add("view/AuthenticationPersonStyle.css");
        setTitle("Person");
        setScene(scene);
        setResizable(false);
        show();
    }
}
