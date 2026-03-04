# 06 — IMPORTS E FORMATTAZIONE

## Import completi per Main.java

```java
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;    // cambia in base al root del tuo FXML
import javafx.stage.Stage;
```

---

## Import completi per il Controller

```java
// Obbligatori
import javafx.fxml.FXML;
import javafx.event.ActionEvent;

// Controlli (aggiungi solo quelli che usi)
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.scene.control.ComboBox;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Slider;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

// Layout (se costruisci layout a codice)
import javafx.scene.layout.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;

// Immagini
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

// Utility Java
import java.util.Optional;
```

> **Trucco veloce**: usa `import javafx.scene.control.*;` e `import javafx.scene.layout.*;`
> per evitare di dimenticare singoli import durante la verifica.

---

## String.format — riferimento rapido

```java
String.format("%.2f", 3.14159)    // → "3.14"   (2 decimali)
String.format("%.0f", 3.7)        // → "4"      (nessun decimale, arrotonda)
String.format("%d", 42)           // → "42"     (intero)
String.format("%s ha %d anni", "Marco", 25)  // → "Marco ha 25 anni"

// Usato spesso per mostrare risultati
outputLabel.setText(String.format("%.2f EUR = %.2f USD", eur, usd));
```

---

## Conversioni di tipo utili

```java
// String → numeri
double d = Double.parseDouble(tf.getText());
int    i = Integer.parseInt(tf.getText());

// Numeri → String
String s1 = String.valueOf(42);
String s2 = String.valueOf(3.14);
String s3 = Double.toString(3.14);

// double → int (tronca)
int intero = (int) 3.9;    // → 3

// Controllo se stringa è vuota
if (tf.getText().trim().isEmpty()) { ... }
```

---

## Operatori e metodi String utili

```java
String s = "  Hello World  ";
s.trim()                    // "Hello World" — rimuove spazi
s.toLowerCase()             // "  hello world  "
s.toUpperCase()             // "  HELLO WORLD  "
s.contains("World")         // true
s.equals("Hello")           // false — confronto case-sensitive
s.equalsIgnoreCase("hello") // false (c'è lo spazio, ma come esempio)
s.length()                  // 15
s.isEmpty()                 // false
s.replace("Hello", "Ciao")  // "  Ciao World  "
```

---

## Math — funzioni utili

```java
Math.abs(-5)        // 5       — valore assoluto
Math.pow(2, 10)     // 1024.0  — potenza
Math.sqrt(16)       // 4.0     — radice quadrata
Math.round(3.7)     // 4       — arrotonda
Math.max(3, 7)      // 7
Math.min(3, 7)      // 3
Math.PI             // 3.14159...
```
