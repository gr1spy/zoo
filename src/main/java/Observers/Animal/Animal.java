package Observers.Animal;

import Object.Zoo;
import Observers.IObserver;

public class Animal implements AnimalImpl, IObserver {

    private Zoo zoo;

    private Long id;
    private Boolean predator;
    private String kindOfAnimal;
    private Boolean noise = false;
    private Boolean hungry = false;
    private Boolean sleep = false;

    public Animal(Long id, boolean isPredator, String kindOfAnimal, boolean noise, boolean hungry, boolean sleep) {
        this.id = id;
        this.predator = isPredator;
        this.kindOfAnimal = kindOfAnimal;
        this.noise = noise;
        this.hungry = hungry;
        this.sleep = sleep;
    }

    public Animal(Zoo zoo) {
        this.zoo = zoo;
    }

    public Animal() {
    }

    @Override
    public void update(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isPredator() {
        return predator;
    }

    public void setPredator(boolean predator) {
        this.predator = predator;
    }

    public String getKindOfAnimal() {
        return kindOfAnimal;
    }

    public void setKindOfAnimal(String kindOfAnimal) {
        this.kindOfAnimal = kindOfAnimal;
    }

    public boolean isNoise() {
        return noise;
    }

    public void setNoise(boolean noise) {
        this.noise = noise;
    }

    public boolean isHungry() {
        return hungry;
    }

    public void setHungry(boolean hungry) {
        this.hungry = hungry;
    }

    public boolean isSleep() {
        return sleep;
    }

    public void setSleep(boolean sleep) {
        this.sleep = sleep;
    }

    @Override
    public String toString() {
        return "Observers.Animal{" +
                "id=" + id +
                ", predator=" + predator +
                ", kindOfAnimal='" + kindOfAnimal + '\'' +
                ", noise=" + noise +
                ", hungry=" + hungry +
                ", sleep=" + sleep +
                '}' + "\n";
    }
}