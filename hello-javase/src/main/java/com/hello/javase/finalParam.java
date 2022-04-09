package com.hello.javase;

public class finalParam {

    public static void testFinalParam(final String name) {
        //name = "123";
        System.out.println(name);
    }

    public static void main(String[] args) {

        final Person person1 = new Person("n1", 1);
        final Person person2 = new Person("n2", 2);
        final Person person3 = new Person("n3", 3);

        System.out.println(person1.toString());
        System.out.println(person2.toString());
        System.out.println(person3.toString());

        test(person1, person2, person3);

        System.out.println("-----------------------------------");

        System.out.println(person1.toString());
        System.out.println(person2.toString());
        System.out.println(person3.toString());
    }

    static void test(Person person1, Person person2, final Person person3) {
        System.out.println("before person1" + person1);
        person1 = new Person("n1", 10);
        System.out.println("after person1" + person1);
        person2.setAge(20);
        person3.setAge(30);
    }

}
