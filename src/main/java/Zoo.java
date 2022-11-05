import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Зоопарк в данный момент времени
 */
public class Zoo {

    public Enum partOfDay;
    public Boolean nowIsThunder = Boolean.FALSE;
    public Boolean nowIsNoising = Boolean.FALSE;
    public Boolean nowIsEating = Boolean.FALSE;

    public Zoo(Enum partOfDay, Boolean nowIsThunder, Boolean nowIsNoising, Boolean nowIsEating) {
        this.partOfDay = partOfDay;
        this.nowIsThunder = nowIsThunder;
        this.nowIsNoising = nowIsNoising;
        this.nowIsEating = nowIsEating;
    }

    public Enum getPartOfDay() {
        return partOfDay;
    }

    public void setPartOfDay(Enum partOfDay) {
        this.partOfDay = partOfDay;
    }

    public Boolean getNowIsThunder() {
        return nowIsThunder;
    }

    public void setNowIsThunder(Boolean nowIsThunder) {
        this.nowIsThunder = nowIsThunder;
    }

    public Boolean getNowIsNoising() {
        return nowIsNoising;
    }

    public void setNowIsNoising(Boolean nowIsNoising) {
        this.nowIsNoising = nowIsNoising;
    }

    public Boolean getNowIsEating() {
        return nowIsEating;
    }

    public void setNowIsEating(Boolean nowIsEating) {
        this.nowIsEating = nowIsEating;
    }
}
