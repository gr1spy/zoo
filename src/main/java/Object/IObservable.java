package Object;

import Observers.Animal.Animal;
import Observers.Human.Human;

public interface IObservable {

    void subscribe(Human o);
    void subscribe(Animal o);

    void notifyPredator();
    void notifyHerb();

}
