package practice2.core;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class HelloLombok {
    private String name;
    private int age;

    HelloLombok(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public static void main(String[] args) {
        HelloLombok helloLombok = new HelloLombok("jochong", 23);

        System.out.println(helloLombok);
    }
}
