package com.company.linkedListSongList;

import java.util.ArrayList;
import java.util.List;

public class Album {
    private String name;
    private String artist;
    private ArrayList<Song> songs = new ArrayList<>();

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
    }

    public boolean addSong(String title, double duration) {
        if (findSong(title) == null) {
            songs.add(new Song(title, duration));
            return true;
        }
        System.out.println(title + "already exists.");
        return false;
    }

    private Song findSong(Song targetSong) {
        int position = songs.indexOf(targetSong);
        if (position >= 0) {
            return songs.get(position);
        }
        return null;
    }

    private Song findSong(String targetSongTitle) {
        for (Song checkedSong : songs) {
            if (checkedSong.getTitle().equals(targetSongTitle)) {
                return checkedSong;
            }
        }
        return null;
    }

    public boolean addToPlaylist(int trackNumber, List<Song> playlist) {
        int index = trackNumber - 1;
        if (index >= 0 && index < songs.size()) {
            playlist.add(songs.get(index));
            return true;
        }
        System.out.println("This album does not have a track " + trackNumber);
        return false;
    }

    public boolean addToPlaylist(String title, List<Song> playlist) {
        Song targetSong = findSong(title);
        if (targetSong != null) {
            playlist.add(targetSong);
            return true;
        }
        System.out.println("The song " + title + " is not in this album");
        return false;
    }
}
