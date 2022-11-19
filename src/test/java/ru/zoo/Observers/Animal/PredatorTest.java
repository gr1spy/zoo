package ru.zoo.Observers.Animal;

import ru.zoo.JsonParser.Parser;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.zoo.Object.Zoo;
import ru.zoo.Observers.Human.Human;

public class PredatorTest {

    Zoo zoo;
    Human human;

    @Before
    public void prepareZoo() {
        this.zoo = new Zoo();
        this.human = new Human(zoo);
        Parser parser = new Parser();
        parser.parse(human);
        zoo.subscribe(human);
    }

    @Test
    public void checkWhenThunder() {
        this.zoo.setThunderNow(true);

        for (Animal animal : this.human.getAnimalList()) {
            if (animal.isPredator()) {
                Assert.assertFalse(animal.isSleep());
                Assert.assertTrue(animal.isNoise());
            }
        }
    }

    @Test
    public void checkWhenMustSleep() {
        this.zoo.setNightNow(true);

        for (Animal animal : this.human.getAnimalList()) {
            if (animal.isPredator() && !this.zoo.isNoisingNow()) {
                Assert.assertTrue(animal.isSleep());
            }
            if (animal.isPredator() && this.zoo.isNoisingNow()) {
                Assert.assertFalse(animal.isNoise());
            }
        }
    }

    @Test
    public void checkWhenMustWakeUp() {
        this.zoo.setNightNow(false);

        for (Animal animal : this.human.getAnimalList()) {
            if (animal.isPredator() && !this.zoo.isNightNow()) {
                Assert.assertFalse(animal.isSleep());
            }
        }
    }

    @Test
    public void whenNoisingSmthInZoo() {

        this.zoo.setNoisingNow(true);
        this.zoo.setEatingNow(true);
        for (Animal animal : this.human.getAnimalList()) {
            if (animal.isPredator()  && !animal.isHungry()) {
                Assert.assertFalse(animal.isNoise());
            }
        }
    }
}