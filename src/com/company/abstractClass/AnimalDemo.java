package com.company.abstractClass;

public class AnimalDemo {
    public static void main(String[] args) {
        Dog dog = new Dog("Yorkie");
        dog.eat();
        dog.breath();

        Parrot parrot = new Parrot("Parrot");
        parrot.fly();

        Penguin penguin = new Penguin("Penguin");
        penguin.fly();
    }
}
