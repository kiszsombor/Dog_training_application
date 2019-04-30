package hu.elte.DogTrainingApplication.controller;

import hu.elte.DogTrainingApplication.api.TrickService;
import hu.elte.DogTrainingApplication.entities.Trick;
import jdk.nashorn.internal.runtime.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
