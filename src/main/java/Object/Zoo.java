package Object;

import Observers.Animal.Animal;
import Observers.Animal.Herb;
import Observers.Animal.Predator;
import Observers.Human.Human;

import java.util.List;

/**
 * Класс zoo - "наблюдаемый" объект в паттерне Publish-Subscribe (Pub-Sub)
 */
public class Zoo implements IObservable {
    private boolean noisingNow = false;
    private boolean thunderNow = false;
    private boolean eatingNow = false;
    private boolean nightNow = true;

    private List<Animal> animalList;
    private List<Long> herbeIndex;
    private List<Long> predatorIndex;
    private List<Human> humanList;

    @Override
    public void subscribe(Human o) {
        humanList.add(o);
    }

    @Override
    public void subscribe(Animal o) {
        animalList.add(o);
        if (o instanceof Predator) {
            predatorIndex.add(o.getId());
        } else if (o instanceof Herb) {
            herbeIndex.add(o.getId());
        }
    }

    @Override
    public void notifyPredator() {
        for (Long indx :
                predatorIndex) {
            for (Animal a :
                    animalList) {
                if (a.getId().equals(indx)) {
                    a.update();
                }
            }
        }
    }

    @Override
    public void notifyHerb() {
        for (Long indx :
                herbeIndex) {
            for (Animal a :
                    animalList) {
                if (a.getId().equals(indx)) {
                    a.update();
                }
            }
        }
    }

    public boolean isNoisingNow() {
        return noisingNow;
    }

    public void setNoisingNow(boolean noisingNow) {
        this.noisingNow = noisingNow;
    }

    public boolean isThunderNow() {
        return thunderNow;
    }

    public void setThunderNow(boolean thunderNow) {
        this.thunderNow = thunderNow;
    }

    public boolean isEatingNow() {
        return eatingNow;
    }

    public void setEatingNow(boolean eatingNow) {
        this.eatingNow = eatingNow;
    }

    public boolean isNightNow() {
        return nightNow;
    }

    public void setNightNow(boolean nightNow) {
        this.nightNow = nightNow;
    }

    public List<Animal> getAnimalList() {
        return animalList;
    }

    public List<Long> getHerbeIndex() {
        return herbeIndex;
    }

    public List<Long> getPredatorIndex() {
        return predatorIndex;
    }
}
