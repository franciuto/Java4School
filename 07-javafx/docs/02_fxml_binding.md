# 02 — FXML + SCENE BUILDER: REGOLE DI BINDING

## La regola d'oro (non sbagliarla mai)

| Scene Builder | Java (Controller) |
|---|---|
| `fx:id="mioTesto"` | `@FXML private TextField mioTesto;` |
| `onAction="#cliccato"` | `@FXML private void cliccato(ActionEvent e) {}` |
| Controller field = `NomeController` | Il file si chiama `NomeController.java` |

**Se anche solo un carattere non corrisponde → NullPointerException a runtime.**

---

## Come assegnare fx:id in Scene Builder

1. Seleziona il componente sulla canvas
2. Pannello destro → tab **Code**
3. Campo **fx:id** → scrivi il nome
4. Campo **On Action** → scrivi il nome del metodo (senza `#`, quello lo aggiunge FXML da solo)

---

## Come impostare il controller in Scene Builder

1. Pannello sinistro → tab **Document** → sezione **Controller**
2. Campo **Controller class** → scrivi `NomeController`

---

## Tipi da importare nel controller in base a cosa usi

```java
import javafx.fxml.FXML;
import javafx.event.ActionEvent;        // per i metodi onAction
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ComboBox;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.TextArea;
import javafx.scene.control.Slider;
import javafx.scene.control.ProgressBar;
```

---

## initialize() — quando usarlo

```java
@FXML
private void initialize() {
    // Viene chiamato DOPO che tutti i @FXML sono stati iniettati
    // Usalo per:
    // - impostare valori di default
    // - aggiungere listener
    // - popolare ComboBox
    // - qualsiasi setup iniziale
    
    combo.getItems().addAll("Opzione 1", "Opzione 2", "Opzione 3");
    label.setText("Pronto");
}
```

> `initialize()` è il "costruttore" del controller per JavaFX.
> NON usare un costruttore normale per accedere ai campi `@FXML` — a quel punto non sono ancora iniettati.

---

## Passare dati tra finestre (se richiesto dalla traccia)

```java
// Nel controller che apre la nuova finestra
FXMLLoader loader = new FXMLLoader(getClass().getResource("SecondaFinestra.fxml"));
Parent root = loader.load();

SecondoController controller = loader.getController();
controller.setDato("valore da passare");   // metodo pubblico nel secondo controller

Stage nuovoStage = new Stage();
nuovoStage.setScene(new Scene(root));
nuovoStage.show();
```

```java
// Nel SecondoController
public void setDato(String dato) {
    this.mioLabel.setText(dato);
}
```

---

## Errori comuni e come riconoscerli

| Errore | Causa |
|---|---|
| `NullPointerException` su un campo `@FXML` | `fx:id` non corrisponde al nome del campo |
| La finestra non appare | Manca `stage.show()` |
| Il metodo non viene chiamato | `onAction` nel FXML non corrisponde al nome del metodo Java |
| `ClassCastException` in `loader.load()` | Il tipo dichiarato in Main non corrisponde al root container nel FXML |
| Controller non trovato | `fx:controller` nel FXML sbagliato o classe non compilata |
