package hu.elte.DogTrainingApplication.wrapper;

import hu.elte.DogTrainingApplication.entities.Dog;
import hu.elte.DogTrainingApplication.entities.SeasonTicket;
import lombok.Data;

@Data
public class DogAndSeasonTicketWrapper {
    Dog dog;
    SeasonTicket seasonTicket;

    public void setDog(SeasonTicket seasonTicket, Dog dog){
        seasonTicket.setDog(dog);
    }
}
