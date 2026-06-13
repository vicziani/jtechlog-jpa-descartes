package employees;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Phone {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="PHONE_TYPE")
    private String type;

    @Column(name="PHONE_NUMBER")
    private String number;
    
    @ManyToOne
    private Employee employee;

}
