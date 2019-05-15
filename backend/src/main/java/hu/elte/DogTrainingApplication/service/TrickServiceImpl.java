package hu.elte.DogTrainingApplication.service;

import hu.elte.DogTrainingApplication.api.TrickService;
import hu.elte.DogTrainingApplication.common.TrickCategory;
import hu.elte.DogTrainingApplication.entities.Trick;
import hu.elte.DogTrainingApplication.repository.TrickRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
public class TrickServiceImpl implements TrickService {
    @Autowired
    private TrickRepository trickRepository;

    @Override
    public List<Trick> findAll(){
        return trickRepository.findAll();
    }

    @Override
    public List<Trick> findTricksByCategory(String category) {
        TrickCategory type=TrickCategory.valueOf(category.toUpperCase());
        System.out.println(type.toString());
        return trickRepository.findAllByCategory(type);
    }
}
