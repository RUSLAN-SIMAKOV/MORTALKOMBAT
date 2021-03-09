package ruslan.simakov.kombatchances.model;

public class Chance {

    private Integer id;
    private Double winChance;

    public Chance(Integer id, Double winChance) {
        this.winChance = winChance;
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getWinChance() {
        return winChance;
    }

    public void setWinChance(Double winChance) {
        this.winChance = winChance;
    }
}
