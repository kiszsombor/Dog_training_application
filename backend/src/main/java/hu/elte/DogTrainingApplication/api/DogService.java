package hu.elte.DogTrainingApplication.api;

import hu.elte.DogTrainingApplication.entities.Dog;
import java.util.Optional;
/**
 * DogService interfésze
 *
 * @author Bajári LÚCIA
 * @category Interface
 */
public interface DogService {

    /**
     * @return Iterable<Dog>
     *     Az összes kutya kilistázása
     */
    Iterable<Dog> findAll();

    /**
     * @param id
     * @return Optional<Dog>
     *      Egy kutya lekérése id alapján
     */
    Optional<Dog> findById(Integer id);
}
