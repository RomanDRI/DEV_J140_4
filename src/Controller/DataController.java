package Controller;

import Model.Domains;
import Model.Person;
import Repository.Repository;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.Set;
import java.util.stream.Collectors;

public class DataController {
    public ObservableList<PersonDto> getPerson() {
        Repository repository = new Repository();
        Set<Person> persons = repository.findPerson();
        Set<PersonDto> personDto = persons.stream().map(person -> new PersonDto(person)).collect(Collectors.toSet());
        ObservableList<PersonDto> odsPerson = FXCollections.observableArrayList(personDto);
        return odsPerson;
    }
    public ObservableList<Domains> getDomainsByPerson(PersonDto personDto) {
        Set<Domains> domains = personDto.getDomains();
        ObservableList<Domains> obsDomain = FXCollections.observableArrayList(domains);
        return obsDomain;
    }
}
