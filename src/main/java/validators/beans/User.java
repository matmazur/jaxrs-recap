package validators.beans;

import javax.validation.constraints.*;
import java.time.LocalDate;

public class User {

    @NotNull
    private String username;
    @Past
    @NotNull
    private LocalDate birthDate;
    @NotNull
    @Size(min = 11, max = 11)
    private String pesel;
    @NotNull
    @Size(min = 2, max = 20)
    private String name;
    @NotNull
    @Size(min = 2, max = 20)
    private String surname;
    @NotNull
    @Min(13)
    private int age;
    @NotNull
    @Email
    private String email;

    public User() {
    }

    public User(String username, LocalDate birthDate, String pesel, String name, String surname, int age, String email) {
        this.username = username;
        this.birthDate = birthDate;
        this.pesel = pesel;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", birthDate=" + birthDate +
                ", pesel='" + pesel + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                '}';
    }
}
