package Controller;

import Model.Domains;
import Model.Person;
import Repository.Repository;
import View.DomainsInterface;
import View.PersonInterface;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.stream.Collectors;

public class FXMLPersonController implements Initializable {
    @FXML
    private TableView<PersonDto> personTable;
    @FXML
    private TableColumn<PersonDto, Integer> idColumn;
    @FXML
    private TableColumn<PersonDto, String> jobTitleColumn;
    @FXML
    private TableColumn<PersonDto, String> firstNameLastNameColumn;
    @FXML
    private TableColumn<PersonDto, String> phoneColumn;
    @FXML
    private TableColumn<PersonDto, String> emailColumn;
    @FXML
    private TableColumn<PersonDto, Integer> countColumn;


    @FXML
    private void handlerDoubleClicked(MouseEvent event) {
        if (event.getClickCount() == 2) {
           Integer id = personTable.getSelectionModel().getSelectedItem().getId();
           PersonDto personDto = new PersonDto(id);
           new DomainsInterface().init(personDto);
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Repository repository = new Repository();
        Set<Person> persons = repository.findPerson();
        Set<PersonDto> personDto = persons.stream().map(person -> new PersonDto(person)).collect(Collectors.toSet());
        ObservableList<PersonDto> odsPerson = FXCollections.observableArrayList(personDto);
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        jobTitleColumn.setCellValueFactory(new PropertyValueFactory<>("jobTitle"));
        firstNameLastNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstNameLastName"));
        phoneColumn.setCellValueFactory(new PropertyValueFactory<>("phone"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
        countColumn.setCellValueFactory(new PropertyValueFactory<>("domainsCount"));
        personTable.setItems(odsPerson);
    }
}


