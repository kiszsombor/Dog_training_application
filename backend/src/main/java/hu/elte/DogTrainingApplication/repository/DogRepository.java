package hu.elte.DogTrainingApplication.repository;

import hu.elte.DogTrainingApplication.entities.Dog;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

/**
 * @author Bajári LÚCIA
 * @category Repository
 * @version 0.0.1
 */
public interface DogRepository extends CrudRepository<Dog, Integer> {

}
