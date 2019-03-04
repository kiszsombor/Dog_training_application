package hu.elte.DogTrainingApplication.service;

import hu.elte.DogTrainingApplication.api.DogService;
import hu.elte.DogTrainingApplication.entities.Dog;
import hu.elte.DogTrainingApplication.repository.DogRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.TimeZone;

@Service
@Log4j2
public class DogServiceImpl implements DogService {
    @Autowired
    private DogRepository dogRepository;
    @Override
    public boolean nothing() {
        System.out.println(TimeZone.getDefault());
        return false;
    }

    @Override
    public List<Dog> findAll() {
        return dogRepository.findAll();
    }

}
