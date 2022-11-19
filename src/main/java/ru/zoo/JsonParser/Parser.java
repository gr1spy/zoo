package ru.zoo.JsonParser;

import com.fasterxml.jackson.databind.ObjectMapper;
import ru.zoo.Observers.Animal.Animal;
import ru.zoo.Observers.Animal.Herb;
import ru.zoo.Observers.Animal.Predator;
import ru.zoo.Observers.Human.Human;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;


/**
 * Парсер from Json to Список "Animal"
 */
public class Parser {

    private List<Animal> parseAnimalList = new ArrayList<>();

    //String pathJSONFile = "src/main/resources/animals.json";
    String path = Objects.requireNonNull(getClass().getResource("/animals.json")).getPath();
    File jsonFile = new File(path);

    /**
     * Основная функция парсинга
     *
     * @param human передаем текущего наблюдателя в класс, чтобы была взаимосвязь "зоопарк" -> "наблюдатель" -> животные
     */
    public void parse(Human human) {


        ObjectMapper mapper = new ObjectMapper();


        List<Animal> buffered = new ArrayList<>();
        try {
            buffered = Arrays.asList(mapper.readValue(jsonFile, Animal[].class));
        } catch (Exception e) {
            System.out.println("Parsing error: " + e.toString());
        }

        for (Animal animal : buffered) {
            if (animal.isPredator()) {
                parseAnimalList.add(getPredator(animal, human));
            } else {
                parseAnimalList.add(getHerb(animal, human));
            }
        }
        human.setAnimalList(parseAnimalList);
    }

    /**
     * Animal -> Predator
     *
     * @param animal передаем Animal
     * @param human  передаем Human для привязки к конкретному объекту human
     * @return возвращаем объект Predator
     */
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

    /**
     * Animal -> Herbivorous
     *
     * @param animal передаем Animal
     * @param human  передаем Human для привязки к конкретному объекту
     * @return Herbivorous
     */
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

    /**
     * Возвращаем List<Animal> с Predator & Herb
     *
     * @return List<Animal> с Predator & Herb
     */
    public List<Animal> getParseAnimalList() {
        return parseAnimalList;
    }

    /**
     * List<Animal> позволяет задать новый список животных
     * * @param parseAnimalList
     */
    public void setParseAnimalList(List<Animal> parseAnimalList) {
        this.parseAnimalList = parseAnimalList;
    }
}
