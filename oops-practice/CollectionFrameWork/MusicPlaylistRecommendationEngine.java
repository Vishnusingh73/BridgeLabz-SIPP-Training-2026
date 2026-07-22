import java.util.*;

/**
 * Music Playlist Recommendation Engine
 * Uses LinkedList to maintain recently played songs
 * Keeps only the latest 10 songs, with most recent at the beginning
 */
public class MusicPlaylistRecommendationEngine {
    
    private LinkedList<String> recentlyPlayedSongs;
    private static final int MAX_PLAYLIST_SIZE = 10;
    
    public MusicPlaylistRecommendationEngine() {
        this.recentlyPlayedSongs = new LinkedList<>();
    }
    
    /**
     * Add a newly played song to the top of the playlist
     * @param songName Name of the song
     */
    public void addSongToPlaylist(String songName) {
        if (songName == null || songName.trim().isEmpty()) {
            System.out.println("Error: Song name cannot be empty!");
            return;
        }
        
        // Add song at the beginning (most recent)
        recentlyPlayedSongs.addFirst(songName);
        System.out.println("✓ Now playing: " + songName);
        
        // Remove oldest song if exceeds limit
        if (recentlyPlayedSongs.size() > MAX_PLAYLIST_SIZE) {
            String removedSong = recentlyPlayedSongs.removeLast();
            System.out.println("  (Removed oldest song from history: " + removedSong + ")");
        }
    }
    
    /**
     * Search for a song in the recently played history
     * @param songName Song name to search
     * @return true if found, false otherwise
     */
    public boolean searchSong(String songName) {
        if (recentlyPlayedSongs.contains(songName)) {
            int position = recentlyPlayedSongs.indexOf(songName) + 1;
            System.out.println("✓ Found: '" + songName + "' at position " + position + " in recently played");
            return true;
        } else {
            System.out.println("✗ Not found: '" + songName + "' is not in recently played history");
            return false;
        }
    }
    
    /**
     * Display the complete recently played history
     */
    public void displayRecentlyPlayedHistory() {
        if (recentlyPlayedSongs.isEmpty()) {
            System.out.println("\n========== Recently Played History ==========");
            System.out.println("No songs played yet.");
            System.out.println("Total songs in history: 0");
            System.out.println("============================================\n");
            return;
        }
        
        System.out.println("\n========== Recently Played History ==========");
        for (int i = 0; i < recentlyPlayedSongs.size(); i++) {
            String marker = (i == 0) ? "► " : "  ";
            System.out.println(marker + (i + 1) + ". " + recentlyPlayedSongs.get(i));
        }
        System.out.println("\nTotal songs in history: " + recentlyPlayedSongs.size() + "/" + MAX_PLAYLIST_SIZE);
        System.out.println("Max capacity: " + MAX_PLAYLIST_SIZE + " songs");
        System.out.println("============================================\n");
    }
    
    /**
     * Get the most recently played song
     */
    public String getMostRecentSong() {
        return recentlyPlayedSongs.isEmpty() ? null : recentlyPlayedSongs.getFirst();
    }
    
    /**
     * Get total songs in history
     */
    public int getTotalSongsInHistory() {
        return recentlyPlayedSongs.size();
    }
    
    /**
     * Clear all recently played songs
     */
    public void clearHistory() {
        recentlyPlayedSongs.clear();
        System.out.println("✓ Recently played history cleared.");
    }
    
    /**
     * Remove a specific song from history
     * @param songName Song to remove
     * @return true if removed, false if not found
     */
    public boolean removeSongFromHistory(String songName) {
        if (recentlyPlayedSongs.remove(songName)) {
            System.out.println("✓ Removed: '" + songName + "' from history");
            return true;
        } else {
            System.out.println("✗ Song not found in history");
            return false;
        }
    }
    
    public static void main(String[] args) {
        MusicPlaylistRecommendationEngine playlistEngine = new MusicPlaylistRecommendationEngine();
        
        System.out.println("========== Music Playlist Recommendation Engine ==========\n");
        
        // Play songs
        System.out.println("--- Playing Songs ---");
        playlistEngine.addSongToPlaylist("Bohemian Rhapsody");
        playlistEngine.addSongToPlaylist("Imagine");
        playlistEngine.addSongToPlaylist("Stairway to Heaven");
        playlistEngine.addSongToPlaylist("Hotel California");
        playlistEngine.addSongToPlaylist("Smells Like Teen Spirit");
        playlistEngine.addSongToPlaylist("Black");
        playlistEngine.addSongToPlaylist("Sweet Child O' Mine");
        playlistEngine.addSongToPlaylist("Wonderwall");
        playlistEngine.addSongToPlaylist("Shape of You");
        playlistEngine.addSongToPlaylist("Blinding Lights");
        
        System.out.println();
        playlistEngine.displayRecentlyPlayedHistory();
        
        // Play more songs to exceed limit
        System.out.println("--- Playing More Songs (Exceeding Limit) ---");
        playlistEngine.addSongToPlaylist("Levitating");
        System.out.println();
        playlistEngine.addSongToPlaylist("As It Was");
        System.out.println();
        playlistEngine.addSongToPlaylist("Anti-Hero");
        System.out.println();
        
        playlistEngine.displayRecentlyPlayedHistory();
        
        // Search for songs
        System.out.println("--- Searching for Songs ---");
        playlistEngine.searchSong("Bohemian Rhapsody");
        System.out.println();
        playlistEngine.searchSong("Imagine");
        System.out.println();
        playlistEngine.searchSong("Hotel California");
        System.out.println();
        playlistEngine.searchSong("Old Song");
        System.out.println();
        
        // Display most recent song
        System.out.println("--- Most Recent Song ---");
        String mostRecent = playlistEngine.getMostRecentSong();
        if (mostRecent != null) {
            System.out.println("Most recently played: " + mostRecent);
        }
        System.out.println();
        
        // Remove a song
        System.out.println("--- Removing a Song ---");
        playlistEngine.removeSongFromHistory("Shape of You");
        System.out.println();
        
        // Final display
        playlistEngine.displayRecentlyPlayedHistory();
        
        System.out.println("Total songs in recently played history: " + playlistEngine.getTotalSongsInHistory());
    }
}
