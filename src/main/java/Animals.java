public class Animals {

    public String kindOfAnimal;
    public Boolean noise = Boolean.FALSE;
    public Boolean hungry = Boolean.FALSE;
    public Boolean sleep = Boolean.FALSE;

    public Animals(String kindOfAnimal, Boolean noise, Boolean hungry, Boolean sleep) {
        this.kindOfAnimal = kindOfAnimal;
        this.noise = noise;
        this.hungry = hungry;
        this.sleep = sleep;
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

    public String getKindOfAnimal() {
        return kindOfAnimal;
    }

    public void setKindOfAnimal(String kindOfAnimal) {
        this.kindOfAnimal = kindOfAnimal;
    }
}
