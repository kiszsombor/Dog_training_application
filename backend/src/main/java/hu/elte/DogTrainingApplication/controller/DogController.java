package hu.elte.DogTrainingApplication.controller;


import hu.elte.DogTrainingApplication.api.DogService;
import hu.elte.DogTrainingApplication.api.TrainerService;
import hu.elte.DogTrainingApplication.api.TrickService;
import hu.elte.DogTrainingApplication.entities.Dog;
import hu.elte.DogTrainingApplication.entities.SeasonTicket;
import hu.elte.DogTrainingApplication.entities.Trainer;
import hu.elte.DogTrainingApplication.entities.Trick;
import hu.elte.DogTrainingApplication.wrapper.TrainerAndDogWrapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


/**
 * DogController
 * <p>
 * A Dog Service kommunikációjáért felel.
 *
 * @author Bajári LÚCIA
 * @version 0.0.1
 * @category controller
 */


@Log4j2
@RestController
@CrossOrigin
@RequestMapping("/dog")
public class DogController {
    @Autowired
    private DogService dogService;
    @Autowired
    private TrainerService trainerService;
    @Autowired
    private TrickService trickService;


    @GetMapping("")
    public Iterable<Dog> getAll() {
        return dogService.findAll();
    }

    @GetMapping("/{id}")
    public Dog getDogById(@PathVariable Integer id) {
        Optional<Dog> optionalDog = dogService.findById(id);

        if (optionalDog.isPresent()) {
            return optionalDog.get();
        }
        return null;
    }

    /**
     * @param id
     * @return List<SeasonTicket>
     * Egy diákhoz tartozó összes bérlet kilistázása
     */
    @GetMapping("/{id}/season_tickets")
    public List<SeasonTicket> findAllSeasonTicketByDogId(@PathVariable Integer id) {
        return dogService.findAllSeasonTicketByDogId(id);
    }

    @GetMapping("/{id}/tricks")
    public List<Trick> findTricksByDog(@PathVariable Integer id) {
        System.out.println(dogService.findTricksByDog(id));
        return dogService.findTricksByDog(id);
    }

    @GetMapping("/{id}/tricks/{category}")
    public List<Trick> findTricksByDogIdAndCategory(@PathVariable Integer id, @PathVariable String category) {
        System.out.println("category: " + category);
        System.out.println("tömb: " + dogService.findTricksByDogIdAndCategory(id, category));
        return dogService.findTricksByDogIdAndCategory(id, category);
    }

    @GetMapping("/{id}/owner")
    public Trainer findOwnerByDog(@PathVariable Integer id) {
        Optional<Trainer> optionalTrainer = dogService.findOwnerByDog(id);

        if (optionalTrainer.isPresent()) {
            return optionalTrainer.get();
        }
        return null;
    }

    @GetMapping("/{id}/trainer")
    public Trainer findTrainerByDog(@PathVariable Integer id) {
        Optional<Trainer> optionalTrainer = dogService.findTrainerByDog(id);

        if (optionalTrainer.isPresent()) {
            return optionalTrainer.get();
        }
        return null;
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
     * @param wrapper Új Kutya felvételéhez
     */
    @PostMapping("/save")
    public Dog post(@RequestBody TrainerAndDogWrapper wrapper) {
        wrapper.setTrainer(wrapper.getTrainer(), wrapper.getDog());
        System.out.println("Trainer: " + wrapper.getTrainer());
        return dogService.save(wrapper.getDog());
    }


    @PutMapping("/modify/{id}")
    public void put(@PathVariable Integer id, @RequestBody Dog dog) {
        Optional<Dog> optionalDog = dogService.findById(id);
        Dog oldDog = dog;
        System.out.println(optionalDog.get());

        if (optionalDog.isPresent()) {
            System.out.println("ID " + optionalDog.get().getId());
            oldDog = optionalDog.get();
        }

//        SeasonTicket oldSeasonTicket=seaonTicketService.findById(id).get();
//        System.out.println(("Bérlet: "+oldSeasonTicket.getId()));
        oldDog.setDog(dog.getName(), dog.getBirthDate(), dog.getBreed(),
                dog.getSex(), dog.getWeight(), dog.getTrainer(), dog.getSeasonTickets());

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
    public void deleteAll() {
        dogService.deleteAll();
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public Dog deleteById(@PathVariable Integer id) {
        Dog deletedDog = null;
        List<Dog> dogList = dogService.findAll();
        for (int i = 0; i < dogList.size(); i++) {
            if (dogList.get(i).getId() == id) {
                deletedDog = dogList.get(i);
            }
        }
//        System.out.println("deletedDog1: " + dogService.findById(id));
        dogService.deleteById(id);
//        System.out.println("deletedDog2: " + deletedDog);
        return deletedDog;
    }

}
