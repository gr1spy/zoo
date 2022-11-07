/**
 * Абстрактный класс животное
 */
public class Animal {

    public Long animalId;
    public Boolean isPredator;
    public String kindOfAnimal;
    public Boolean noise;
    public Boolean hungry;
    public Boolean sleep;

    Animal(){}

    public Animal(Long animalId, Boolean isPredator, String kindOfAnimal, Boolean noise, Boolean hungry, Boolean sleep) {
        this.animalId = animalId;
        this.isPredator = isPredator;
        this.kindOfAnimal = kindOfAnimal;
        this.noise = noise;
        this.hungry = hungry;
        this.sleep = sleep;
    }

    public Long getAnimalId() {
        return animalId;
    }

    public void setAnimalId(Long animalId) {
        this.animalId = animalId;
    }

    public Boolean getPredator() {
        return isPredator;
    }

    public void setPredator(Boolean predator) {
        isPredator = predator;
    }

    public String getKindOfAnimal() {
        return kindOfAnimal;
    }

    public void setKindOfAnimal(String kindOfAnimal) {
        this.kindOfAnimal = kindOfAnimal;
    }

    public Boolean getNoise() {
        return noise;
    }

    public void setNoise(Boolean noise) {
        this.noise = noise;
    }

    public Boolean getHungry() {
        return hungry;
    }

    public void setHungry(Boolean hungry) {
        this.hungry = hungry;
    }

    public Boolean getSleep() {
        return sleep;
    }

    public void setSleep(Boolean sleep) {
        this.sleep = sleep;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "animalId=" + animalId +
                ", isPredator=" + isPredator +
                ", kindOfAnimal='" + kindOfAnimal + '\'' +
                ", noise=" + noise +
                ", hungry=" + hungry +
                ", sleep=" + sleep +
                '}';
    }
}
