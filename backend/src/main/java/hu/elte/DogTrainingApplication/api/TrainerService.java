package hu.elte.DogTrainingApplication.api;

import hu.elte.DogTrainingApplication.entities.Dog;
import hu.elte.DogTrainingApplication.entities.Trainer;

import java.util.List;
import java.util.Optional;
/**
 * TrainerService interfésze
 *
 * @author Bajári LÚCIA
 * @category Interface
 */
public interface TrainerService {

    /**
     * @return Iterable<Trainer>
     *     Az összes oktató kilistázása
     */
    Iterable<Trainer> findAll();

    /**
     * @param id
     * @return Optional<Trainer>
     *     Egy oktató lekérése id alapján
     */
    Optional<Trainer> findById(Integer id);


}
