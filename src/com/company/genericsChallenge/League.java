package com.company.genericsChallenge;

import com.company.generics.Team;

import java.util.ArrayList;
import java.util.Collections;

public class League<T extends Team<?>> {
    private String name;
    private ArrayList<T> league = new ArrayList<>();

    public League(String name) {
        this.name = name;
    }

    public void showLeagueTable() {
        Collections.sort(league);
        for (T team : league) {
            System.out.println(team.getName() + ": " + team.ranking());
        }
    }

    public boolean add(T team) {
        if (league.contains(team)) {
            return false;
        }
        league.add(team);
        return true;
    }
}
