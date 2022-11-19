package ru.zoo.Object;

import ru.zoo.Observers.Human.Human;

/**
 * Интерфейс объекта, который мы наблюдаем
 */
public interface IObservable {

    /**
     * Добавляем наблюдателя за объектом
     *
     * @param o новый наблюдатель Human
     */
    void subscribe(Human o);

    /**
     * Уведомляем Human, если состояние зоопарка изменилось
     */
    void notifyHuman();


}
