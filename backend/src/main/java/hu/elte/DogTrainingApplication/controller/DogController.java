package hu.elte.DogTrainingApplication.controller;


import hu.elte.DogTrainingApplication.api.DogService;
import hu.elte.DogTrainingApplication.entities.Dog;
import hu.elte.DogTrainingApplication.entities.SeasonTicket;
import hu.elte.DogTrainingApplication.entities.SeasonTicketSegment;
import hu.elte.DogTrainingApplication.entities.Trick;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


/**
 * DogController
 *
 * A Dog Service kommunikációjáért felel.
 *
 * @author Bajári LÚCIA
 * @category controller
 * @version 0.0.1
 */


@Log4j2
@RestController
@CrossOrigin
@RequestMapping("/dog")
public class DogController {
    @Autowired
    private DogService dogService;


    @GetMapping("")
    public Iterable<Dog> getAll() {
        return dogService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Dog> getDogById(@PathVariable Integer id) {
        Dog dog= dogService.findById(id);
        if (!dog.equals(null)) {
            return ResponseEntity.ok(dog);
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     * @param id
     * @return List<SeasonTicket>
     *      Egy diákhoz tartozó összes bérlet kilistázása
     */
    @GetMapping("/{id}/season_tickets")
    public List<SeasonTicket> findAllSeasonTicketByDogId(@PathVariable Integer id){
        return dogService.findAllSeasonTicketByDogId(id);
    }

    /**
     * @param id
     * @param seasonTicketId
     * @return  List<SeasonTicketSegment>
     *     Egy kztya bérletei közül egy adott id alapján egy bérlet lekérdezése (szegmenseinek megjelenítése)
     */
    @GetMapping("/{id}/season_tickets/{seasonTicketId}")
    public List<SeasonTicketSegment> findAllSeasonTicketSegmentBySeasonTicketId(@PathVariable Integer id, @PathVariable Integer seasonTicketId){
        return dogService.findAllSeasonTicketSegmentBySeasonTicketId(seasonTicketId);
    }

    @GetMapping("/{id}/tricks")
    public List<Trick> findTricksByDog(@PathVariable Integer id){
        System.out.println(dogService.findTricksByDog(id));
        return dogService.findTricksByDog(id);
    }


}
