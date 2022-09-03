package com.company.innerClassChallenge;

import java.util.ArrayList;
import java.util.List;

public class Album {
    private String name;
    private String artist;
    private SongList songList = new SongList();

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
    }

    public boolean addSong(String title, double duration) {
        return songList.add(new Song(title, duration));
    }

    public boolean addToPlaylist(int trackNumber, List<Song> playlist) {
        Song targetSong = songList.findSong(trackNumber);
        if (targetSong != null) {
            playlist.add(targetSong);
            return true;
        }
        System.out.println("This album does not have a track " + trackNumber);
        return false;
    }

    public boolean addToPlaylist(String title, List<Song> playlist) {
        Song targetSong = songList.findSong(title);
        if (targetSong != null) {
            playlist.add(targetSong);
            return true;
        }
        System.out.println("The song " + title + " is not in this album");
        return false;
    }

    private class SongList {
        private ArrayList<Song> songs = new ArrayList();

        public boolean add(Song song) {
            if (findSong(song) == null) {
                songs.add(song);
                return true;
            }
            System.out.println(song.getTitle() + " already exists.");
            return false;
        }

        public Song findSong(int trackNumber) {
            int position = trackNumber - 1;
            if (position >= 0 && position < songs.size()) {
                return songs.get(position);
            }
            return null;
        }

        public Song findSong(Song targetSong) {
            int position = songs.indexOf(targetSong);
            if (position >= 0) {
                return songs.get(position);
            }
            return null;
        }

        public Song findSong(String targetSongTitle) {
            for (Song checkedSong : songs) {
                if (checkedSong.getTitle().equals(targetSongTitle)) {
                    return checkedSong;
                }
            }
            return null;
        }
    }
}
