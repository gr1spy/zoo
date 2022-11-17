package Object;

import Observers.Animal.Animal;
import Observers.Human.Human;

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

    public boolean isNoisingNow() {
        return noisingNow;
    }

    public void setNoisingNow(boolean noisingNow) {
        this.noisingNow = noisingNow;
        humanList.get(0).update();
    }

    public boolean isThunderNow() {
        return thunderNow;
    }

    public void setThunderNow(boolean thunderNow) {
        this.thunderNow = thunderNow;
        humanList.get(0).update();
        this.thunderNow = false;
    }

    public boolean isEatingNow() {
        return eatingNow;
    }

    public void setEatingNow(boolean eatingNow) {
        this.eatingNow = eatingNow;
        humanList.get(0).update();
    }

    public boolean isNightNow() {
        return nightNow;
    }

    public void setNightNow(boolean nightNow) {
        this.nightNow = nightNow;
        humanList.get(0).update();
    }

    @Override
    public void notifyHerb() {
    }

    @Override
    public void notifyPredator() {
    }

}
