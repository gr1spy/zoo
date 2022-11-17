package Observers.Animal;

import Object.Zoo;
import Observers.Human.Human;
import Observers.IObserver;

public class Herb extends Animal implements IObserver {

    private Human human;

    public Herb(Herb herb, Human human) {
        this.human = human;
        this.setId(herb.getId());
        this.setPredator(herb.isPredator());
        this.setKindOfAnimal(herb.getKindOfAnimal());
        this.setNoise(herb.isNoise());
        this.setHungry(herb.isHungry());
        this.setSleep(herb.isSleep());
    }

    public Herb(Long id, boolean isPredator, String kindOfAnimal, boolean noise, boolean hungry, boolean sleep) {
        super(id, isPredator, kindOfAnimal, noise, hungry, sleep);
    }

    public Herb() {
    }

    @Override
    public void update() {
        Zoo localZoo = this.human.getZoo();

        //Если гремит гром
        if (localZoo.isThunderNow()) {
            this.setNoise(true);
            this.setSleep(false);
            this.human.checkValueZoo();
        }

        //Когда надо спать
        if (localZoo.isNightNow() && !this.isSleep() && !localZoo.isNoisingNow()) {    //если ночь и я не сплю
            this.setSleep(true);
        }

        //Когда надо просыпаться
        if (!localZoo.isNightNow() && this.isSleep()) {
            this.setSleep(false);
        }
    }
}
