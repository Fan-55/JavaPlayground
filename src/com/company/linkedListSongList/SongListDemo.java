package com.company.linkedListSongList;

import java.util.*;

public class SongListDemo {
    private static List<Album> albums = new ArrayList<>();

    public static void main(String[] args) {
        Album album = new Album("Stormbringer", "Deep Purple");
        album.addSong("Stormbringer", 4.6);
        album.addSong("Love Don't Mean a Thing", 4.22);
        album.addSong("Holy Man", 4.3);
        album.addSong("Hold On", 5.6);
        album.addSong("Lady Double Dealer", 3.21);
        album.addSong("You Can't Do It Right", 6.23);
        album.addSong("High Ball Shooter", 4.27);
        album.addSong("The Gypsy", 4.2);
        album.addSong("Soldier of Fortune", 3.13);
        albums.add(album);
        album = new Album("For those about to rock", "AC/DC");
        album.addSong("For Those About to Rock", 5.44);
        album.addSong("Put the Finger on You", 3.25);
        album.addSong("Let's Get It Up", 3.45);
        album.addSong("Inject the Venom", 3.33);
        album.addSong("Snowballed", 4.51);
        album.addSong("Evil Walks", 3.45);
        album.addSong("C.O.D.", 5.25);
        album.addSong("Breaking the Rules", 5.32);
        album.addSong("Night of the Long Knives", 5.12);
        albums.add(album);

        List<Song> playlist = new LinkedList<>();
        albums.get(0).addToPlaylist("You Can't Do It Right", playlist);
        albums.get(0).addToPlaylist("Holy Man", playlist);
        albums.get(0).addToPlaylist("Speed king", playlist); // Speed king does not exist on album 0
        albums.get(0).addToPlaylist(9, playlist);
        albums.get(1).addToPlaylist(8, playlist);
        albums.get(1).addToPlaylist(3, playlist);
        albums.get(1).addToPlaylist(2, playlist);
        albums.get(1).addToPlaylist(24, playlist); // no track 24

        play(playlist);
    }

    private static void play(List<Song> playlist) {
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean forward = true;
        ListIterator<Song> i = playlist.listIterator();
        if (playlist.size() == 0) {
            System.out.println("No songs in playlist");
            return;
        } else {
            System.out.println("Now playing " + i.next().toString());
            printMenu();
        }
        while (!quit) {
            int action = scanner.nextInt();
            scanner.nextLine();
            switch (action) {
                case 0: {
                    System.out.println("Playlist complete.");
                    quit = true;
                    break;
                }
                case 1: {
                    if (!forward) {
                        if (i.hasNext()) {
                            i.next();
                        }
                        forward = true;
                    }
                    if (i.hasNext()) {
                        System.out.println("Now playing " + i.next().toString());
                    } else {
                        System.out.println("Reached the end of the list");
                        forward = false;
                    }
                    break;
                }
                case 2: {
                    if (forward) {
                        if (i.hasPrevious()) {
                            i.previous();
                            forward = false;
                        }
                    }
                    if (i.hasPrevious()) {
                        System.out.println("Now playing " + i.previous().toString());
                    } else {
                        System.out.println("We are at the start of the list");
                        forward = true;
                    }
                    break;
                }
                case 3: {
                    if (forward) {
                        if (i.hasPrevious()) {
                            System.out.println("Now replaying " + i.previous().toString());
                            forward = false;
                        } else {
                            System.out.println("We are at the start of the list");
                        }
                    } else {
                        if (i.hasNext()) {
                            System.out.println("Now replaying " + i.next().toString());
                            forward = true;
                        } else {
                            System.out.println("We have reached the end of the list");
                        }
                    }
                    break;
                }
                case 4: {
                    printList(playlist);
                    break;
                }
                case 5: {
                    printMenu();
                    break;
                }
                case 6: {
                    if (playlist.size() > 0) {
                        i.remove();
                        if (i.hasNext()) {
                            System.out.println("Now playing " + i.next().toString());
                        } else if (i.hasPrevious()) {
                            System.out.println("Now playing " + i.previous().toString());
                        }
                    }
                }
            }
        }
    }

    private static void printList(List<Song> playlist) {
        System.out.println("============================");
        for (Song song : playlist) {
            System.out.println(song.toString());
        }
        System.out.println("============================");
    }

    private static void printMenu() {
        System.out.println("Available actions:\npress");
        System.out.println("0 - to quit\n" +
                "1 - play next song\n" +
                "2 - play previous song\n" +
                "3 - replay current song\n" +
                "4 - list songs in the playlist\n" +
                "5 - print menu options\n" +
                "6 - remove current song from playlist");
    }
}
