package hu.elte.DogTrainingApplication.api;

import hu.elte.DogTrainingApplication.entities.SeasonTicket;

import java.util.Optional;

/**
 * SeasonTicketService interfésze
 *
 * @author Bajári LÚCIA
 * @category Interface
 */

public interface SeasonTicketService {
    /**
     * @return Iterable<SeasonTicket>
     *     Az összes bérlet kilistázása
     */
    Iterable<SeasonTicket> findAll();

    /**
     * @param id
     * @return Optional<SeasonTicket>
     *     Bizonyos id alapján egy bérlet lekérdezése, ha az létezik
     */
    Optional<SeasonTicket> findById(Integer id);

    /**
     * @param seasonTicket
     *     Új bérlet felvételéhez
     */
    void save (SeasonTicket seasonTicket);
}
