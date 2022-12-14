package com.company.genericsChallenge;

import com.company.generics.FootballPlayer;
import com.company.generics.Team;

public class LeagueDemo {
    public static void main(String[] args) {
        League<Team<FootballPlayer>> footballLeague = new League("AFL");
        Team<FootballPlayer> adelaideCrows = new Team<>("Adelaide Crows");
        Team<FootballPlayer> melbourne = new Team<>("Melbourne");
        Team<FootballPlayer> hawthorn = new Team<>("Hawthorn");
        Team<FootballPlayer> fremantle = new Team<>("Fremantle");
        footballLeague.add(adelaideCrows);
        footballLeague.add(melbourne);
        footballLeague.add(hawthorn);
        footballLeague.add(fremantle);
        hawthorn.matchResult(fremantle, 1, 0);
        hawthorn.matchResult(adelaideCrows, 3, 8);
        adelaideCrows.matchResult(fremantle, 2, 1);
        footballLeague.showLeagueTable();

        League<Team<FootballPlayer>> anotherLeague = new League("AFL");
    }
}
