package hu.elte.DogTrainingApplication.controller;


import hu.elte.DogTrainingApplication.api.DogService;
import hu.elte.DogTrainingApplication.entities.Dog;
import hu.elte.DogTrainingApplication.entities.SeasonTicket;
import hu.elte.DogTrainingApplication.entities.SeasonTicketSegment;
import hu.elte.DogTrainingApplication.entities.Trick;
import hu.elte.DogTrainingApplication.wrapper.TrainerAndDogWrapper;
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
    public Dog getDogById(@PathVariable Integer id) {
        Optional<Dog> optionalDog= dogService.findById(id);

        if (optionalDog.isPresent()) {
            return optionalDog.get();
        }
        return null;
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

//    /**
//     * @param dog
//     * @return Dog
//     * Új kutya hozzáadása
//     */
//    @PostMapping("/save")
//    public Dog post(@RequestBody Dog dog) {
//        System.out.println("DOG: "+dog);
//        return dogService.save(dog);
//    }


    /**
     * @param wrapper
     * Új Kutya felvételéhez
     */
    @PostMapping("/save")
    public Dog post(@RequestBody TrainerAndDogWrapper wrapper) {
        wrapper.setTrainer(wrapper.getTrainer(),wrapper.getDog());
        System.out.println("Trainer: "+wrapper.getTrainer());
        return dogService.save(wrapper.getDog());
    }




    @PutMapping("/modify/{id}")
    public void put(@PathVariable Integer id, @RequestBody Dog dog) {
        Optional<Dog> optionalDog = dogService.findById(id);
        Dog oldDog=dog;
        System.out.println(optionalDog.get());

        if(optionalDog.isPresent()) {
            System.out.println("ID " + optionalDog.get().getId());
            oldDog=optionalDog.get();
        }

//        SeasonTicket oldSeasonTicket=seaonTicketService.findById(id).get();
//        System.out.println(("Bérlet: "+oldSeasonTicket.getId()));
        oldDog.setDog(dog.getName(),dog.getBirthDate(),dog.getBreed(),
                dog.getSex(),dog.getWeight(),dog.getTrainer(), dog.getSeasonTickets());

        dogService.save(oldDog);
    }

//    @DeleteMapping("/delete/{id}")
//    @ResponseBody
//    public Dog deleteDog(@PathVariable("id") Integer id) {
//        try {
//            return dogService.deleteById(id);
//        } catch (Exception e) {
//            log.error("Nem sikerült a season ticket lekérdezése {}", e.getMessage());
//            return null;
//        }
//    }

    /*********************************************************************************************************************/


    @DeleteMapping("/delete")
    public void deleteAll(){
        dogService.deleteAll();
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public Dog deleteById(@PathVariable Integer id){
        Dog deletedDog = null;
        List<Dog> dogList= dogService.findAll();
        for(int i=0;i<dogList.size();i++){
            if(dogList.get(i).getId() == id){
                deletedDog = dogList.get(i);
            }
        }
//        System.out.println("deletedDog1: " + dogService.findById(id));
        dogService.deleteById(id);
//        System.out.println("deletedDog2: " + deletedDog);
        return deletedDog;
    }

}
