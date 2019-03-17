package hu.elte.DogTrainingApplication.entities;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

/**
 * @author kiszs
 * @category entity
 *
 */
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "season_ticket_segment")
public class SeasonTicketSegment {

    @Id
    @Column(name = "id", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "season_ticket_id", updatable = false, nullable = false)
    private Integer seasonTicketId;

    @Column(name = "date", updatable = false)
    private LocalDateTime start_at;

    @Column(name = "spent_time")
    private LocalDateTime spentTime;

    @OneToOne
    @JoinColumn(name = "season_ticket_id", nullable = false)
    private SeasonTicket seasonTicket;

}
