import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Класс "Смотритель" - управляет зоопарком
 */
public class Caretaker implements CaretakerDo {
    public static int dayIs = 0; //Номер дня зоопарка
    public static Long nextAnimalId = 1L; //Айдишники для животных
    public static Enum<TimeOfDay> time = TimeOfDay.NIGHT; //текущее время дня
    public static List<ArrayList<Zoo>> dayInZoo = new ArrayList<>();
    public HashMap<Long, Animals> animalList = new HashMap<>();
    public List<Long> indexOfPredator = new ArrayList<>();
    public List<Long> indexOfHerbivorous = new ArrayList<>();

    public static void main(String[] args) {
        Caretaker caretaker = new Caretaker();
        caretaker.addPredator(new Predators("Тигр", Boolean.FALSE, Boolean.FALSE, Boolean.FALSE));
        caretaker.addPredator(new Predators("Лев", Boolean.FALSE, Boolean.FALSE, Boolean.FALSE));
        caretaker.addHerbivorous(new Herbivores("Корова", Boolean.FALSE, Boolean.FALSE, Boolean.FALSE));
        caretaker.changeTime();
        caretaker.changeTime();
        caretaker.startFeedPredator();
        caretaker.changeTime();
        caretaker.changeTime();
        caretaker.startFeedHerbivorous();
        caretaker.startFeedPredator();
        caretaker.changeTime();
        caretaker.makeThunder();
    }

    @Override
    public void makeThunder() {
        for (Long ID :
                animalList.keySet()) {
            animalList.get(ID).setSleep(Boolean.FALSE);
            animalList.get(ID).setNoise(Boolean.TRUE);
        }
        checkNoiseZoo();
    }

    @Override
    public void startFeedPredator() {
        for (Long ID :
                indexOfPredator) {
            animalList.get(ID).setNoise(Boolean.TRUE);
        }
        if (time.equals(TimeOfDay.NIGHT)) {
            dayInZoo.get(dayIs - 1).get(0).setNowIsEating(Boolean.TRUE);
            dayInZoo.get(dayIs - 1).get(0).setNowIsNoising(Boolean.TRUE);
        } else if (time.equals(TimeOfDay.DAY)) {
            dayInZoo.get(dayIs - 1).get(1).setNowIsEating(Boolean.TRUE);
            dayInZoo.get(dayIs - 1).get(1).setNowIsNoising(Boolean.TRUE);
        }
        endFeedPredators();
    }

    public void endFeedPredators() {
        boolean herbivorousNotHungry = Boolean.TRUE;
        for (Long ID:
                indexOfHerbivorous) {
            if (animalList.get(ID).getNoise()){
                herbivorousNotHungry = Boolean.FALSE;
            }
        }
        if (herbivorousNotHungry) {
            for (Long Id :
                    indexOfPredator) {
                animalList.get(Id).setNoise(Boolean.FALSE);
                animalList.get(Id).setHungry(Boolean.FALSE);
            }
            if (time.equals(TimeOfDay.NIGHT)) {
                dayInZoo.get(dayIs - 1).get(0).setNowIsEating(Boolean.FALSE);
            } else if (time.equals(TimeOfDay.DAY)) {
                dayInZoo.get(dayIs - 1).get(1).setNowIsEating(Boolean.FALSE);
            }
        } else {
            for (Long Id :
                    indexOfPredator) {
                animalList.get(Id).setHungry(Boolean.FALSE);
            }
            if (time.equals(TimeOfDay.NIGHT)) {
                dayInZoo.get(dayIs - 1).get(0).setNowIsEating(Boolean.FALSE);
            } else if (time.equals(TimeOfDay.DAY)) {
                dayInZoo.get(dayIs - 1).get(1).setNowIsEating(Boolean.FALSE);
            }
        }
        checkNoiseZoo();
    }

    @Override
    public void startFeedHerbivorous() {
        for (Long ID :
                indexOfHerbivorous) {
            animalList.get(ID).setNoise(Boolean.TRUE);
        }
        if (time.equals(TimeOfDay.NIGHT)) {
            dayInZoo.get(dayIs - 1).get(0).setNowIsEating(Boolean.TRUE);
            dayInZoo.get(dayIs - 1).get(0).setNowIsNoising(Boolean.TRUE);
        } else if (time.equals(TimeOfDay.DAY)) {
            dayInZoo.get(dayIs - 1).get(1).setNowIsEating(Boolean.TRUE);
            dayInZoo.get(dayIs - 1).get(1).setNowIsNoising(Boolean.TRUE);
        }
        makeNoisePredator();
        endFeedHerbivorous();
    }


    public void endFeedHerbivorous() {
        for (Long Id :
                indexOfHerbivorous) {
            animalList.get(Id).setNoise(Boolean.FALSE);
            animalList.get(Id).setHungry(Boolean.FALSE);
        }
        if (time.equals(TimeOfDay.NIGHT)) {
            dayInZoo.get(dayIs - 1).get(0).setNowIsEating(Boolean.FALSE);
        } else if (time.equals(TimeOfDay.DAY)) {
            dayInZoo.get(dayIs - 1).get(1).setNowIsEating(Boolean.FALSE);
        }
        checkNoiseZoo();
    }

    /**
     * Проверяет, шумит ли кто-то в зоопарке
     * Если шумит, то устанавливает статус "шум" в текущем дне в зоопарке
     */
    public void checkNoiseZoo() {
        boolean smbNoising = Boolean.FALSE;
        for (Long animal :
                animalList.keySet()) {
            if (animalList.get(animal).getNoise()) {
                smbNoising = Boolean.TRUE;
            }
        }
        if (!smbNoising && time.equals(TimeOfDay.NIGHT)) {
            dayInZoo.get(dayIs - 1).get(0).setNowIsNoising(Boolean.FALSE);
        } else if (!smbNoising && time.equals(TimeOfDay.DAY)) {
            dayInZoo.get(dayIs - 1).get(1).setNowIsNoising(Boolean.FALSE);
        }
        if (smbNoising && time.equals(TimeOfDay.NIGHT)) {
            dayInZoo.get(dayIs - 1).get(0).setNowIsNoising(Boolean.TRUE);
        } else if (smbNoising && time.equals(TimeOfDay.DAY)) {
            dayInZoo.get(dayIs - 1).get(1).setNowIsNoising(Boolean.TRUE);
        }
    }

    public void makeNoisePredator() {
        for (Long predator :
                indexOfPredator) {
            animalList.get(predator).setNoise(Boolean.TRUE);
        }

    }

    @Override
    public void createDay() {
        ArrayList<Zoo> zooToday = new ArrayList<>();
        if (dayIs > 0 && dayInZoo.get(dayIs - 1).get(1).getNowIsNoising()) {
            Zoo zooAM = new Zoo(TimeOfDay.NIGHT, Boolean.FALSE, Boolean.TRUE, Boolean.FALSE);
            zooToday.add(zooAM);
        } else {
            Zoo zooAM = new Zoo(TimeOfDay.NIGHT, Boolean.FALSE, Boolean.FALSE, Boolean.FALSE);
            zooToday.add(zooAM);
        }
        Zoo zooPM = new Zoo(TimeOfDay.DAY, Boolean.FALSE, Boolean.FALSE, Boolean.FALSE);
        zooToday.add(zooPM);
        dayInZoo.add(zooToday);
        dayIs++;
    }

    @Override
    public void changeTime() {
        if (time.equals(TimeOfDay.NIGHT) && dayIs == 0) {
            createDay();
            checkNoiseZoo();
        } else if (time.equals(TimeOfDay.NIGHT) && dayIs > 0) {
            time = TimeOfDay.DAY;
            //Когда наступает утро - все животные просыпаются
            for (Long animal :
                    animalList.keySet()) {
                animalList.get(animal).setSleep(Boolean.FALSE);
                animalList.get(animal).setHungry(Boolean.TRUE);
                animalList.get(animal).setNoise(Boolean.TRUE);
            }
            checkNoiseZoo();
        } else if (time.equals(TimeOfDay.DAY)) {
            changeDay();
        }
    }

    @Override
    public void changeDay() {
        time = TimeOfDay.NIGHT;
        Caretaker caretaker = new Caretaker();
        caretaker.createDay();
        //Когда наступает ночь, все животные ложатся спать при условии, что никто не шумит
        boolean smbNoising = Boolean.FALSE;
        for (Long animal :
                animalList.keySet()) {
            if (animalList.get(animal).getNoise()) {
                smbNoising = Boolean.TRUE;
            }
        }
        if (!smbNoising) {
            for (Long animal :
                    animalList.keySet()) {
                animalList.get(animal).setSleep(Boolean.TRUE);
            }
        }
    }

    @Override
    public void addPredator(Predators predator) {
        animalList.put(getUniqId(), predator);
        indexOfPredator.add(getUniqId());
        setUniqId(getUniqId() + 1);
    }

    @Override
    public void addHerbivorous(Herbivores herbivores) {
        animalList.put(getUniqId(), herbivores);
        indexOfHerbivorous.add(getUniqId());
        setUniqId(getUniqId() + 1);
    }

    public Long getUniqId() {
        return nextAnimalId;
    }

    public void setUniqId(Long uniqId) {
        Caretaker.nextAnimalId = uniqId;
    }
}
