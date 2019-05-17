package hu.elte.DogTrainingApplication.repository;

import hu.elte.DogTrainingApplication.entities.SeasonTicketSegment;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SeasonTicketSegmentRepository extends CrudRepository<SeasonTicketSegment, Integer> {
    List<SeasonTicketSegment> findAllBySeasonTicketId(Integer seasonTicketId);
}
