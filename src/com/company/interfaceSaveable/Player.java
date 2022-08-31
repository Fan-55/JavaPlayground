package com.company.interfaceSaveable;

import java.util.ArrayList;
import java.util.List;

public class Player implements ISaveable {
    private String name;
    private int hitPoints;
    private int strength;
    private String weapon;

    public Player(String name, int hitPoints, int strength) {
        this.name = name;
        this.hitPoints = hitPoints;
        this.strength = strength;
        weapon = "Sword";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public String getWeapon() {
        return weapon;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }

    @Override
    public String toString() {
        return "Player{" + " name= " + name + " ,hitPoint = " + hitPoints + " strength = " + strength + ", weapon = " + weapon + " }";
    }

    @Override
    public List<String> write() {
        List<String> values = new ArrayList();
        values.add(0, name);
        values.add(1, "" + hitPoints);
        values.add(2, "" + strength);
        values.add(3, weapon);
        return values;
    }

    @Override
    public void read(List<String> readValues) {
        if (readValues != null && readValues.size() > 0) {
            name = readValues.get(0);
            hitPoints = Integer.parseInt(readValues.get(1));
            strength = Integer.parseInt(readValues.get(2));
            weapon = readValues.get(3);
        }
    }
}
