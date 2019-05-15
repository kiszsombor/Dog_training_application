package hu.elte.DogTrainingApplication.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import hu.elte.DogTrainingApplication.common.TrickCategory;
import hu.elte.DogTrainingApplication.common.TrickName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Table(name = "trick")
public class Trick implements Serializable{

    @Transient
    private static final long serialVersionUID= -8633980627458783249L;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    @NotNull
    @Column(name = "name")
    private TrickName name;

    @Enumerated(EnumType.STRING)
    @NotNull
    @Column(name = "category")
    private TrickCategory category;

//    @JsonIgnore
//    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "tricks")
//    //@ManyToMany(mappedBy = "tricks")
//    private Set<Dog> dogs;
}