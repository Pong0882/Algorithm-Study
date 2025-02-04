package ssafy.ssafyGit.restaurant;

public class KoreanRestaurant extends Restaurant {

    private String number;
    private String breakTime;

    public KoreanRestaurant(int resid, String name, String address, String signatureMenu, int rate, String number,
            String breakTime) {
        super(resid, name, address, signatureMenu, rate);
        this.number = number;
        this.breakTime = breakTime;
    }

    public KoreanRestaurant() {
    }

    @Override
    public String toString() {
        return super.toString() + "KoreanRestaurant [number=" + number + ", breakTime=" + breakTime + "]";
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getBreakTime() {
        return breakTime;
    }

    public void setBreakTime(String breakTime) {
        this.breakTime = breakTime;
    }

}
