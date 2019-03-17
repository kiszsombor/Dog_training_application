package hu.elte.DogTrainingApplication.entities;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
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
public class SeasonTicket {

    @Id
    @Column(name = "id", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "start_date", updatable = false)
    @CreationTimestamp
    private LocalDateTime start_at;

    @Column(name = "end_date", updatable = false)
    @UpdateTimestamp
    private LocalDateTime end_at;

    @Column(name = "paid")
    private boolean paid;

    @Column(name = "dog_id", updatable = false)
    private boolean dogId;

    @OneToOne
    @JoinColumn
    private SeasonTicketSegment seasonTicketSegment;

    @OneToOne
    @JoinColumn(name = "dog_id", nullable = false)
    private Dog dog_id;
}
