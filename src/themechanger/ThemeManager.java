package themechanger;

import java.util.ArrayList;
import java.util.List;

/**
 * Core manager that holds the active theme and notifies registered listeners
 * whenever the theme changes (Observer pattern).
 */
public class ThemeManager {

    private Theme currentTheme;
    private final ThemePreferenceStore store;
    private final List<ThemeChangeListener> listeners;

    /** Constructor — loads the last-saved theme from disk. */
    public ThemeManager() {
        store     = new ThemePreferenceStore();
        listeners = new ArrayList<>();
        currentTheme = store.load();          // restore persisted preference
    }

    /**
     * Returns the currently active theme.
     *
     * @return current Theme
     */
    public Theme getCurrentTheme() {
        return currentTheme;
    }

    /**
     * Switches to the specified theme, persists the choice, and
     * notifies all registered listeners.
     *
     * @param newTheme the theme to apply
     */
    public void setTheme(Theme newTheme) {
        if (newTheme == null) {
            System.err.println("[ThemeManager] Received null theme — ignoring.");
            return;
        }
        if (newTheme == currentTheme) {
            System.out.println("[ThemeManager] Theme unchanged: " + currentTheme.getDisplayName());
            return;
        }
        Theme previous = currentTheme;
        currentTheme   = newTheme;
        store.save(currentTheme);
        notifyListeners(previous, currentTheme);
    }

    /**
     * Registers a listener that will be called on every theme change.
     *
     * @param listener the listener to add
     */
    public void addListener(ThemeChangeListener listener) {
        if (listener != null) listeners.add(listener);
    }

    /**
     * Removes a previously registered listener.
     *
     * @param listener the listener to remove
     */
    public void removeListener(ThemeChangeListener listener) {
        listeners.remove(listener);
    }

    /** Fires onThemeChanged for every registered listener. */
    private void notifyListeners(Theme previous, Theme next) {
        for (ThemeChangeListener listener : listeners) {
            listener.onThemeChanged(previous, next);
        }
    }
}
