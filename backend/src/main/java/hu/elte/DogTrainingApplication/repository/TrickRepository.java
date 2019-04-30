package hu.elte.DogTrainingApplication.repository;

import hu.elte.DogTrainingApplication.entities.Trick;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TrickRepository extends CrudRepository<Trick, Integer> {
    List<Trick> findAll();
}
