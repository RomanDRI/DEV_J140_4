package Controller;

import Model.Domains;
import Model.Person;
import Repository.Repository;
import java.util.Objects;
import java.util.Set;


public class PersonDto {
    private Integer id;
    private String jobTitle;
    private String firstNameLastName;
    private String phone;
    private String email;
    private Set<Domains> domains;
    private int domainsCount;

    public PersonDto(Integer id){
        this.domains = new Repository().findDomains(id);
    }

    public PersonDto(Person person) {
        this.id = person.getId();
        this.jobTitle = person.getJobTitle();
        this.firstNameLastName = person.getFirstNameLastName();
        this.phone = person.getPhone();
        this.email = person.getEmail();
        domainsCount = person.getDomains().size();
        domains = person.getDomains();
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

    public int getDomainsCount() {
        return domains.size();
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonDto personDto = (PersonDto) o;
        return Objects.equals(id, personDto.id) && Objects.equals(jobTitle, personDto.jobTitle) && Objects.equals(firstNameLastName, personDto.firstNameLastName) && Objects.equals(phone, personDto.phone) && Objects.equals(email, personDto.email);
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
