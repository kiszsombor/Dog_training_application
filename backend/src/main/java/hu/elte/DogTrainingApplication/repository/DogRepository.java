package hu.elte.DogTrainingApplication.repository;

import hu.elte.DogTrainingApplication.entities.Dog;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;


/**
 * @author Bajári LÚCIA
 * @category Repository
 * @version 0.0.1
 */
public interface DogRepository extends CrudRepository<Dog, Integer> {

}
