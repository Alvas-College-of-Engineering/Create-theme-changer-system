package themechanger;

import java.io.*;
import java.nio.file.*;

/**
 * Handles persistent storage of the user's theme preference.
 * Saves to a plain-text file in the user's home directory.
 */
public class ThemePreferenceStore {

    private static final String FILE_NAME = "theme_preference.txt";
    private final Path storagePath;

    /** Constructor — resolves the storage file path. */
    public ThemePreferenceStore() {
        storagePath = Paths.get(System.getProperty("user.home"), FILE_NAME);
    }

    /**
     * Saves the given theme name to disk.
     *
     * @param theme the theme to persist
     */
    public void save(Theme theme) {
        try (BufferedWriter writer = Files.newBufferedWriter(storagePath)) {
            writer.write(theme.name());
            System.out.println("[Store] Saved theme preference: " + theme.name());
        } catch (IOException e) {
            System.err.println("[Store] Failed to save preference: " + e.getMessage());
        }
    }

    /**
     * Loads the stored theme from disk.
     * Returns LIGHT as default if no file exists or parsing fails.
     *
     * @return the previously saved Theme, or LIGHT
     */
    public Theme load() {
        if (!Files.exists(storagePath)) {
            System.out.println("[Store] No saved preference found. Defaulting to LIGHT.");
            return Theme.LIGHT;
        }
        try (BufferedReader reader = Files.newBufferedReader(storagePath)) {
            String line = reader.readLine();
            if (line != null) {
                Theme theme = Theme.valueOf(line.trim().toUpperCase());
                System.out.println("[Store] Loaded saved theme: " + theme.name());
                return theme;
            }
        } catch (IOException | IllegalArgumentException e) {
            System.err.println("[Store] Could not read preference: " + e.getMessage());
        }
        return Theme.LIGHT;
    }
}
