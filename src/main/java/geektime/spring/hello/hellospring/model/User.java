package geektime.spring.hello.hellospring.model;

import lombok.Data;

@Data
public class User {

    private int id;
    private String name;
    private String password;
    private int age;
    private int age2;

    public User() {
    }

    public User(String name, String password, int age) {
        this.name = name;
        this.password = password;
        this.age = age;
        this.age2 = age2;
    }

    public User(int id, String name, String password, int age) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.age = age;
        this.age2 = age2;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age + '\'' +
                ", age2=" + age2 +
                '}';
    }
}
