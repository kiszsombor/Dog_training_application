package hu.elte.DogTrainingApplication.api;

import hu.elte.DogTrainingApplication.entities.Dog;

import java.util.List;

public interface DogService {

    boolean nothing();
    List<Dog> findAll();
}
