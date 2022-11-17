package Observers.Human;

import Observers.Animal.Animal;
import Observers.IObserver;
import Object.Zoo;

/**
 * Observable класс, который наблюдает за объектом "зоопарк"
 */
public class Human implements IObserver {

    private Zoo zoo;

    public Human(Zoo zoo){
        this.zoo = zoo;
    }


    @Override
    public void update() {

    }

    /**
     * Надсмоторщик кормит животного
     * @param id - животное, которое кормим
     */
    public void toEatAnimal(Long id) {
        this.zoo.setEatingNow(true);
        this.zoo.notifyPredator();      //уведомляем хищников, что идет кормешка
        for (Animal a :
                zoo.getAnimalList()) {
            if (a.getId().equals(id)) {
                a.setHungry(false);
                a.setNoise(false);
            }
        }
        this.zoo.setEatingNow(false);   //Покормили
    }
}
