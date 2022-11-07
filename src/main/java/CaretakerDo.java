/**
 * Действия наблюдателя Caretaker
 */
public interface CaretakerDo {

    /**
     * Делаем гром
     */
    void makeThunder();

    /**
     * Кормим хищника
     */
    void startFeedPredator();

    /**
     * Кормим травоядное
     */
    void startFeedHerbivorous();

    /**
     * Создаем новый день зоопарка
     */
    void createDay();

    /**
     * Меняем время суток
     */
    void changeTime();

    /**
     * Меняем день
     */
    void changeDay();

    /**
     * Добавляем животных в зоопарк
     */
    void addAnimal(Caretaker caretaker);
}
