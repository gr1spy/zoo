package Observers.Human;

import Observers.Animal.Herb;
import Observers.Animal.Predator;

public interface IHuman {

    void subscribe(Predator predator);
    void subscribe(Herb herb);
    void feedAnimal(Long id);

}
