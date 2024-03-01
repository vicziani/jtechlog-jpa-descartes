package employees;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
@NamedEntityGraph(name = "graph.Employee.phonesAndAddresses",
        attributeNodes = {@NamedAttributeNode("phones"), @NamedAttributeNode("addresses")})

public class Employee implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="EMP_NAME")
    private String name;

    @OneToMany(mappedBy = "employee")
    private List<Phone> phones;
//    @OneToMany(mappedBy = "employee", fetch = FetchType.EAGER)
//    private Set<Phone> phones;

    @OneToMany(mappedBy = "employee")
    private List<Address> addresses;
//    @OneToMany(mappedBy = "employee", fetch = FetchType.EAGER)
//    private Set<Address> addresses;

}
