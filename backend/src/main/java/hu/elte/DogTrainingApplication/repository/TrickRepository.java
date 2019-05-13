package hu.elte.DogTrainingApplication.repository;

import hu.elte.DogTrainingApplication.entities.Trick;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TrickRepository extends CrudRepository<Trick, Integer> {
    List<Trick> findAll();

    @Query(value = "SELECT * FROM `trick` WHERE id IN (SELECT trick_id from `dog_tricks` where dog_id=:#{#dogId})", nativeQuery = true)
    List<Trick> findTricksByDog(Integer dogId);

}
