package miracle.model;


public class User {
    private String name;
    private String skills;

     public User() {

    }

    public User(String name, String skills) {
        this.name = name;
        this.skills = skills;
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

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", skills='" + skills + '\'' +
                '}';
    }

}
