package Observers.Human;

import Observers.IObserver;
import Object.IObservable;
import Object.Zoo;
import Observers.Animal.Predator;
import Observers.Animal.Herb;

import java.util.ArrayList;
import java.util.List;

/**
 * Observable класс, который наблюдает за объектом "зоопарк"
 */
public class Human implements IObservable, IObserver, IHuman {

    private final Zoo zoo;
    private List<Predator> predatorsSub = new ArrayList<>();
    private List<Herb> herbsSub = new ArrayList<>();

    public Human(Zoo zoo) {
        this.zoo = zoo;
    }

    @Override
    public void notifyPredator() {
        for (Predator predator : predatorsSub) {
            predator.update();
        }
    }

    @Override
    public void notifyHerb() {
        for (Herb herb : herbsSub) {
            herb.update();
        }
    }

    public void notifyAllOfAnimal() {
        for (Predator predator : predatorsSub) {
            predator.update();
        }
        for (Herb herb : herbsSub) {
            herb.update();
        }
    }


    public boolean everyOneSleeping() {
        boolean allSleep = true; //все спят
        for (Predator predator :
                predatorsSub) {
            if (!predator.isSleep()) {
                allSleep = false;
            }
        }

        for (Herb herb :
                herbsSub) {
            if (!herb.isSleep()) {
                allSleep = false;
            }
        }
        return allSleep;
    }

    @Override
    public void update() {
        notifyAllOfAnimal();
    }

    public void subscribe(Predator predator) {
        predatorsSub.add(predator);
    }

    public void subscribe(Herb herb) {
        herbsSub.add(herb);
    }

    /**
     * Надсмоторщик кормит животного
     *
     * @param id - животное, которое кормим
     */
    @Override
    public void feedAnimal(Long id) {
        this.zoo.setEatingNow(true);    //уведомляем хищников, что идет кормешка
        for (Herb herb : herbsSub) {
            if (herb.getId().equals(id)) {
                herb.setNoise(false);
                herb.setHungry(false);
                herb.setSleep(false);
            }
        }
        for (Predator predator : predatorsSub) {
            if (predator.getId().equals(id)) {
                predator.setNoise(false);
                predator.setHungry(false);
                predator.setSleep(false);
            }
        }

        this.zoo.setEatingNow(false);   //Покормили
    }

    @Override
    public void subscribe(Human o) {
    }

    @Override
    public void notifyHuman() {
    }

    public Zoo getZoo() {
        return this.zoo;
    }

    public List<Predator> getPredatorsSub() {
        return predatorsSub;
    }

    public void setPredatorsSub(List<Predator> predatorsSub) {
        this.predatorsSub = predatorsSub;
    }

    public List<Herb> getHerbsSub() {
        return herbsSub;
    }

    public void setHerbsSub(List<Herb> herbsSub) {
        this.herbsSub = herbsSub;
    }
}
