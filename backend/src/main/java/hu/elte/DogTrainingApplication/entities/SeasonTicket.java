package hu.elte.DogTrainingApplication.entities;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import hu.elte.DogTrainingApplication.common.SeasonTicketType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.tomcat.jni.Local;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

/**
 *
 * @author kiszs
 * @category entity
 */
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "season_ticket")
public class SeasonTicket implements Serializable {
    @Transient
    private static final long serialVersionUID= 6921592859109495666L;

    @Id
    @Column(name = "id", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "start_date", updatable = false)
    @CreationTimestamp
    private LocalDateTime startDate;

    @Column(name = "end_date", updatable = false)
    @UpdateTimestamp
    private LocalDateTime endDate;

    @Column(name = "type")
    private SeasonTicketType type;

    @Column(name = "paid")
    private Boolean paid;


    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "seasonTicket")
    private Set<SeasonTicketSegment> seasonTicketSegments;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "dog_id", nullable = false)
    private Dog dog;

    public void setSeasonTicket(LocalDateTime startDate, LocalDateTime endDate, SeasonTicketType type, Boolean paid, Dog dog, Set<SeasonTicketSegment> seasonTicketSegments) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.type = type;
        this.paid = paid;
        this.dog = dog;
        this.seasonTicketSegments = seasonTicketSegments;
    }
}
