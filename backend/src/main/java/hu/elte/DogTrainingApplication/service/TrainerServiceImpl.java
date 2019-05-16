package hu.elte.DogTrainingApplication.service;

import hu.elte.DogTrainingApplication.api.TrainerService;
import hu.elte.DogTrainingApplication.entities.Dog;
import hu.elte.DogTrainingApplication.entities.Trainer;
import hu.elte.DogTrainingApplication.repository.TrainerRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


/**
 * @author Bajári LÚCIA
 * @category Service
 * @version 0.0.1
 * Implementálja a TrainerService interface-t
 */

@Log4j2
@Service
public class TrainerServiceImpl implements TrainerService {

    @Autowired
    private TrainerRepository trainerRepository;


    @Override
    public Iterable<Trainer> findAll() {
        return trainerRepository.findAll();
    }

    @Override
    public Optional<Trainer> findById(Integer id) {
        return trainerRepository.findById(id);
    }


}
