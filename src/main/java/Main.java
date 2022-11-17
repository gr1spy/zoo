import JsonParser.Parser;
import Observers.Animal.Animal;
import Observers.Animal.Predator;
import Observers.Human.Human;
import Object.Zoo;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        //Объект зоопарка, который будет передаваться во все классы
        Zoo zoo = new Zoo();

        //Парсим JSON, добавляем животных в подписчики
        Human human = new Human(zoo);

        Parser parser = new Parser();
        parser.parse(human);

        zoo.subscribe(human);

        zoo.setNightNow(false);

       human.feedAnimal(1L);  //айдишник дивотного, которого кормим

    }
}
