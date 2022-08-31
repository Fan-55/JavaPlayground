package com.company.interfaceSaveable;

import java.util.ArrayList;
import java.util.List;

public class Monster implements ISaveable {
    private String name;
    private int hitPoints;
    private int strength;

    public Monster(String name, int hitPoints, int strength) {
        this.name = name;
        this.hitPoints = hitPoints;
        this.strength = strength;
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

    @Override
    public String toString() {
        return "Monster{" +
                "name='" + name + '\'' +
                ", hitPoints=" + hitPoints +
                ", strength=" + strength +
                '}';
    }

    @Override
    public List<String> write() {
        ArrayList<String> values = new ArrayList<>();
        values.add(0, name);
        values.add(1, "" + hitPoints);
        values.add(2, "" + strength);
        return values;
    }

    @Override
    public void read(List<String> readValues) {
        if (readValues != null && readValues.size() > 0) {
            name = readValues.get(0);
            hitPoints = Integer.parseInt(readValues.get(1));
            strength = Integer.parseInt(readValues.get(2));
        }

    }
}
