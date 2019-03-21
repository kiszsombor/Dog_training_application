package hu.elte.DogTrainingApplication.api;

import hu.elte.DogTrainingApplication.entities.SeasonTicketSegment;

import java.util.Optional;
/**
 * SeasonTicketService interfésze
 *
 * @author Bajári LÚCIA
 * @category Interface
 */
public interface SeasonTicketSegmentService {

    /**
     * @return Iterable<SeasonTicketSegment>
     *     Összes bérlet szegmens kilistázása
     */
    Iterable<SeasonTicketSegment> findAll();
    //TODO: erre a funkcióra szerintem nem lesz szükség a későbbiekben
    /**
     * @param id
     * @return Optional<SeasonTicketSegment>
     *     Bizonyos id alapján egy bérlet szegmensének lekérdezése, ha az létezik
     */
    Optional<SeasonTicketSegment> findById(Integer id);


    /**
     * @param seasonTicketSegment
     *     Új bérlet egy szegmensének felvételéhez
     */
    void save (SeasonTicketSegment seasonTicketSegment);
}
