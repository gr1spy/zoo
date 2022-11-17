package JsonParser;

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

    String pathJSONFile = "src/main/resources/animals.json";
    File jsonFile = new File(pathJSONFile);

    public List<Animal> parse() {


        ObjectMapper mapper = new ObjectMapper();
        List<Animal> animalList = new ArrayList<>();
        try {
            animalList = Arrays.asList(mapper.readValue(jsonFile, Animal[].class));
        } catch (Exception e) {
            System.out.println("Parsing error: " + e.toString());
        }
        return animalList;

    }
}
