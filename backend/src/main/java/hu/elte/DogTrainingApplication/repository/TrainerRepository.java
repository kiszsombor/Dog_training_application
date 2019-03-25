package hu.elte.DogTrainingApplication.repository;

import hu.elte.DogTrainingApplication.entities.Dog;
import hu.elte.DogTrainingApplication.entities.Trainer;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Bajári LÚCIA
 * @category Repository
 * @version 0.0.1
 */
public interface TrainerRepository extends CrudRepository<Trainer, Integer> {
}
