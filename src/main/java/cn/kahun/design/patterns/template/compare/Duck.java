package cn.kahun.design.patterns.template.compare;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Duck implements Comparable<Duck> {

    private String type;

    private int age;

    @Override
    public int compareTo(Duck duck) {

        return Integer.compare(this.age, duck.getAge());
    }
}
