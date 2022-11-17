package Object;

import Observers.Animal.Animal;
import Observers.Human.Human;

public interface IObservable {

    void subscribe(Human o);

    void notifyHuman();

    void notifyHerb();

    void notifyPredator();

}
