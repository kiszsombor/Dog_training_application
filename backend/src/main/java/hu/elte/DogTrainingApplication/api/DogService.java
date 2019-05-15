package hu.elte.DogTrainingApplication.api;

import hu.elte.DogTrainingApplication.entities.Dog;
import hu.elte.DogTrainingApplication.entities.SeasonTicket;
import hu.elte.DogTrainingApplication.entities.SeasonTicketSegment;
import hu.elte.DogTrainingApplication.entities.Trick;

import java.util.List;

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
     * @return Dog
     *      Egy kutya lekérése id alapján
     */
    Dog findById(Integer id);

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
     * @param dogId
     *  Id alapján kutya törlése
     */
    Dog deleteById(Integer dogId);

    /**
     * @param dogId
     * @return List<Trick>
     *     Egy kutyához tartozó trükkök lekérdezése
     */
    List<Trick> findTricksByDog(Integer dogId);



}
