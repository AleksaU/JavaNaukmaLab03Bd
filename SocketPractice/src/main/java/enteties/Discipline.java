package enteties;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect
public class Discipline {

    private int id;
    private String name;
    private double credits;

    public Discipline() {
    }

    public Discipline(int id) {
        this.id = id;
    }

    public Discipline(int id, String name, double credits) {
        this.id = id;
        this.name = name;
        this.credits = credits;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCredits() {
        return credits;
    }

    public void setCredits(double credits) {
        this.credits = credits;
    }

    @Override
    public String toString() {
        return "{id=" + id +
                ", name='" + name + '\'' +
                ", credits=" + credits +
                '}';
    }
}
