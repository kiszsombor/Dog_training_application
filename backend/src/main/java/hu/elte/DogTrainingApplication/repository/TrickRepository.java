package hu.elte.DogTrainingApplication.repository;

import hu.elte.DogTrainingApplication.common.TrickCategory;
import hu.elte.DogTrainingApplication.entities.Trick;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface TrickRepository extends CrudRepository<Trick, Integer> {
    List<Trick> findAll();

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM `dog_tricks` WHERE `dog_id` = :dogId", nativeQuery = true)
    void deleteDogTricksByDogId(@Param("dogId") Integer dogId);

    //@Query(value = "SELECT u FROM User u WHERE u.name IN :names")
    @Query(value = "SELECT * FROM `trick` WHERE id IN (SELECT trick_id from `dog_tricks` where dog_id = :dogId)", nativeQuery = true)
    List<Trick> findTricksByDog(@Param("dogId") Integer dogId);

    //@Query(value = "SELECT * FROM trick WHERE category = :#{#languageType}", nativeQuery = true)
    List<Trick> findAllByCategory(TrickCategory category);

    //@Query(value = "SELECT * FROM `trick` WHERE id IN (SELECT trick_id from `dog_tricks` where dog_id=:#{#dogId})", nativeQuery = true)
    //List<Trick> findTricksByDog(Integer dogId);

}
