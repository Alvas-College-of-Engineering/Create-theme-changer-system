package themechanger;

import java.util.Scanner;

/**
 * Entry point for the Theme Changer System.
 * Provides a console menu to switch between Light, Dark, and Custom themes.
 */
public class Main {

    public static void main(String[] args) {

        System.out.println("╔══════════════════════════════════════════╗");
        System.out.println("║       Java Theme Changer System          ║");
        System.out.println("╚══════════════════════════════════════════╝\n");

        // Core manager — loads persisted preference automatically
        ThemeManager manager = new ThemeManager();

        // Two UI components that listen for theme changes
        ThemeDisplay mainWindow  = new ThemeDisplay("Main Window",  manager.getCurrentTheme());
        ThemeDisplay sidePanel   = new ThemeDisplay("Side Panel",   manager.getCurrentTheme());

        // Register both as listeners
        manager.addListener(mainWindow);
        manager.addListener(sidePanel);

        // Console menu loop
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n┌──────────────── MENU ────────────────┐");
            System.out.println("│  1. Switch to Light Theme             │");
            System.out.println("│  2. Switch to Dark Theme              │");
            System.out.println("│  3. Switch to Custom Theme            │");
            System.out.println("│  4. Show Current Theme Info           │");
            System.out.println("│  5. Exit                              │");
            System.out.println("└───────────────────────────────────────┘");
            System.out.print("Enter choice: ");

            String input = scanner.nextLine().trim();

            switch (input) {
                case "1":
                    manager.setTheme(Theme.LIGHT);
                    break;
                case "2":
                    manager.setTheme(Theme.DARK);
                    break;
                case "3":
                    manager.setTheme(Theme.CUSTOM);
                    break;
                case "4":
                    System.out.println("\n--- Current Theme Info ---");
                    mainWindow.render();
                    sidePanel.render();
                    break;
                case "5":
                    System.out.println("\nGoodbye! Preference saved.");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please enter 1–5.");
            }
        }

        scanner.close();
    }
}
