package hu.elte.DogTrainingApplication.entities;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
 * @modify: Bajári Lúcia: 19/03/21
 *
 */
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "season_ticket_segment")
public class SeasonTicketSegment implements Serializable {

    @Transient
    private static final long serialVersionUID= 9220596922452110584L;

    @Id
    @Column(name = "id", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    //@Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date", nullable = false)
    private LocalDateTime date;

    //TODO: percekben megadott időpontok kellenek ide, az nem jó Integer típusnak?
    @Column(name = "spent_time",nullable = false)
    private LocalDateTime spentTime;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "season_ticket_id", nullable = false)
    private SeasonTicket seasonTicket;

}
