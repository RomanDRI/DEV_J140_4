package Model;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Domains {
    private Integer id;
    private String webName;
    private String domainName;
    private String ip;
    private Timestamp dateReg;
    private String countryReg;
    private Integer personId;
    private Set<Person> person = new HashSet<>();

    public Domains(Integer id, String webName, String domainName, String ip, Timestamp dateReg, String countryReg, Integer personId) {
        this.id = id;
        this.webName = webName;
        this.domainName = domainName;
        this.ip = ip;
        this.dateReg = dateReg;
        this.countryReg = countryReg;
        this.personId = personId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWebName() {
        return webName;
    }

    public void setWebName(String webName) {
        this.webName = webName;
    }

    public String getDomainName() {
        return domainName;
    }

    public void setDomainName(String domainName) {
        this.domainName = domainName;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Timestamp getDateReg() {
        return dateReg;
    }

    public void setDateReg(Timestamp dateReg) {
        this.dateReg = dateReg;
    }

    public String getCountryReg() {
        return countryReg;
    }

    public void setCountryReg(String countryReg) {
        this.countryReg = countryReg;
    }

    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    public Set<Person> getPerson() {
        return person;
    }

    public void setPerson(Set<Person> person) {
        this.person = person;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Domains domains = (Domains) o;
        return Objects.equals(id, domains.id) && Objects.equals(webName, domains.webName) && Objects.equals(domainName, domains.domainName) && Objects.equals(ip, domains.ip) && Objects.equals(dateReg, domains.dateReg) && Objects.equals(countryReg, domains.countryReg) && Objects.equals(personId, domains.personId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, webName, domainName, ip, dateReg, countryReg, personId);
    }

    @Override
    public String toString() {
        return "Domains{" +
                "id=" + id +
                ", webName='" + webName + '\'' +
                ", domainName='" + domainName + '\'' +
                ", ip='" + ip + '\'' +
                ", dateReg=" + dateReg +
                ", countryReg='" + countryReg + '\'' +
                ", personId=" + personId +
                '}';
    }
}
