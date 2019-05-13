package 原生JDBC;

public class Hero {
    private Integer hero_id;
    private String name;
    private String skills;
    private String race;
    private long hp;
    private long mp;

    public Integer getHero_id() {
        return hero_id;
    }

    public void setHero_id(Integer hero_id) {
        this.hero_id = hero_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public long getHp() {
        return hp;
    }

    public void setHp(long hp) {
        this.hp = hp;
    }

    public long getMp() {
        return mp;
    }

    public void setMp(long mp) {
        this.mp = mp;
    }

    @Override
    public String toString() {
        return "Hero{" +
                "hero_id=" + hero_id +
                ", name='" + name + '\'' +
                ", skills='" + skills + '\'' +
                ", race='" + race + '\'' +
                ", hp=" + hp +
                ", mp=" + mp +
                '}';
    }
}
