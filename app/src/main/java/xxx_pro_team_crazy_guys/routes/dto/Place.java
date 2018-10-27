package xxx_pro_team_crazy_guys.routes.dto;

public class Place {


    private double x;
    private double y;
    private String name;
    private long categoryId;
    private int time; //in minutes

    public Place(long categoryId, double x, double y, String name, int time) {
        this.x = x;
        this.y = y;
        this.name = name;
        this.categoryId = categoryId;
        this.time = time;
    }

    public Place(double x, double y, String name, int time) {
        this.x = x;
        this.y = y;
        this.name = name;
        this.time = time;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public String getName() {
        return name;
    }


    public long getCategoryId() {
        return categoryId;
    }

    public int getTime() {
        return time;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTime(int time) {
        this.time = time;
    }
}