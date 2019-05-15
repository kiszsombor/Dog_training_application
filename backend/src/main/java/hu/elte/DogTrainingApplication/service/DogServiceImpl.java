package hu.elte.DogTrainingApplication.service;

import hu.elte.DogTrainingApplication.api.DogService;
import hu.elte.DogTrainingApplication.entities.Dog;
import hu.elte.DogTrainingApplication.entities.SeasonTicket;
import hu.elte.DogTrainingApplication.entities.SeasonTicketSegment;
import hu.elte.DogTrainingApplication.entities.Trick;
import hu.elte.DogTrainingApplication.repository.DogRepository;
import hu.elte.DogTrainingApplication.repository.SeasonTicketRepository;
import hu.elte.DogTrainingApplication.repository.SeasonTicketSegmentRepository;
import hu.elte.DogTrainingApplication.repository.TrickRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
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
    @Autowired
    private SeasonTicketRepository seasonTicketRepository;
    @Autowired
    private SeasonTicketSegmentRepository seasonTicketSegmentRepository;
    @Autowired
    private TrickRepository trickRepository;

    @Override
    public Iterable<Dog> findAll() {
        return dogRepository.findAll();
    }

    @Override
    public Dog findById(Integer id) {

        Optional<Dog> optional =dogRepository.findById(id);
        if(optional.isPresent()){
            return optional.get();
        }
        return null;
    }

    @Override
    public Dog save(Dog dog) {
        return dogRepository.save(dog);
    }

    @Override
    public List<SeasonTicket> findAllSeasonTicketByDogId(Integer dogId) {
        return seasonTicketRepository.findAllByDogId(dogId);
    }

    @Override
    public List<SeasonTicketSegment> findAllSeasonTicketSegmentBySeasonTicketId(Integer seasonTicketId) {
        return seasonTicketSegmentRepository.findAllBySeasonTicketId(seasonTicketId);
    }

    @Override
    public void deleteById(Integer dogId) {
//        Optional<Dog> dog=dogRepository.findById(dogId);
//        if(dog.isPresent()){
//            return dog.get();
//        }
        dogRepository.deleteById(dogId);
       // return null;
    }

    @Override
    public List<Trick> findTricksByDog(Integer dogId) {
        System.out.println(trickRepository.findTricksByDog(dogId));
        return trickRepository.findTricksByDog(dogId);
    }

}
