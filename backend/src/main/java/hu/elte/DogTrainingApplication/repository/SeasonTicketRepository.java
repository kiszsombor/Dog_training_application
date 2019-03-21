package hu.elte.DogTrainingApplication.repository;

import hu.elte.DogTrainingApplication.entities.SeasonTicket;
import org.springframework.data.repository.CrudRepository;
/**
 * @author Bajári LÚCIA
 * @category Repository
 * @version 0.0.1
 */
public interface SeasonTicketRepository extends CrudRepository<SeasonTicket, Integer> {
}
