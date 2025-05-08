package com.example;

public class GameTest {
    public static void main(String[] args) {
        Character role1 = new Character("佩克利姆",200,2);
        Character role2 = new Character("凯露",100,5);
        while (true){
            role1.attack(role2);
            if (role2.getHealthPoints()==0){
                break;
            }
            role2.attack(role1);
            if (role1.getHealthPoints()==0){
                break;
            }
        }
    }
}
