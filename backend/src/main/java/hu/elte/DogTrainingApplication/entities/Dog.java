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


    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "dog")
    private Set<SeasonTicket> seasonTickets;

//    @JsonIgnore
//    @ManyToMany(cascade = { CascadeType.ALL })
//    @JoinTable(
//            name = "dog_tricks",
//            joinColumns = { @JoinColumn(name = "dog_id", referencedColumnName = "id") },
//            inverseJoinColumns = { @JoinColumn(name = "trick_id", referencedColumnName = "id") }
//    )
//    Set<Trick> tricks;



//    @JsonIgnore
//    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
//    @JoinTable(name = "dog_tricks", joinColumns = @JoinColumn(name = "dog_id", referencedColumnName = "id"),
//            inverseJoinColumns = @JoinColumn(name = "trick_id", referencedColumnName = "id"))
//    private Set<Trick> tricks;

//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public Date getBirthDate() {
//        return birthDate;
//    }
//
//    public void setBirthDate(Date birthDate) {
//        this.birthDate = birthDate;
//    }
//
//    public String getBreed() {
//        return breed;
//    }
//
//    public void setBreed(String breed) {
//        this.breed = breed;
//    }
//
//    public DogSex getSex() {
//        return sex;
//    }
//
//    public void setSex(DogSex sex) {
//        this.sex = sex;
//    }
//
//    public Integer getWeight() {
//        return weight;
//    }
//
//    public void setWeight(Integer weight) {
//        this.weight = weight;
//    }
//
//    public Trainer getTrainer() {
//        return trainer;
//    }
//
//    public void setTrainer(Trainer trainer) {
//        this.trainer = trainer;
//    }
//
//    public Set<Trick> getTricks() {
//        return tricks;
//    }
//
//    public void setTricks(Set<Trick> tricks) {
//        this.tricks = tricks;
//    }
}
