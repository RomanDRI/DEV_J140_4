package Model;

import Repository.Repository;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Person {
    private Integer id;
    private String jobTitle;
    private String firstNameLastName;
    private String phone;
    private String email;
    private Set<Domains> domains = new HashSet<>();

    public Person(){
        new Repository().findPerson();
    }

    public Person(Integer id, String jobTitle, String firstNameLastName, String phone, String email) {
        this.id = id;
        this.jobTitle = jobTitle;
        this.firstNameLastName = firstNameLastName;
        this.phone = phone;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getFirstNameLastName() {
        return firstNameLastName;
    }

    public void setFirstNameLastName(String firstNameLastName) {
        this.firstNameLastName = firstNameLastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Domains> getDomains() {
        return domains;
    }

    public void setDomains(Set<Domains> domains) {
        this.domains = domains;
    }

    public void addDomains(Domains domain) {
        this.domains.add(domain);
        domain.getPerson().add(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(id, person.id) && Objects.equals(jobTitle, person.jobTitle) && Objects.equals(firstNameLastName, person.firstNameLastName) && Objects.equals(phone, person.phone) && Objects.equals(email, person.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, jobTitle, firstNameLastName, phone, email);
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", jobTitle='" + jobTitle + '\'' +
                ", firstNameLastName='" + firstNameLastName + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
