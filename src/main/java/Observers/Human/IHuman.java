package Observers.Human;

import Observers.Animal.Animal;

public interface IHuman {

    /**
     * Подписываем животных на объект класса Human
     *
     * @param animal
     */
    void subscribe(Animal animal);

    /**
     * Смотритель кормит животных
     *
     * @param id id-шник животного, которого кормим
     */
    void feedAnimal(Long id);

}
