package hu.elte.DogTrainingApplication.wrapper;

import hu.elte.DogTrainingApplication.entities.Dog;
import hu.elte.DogTrainingApplication.entities.Trainer;
import lombok.Data;

@Data
public class TrainerAndDogWrapper {
    Dog dog;
    Trainer trainer;

    public void setTrainer(Trainer trainer, Dog dog){
        dog.setTrainer(trainer);
    }
}
