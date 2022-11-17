package Observers.Human;

import Observers.Animal.Animal;
import Observers.IObserver;
import Object.IObservable;
import Object.Zoo;

import java.util.ArrayList;
import java.util.List;

/**
 * Observable класс, который наблюдает за объектом "зоопарк"
 */
public class Human implements IObservable, IObserver, IHuman {

    private final Zoo zoo;
    private List<Animal> animalList = new ArrayList<>();

    public Human(Zoo zoo) {
        this.zoo = zoo;
    }

    @Override
    public void notifyPredator() {
        for (Animal animal : animalList) {
            if (animal.isPredator()) {
                animal.update();
            }
        }
    }

    @Override
    public void notifyHerb() {
        for (Animal animal : animalList) {
            if (!animal.isPredator()) {
                animal.update();
            }
        }
    }

    public void notifyAllOfAnimal() {
        for (Animal animal : animalList) {
            animal.update();
        }
    }

    /**
     * Проверка на то, что все спят
     */
    public boolean everyOneSleeping() {
        boolean allSleep = true; //все спят
        for (Animal animal : animalList) {
            if (!animal.isSleep()) {
                allSleep = false;
            }
        }
        return allSleep;
    }

    public void checkValueZoo() {
        if (this.zoo.isNoisingNow()) {
            boolean noise = false;
            for (Animal a : animalList) {
                if (a.isNoise()) {
                    noise = true;
                }
            }
            if (!noise) {
                this.zoo.setNoisingNow(false);
            }
        } else if (!this.zoo.isNoisingNow()) {
            boolean noise = true;
            for (Animal a : animalList) {
                if (a.isNoise()) {
                    noise = false;
                }
            }
            if (!noise) {
                this.zoo.setNoisingNow(true);
            }
        }
        if (this.zoo.isThunderNow()) {
            boolean allAcceptThunder = true;
            for (Animal a : animalList) {
                if (!a.isNoise() && a.isSleep()) {
                    allAcceptThunder = false;
                }
            }
            if (allAcceptThunder) {
                this.zoo.setThunderNow(false);
            }

        }
    }

    @Override
    public void update() {
        notifyAllOfAnimal();
    }

    public void subscribe(Animal animal) {
        animalList.add(animal);
    }

    /**
     * Надсмоторщик кормит животного
     *
     * @param id - животное, которое кормим
     */
    @Override
    public void feedAnimal(Long id) {
        this.zoo.setEatingNow(true);    //уведомляем хищников, что идет кормешка
        notifyPredator();
        for (Animal animal : animalList) {
            if (animal.getId().equals(id)) {
                animal.setNoise(false);
                animal.setHungry(false);
                animal.setSleep(false);
                this.zoo.setNoisingNow(true);
            }
        }
        this.zoo.setEatingNow(false);   //Покормили
        checkValueZoo();
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

    public List<Animal> getAnimalList() {
        return animalList;
    }

    public void setAnimalList(List<Animal> animalList) {
        this.animalList = animalList;
    }
}