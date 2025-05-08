package com.example;

public class Character {
    //角色的一些属性
    private String name;
    private int healthPoints;
    private int attackPower;

    public Character() {
    }

    public Character(String name, int healthPoints, int attackPower) {
        this.name = name;
        this.healthPoints = healthPoints;
        this.attackPower = attackPower;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public void setAttackPower(int attackPower) {
        this.attackPower = attackPower;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }

    //简单攻击逻辑
    public void attack(Character other) {
        if (other.getHealthPoints() == 0 || this.healthPoints == 0) {
            System.out.println("不满足对战开始的条件");
            return;
        }
        int newHp = other.getHealthPoints() - this.attackPower;
        if (newHp <= 0) {
            other.setHealthPoints(0);
            System.out.println(this.name + "K.O.了" + other.getName());
        } else {
            other.setHealthPoints(newHp);
            System.out.println(this.name + "攻击了" + other.getName() + ",造成了" + this.attackPower
                    + "点伤害。" + other.getName() + "还剩下" + newHp + "点血量。");
        }
    }
}
