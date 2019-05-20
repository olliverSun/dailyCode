package 注解;
@Entity
@ToTable(tablename = "hero")
public class Hero {
    @ToColumn(ColumName ="name")
    private String name;
    @Mainkey(Column = "hero_id")
    private int id;
    @ToColumn(ColumName = "skill")
    private String skill;
    @ToColumn(ColumName = "race")
    private String race;
    @ToColumn(ColumName = "hp")
    private String hp;
    @ToColumn(ColumName = "mp")
    private String mp;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getHp() {
        return hp;
    }

    public void setHp(String hp) {
        this.hp = hp;
    }

    public String getMp() {
        return mp;
    }

    public void setMp(String mp) {
        this.mp = mp;
    }
}
