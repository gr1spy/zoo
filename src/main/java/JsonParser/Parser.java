package JsonParser;

import Observers.Animal.Herb;
import Observers.Animal.Predator;
import Observers.Human.Human;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import Observers.Animal.Animal;
import Object.Zoo;

/**
 * Парсер from Json to Object "Observers.Animal"
 */
public class Parser {

    private List<Predator> predatorsList = new ArrayList<>();
    private List<Herb> herbsList = new ArrayList<>();

    String pathJSONFile = "src/main/resources/animals.json";
    File jsonFile = new File(pathJSONFile);

    public void parse(Human human) {
        ObjectMapper mapper = new ObjectMapper();
        List<Animal> animalList = new ArrayList<>();
        try {
            animalList = Arrays.asList(mapper.readValue(jsonFile, Animal[].class));
        } catch (Exception e) {
            System.out.println("Parsing error: " + e.toString());
        }

        for (Animal animal : animalList) {
            if (animal.isPredator()) {
                predatorsList.add(getPredator(animal, human));  //отправляем Animal, получаем Predator
            } else {
                herbsList.add(getHerb(animal, human));
            }
        }
        human.setHerbsSub(herbsList);
        human.setPredatorsSub(predatorsList);
    }

    public Predator getPredator(Animal animal, Human human) {
        Predator newPredator = new Predator();
        newPredator.setId(animal.getId());
        newPredator.setPredator(animal.isPredator());
        newPredator.setKindOfAnimal(animal.getKindOfAnimal());
        newPredator.setNoise(animal.isNoise());
        newPredator.setHungry(animal.isHungry());
        newPredator.setSleep(animal.isSleep());
        Predator result = new Predator(newPredator, human);
        return result;
    }

    public Herb getHerb(Animal animal, Human human) {
        Herb newHerb = new Herb();
        newHerb.setId(animal.getId());
        newHerb.setPredator(animal.isPredator());
        newHerb.setKindOfAnimal(animal.getKindOfAnimal());
        newHerb.setNoise(animal.isNoise());
        newHerb.setHungry(animal.isHungry());
        newHerb.setSleep(animal.isSleep());
        Herb result = new Herb(newHerb, human);
        return result;
    }

    public List<Predator> getPredatorsList() {
        return predatorsList;
    }

    public void setPredatorsList(List<Predator> predatorsList) {
        this.predatorsList = predatorsList;
    }

    public List<Herb> getHerbsList() {
        return herbsList;
    }

    public void setHerbsList(List<Herb> herbsList) {
        this.herbsList = herbsList;
    }
}
