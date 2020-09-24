package krenc.mirek.jdbcjpa.domain;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;

public class Person {

    private int id;
    private String name;
    private String location;
    private Date birthDate;

    public Person() {
    }

    public Person(int id, String name, String location, Date bithDate) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.birthDate = bithDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return name.equals(person.name) &&
                location.equals(person.location) &&
                birthDate.equals(person.birthDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, location, birthDate);
    }
}
