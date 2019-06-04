package hu.elte.DogTrainingApplication.controller;

import hu.elte.DogTrainingApplication.api.TrickService;
import hu.elte.DogTrainingApplication.entities.Trick;
import jdk.nashorn.internal.runtime.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Logger
@RestController
@CrossOrigin
@RequestMapping("/trick")
public class TrickController {

    @Autowired
    private TrickService trickService;

    @GetMapping("")
    public Iterable<Trick> findAll() {
        return trickService.findAll();
    }

    @GetMapping("/{category}")
    public List<Trick> getTricksByCategory(@PathVariable String category) {
        return trickService.findTricksByCategory(category);
    }

    @PostMapping("/save/{dogId}/{trickId}")
    public void postDogTricks(@PathVariable Integer dogId, @PathVariable Integer trickId) {
        trickService.postDogTricks(dogId, trickId);
    }

    @DeleteMapping("/delete/{dogId}/{trickId}")
    public void deleteDogTricksByDogIdAndTrickId(@PathVariable Integer dogId, @PathVariable Integer trickId) {
        trickService.deleteDogTricksByDogIdAndTrickId(dogId, trickId);
    }
}
