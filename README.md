# Java Theme Changer System

A console-based Java application that lets users switch between **Light**, **Dark**, and **Custom** themes. The selected theme is persisted to disk and automatically restored on the next run. Multiple UI components (display panels) update simultaneously via the Observer pattern.

---

## Project Structure

```
ThemeChanger/
├── src/
│   └── themechanger/
│       ├── Main.java                  ← Entry point / console menu
│       ├── Theme.java                 ← Enum: LIGHT, DARK, CUSTOM (with color values)
│       ├── ThemeManager.java          ← Manages active theme + notifies listeners
│       ├── ThemeChangeListener.java   ← Interface for Observer pattern
│       ├── ThemeDisplay.java          ← UI component that reacts to theme changes
│       └── ThemePreferenceStore.java  ← Saves/loads preference to ~/theme_preference.txt
└── README.md
```

---

## How to Run in VS Code

### Prerequisites
- **Java JDK 11+** — [Download](https://adoptium.net/)
- **VS Code** — [Download](https://code.visualstudio.com/)
- **Extension Pack for Java** — Install from VS Code Extensions (`Ctrl+Shift+X`) → search `Extension Pack for Java`

### Steps

1. **Open the project folder in VS Code**
   ```
   File → Open Folder → select the ThemeChanger folder
   ```

2. **Compile the source files**  
   Open a terminal in VS Code (`Ctrl+` `` ` ``) and run:
   ```bash
   # From inside the ThemeChanger folder
   mkdir -p out
   javac -d out src/themechanger/*.java
   ```

3. **Run the application**
   ```bash
   java -cp out themechanger.Main
   ```

4. **Using VS Code's Run button (alternative)**  
   Open `Main.java`, click the ▶ **Run** button that appears above `public static void main(...)`.

---

## How to Push to GitHub

### First-time setup

1. **Create a repository on GitHub**  
   Go to [github.com](https://github.com) → **New repository** → name it `ThemeChanger` → click **Create repository**

2. **Initialize Git locally** (run in your `ThemeChanger` folder)
   ```bash
   git init
   git add .
   git commit -m "Initial commit: Java Theme Changer System"
   ```

3. **Connect to GitHub and push**
   ```bash
   git remote add origin https://github.com/<your-username>/ThemeChanger.git
   git branch -M main
   git push -u origin main
   ```
   Replace `<your-username>` with your actual GitHub username.

### Subsequent pushes (after making changes)
```bash
git add .
git commit -m "Your commit message"
git push
```

---

## How It Works

| Class | Role |
|---|---|
| `Theme` | Enum holding display name + colour values for each theme |
| `ThemeManager` | Stores active theme, persists it, notifies listeners |
| `ThemeChangeListener` | Interface: `onThemeChanged(previous, next)` |
| `ThemeDisplay` | Implements the listener; renders theme info to console |
| `ThemePreferenceStore` | Reads/writes `theme_preference.txt` in user home directory |
| `Main` | Entry point; wires everything together; runs the menu loop |

---

## Sample Output

```
╔══════════════════════════════════════════╗
║       Java Theme Changer System          ║
╚══════════════════════════════════════════╝

┌─────────────────────────────────────────┐
│  Component : Main Window                │
│  Theme     : Light                      │
│  BG Color  : #FFFFFF                    │
│  Text Color: #000000                    │
│  Panel BG  : #F0F0F0                    │
│  Border    : #333333                    │
└─────────────────────────────────────────┘
```
