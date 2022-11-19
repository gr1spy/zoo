package ru.zoo.Object;

import ru.zoo.Observers.Human.Human;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс zoo - "наблюдаемый" объект в паттерне Publish-Subscribe (Pub-Sub)
 */
public class Zoo implements IObservable {
    private boolean noisingNow = false;
    private boolean thunderNow = false;
    private boolean eatingNow = false;
    private boolean nightNow = true;

    private final List<Human> humanList = new ArrayList<>();


    @Override
    public void notifyHuman() {
        humanList.get(0).update();
    }

    @Override
    public void subscribe(Human o) {
        humanList.add(o);
    }

    /**
     * Есть ли шум в зоопарке в данный момент?
     *
     * @return
     */
    public boolean isNoisingNow() {
        return noisingNow;
    }

    /**
     * Устанавливаем значение шума в зоопарке в данный момент
     *
     * @param noisingNow true / false
     */
    public void setNoisingNow(boolean noisingNow) {
        this.noisingNow = noisingNow;
        humanList.get(0).update();
    }

    /**
     * Гремит ли сейчас гром?
     *
     * @return true / false
     */
    public boolean isThunderNow() {
        return thunderNow;
    }

    /**
     * Сейчас гремит гром
     *
     * @param thunderNow true / false
     */
    public void setThunderNow(boolean thunderNow) {
        this.thunderNow = thunderNow;
        humanList.get(0).update();
    }

    /**
     * Сейчас коро то кормят?
     *
     * @return true / false
     */
    public boolean isEatingNow() {
        return eatingNow;
    }

    /**
     * Сейчас кого то кормят!
     *
     * @param eatingNow true/false
     */
    public void setEatingNow(boolean eatingNow) {
        this.eatingNow = eatingNow;
        this.setNoisingNow(true);
    }

    /**
     * Сейчас ночь?
     *
     * @return true / false
     */
    public boolean isNightNow() {
        return nightNow;
    }

    /**
     * Сейчас ночь!
     *
     * @param nightNow true / false
     */
    public void setNightNow(boolean nightNow) {
        this.nightNow = nightNow;
        humanList.get(0).update();
    }

}
