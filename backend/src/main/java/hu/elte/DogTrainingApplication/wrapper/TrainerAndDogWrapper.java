package hu.elte.DogTrainingApplication.wrapper;

import hu.elte.DogTrainingApplication.entities.Dog;
import hu.elte.DogTrainingApplication.entities.Trainer;
import lombok.Data;

@Data
public class TrainerAndDogWrapper {
    Dog dog;
    Trainer trainer;
    Trainer owner;

    public void setTrainerAndOwner(Trainer trainer, Trainer owner,Dog dog){

        dog.setTrainer(trainer);
        dog.setOwner(owner);
    }
}
