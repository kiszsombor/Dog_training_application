package hu.elte.DogTrainingApplication.service;

import hu.elte.DogTrainingApplication.api.DogService;
import hu.elte.DogTrainingApplication.common.TrickCategory;
import hu.elte.DogTrainingApplication.entities.Dog;
import hu.elte.DogTrainingApplication.entities.SeasonTicket;
import hu.elte.DogTrainingApplication.entities.Trainer;
import hu.elte.DogTrainingApplication.entities.Trick;
import hu.elte.DogTrainingApplication.repository.DogRepository;
import hu.elte.DogTrainingApplication.repository.SeasonTicketRepository;
import hu.elte.DogTrainingApplication.repository.TrainerRepository;
import hu.elte.DogTrainingApplication.repository.TrickRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author Bajári LÚCIA
 * @version 0.0.1
 * Implementálja a DogService interface-t
 * @category Service
 */

@Service
@Log4j2
public class DogServiceImpl implements DogService {
    @Autowired
    private DogRepository dogRepository;
    @Autowired
    private SeasonTicketRepository seasonTicketRepository;
    @Autowired
    private TrickRepository trickRepository;
    @Autowired
    private TrainerRepository trainerRepository;

    private Trainer trainer;

    @Override
    public List<Dog> findAll() {
        return dogRepository.findAll();
    }

    @Override
    public Optional<Dog> findById(Integer id) {
        return dogRepository.findById(id);
    }

    @Override
    public Dog save(Dog dog) {
        return dogRepository.save(dog);
    }

    @Override
    public List<SeasonTicket> findAllSeasonTicketByDogId(Integer dogId) {
        return seasonTicketRepository.findAllByDogId(dogId);
    }

//    @Override
//    public Dog deleteById(Integer dogId) {
//        Optional<Dog> dog=dogRepository.findById(dogId);
//        if(dog.isPresent()){
//            System.out.println(dog.get());
//            return dog.get();
//        }
//        dogRepository.deleteById(dogId);
//        return null;
//    }

    @Override
    public void deleteById(Integer id) {
        List<Trick> tricks = trickRepository.findTricksByDogId(id);
        List<SeasonTicket> seasonTickets = seasonTicketRepository.findAllByDogId(id);
//        for(int i=0; i<tricks.size();i++){
        trickRepository.deleteDogTricksByDogId(id);
        for (int i = 0; i < seasonTickets.size(); i++) {
            seasonTicketRepository.deleteById(seasonTickets.get(i).getId());
        }
        dogRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        dogRepository.deleteAll();

    }

//    @Override
//    public Dog deleteById(Integer id) {
//        Optional<Dog> deletedDogOptional=dogRepository.findById(id);
//        Dog deletedDog=null;
//        if(deletedDogOptional.isPresent()){
//            deletedDog=deletedDogOptional.get();
//        }
//
//        dogRepository.deleteById(id);
//        return deletedDog;
//    }

    @Override
    public Optional<Trainer> findOwnerByDog(Integer dogId) {
        return trainerRepository.findById(dogRepository.findOwnerByDog(dogId));
    }

    @Override
    public Optional<Trainer> findTrainerByDog(Integer dogId) {
        return trainerRepository.findById(dogRepository.findTrainerByDog(dogId));
    }

    @Override
    public List<Trick> findTricksByDog(Integer dogId) {
//        System.out.println(trickRepository.findTricksByDogId(dogId));
        return trickRepository.findTricksByDogId(dogId);
    }

    @Override
    public List<Dog> findDogByTrainerId(Integer trainerId) {
//        System.out.println(dogRepository.findAllByTrainerId(trainerId));
        return dogRepository.findAllByTrainerId(trainerId);
    }

    @Override
    public List<Trick> findTricksByDogIdAndCategory(Integer dogId, String category) {
        TrickCategory type = TrickCategory.valueOf(category.toUpperCase());
        System.out.println("service: " + type);
        return trickRepository.findTricksByDogIdAndCategory(dogId, type);
    }
}
