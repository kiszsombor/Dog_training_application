package hu.elte.DogTrainingApplication.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import hu.elte.DogTrainingApplication.common.DogSex;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Bajári LÚCIA
 * @category entity
 *
 * @version: 0.0.1
 *
 * Dog entity, ami tartalmazza egy kutya tárolásához szükséges információkat
 */
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "dog")
public class Dog implements Serializable {
    @Transient
    private static final long serialVersionUID = -2111292372311783482L;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "birth_date")
    private Date birthDate;

    @Column(name = "breed")
    private String breed;

    @Enumerated(EnumType.STRING)
    @NotNull
    @Column(name = "sex")
    private DogSex sex;

    @Column(name = "weight")
    private Integer weight;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "trainer_id", nullable = false)
    private Trainer trainer;

//    @JsonIgnore
//    @ManyToMany(cascade = { CascadeType.ALL })
//    @JoinTable(
//            name = "dog_tricks",
//            joinColumns = { @JoinColumn(name = "dog_id", referencedColumnName = "id") },
//            inverseJoinColumns = { @JoinColumn(name = "trick_id", referencedColumnName = "id") }
//    )
//    Set<Trick> tricks;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinTable(name = "dog_tricks", joinColumns = @JoinColumn(name = "dog_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "trick_id", referencedColumnName = "id"))
    private Set<Trick> tricks;
}
