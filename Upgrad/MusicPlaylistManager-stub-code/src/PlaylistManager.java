/**
 * The PlaylistManager class manages a collection of playlists.
 * Allows creation, retrieval, and modification of playlists.
 * Playlists are stored in a HashMap where the key is the playlist name.
 */

import java.util.HashMap;

public class PlaylistManager {
    private HashMap<String, Playlist> playlists; // Map to store playlists

    // Constructor
    public PlaylistManager() {
        this.playlists = new HashMap<>();
    }

    /**
     * Implement method to create a new playlist
     * 1. Check if the given playlist name already exists in the playlists HashMap
     * 2. If the playlist name does not exist:
     *      i. Add a new playlist to the playlists HashMap with the given name
     *      ii. Print "Playlist 'name' created successfully."
     * 3. If the playlist name already exists:
     *      i. Print "Playlist with name 'name' already exists."
     */
    public void createPlaylist(String name) {
        // Write your code here
        if (playlists.containsKey(name)) {
            System.out.println("Playlist with name '" + name + "' already exists.");
        } else {
            playlists.put(name, new Playlist(name));
            System.out.println("Playlist '" + name + "' created successfully.");
        }
    }

    // Method to get a playlist by name from the playlist manager
    public Playlist getPlaylist(String playlistName) {
        return playlists.get(playlistName);
    }

    /**
     * Implement method to add a song to a playlist
     * 1. Get the playlist associated with the given playlist name from the playlists HashMap
     * 2. Add the given song to the retrieved playlist
     * 3. Print "Song 'title' by 'artist' added to playlist 'playlistName'."
     */
    public void addSongToPlaylist(String playlistName, Song song) {
        // Write your code here
        Playlist playlist = playlists.get(playlistName);
        if (playlist != null) {
            playlist.addSong(song);
            System.out.println("Song '" + song.getTitle() + "' by '" + song.getArtist() + "' added to playlist '" + playlistName + "'.");
        } else {
            System.out.println("Playlist '" + playlistName + "' not found.");
        }
    }

    /**
     * Implement method to remove a song from a playlist
     * 1. Get the playlist object from the playlists HashMap using the provided playlistName
     * 2. Call the findSongByTitle() method on the playlist object to find the song to remove
     * 3. If the song is found (i.e., songToRemove is not null):
     *      i. Remove the song from the playlist
     *      ii. Print "Song " + songTitle + " removed from playlist " + playlistName + "."
     * 4. If the song is not found:
     *      i. Print "Song " + songTitle + " not found in playlist " + playlistName + "."
     */
    public void removeSongFromPlaylist(String playlistName, String songTitle) {
        // Write your code here
        Playlist playlist = playlists.get(playlistName);
        if (playlist != null) {
            Song songToRemove = playlist.findSongByTitle(songTitle);
            if (songToRemove != null) {
                playlist.removeSong(songToRemove);
                System.out.println("Song '" + songTitle + "' removed from playlist '" + playlistName + "'.");
            } else {
                System.out.println("Song '" + songTitle + "' not found in playlist '" + playlistName + "'.");
            }
        } else {
            System.out.println("Playlist '" + playlistName + "' not found.");
        }
    }

    /**
     * Implement method to display all playlists
     * 1. Print "Available Playlists:"
     * 2. Iterate over the keys of the playlists HashMap
     * 3. For each playlist name, print "- playlistName"
     */
    public void displayPlaylists() {
        // Write your code here
        System.out.println("Available Playlists:");
        for (String playlistName : playlists.keySet()) {
            System.out.println("- " + playlistName);
        }
    }

    // Method to check if a playlist with the given name exists
    public boolean containsPlaylist(String playlistName) {
        return playlists.containsKey(playlistName);
    }
}