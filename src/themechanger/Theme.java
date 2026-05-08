package themechanger;

/**
 * Enum representing available themes in the system.
 */
public enum Theme {
    LIGHT("Light", "#FFFFFF", "#000000", "#F0F0F0", "#333333"),
    DARK("Dark", "#1E1E1E", "#FFFFFF", "#2D2D2D", "#AAAAAA"),
    CUSTOM("Custom", "#FFF8E7", "#3D2B1F", "#F5E6C8", "#5C4033");

    private final String displayName;
    private final String backgroundColor;
    private final String textColor;
    private final String panelColor;
    private final String borderColor;

    /**
     * Constructor for Theme enum.
     *
     * @param displayName     human-readable name
     * @param backgroundColor background hex color
     * @param textColor       foreground/text hex color
     * @param panelColor      secondary panel hex color
     * @param borderColor     border/accent hex color
     */
    Theme(String displayName, String backgroundColor, String textColor,
          String panelColor, String borderColor) {
        this.displayName   = displayName;
        this.backgroundColor = backgroundColor;
        this.textColor     = textColor;
        this.panelColor    = panelColor;
        this.borderColor   = borderColor;
    }

    public String getDisplayName()     { return displayName; }
    public String getBackgroundColor() { return backgroundColor; }
    public String getTextColor()       { return textColor; }
    public String getPanelColor()      { return panelColor; }
    public String getBorderColor()     { return borderColor; }

    @Override
    public String toString() { return displayName; }
}
