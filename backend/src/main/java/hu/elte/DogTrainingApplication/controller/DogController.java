package hu.elte.DogTrainingApplication.controller;


import hu.elte.DogTrainingApplication.api.DogService;
import hu.elte.DogTrainingApplication.entities.Dog;
import hu.elte.DogTrainingApplication.repository.DogRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Log4j2
@RestController
@CrossOrigin
@RequestMapping("/dog")

public class DogController {
    @Autowired
    private DogService dogService;
    @Autowired
    private DogRepository dogRepository;

    @GetMapping("")
    public Iterable<Dog> getAll() {
        return dogService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Dog> getDogById(@PathVariable Integer id) {
        Optional<Dog> optional= dogRepository.findById(id);
        if (optional.isPresent()) {
            return ResponseEntity.ok(optional.get());
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }



}
