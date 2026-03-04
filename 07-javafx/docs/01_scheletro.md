# 01 — SCHELETRO PROGETTO FXML

## Struttura file minima

```
src/
├── Main.java
├── NomeController.java
└── NomeFinestra.fxml
```

---

## Main.java — copia sempre questo

```java
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;   // o AnchorPane — deve corrispondere al root nel fxml
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Titolo App");

        FXMLLoader loader = new FXMLLoader(getClass().getResource("NomeFinestra.fxml"));
        BorderPane root = loader.load();    // tipo = root container scelto in Scene Builder

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);   // opzionale
        primaryStage.show();               // ← NON dimenticarlo
    }
}
```

> **Root container in Main.java deve essere lo stesso tipo scelto come root in Scene Builder.**
> Se in Scene Builder hai `AnchorPane` come root → `AnchorPane root = loader.load();`

---

## NomeController.java — scheletro

```java
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class NomeController {

    // un campo per ogni elemento con fx:id nel fxml
    @FXML private TextField nomeTextField;
    @FXML private Label     nomeLabel;
    @FXML private Button    nomeButton;

    // chiamato automaticamente da JavaFX dopo il caricamento del fxml
    @FXML
    private void initialize() {
        // setup iniziale
    }

    // un metodo per ogni onAction nel fxml
    @FXML
    private void nomeMetodo(ActionEvent event) {
        // logica
    }
}
```

---

## NomeFinestra.fxml — cosa Scene Builder genera (riferimento)

```xml
<?xml version="1.0" encoding="UTF-8"?>
<?import javafx.scene.layout.BorderPane?>
<?import javafx.scene.control.*?>

<BorderPane xmlns:fx="http://javafx.com/fxml"
            fx:controller="NomeController">

    <center>
        <Label text="Ciao" />
        <TextField fx:id="nomeTextField" />
        <Button text="Click" onAction="#nomeMetodo" />
    </center>
</BorderPane>
```

> Non devi scrivere l'FXML a mano — lo genera Scene Builder.
> Devi solo sapere cosa mettere nei campi **fx:controller**, **fx:id**, **onAction**.

---

## Checklist prima di compilare

- [ ] `fx:controller="NomeController"` scritto nel pannello Document > Controller in Scene Builder
- [ ] Ogni elemento interattivo ha `fx:id` assegnato (tasto destro → "Copy fx:id" in Scene Builder)
- [ ] Il nome del campo `@FXML` in Java corrisponde **esattamente** all'`fx:id`
- [ ] Il nome del metodo in Java corrisponde **esattamente** all'`onAction` (senza `#`)
- [ ] `stage.show()` presente in Main
- [ ] Il tipo del root in `loader.load()` corrisponde al container root scelto in Scene Builder
