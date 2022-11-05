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
     * Добавляем нового хищника в зоопарк
     */
    void addPredator(Predators predator);

    /**
     * Добавляем нового травоядного в зоопарк
     */
    void addHerbivorous(Herbivores herbivores);
}
