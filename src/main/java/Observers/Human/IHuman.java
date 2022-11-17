package Observers.Human;

import Observers.Animal.Animal;

public interface IHuman {

    void subscribe(Animal animal);
    void feedAnimal(Long id);

}
