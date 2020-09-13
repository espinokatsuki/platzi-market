package io.maya.platzimarket.persistance.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "clients")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Client {
    private @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    private @Column(name = "first_name")
    String firstName;
    private @Column(name = "last_name")
    String lastName;
    private Long cellphone;
    private String address;
    private String email;
    private @OneToMany(mappedBy = "client")
    List<Purchase> purchases;
}
