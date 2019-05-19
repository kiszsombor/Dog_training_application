package hu.elte.DogTrainingApplication.api;

import hu.elte.DogTrainingApplication.entities.*;

import java.util.List;
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
    List<Dog> findAll();

    /**
     * @param id
     * @return Dog
     *      Egy kutya lekérése id alapján
     */
    Optional<Dog> findById(Integer id);

    /**
     * @param dog
     *  Új kutya regisztrálásához
     */
    Dog save(Dog dog);
    /**
     * @param dogId
     * @return  List<SeasonTicket>
     *     Egy kutyához tartozó összes bérlet lekérdezése
     */
    List<SeasonTicket> findAllSeasonTicketByDogId(Integer dogId);


    /**
     * @param seasonTicketId
     * @return  List<SeasonTicketSegment>
     *     Egy bérlethez tartozó összes id lekérdezése
     */
    List<SeasonTicketSegment> findAllSeasonTicketSegmentBySeasonTicketId(Integer seasonTicketId);

    /**
     * @param id
     *  Id alapján kutya törlése
     */

    void deleteById(Integer id);
    void deleteAll();

//    Dog deleteById(Integer dogId);

    Optional<Trainer> findOwnerByDog(Integer dogId);

    Optional<Trainer> findTrainerByDog(Integer dogId);


        /**
         * @param dogId
         * @return List<Trick>
         *     Egy kutyához tartozó trükkök lekérdezése
         */
    List<Trick> findTricksByDog(Integer dogId);

    List <Dog> findDogByTrainerId(Integer trainerId);

    List<Trick> findTricksByDogIdAndCategory(Integer dogId, String category);

}
