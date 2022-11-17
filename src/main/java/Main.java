import JsonParser.Parser;
import Observers.Animal.Animal;
import Observers.Human.Human;
import Object.Zoo;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        //Объект зоопарка, который будет передаваться во все классы
        Zoo zoo = new Zoo();

        //Парсим JSON
        Parser parser = new Parser();
        List<Animal> animals = new ArrayList<>(parser.parse());

        //Добавляем животных в подписчики
        for (Animal o :
                animals) {
            o = new Animal(zoo);
            zoo.subscribe(o);
        }

        //Добавляем человека в подписчики
        Human human = new Human(zoo);
        zoo.subscribe(human);

        human.toEatAnimal(1L);  //айдишник дивотного, которого кормим

    }
}
