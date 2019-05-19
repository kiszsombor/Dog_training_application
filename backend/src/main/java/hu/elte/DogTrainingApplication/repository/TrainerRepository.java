package hu.elte.DogTrainingApplication.repository;

import hu.elte.DogTrainingApplication.entities.Dog;
import hu.elte.DogTrainingApplication.entities.Trainer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.List;

/**
 * @author Bajári LÚCIA
 * @category Repository
 * @version 0.0.1
 */
public interface TrainerRepository extends CrudRepository<Trainer, Integer> {

    @Query(value = "SELECT * FROM `trainer` WHERE username = :username", nativeQuery = true)
    Trainer findByUsername(@Param("username") String username);
    

    Optional<Trainer> findByName(String name);
//    Trainer findByUsername(String name);

}
