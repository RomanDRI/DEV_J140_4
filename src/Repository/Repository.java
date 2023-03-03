package Repository;

import Model.Domains;
import Model.Person;
import Model.Users;

import java.sql.*;
import java.util.HashSet;
import java.util.Set;

public class Repository {
    private static final String URL_KEY = "db.url";
    private static final String USER_KEY = "db.user";
    private static final String PASSWORD_KEY = "db.password";

    public Set<Users> findUser() {
        Set<Users> users = new HashSet<>();
        try (Connection connection = DriverManager.getConnection(PropertiesUtil.get(URL_KEY),
                PropertiesUtil.get(USER_KEY),
                PropertiesUtil.get(PASSWORD_KEY));
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM USERS");
            while (resultSet.next()) {
                Integer id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String password = resultSet.getString(3);
                Users user = new Users(id, name, password);
                users.add(user);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    public Set<Person> findPerson() {
        Set<Person> persons = new HashSet<>();
        try(Connection connection = DriverManager.getConnection(PropertiesUtil.get(URL_KEY),
                PropertiesUtil.get(USER_KEY),
                PropertiesUtil.get(PASSWORD_KEY));
        Statement statement = connection.createStatement()){
            String sqlCode = "SELECT*FROM PERSON LEFT JOIN DOMAINS ON PERSON.ID = DOMAINS.PERSONID";
            try(ResultSet resultSet = statement.executeQuery(sqlCode)) {
                while (resultSet.next()) {
                    Person person;
                    {
                        Integer id = resultSet.getInt(1);
                        person = persons.stream().filter(p -> p.getId()==id).findFirst().orElse(null);
                        if(person == null) {
                            String jobTitle = resultSet.getString(2);
                            String firstNameLastName = resultSet.getString(3);
                            String phone = resultSet.getString(4);
                            String email = resultSet.getString(5);
                            person = new Person(id,jobTitle,firstNameLastName,phone,email);
                            persons.add(person);
                        }
                    }
                    {
                      if (resultSet.getString(7)!=null) {
                            Integer id = resultSet.getInt(6);
                            String webName = resultSet.getString(7);
                            String domainName = resultSet.getString(8);
                            String ip = resultSet.getString(9);
                            Timestamp dateReg = resultSet.getTimestamp(10);
                            String countryReg = resultSet.getString(11);
                            Integer personId = resultSet.getInt(12);
                            Domains domains = new Domains(id,webName,domainName,ip,dateReg,countryReg,personId);
                            person.addDomains(domains);
                    }
                    }
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return persons;

    }

    public Set<Domains> findDomains(Integer idPerson){
        Set<Domains> domains= new HashSet<>();
        try(Connection connection = DriverManager.getConnection(PropertiesUtil.get(URL_KEY),
                PropertiesUtil.get(USER_KEY),
                PropertiesUtil.get(PASSWORD_KEY));
        Statement statement = connection.createStatement()){
            String sqlCode = "SELECT*FROM DOMAINS WHERE PERSONID =" + idPerson;
            try(ResultSet resultSet = statement.executeQuery(sqlCode)) {
                while (resultSet.next()) {
                        Integer id = resultSet.getInt(1);
                        String webName = resultSet.getString(2);
                        String domainName = resultSet.getString(3);
                        String ip = resultSet.getString(4);
                        Timestamp dateReg = resultSet.getTimestamp(5);
                        String countryReg = resultSet.getString(6);
                        Integer personId = resultSet.getInt(7);
                        Domains domain = new Domains(id,webName,domainName,ip,dateReg,countryReg,personId);
                        domains.add(domain);
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return domains;
    }
}