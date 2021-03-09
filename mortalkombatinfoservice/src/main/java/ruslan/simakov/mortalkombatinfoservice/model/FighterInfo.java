package ruslan.simakov.mortalkombatinfoservice.model;

public class FighterInfo {
    private Integer id;
    private String name;

    public FighterInfo(Integer id, String name) {
        this.id = id;
        this.name = name;
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
}
