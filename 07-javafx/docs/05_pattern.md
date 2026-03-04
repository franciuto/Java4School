# 05 — PATTERN RICORRENTI (copia e adatta)

## Lettura e validazione input numerico

```java
@FXML
private void calcola(ActionEvent event) {
    try {
        double valore = Double.parseDouble(inputField.getText().trim());
        
        // usa valore
        double risultato = valore * 2;
        outputLabel.setText(String.format("%.2f", risultato));
        
    } catch (NumberFormatException e) {
        outputLabel.setText("Inserisci un numero valido");
    }
}
```

---

## Listener bidirezionale con flag anti-loop

Pattern usato nel convertitore: aggiornare il campo B quando l'utente scrive in A, e viceversa.

```java
private boolean sync = false;

@FXML
private void initialize() {
    campoA.textProperty().addListener((obs, old, val) -> {
        if (sync) return;
        sync = true;
        try {
            if (val.isEmpty()) {
                campoB.setText("");
            } else {
                double a = Double.parseDouble(val);
                double b = a * 1.17;              // formula A → B
                campoB.setText(String.format("%.2f", b));
                errLabel.setText("");
            }
        } catch (NumberFormatException ex) {
            errLabel.setText("Valore non valido");
        }
        sync = false;
    });

    campoB.textProperty().addListener((obs, old, val) -> {
        if (sync) return;
        sync = true;
        try {
            if (val.isEmpty()) {
                campoA.setText("");
            } else {
                double b = Double.parseDouble(val);
                double a = b / 1.17;              // formula B → A
                campoA.setText(String.format("%.2f", a));
                errLabel.setText("");
            }
        } catch (NumberFormatException ex) {
            errLabel.setText("Valore non valido");
        }
        sync = false;
    });
}
```

---

## Reset / pulizia form

```java
@FXML
private void reset(ActionEvent event) {
    campoNome.clear();
    campoEta.clear();
    combo.setValue(null);
    check.setSelected(false);
    outputLabel.setText("");
}
```

---

## Mostrare/nascondere elementi dinamicamente

```java
// Nasconde ma occupa spazio
errorLabel.setVisible(false);

// Nasconde e NON occupa spazio (si usa più spesso)
errorLabel.setManaged(false);
errorLabel.setVisible(false);

// Per mostrarlo di nuovo
errorLabel.setVisible(true);
errorLabel.setManaged(true);
```

---

## Abilitare un bottone solo se i campi sono compilati

```java
@FXML
private void initialize() {
    // bottone disabilitato finché i campi sono vuoti
    btnConferma.setDisable(true);
    
    campoNome.textProperty().addListener((obs, old, val) -> aggiornaBottone());
    campoEmail.textProperty().addListener((obs, old, val) -> aggiornaBottone());
}

private void aggiornaBottone() {
    boolean campiVuoti = campoNome.getText().trim().isEmpty() 
                      || campoEmail.getText().trim().isEmpty();
    btnConferma.setDisable(campiVuoti);
}
```

---

## Cambiare stile a un elemento via codice

```java
// Stile inline
label.setStyle("-fx-text-fill: red; -fx-font-weight: bold;");
label.setStyle("-fx-text-fill: green;");
label.setStyle("");   // resetta lo stile

// Aggiungere/rimuovere CSS class (se usi un file .css)
nodo.getStyleClass().add("errore");
nodo.getStyleClass().remove("errore");
```

---

## Leggere una ComboBox e reagire

```java
@FXML
private void initialize() {
    combo.getItems().addAll("Opzione 1", "Opzione 2", "Opzione 3");
    
    combo.setOnAction(e -> {
        String scelta = combo.getValue();
        if (scelta == null) return;
        
        switch (scelta) {
            case "Opzione 1":
                outputLabel.setText("Hai scelto 1");
                break;
            case "Opzione 2":
                outputLabel.setText("Hai scelto 2");
                break;
        }
    });
}
```

---

## Calcolo con più operandi e risultato formattato

```java
private String formatta(double value) {
    if (value == (long) value) {
        return String.valueOf((long) value);    // mostra 5 invece di 5.0
    }
    return String.format("%.2f", value);        // mostra 5.25
}
```

---

## Aprire una seconda finestra

```java
@FXML
private void apriSecondaFinestra(ActionEvent event) throws Exception {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("SecondaFinestra.fxml"));
    Parent root = loader.load();
    
    Stage stage = new Stage();
    stage.setTitle("Seconda finestra");
    stage.setScene(new Scene(root));
    stage.show();
}
```

---

## Chiudere la finestra corrente

```java
@FXML
private void chiudi(ActionEvent event) {
    Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
    stage.close();
}
```
