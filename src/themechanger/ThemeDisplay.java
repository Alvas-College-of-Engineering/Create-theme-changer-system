package themechanger;

/**
 * Simulates a UI display panel that reacts to theme changes.
 * In a real Swing/JavaFX app this class would update component colours;
 * here it prints a visual representation to the console.
 */
public class ThemeDisplay implements ThemeChangeListener {

    private final String componentName;
    private Theme appliedTheme;

    /**
     * Constructor.
     *
     * @param componentName  a label used in console output (e.g. "Main Window")
     * @param initialTheme   the theme to apply at construction time
     */
    public ThemeDisplay(String componentName, Theme initialTheme) {
        this.componentName = componentName;
        this.appliedTheme  = initialTheme;
        render();
    }

    /** Returns the theme currently applied to this display. */
    public Theme getAppliedTheme() {
        return appliedTheme;
    }

    /**
     * Called automatically by ThemeManager when the theme changes.
     *
     * @param previousTheme the old theme
     * @param newTheme      the new theme to apply
     */
    @Override
    public void onThemeChanged(Theme previousTheme, Theme newTheme) {
        System.out.println("\n[" + componentName + "] Theme change received: "
                + previousTheme.getDisplayName() + " → " + newTheme.getDisplayName());
        appliedTheme = newTheme;
        render();
    }

    /** Prints a styled console representation of the current theme. */
    public void render() {
        Theme t = appliedTheme;
        System.out.println("┌─────────────────────────────────────────┐");
        System.out.printf( "│  Component : %-28s│%n", componentName);
        System.out.printf( "│  Theme     : %-28s│%n", t.getDisplayName());
        System.out.printf( "│  BG Color  : %-28s│%n", t.getBackgroundColor());
        System.out.printf( "│  Text Color: %-28s│%n", t.getTextColor());
        System.out.printf( "│  Panel BG  : %-28s│%n", t.getPanelColor());
        System.out.printf( "│  Border    : %-28s│%n", t.getBorderColor());
        System.out.println("└─────────────────────────────────────────┘");
    }
}
