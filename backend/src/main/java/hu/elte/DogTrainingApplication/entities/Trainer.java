package hu.elte.DogTrainingApplication.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import hu.elte.DogTrainingApplication.common.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;
/**
 * @author Bajári LÚCIA
 * @category entity
 *
 * @version: 0.0.1
 *
 * Trainer entity, ami tartalmazza egy trainer (edző) tárolásához szükséges információkat
 */
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "trainer")
public class Trainer implements Serializable {

    @Transient
    private static final long serialVersionUID = 6680215604083741163L;

    @Id
    @Column(name = "id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;
    
    @Column(name = "username", nullable = false)
    private String username;

    @Column( name="password",nullable = false)
    private String password;

    @Column(name = "email")
    private String email;

    @Column(name = "address")
    private String address;

    @Column(name = "phone_number")
    private Integer phoneNumber;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "birth_date")
    private Date birthDate;

    @Column(name = "birth_place")
    private String birthPlace;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "trainer")
    private Set<Dog> dogs;

}