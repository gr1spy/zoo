package ru.zoo.Observers.Human;

import ru.zoo.JsonParser.Parser;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import ru.zoo.Object.Zoo;
import ru.zoo.Observers.Animal.Animal;
import ru.zoo.Observers.Human.Human;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class HumanTest {

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
    public void subscribe() {
        Human human = new Human();
        Animal animal = new Animal();
        List<Animal> animals = new ArrayList<>();
        animals.add(animal);
        human.subscribe(animal);
        assertArrayEquals(animals.toArray(), human.getAnimalList().toArray());
    }

    @Test
    public void checkAfterFeedHerb() {

        ArrayList<Long> indexOfHerb = new ArrayList<>();

        for (Long i = 1L; i <= 5L; i++) {
            indexOfHerb.add(i);
        }

        var random = new SecureRandom();
        var randomIndex = indexOfHerb.get(random.nextInt(indexOfHerb.size()));

        human.feedAnimal(randomIndex);

        for (Animal animal :
                human.getAnimalList()) {
            if (animal.isPredator()) {
                assertTrue(animal.isNoise());
            }
            if (animal.getId().equals(randomIndex)) {
                assertFalse(animal.isHungry());
                assertFalse(animal.isNoise());
            }
        }

    }

    @Ignore
    @Test
    public void checkAfterFeedPredator() {

        ArrayList<Long> indexOfPredator = new ArrayList<>();

//        for (Long i = 6L; i <= 11L; i++) {
//            indexOfPredator.add(i);
//        }
//
//        SecureRandom random = new SecureRandom();
//        final Long randomIndex = indexOfPredator.get(random.nextInt(indexOfPredator.size()));

        Long randomIndex = 7L;

        human.feedAnimal(randomIndex);

        for (Animal animal : human.getAnimalList()) {
            if (animal.getId().equals(randomIndex)) {
                assertFalse(animal.isNoise());
                assertFalse(animal.isHungry());
            }
            if (!animal.getId().equals(randomIndex) && animal.isPredator()) {
                assertTrue(animal.isNoise());
            }
        }
    }
}