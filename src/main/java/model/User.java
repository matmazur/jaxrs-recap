package model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@NamedQueries({
        @NamedQuery(name = "User.findAll", query ="SELECT u FROM User u"),
        @NamedQuery(name = "User.findById",query = "SELECT u from User u WHERE u")
})
@XmlRootElement
public class User {




    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String telephone;
    private String pesel;
    @OneToOne(cascade = CascadeType.ALL)
    private UserDetails details;


    public User(String firstName, String lastName, String telephone, String pesel, UserDetails details) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.telephone = telephone;
        this.pesel = pesel;
        this.details = details;
    }

    public User() {
    }

}
