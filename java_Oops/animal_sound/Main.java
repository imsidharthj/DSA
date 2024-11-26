import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;

abstract class Animal{
    private String name;
    private String sound;

    public Animal(String name, String sound){
        this.name = name;
        this.sound = sound;
    }

    public String getName() { return name; }

    public String getSound() { return sound; }

    public void setName(String name){
        this.name = name;
    }

    public void setSound(String sound){
        this.sound = sound;
    }

    public abstract void makeSound();
}

class Cat extends Animal{
    public Cat(String name, String sound){
        super(name, sound);
    }
    @Override
    public void makeSound(){
        System.out.println(getName() + " says " + getSound());
    }
}

class Dog extends Animal {
    public Dog(String name, String sound) {
        super(name, sound);
    }

    @Override
    public void makeSound() {
        System.out.println(getName() + " says " + getSound());
    }
}

public class Main {
    public static void main(String[] args) {
        Cat cat = new Cat("Whiskers", "Meow");
        Dog dog = new Dog("Buddy", "Woof");
        cat.makeSound();
        dog.makeSound();
    }
}