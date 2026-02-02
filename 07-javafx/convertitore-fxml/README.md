# JavaFX Scene Builder Maven Project

This is a Maven project configured to work with **JavaFX Scene Builder**.

## Project Structure

```
maven-javafx-scenebuilder/
├── pom.xml                                 # Maven configuration with Scene Builder dependencies
├── src/
│   └── main/
│       ├── java/
│       │   └── Main.java                  # Main application class
│       └── resources/
│           └── MainWindow.fxml            # FXML layout (edit with Scene Builder)
└── README.md
```

## Requirements

- Java 17 or later
- Maven 3.6+
- JavaFX Scene Builder (download from: https://gluonhq.com/products/scene-builder/)

## Setup

### 1. Build the project

```bash
mvn clean compile
```

### 2. Open FXML files in Scene Builder

1. Install JavaFX Scene Builder
2. Open `src/main/resources/MainWindow.fxml` with Scene Builder
3. Edit the UI visually and save

### 3. Run the application

```bash
mvn javafx:run
```

## Key Features for Scene Builder

✅ **FXML Support** - Full FXML file support with `javafx-fxml` dependency
✅ **Standard Maven Layout** - Uses `src/main/java` and `src/main/resources`
✅ **Resource Folder** - FXML files are stored in `src/main/resources`
✅ **FXMLLoader** - Main class loads FXML files at runtime
✅ **JavaFX Plugin** - Configured javafx-maven-plugin for easy execution

## Adding More FXML Files

1. Create new `.fxml` files in `src/main/resources/`
2. Open them in Scene Builder to design the UI
3. Create corresponding controller classes in `src/main/java/`
4. Link controllers in FXML: `fx:controller="YourControllerClass"`

## Dependencies

- **javafx-controls** - UI controls
- **javafx-fxml** - FXML file support (required for Scene Builder)
- **javafx-graphics** - Graphics support

## IDE Configuration

### IntelliJ IDEA

1. File → Project Structure → Modules
2. Select your module, go to "Sources"
3. Mark `src/main/java` as Sources and `src/main/resources` as Resources

### Eclipse/VSCode

The Maven configuration should automatically recognize the directory structure.

## Troubleshooting

### "Cannot find resource MainWindow.fxml"
- Ensure the FXML file is in `src/main/resources/`
- Run `mvn clean compile` to rebuild

### Scene Builder cannot open FXML
- Check that the FXML is valid XML
- Verify controller class exists (if specified in FXML)

## Learn More

- [JavaFX Documentation](https://openjfx.io/)
- [Scene Builder Guide](https://gluonhq.com/products/scene-builder/learn/)
- [FXML Tutorial](https://docs.oracle.com/javase/8/javafx/fxml-tutorial/index.html)
