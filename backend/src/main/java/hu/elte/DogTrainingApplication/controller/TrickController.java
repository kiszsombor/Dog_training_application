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
}
