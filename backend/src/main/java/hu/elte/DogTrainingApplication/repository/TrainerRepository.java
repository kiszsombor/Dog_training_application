package hu.elte.DogTrainingApplication.repository;

import hu.elte.DogTrainingApplication.entities.Trainer;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Bajári LÚCIA
 * @version 0.0.1
 * @category Repository
 */
public interface TrainerRepository extends CrudRepository<Trainer, Integer> {

}
