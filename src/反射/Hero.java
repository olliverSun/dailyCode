package 反射;

public class Hero {

    String name;
    String skill;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public void castSkill(){
        System.out.println(skill);
    }

}
