package hu.elte.DogTrainingApplication.repository;

import hu.elte.DogTrainingApplication.entities.SeasonTicketSegment;
import org.springframework.data.repository.CrudRepository;

public interface SeasonTicketSegmentRepository extends CrudRepository<SeasonTicketSegment, Integer> {
}
