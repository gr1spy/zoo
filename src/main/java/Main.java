import JsonParser.Parser;
import Observers.Human.Human;
import Object.Zoo;

public class Main {

    public static void main(String[] args) {
        //Объект зоопарка, который будет передаваться во все классы
        Zoo zoo = new Zoo();
        Human human = new Human(zoo);

        Parser parser = new Parser();
        parser.parse(human);

        zoo.subscribe(human);

        zoo.setNightNow(false);

        //Кормим животных
        for (Long i = 1L; i <= 11L; i++) {
            human.feedAnimal(i);
        }

        zoo.setNightNow(true);
    }
}
