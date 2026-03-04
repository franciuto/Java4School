# 03 — CONTROLLI: METODI CHE TI SERVONO

## Label

```java
@FXML private Label miaLabel;

miaLabel.setText("testo");          // scrive
miaLabel.getText();                 // legge
miaLabel.setVisible(false);         // nasconde (occupa ancora spazio)
miaLabel.setStyle("-fx-text-fill: red; -fx-font-size: 16px;");
```

---

## TextField

```java
@FXML private TextField mioTextField;

mioTextField.getText();                    // legge il contenuto
mioTextField.setText("valore");            // imposta il contenuto
mioTextField.clear();                      // svuota
mioTextField.setPromptText("placeholder"); // testo grigio quando vuoto
mioTextField.setEditable(false);           // sola lettura
mioTextField.setDisable(true);             // disabilita (grigio)

// Ascolta i cambiamenti in tempo reale
mioTextField.textProperty().addListener((obs, oldVal, newVal) -> {
    System.out.println("Nuovo valore: " + newVal);
});
```

---

## Button

```java
@FXML private Button mioButton;

mioButton.setText("Click");
mioButton.setDisable(true);          // disabilita
mioButton.setVisible(false);         // nasconde

// In alternativa al collegamento FXML, puoi farlo via codice in initialize():
mioButton.setOnAction(e -> {
    // logica
});
```

---

## TextArea

```java
@FXML private TextArea miaTextArea;

miaTextArea.getText();
miaTextArea.setText("testo lungo...");
miaTextArea.appendText("\nriga aggiunta");
miaTextArea.clear();
miaTextArea.setEditable(false);
miaTextArea.setWrapText(true);       // va a capo automaticamente
```

---

## ComboBox

```java
@FXML private ComboBox<String> miaCombo;

// Popolare (di solito in initialize)
miaCombo.getItems().addAll("Opzione A", "Opzione B", "Opzione C");
miaCombo.setValue("Opzione A");       // seleziona di default

// Leggere la selezione
String selezionato = miaCombo.getValue();

// Ascoltare il cambio selezione
miaCombo.setOnAction(e -> {
    String val = miaCombo.getValue();
});
```

---

## CheckBox

```java
@FXML private CheckBox mioCheck;

mioCheck.isSelected();               // true/false
mioCheck.setSelected(true);          // forza stato
mioCheck.getText();                  // legge etichetta
mioCheck.setOnAction(e -> {
    if (mioCheck.isSelected()) { /* ... */ }
});
```

---

## RadioButton + ToggleGroup

```java
@FXML private RadioButton radio1;
@FXML private RadioButton radio2;

// In initialize() — raggruppa i radio button
ToggleGroup gruppo = new ToggleGroup();
radio1.setToggleGroup(gruppo);
radio2.setToggleGroup(gruppo);

// Leggere quale è selezionato
RadioButton selezionato = (RadioButton) gruppo.getSelectedToggle();
if (selezionato != null) {
    String testo = selezionato.getText();
}
```

> Puoi anche assegnare il ToggleGroup direttamente in Scene Builder:
> seleziona il RadioButton → tab Code → campo **Toggle Group** → scrivi lo stesso nome per tutti.

---

## Slider

```java
@FXML private Slider mioSlider;

mioSlider.getValue();                // valore attuale (double)
mioSlider.setValue(50.0);
mioSlider.setMin(0);
mioSlider.setMax(100);

mioSlider.valueProperty().addListener((obs, oldVal, newVal) -> {
    double valore = newVal.doubleValue();
});
```

---

## ProgressBar

```java
@FXML private ProgressBar miaProgressBar;

miaProgressBar.setProgress(0.5);    // 0.0 → 1.0 (50%)
miaProgressBar.setProgress(1.0);    // 100%
```

---

## Alert — finestra di dialogo

```java
// Informazione
Alert alert = new Alert(Alert.AlertType.INFORMATION);
alert.setTitle("Titolo");
alert.setHeaderText(null);           // null = nessun sottotitolo
alert.setContentText("Messaggio");
alert.showAndWait();

// Errore
Alert alert = new Alert(Alert.AlertType.ERROR);
alert.setContentText("Qualcosa è andato storto");
alert.showAndWait();

// Conferma (sì/no)
Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
alert.setContentText("Sei sicuro?");
Optional<ButtonType> result = alert.showAndWait();
if (result.isPresent() && result.get() == ButtonType.OK) {
    // ha confermato
}
```

---

## ImageView

```java
@FXML private ImageView miaImmagine;

// Caricare da risorse del progetto
Image img = new Image(getClass().getResourceAsStream("/images/foto.png"));
miaImmagine.setImage(img);

miaImmagine.setFitWidth(200);
miaImmagine.setFitHeight(200);
miaImmagine.setPreserveRatio(true);  // mantiene proporzioni
```
