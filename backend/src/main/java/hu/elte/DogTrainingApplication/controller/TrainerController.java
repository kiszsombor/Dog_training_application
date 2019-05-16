package hu.elte.DogTrainingApplication.controller;

import hu.elte.DogTrainingApplication.api.DogService;
import hu.elte.DogTrainingApplication.api.TrainerService;
import hu.elte.DogTrainingApplication.entities.Dog;
import hu.elte.DogTrainingApplication.entities.Trainer;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * TrainerController
 *
 * A Trainer Service kommunikációjáért felel.
 *
 * @author Bajári LÚCIA
 * @category controller
 * @version 0.0.1
 */

@Log4j2
@RestController
@CrossOrigin
@RequestMapping("/trainer")
public class TrainerController {

    @Autowired
    private TrainerService trainerService;

    @Autowired
    private DogService dogService;

    @GetMapping("")
    public Iterable<Trainer> getAll() {
        return trainerService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Trainer> getTrainerById(@PathVariable Integer id) {
        Optional<Trainer> optional= trainerService.findById(id);
        if (optional.isPresent()) {
            return ResponseEntity.ok(optional.get());
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/dog/{id}")
    public List<Dog> getDogs(@PathVariable Integer id) {
        return dogService.findDogByTrainerId(id);
    }
}
