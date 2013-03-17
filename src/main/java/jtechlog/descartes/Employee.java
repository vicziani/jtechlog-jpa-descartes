package jtechlog.descartes;

//import org.hibernate.annotations.Fetch;
//import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
//import java.util.Set;

@Entity
@NamedQueries({
        @NamedQuery(name = "findEmployees", query = "select e from Employee e order by e.id"),
        // @NamedQuery(name = "findEmployeeById", query = "select distinct e from Employee e join fetch e.phones join fetch e.addresses where e.id = :id")
        @NamedQuery(name = "findEmployeeByIdFetchPhones", query = "select e from Employee e join fetch e.phones where e.id = :id"),
        @NamedQuery(name = "findEmployeeByIdFetchAddresses", query = "select e from Employee e join fetch e.addresses where e.id = :id")
})
public class Employee implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="EMP_NAME")
    private String name;

    //, fetch = FetchType.EAGER
    @OneToMany(mappedBy = "employee")
    //@OrderColumn(name = "PHONE_ORDER")
    //@Fetch(FetchMode.SUBSELECT)
    private List<Phone> phones;
    //private Set<Phone> phones;

    @OneToMany(mappedBy = "employee")
    //@OrderColumn(name = "ADDRESS_ORDER")
    //@Fetch(FetchMode.SUBSELECT)
    private List<Address> addresses;
    //private Set<Address> addresses;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Phone> getPhones() {
        return phones;
    }

    public void setPhones(List<Phone> phones) {
        this.phones = phones;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

//    public Set<Phone> getPhones() {
//        return phones;
//    }
//
//    public void setPhones(Set<Phone> phones) {
//        this.phones = phones;
//    }
//
//    public Set<Address> getAddresses() {
//        return addresses;
//    }
//
//    public void setAddresses(Set<Address> addresses) {
//        this.addresses = addresses;
//    }
}
