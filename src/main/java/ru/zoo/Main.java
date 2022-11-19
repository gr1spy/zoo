package ru.zoo;

import ru.zoo.JsonParser.Parser;

import ru.zoo.Object.Zoo;
import ru.zoo.Observers.Human.Human;

/**
 * Управляющий класс
 */
public class Main {

    public static void main(String[] args) {
        //Объект зоопарка, который будет передаваться во все классы
        Zoo zoo = new Zoo();
        Human human = new Human(zoo);

        //Парсим файл со списком животных
        Parser parser = new Parser();
        parser.parse(human);

        //Подписываем смотрителя на изменения в зоопарке
        zoo.subscribe(human);

        //Устаналиваем ночь в зоопарке
        zoo.setNightNow(false);

        //Кормим животных
        for (Long i = 1L; i <= 11L; i++) {
            human.feedAnimal(i);
        }

        //Устанавливаем ночь в зоопарке
        zoo.setNightNow(true);
    }
}
