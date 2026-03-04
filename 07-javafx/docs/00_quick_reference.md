# 00 — QUICK REFERENCE (apri questo per primo)

## Ordine di lavoro con FXML + Scene Builder

```
1. Crea Main.java          → scheletro con launch() e FXMLLoader
2. Crea NomeController.java → classe vuota con @FXML
3. Apri Scene Builder       → costruisci l'interfaccia
4. In Scene Builder:
     - Document > Controller > scrivi "NomeController"
     - Ogni elemento interattivo → tab Code → assegna fx:id
     - Ogni bottone → tab Code → On Action → scrivi nome metodo
5. Torna in Java:
     - Aggiungi @FXML per ogni fx:id usato
     - Aggiungi @FXML void nomeMetodo(ActionEvent e) per ogni onAction
6. Implementa la logica
```

---

## I 3 collegamenti FXML ↔ Java

```
fx:controller="NomeController"     →  public class NomeController { }
fx:id="mioLabel"                   →  @FXML private Label mioLabel;
onAction="#clicca"                 →  @FXML private void clicca(ActionEvent e) { }
```

---

## Lettura / scrittura controlli

```java
textField.getText()          textField.setText("x")    textField.clear()
label.getText()              label.setText("x")
combo.getValue()             combo.setValue("x")
check.isSelected()           check.setSelected(true)
slider.getValue()            slider.setValue(50.0)
```

---

## Validazione numerica — sempre con try-catch

```java
try {
    double n = Double.parseDouble(campo.getText().trim());
    // usa n
} catch (NumberFormatException e) {
    label.setText("Inserisci un numero valido");
}
```

---

## Layout — scegli in 5 secondi

```
Verticale?        → VBox
Orizzontale?      → HBox
Griglia?          → GridPane      grid.add(nodo, col, row)
Header+Centro+Footer? → BorderPane
Posizionamento libero? → AnchorPane (solo Scene Builder)
```

---

## initialize() — usalo per setup

```java
@FXML
private void initialize() {
    combo.getItems().addAll("A", "B", "C");
    label.setText("Pronto");
    button.setDisable(true);
}
```

---

## Alert rapido

```java
Alert a = new Alert(Alert.AlertType.INFORMATION);
a.setTitle("Titolo");
a.setHeaderText(null);
a.setContentText("Messaggio");
a.showAndWait();
```

---

## Errori più comuni

| Sintomo | Causa | Fix |
|---|---|---|
| Finestra non appare | Manca `stage.show()` | Aggiungilo |
| NullPointerException su campo @FXML | fx:id ≠ nome campo Java | Verifica ortografia |
| Metodo non chiamato | onAction ≠ nome metodo | Verifica ortografia |
| ClassCastException in load() | Tipo root sbagliato in Main | Usa stesso tipo del root FXML |
| Cambio testo non funziona | Stai usando `new Label()` invece del campo @FXML | Usa il campo iniettato |

---

## File da consultare per dettagli

| Argomento | File |
|---|---|
| Struttura progetto / Main.java | `01_scheletro.md` |
| Binding FXML ↔ controller | `02_fxml_binding.md` |
| Metodi di ogni controllo | `03_controlli.md` |
| Layout containers | `04_layout.md` |
| Pattern copia-e-adatta | `05_pattern.md` |
| Import e String.format | `06_imports_utils.md` |
