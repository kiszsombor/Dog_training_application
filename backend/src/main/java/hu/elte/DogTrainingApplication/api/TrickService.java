package hu.elte.DogTrainingApplication.api;

import hu.elte.DogTrainingApplication.entities.Trick;

import java.util.List;

public interface TrickService {

    List<Trick> findAll();

    List<Trick> findTricksByCategory(String category);

    void postDogTricks(Integer dogId, Integer trickId);

    void deleteDogTricksByDogIdAndTrickId(Integer dogId, Integer trickId);
}
