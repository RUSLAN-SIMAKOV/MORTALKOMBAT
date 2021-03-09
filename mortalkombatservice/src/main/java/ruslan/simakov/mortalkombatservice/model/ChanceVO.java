package ruslan.simakov.mortalkombatservice.model;

public class ChanceVO {

    private Integer id;
    private Double winChance;

    public ChanceVO() {
    }

    public ChanceVO(Integer id, Double winChance) {
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
