package hu.elte.DogTrainingApplication.repository;

import hu.elte.DogTrainingApplication.entities.Dog;
import hu.elte.DogTrainingApplication.entities.Trainer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;


/**
 * @author Bajári LÚCIA
 * @category Repository
 * @version 0.0.1
 */
public interface DogRepository extends CrudRepository<Dog, Integer> {

    List<Dog> findAll();

    @Query(value = "SELECT * FROM `dog` WHERE trainer_id = :trainerId", nativeQuery = true)
    List<Dog> findAllByTrainerId(@Param("trainerId") Integer trainerId);

//    @Query(value = "SELECT * FROM `trainer` WHERE id IN (SELECT trainer_id from `dog` where id = :dogId)", nativeQuery = true)
//    Trainer findTrainerByDog(@Param("dogId") Integer dogId);


    @Query(value = "SELECT id FROM `trainer` WHERE id IN (SELECT owner_id from `dog` where id = :dogId)", nativeQuery = true)
    Integer findOwnerByDog(@Param("dogId") Integer dogId);

    @Query(value = "SELECT id FROM `trainer` WHERE id IN (SELECT trainer_id from `dog` where id = :dogId)", nativeQuery = true)
    Integer findTrainerByDog(@Param("dogId") Integer dogId);


//    void deleteAll();
//
//    void deleteById(Integer id);
}
