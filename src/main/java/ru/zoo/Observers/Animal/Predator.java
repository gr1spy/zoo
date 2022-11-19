package ru.zoo.Observers.Animal;

import ru.zoo.Object.Zoo;
import ru.zoo.Observers.Human.Human;
import ru.zoo.Observers.IObserver;

/**
 * Класс "Хищник" наблюдает за Human
 */
public class Predator extends Animal implements IObserver {

    private Human human;

    public Predator(Human human) {
        this.human = human;
    }

    //Конструктор копирования
    public Predator(Predator predator, Human human) {
        this.human = human;
        this.setId(predator.getId());
        this.setPredator(predator.isPredator());
        this.setKindOfAnimal(predator.getKindOfAnimal());
        this.setNoise(predator.isNoise());
        this.setHungry(predator.isHungry());
        this.setSleep(predator.isSleep());
    }

    public Predator() {
    }

    public Predator(Long id, boolean isPredator, String kindOfAnimal, boolean noise, boolean hungry, boolean sleep) {
        super(id, isPredator, kindOfAnimal, noise, hungry, sleep);
    }


    @Override
    public void update() {
        Zoo localZoo = this.human.getZoo();
        //Когда надо просыпаться
        if (!localZoo.isNightNow() && this.isSleep()) {
            this.setSleep(false);
        }

        //Когда надо спать
        if (localZoo.isNightNow() && !this.isSleep() && !localZoo.isNoisingNow()) {    //если ночь и никто не шумит
            this.setSleep(true);
        }

        //Если гремит гром
        if (localZoo.isThunderNow()) {
            this.setNoise(true);
            this.setSleep(false);
            this.human.checkValueZoo();
        }

        //Если кто-то шумит в зоопарке. Например, кормят травоядных (EatingNow = true)
        if (localZoo.isEatingNow() && localZoo.isNoisingNow()) {
            this.setNoise(true);
        }

    }
}
