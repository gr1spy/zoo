package Observers.Animal;

public class Predator extends Animal {

    public Predator(Long id, boolean isPredator, String kindOfAnimal, boolean noise, boolean hungry, boolean sleep) {
        super(id, isPredator, kindOfAnimal, noise, hungry, sleep);
    }

    @Override
    public void update() {

    }
}
