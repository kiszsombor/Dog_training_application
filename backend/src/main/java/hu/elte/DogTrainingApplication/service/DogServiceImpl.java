package hu.elte.DogTrainingApplication.service;

import hu.elte.DogTrainingApplication.api.DogService;
import hu.elte.DogTrainingApplication.entities.Dog;
import hu.elte.DogTrainingApplication.repository.DogRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author Bajári LÚCIA
 * @category Service
 * @version 0.0.1
 * Implementálja a DogService interface-t
 */

@Service
@Log4j2
public class DogServiceImpl implements DogService {
    @Autowired
    private DogRepository dogRepository;

    @Override
    public Iterable<Dog> findAll() {
        return dogRepository.findAll();
    }

    @Override
    public Optional<Dog> findById(Integer id) {
        return dogRepository.findById(id);
    }

    @Override
    public void save(Dog dog) {
        dogRepository.save(dog);
    }

}
