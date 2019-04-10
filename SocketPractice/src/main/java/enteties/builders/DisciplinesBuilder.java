package enteties.builders;

import enteties.Discipline;

public class DisciplinesBuilder {
    private int id;
    private String name;
    private double credits;

    public DisciplinesBuilder setId(int id) {
        this.id = id;
        return this;
    }

    public DisciplinesBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public DisciplinesBuilder setCredits(double credits) {
        this.credits = credits;
        return this;
    }

    public Discipline createDisciplines() {
        return new Discipline(id, name, credits);
    }
}