package hu.elte.DogTrainingApplication.controller;

import hu.elte.DogTrainingApplication.api.DogService;
import hu.elte.DogTrainingApplication.api.TrainerService;
import hu.elte.DogTrainingApplication.common.Role;
import hu.elte.DogTrainingApplication.config.AutenticatedTrainer;
import hu.elte.DogTrainingApplication.entities.Dog;
import hu.elte.DogTrainingApplication.entities.Trainer;
import hu.elte.DogTrainingApplication.repository.TrainerRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
    private TrainerRepository trainerRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Autowired
    private AutenticatedTrainer authenticatedOwner;

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
    @PostMapping("/registration")
    public ResponseEntity<Trainer> regisztracio(@RequestBody Trainer trainer) {
        Optional<Trainer> oUser = trainerRepository.findByName(trainer.getName());
        if (oUser.isPresent()) {
            return ResponseEntity.badRequest().build();
        }
        trainer.setPassword(passwordEncoder.encode(trainer.getPassword()));
        trainer.setRole(Role.ROLE_USER);
        return ResponseEntity.ok(trainerRepository.save(trainer));
    }

    @GetMapping("/{id}/dogs")
    public List<Dog> getDogs(@PathVariable Integer id) {
        return dogService.findDogByTrainerId(id);
    }


    @PostMapping("/login")
    public Trainer login(@RequestBody Trainer trainer) {
//        System.out.println(authenticatedOwner.getTrainer());
//        System.out.println(trainer);
        Optional<Trainer> tr=trainerRepository.findByUsername(trainer.getUsername());

//        String email = trainer.getEmail();
//        String password = trainer.getPassword();

        System.out.println("Tr "+tr);
        authenticatedOwner.setTrainer(tr.get());
        return authenticatedOwner.getTrainer();
    }
}
