package ru.zoo.Observers.Animal;

import ru.zoo.JsonParser.Parser;
import org.junit.Before;
import org.junit.Test;
import ru.zoo.Object.Zoo;
import ru.zoo.Observers.Human.Human;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class HerbTest {

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
            if (!animal.isPredator()) {
                assertFalse(animal.isSleep());
                assertTrue(animal.isNoise());
            }
        }
    }

    @Test
    public void checkWhenMustSleep() {
        this.zoo.setNightNow(true);

        for (Animal animal : this.human.getAnimalList()) {
            if (!animal.isPredator() && !this.zoo.isNoisingNow()) {
                assertTrue(animal.isSleep());
            }
            if (!animal.isPredator() && this.zoo.isNoisingNow()) {
                assertFalse(animal.isNoise());
            }
        }
    }

    @Test
    public void checkWhenMustWakeUp() {
        this.zoo.setNightNow(false);

        for (Animal animal : this.human.getAnimalList()) {
            if (!animal.isPredator() && !this.zoo.isNightNow()) {
                assertFalse(animal.isSleep());
            }
        }
    }
}