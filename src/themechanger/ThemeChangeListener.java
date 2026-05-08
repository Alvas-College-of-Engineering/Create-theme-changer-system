package themechanger;

/**
 * Listener interface for theme-change events.
 * Any component that needs to react to theme changes must implement this.
 */
public interface ThemeChangeListener {

    /**
     * Called when the active theme changes.
     *
     * @param previousTheme the theme that was active before the switch
     * @param newTheme      the newly activated theme
     */
    void onThemeChanged(Theme previousTheme, Theme newTheme);
}
