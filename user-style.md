# User JavaFX Coding Style Guide

> This document describes the exact coding conventions of this user for JavaFX projects.
> Use it as the single source of truth when generating code in their style.

---

## 1. File & Class Structure

- One public class per file, filename matches class name exactly.
- Every main class **extends `Application`** and implements `start(Stage stage)`.
- `main()` is always a **one-liner**: `public static void main(String[] args) { launch(); }`
- Controller classes (FXML) are separate files, never nested.
- Inner model classes (e.g. `Persona`) are `public static` and defined inside the Application class.

```java
public class JavaFXXX extends Application {
    @Override
    public void start(Stage stage) {
        // ...
        stage.setScene(new Scene(root, width, height));
        stage.show();
    }
    public static void main(String[] args) { launch(); }
}
```

---

## 2. Imports

- Use **wildcard imports** for `javafx.scene.control.*` and `javafx.scene.layout.*`.
- Use **specific imports** for everything else (`javafx.stage.Stage`, `javafx.geometry.Insets`, etc.).
- No unused imports.

```java
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
```

In FXML files, use wildcard imports too:
```xml
<?import javafx.scene.control.*?>
<?import javafx.scene.layout.*?>
```

---

## 3. Variable Naming

### UI Controls — Hungarian-prefix convention:
| Prefix | Type        | Example          |
|--------|-------------|------------------|
| `lbl`  | Label       | `lblMessaggio`   |
| `btn`  | Button      | `btnCambia`      |
| `txt`  | TextField   | `txtNome`        |
| `cmb`  | ComboBox    | `cmbClasse`      |
| `tbl` / `table` | TableView | `table`    |
| `col`  | TableColumn | `colNome`        |
| `bar`  | ProgressBar | `bar`            |

### Layout variables:
- Root layout: always named **`root`**.
- Secondary layouts named by role: `form`, `menu`, `toolbar`, `actions`, `overlay`, `wrapper`.

### Other:
- Event lambda parameter: always **`e`** (never `event`, `actionEvent`, etc.) — except `@FXML` handler method parameter which is `ActionEvent event`.
- GraphicsContext: always **`g`**.
- Short, obvious names preferred (`count`, `items`, `list`, `slider`).

---

## 4. Event Handlers

- **Always** use lambda expressions. Never anonymous classes.
- Single-line logic → inline lambda:
  ```java
  btn.setOnAction(e -> lbl.setText("Cliccato!"));
  ```
- Multi-line logic → block lambda:
  ```java
  btn.setOnAction(e -> {
      if (!txt.getText().isEmpty()) {
          items.add(txt.getText());
          txt.clear();
      }
  });
  ```
- FXML controller methods are annotated `@FXML`, prefixed with **`on`**, and accept `ActionEvent event`:
  ```java
  @FXML
  private void onSaluta(ActionEvent event) { ... }
  ```

---

## 5. Layout Construction

- **Simple layouts**: pass children directly in the constructor with spacing:
  ```java
  VBox root = new VBox(10, lbl, btn);
  ```
- **Complex layouts**: declare the container first, then `add()` / `getChildren().add()` separately.
- Always call `stage.setScene(new Scene(root, width, height))` — width and height always explicit.
- `stage.setTitle(...)` is optional; only included when the window has a meaningful title.
- `stage.show()` is always the last line of `start()`.

---

## 6. Styling — CSS & Color

- **Inline CSS** via `.setStyle(...)` using `-fx-` properties, concatenated with `+` for multi-property strings:
  ```java
  btn.setStyle(
      "-fx-background-color: #1976D2;" +
      "-fx-text-fill: white;" +
      "-fx-font-weight: bold;"
  );
  ```
- **Java Color API** for programmatic/dynamic color changes:
  ```java
  lbl.setTextFill(Color.GREEN);
  lbl.setTextFill(Color.RED);
  ```
- `Color.rgb(r, g, b, opacity)` used for background fills with transparency.
- `BackgroundFill` + `Background` used when setting background on a layout pane (never CSS on containers when Java API is cleaner).
- No external CSS files — all styling is inline or via Java API.

---

## 7. Comments & Documentation

- Comments are written like a human would type them casually — **lowercase**, no punctuation rules, occasional typos or syntax quirks are fine and expected.
- **Always one-liners** — `//` only, never block comments `/* */`, no multi-line comment structures.
- No structured separators like `// ===`, `// ***`, `// ---` or banner-style blocks.
- No ASCII diagrams, no tables inside comments, no "Quando usarlo" sections.
- Just a short, natural, lowercase explanation of what the next line/block does — written in **Italian**.
- UI strings (button text, labels, prompts) are in Italian.

---

## 8. FXML Style

- Root element is always a layout pane (e.g. `<VBox>`) with `xmlns:fx` and `fx:controller`.
- `spacing` and `alignment` set as XML attributes directly on the element.
- `<padding>` uses a nested `<Insets>` child element (not inline attribute).
- `fx:id` follows the same naming prefixes as Java (`txtNome`, `lblMessaggio`).
- `onAction` references controller method with `#` prefix: `onAction="#onSaluta"`.
- Inline `style` attribute used for font/weight on Labels.
- Each element on its own line; attributes on the same line as the tag for short elements.

```xml
<VBox xmlns:fx="http://javafx.com/fxml"
      fx:controller="MainController"
      spacing="10"
      alignment="CENTER">

    <padding>
        <Insets top="20" right="20" bottom="20" left="20"/>
    </padding>

    <Label text="Titolo" style="-fx-font-size: 18px; -fx-font-weight: bold;" />
    <TextField fx:id="txtNome" promptText="Scrivi il tuo nome..." />
    <Button text="Saluta" onAction="#onSaluta" />
    <Label fx:id="lblMessaggio" text="..." />

</VBox>
```

---

## 9. Model / Data Classes

- Minimal: only constructor + getters, no setters unless needed.
- `public static` inner class inside the Application class.
- No JavaFX Properties in model (uses plain `String`, `int`, etc.) — `PropertyValueFactory` handles binding to TableView.

```java
public static class Persona {
    private String nome;
    private int eta;
    public Persona(String nome, int eta) { this.nome = nome; this.eta = eta; }
    public String getNome() { return nome; }
    public int getEta() { return eta; }
}
```

---

## 10. General Formatting

- Indentation: **4 spaces** (no tabs).
- Opening brace `{` on same line as declaration.
- Blank line between logical sections inside `start()`.
- No blank line between `stage.setScene(...)` and `stage.show()`.
- Visually align `grid.add()` calls by column/row argument for readability:
  ```java
  grid.add(lblNome,    0, 0);
  grid.add(txtNome,    1, 0);
  grid.add(lblCognome, 0, 1);
  grid.add(txtCognome, 1, 1);
  ```
- `ObservableList` always created via `FXCollections.observableArrayList()`, then passed to the ListView constructor — not set via `setItems()`.
- Binding done with `.bind()` directly, not listeners:
  ```java
  bar.progressProperty().bind(slider.valueProperty());
  lbl.textProperty().bind(count.asString());
  ```

---

## 11. What This User Does NOT Do

- ❌ No `initialize()` method in Application classes (only in Controllers when needed).
- ❌ No anonymous inner classes for event handlers.
- ❌ No external `.css` files.
- ❌ No `setItems()` on ListView — always passes `ObservableList` via constructor.
- ❌ No JavaFX Properties in model classes.
- ❌ No `@Override` annotation on `main()`.
- ❌ No Javadoc (`/** */`) — plain block comments `/* */` only.
- ❌ No `this.` prefix on local variables inside `start()`.
- ❌ Multi-line `main()` body — always single call to `launch()`.
