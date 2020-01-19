public class CivilService implements NationalService {

    private int daysLeft;

    public CivilService() {
        this.daysLeft = 362;
    }

    public int getDaysLeft() {
        return daysLeft;
    }

    public void work() {
        if (this.daysLeft < 1) {
            this.daysLeft = 0;
        } else {
            this.daysLeft--;
        }
    }

}
