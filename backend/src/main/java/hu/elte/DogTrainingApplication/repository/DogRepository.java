package hu.elte.DogTrainingApplication.repository;

import hu.elte.DogTrainingApplication.entities.Dog;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;


/**
 * @author Bajári LÚCIA
 * @category Repository
 * @version 0.0.1
 */
public interface DogRepository extends CrudRepository<Dog, Integer> {

    List<Dog> findAll();


//    void deleteAll();
//
//    void deleteById(Integer id);
}
