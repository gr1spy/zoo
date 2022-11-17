package Observers.Animal;

import Object.Zoo;
import Observers.Human.Human;
import Observers.IObserver;

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
        if (localZoo.isNightNow() && !this.isSleep()) {    //если ночь
            if (this.human.everyOneSleeping()) {
                this.setSleep(true);
                localZoo.setNoisingNow(false);
            }
        }

        //Если гремит гром
        if (localZoo.isThunderNow()) {
            this.setNoise(true);
            this.setSleep(false);
            localZoo.setNoisingNow(true);
        }

        //Если кто-то шумит в зоопарке. Например, кормят травоядных (EatingNow = true)
        if (localZoo.isNoisingNow() && !localZoo.isNightNow() && !localZoo.isThunderNow()) {
            this.setNoise(true);
        }

    }
}
