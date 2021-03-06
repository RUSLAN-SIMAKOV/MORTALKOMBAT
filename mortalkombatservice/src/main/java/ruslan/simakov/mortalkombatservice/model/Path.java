package ruslan.simakov.mortalkombatservice.model;

public class Path {

    private Integer id;
    private String name;
    private Double chance;

    public Path(Integer id, String name, Double chance) {
        this.id = id;
        this.name = name;
        this.chance = chance;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getChance() {
        return chance;
    }

    public void setChance(Double chance) {
        this.chance = chance;
    }
}
