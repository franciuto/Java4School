// TODO: Comment in english
// TODO: Implement Exceptions
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    private TextField display;
    private String currentInput = "";
    private double firstOperand = 0;
    private String operator = "";
    private boolean startNewInput = true;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Calculator");

        // Display per visualizzare risultati
        display = new TextField("0");
        display.setEditable(false);
        display.setAlignment(Pos.CENTER_RIGHT);
        display.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");
        display.setPrefHeight(60);

        // Grid pane per contenere i numeri
        GridPane buttonGrid = new GridPane();
        buttonGrid.setHgap(5);
        buttonGrid.setVgap(5);
        buttonGrid.setPadding(new Insets(10)); // Aggiungo padding su tutti i lati

        // Dichiarazione pulsanti
        String[] buttons = {
                "C", "+/-", "%", "/",
                "7", "8", "9", "*",
                "4", "5", "6", "-",
                "1", "2", "3", "+",
                "0", ".", "="
        };

        int col = 0;
        int row = 0;
        // Render dei bottoni
        for (String text : buttons) {
            Button btn = createButton(text);
            // Gestione dello zero
            if (text.equals("0")) {
                buttonGrid.add(btn, col, row, 2, 1);
                btn.setMaxWidth(Double.MAX_VALUE);
                col += 2;
            } else {
                buttonGrid.add(btn, col, row);
                col++;
            }
            // Prossima riga
            if (col > 3) {
                col = 0;
                row++;
            }
        }

        // Configurazione interfaccia principale
        VBox root = new VBox(10);
        root.setPadding(new Insets(10));
        root.getChildren().addAll(display, buttonGrid); // Aggiunge display e button grid a root

        Scene scene = new Scene(root, 250, 350); // Dimensione della finestra
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Spawn bottoni
    private Button createButton(String text) {
        Button btn = new Button(text);
        btn.setPrefSize(55, 55);
        btn.setStyle("-fx-font-size: 18px;");

        btn.setOnAction(e -> handleButton(text));
        return btn;
    }

    // Gestione input bottoni
    private void handleButton(String text) {
        switch (text) {
            case "0":
            case "1":
            case "2":
            case "3":
            case "4":
            case "5":
            case "6":
            case "7":
            case "8":
            case "9":
                // controllo se sto già inserendo un numero
                if (startNewInput) {
                    currentInput = text;
                    startNewInput = false;
                } else {
                    currentInput += text;
                }
                display.setText(currentInput);
                break;

            // Gestione del punto per numeri decimali
            case ".":
                if (!currentInput.contains(".")) {
                    if (startNewInput) {
                        currentInput = "0.";
                        startNewInput = false;
                    } else {
                        currentInput += ".";
                    }
                    display.setText(currentInput);
                }
                break;

            // Salva il primo numero e l'operazione
            case "+":
            case "-":
            case "*":
            case "/":
                if (!currentInput.isEmpty()) {
                    firstOperand = Double.parseDouble(currentInput);
                }
                operator = text;
                startNewInput = true;
                break;

            // Calcola il risultato
            case "=":
                if (!operator.isEmpty() && !currentInput.isEmpty()) {
                    double secondOperand = Double.parseDouble(currentInput);
                    double result = calculate(firstOperand, secondOperand, operator);
                    display.setText(formatResult(result));
                    currentInput = String.valueOf(result);
                    operator = "";
                    startNewInput = true;
                }
                break;
            // Reset
            case "C":
                currentInput = "";
                firstOperand = 0;
                operator = "";
                startNewInput = true;
                display.setText("0");
                break;

            case "+/-":
                if (!currentInput.isEmpty()) {
                    double value = Double.parseDouble(currentInput);
                    value = -value;
                    currentInput = String.valueOf(value);
                    display.setText(formatResult(value));
                }
                break;

            case "%":
                if (!currentInput.isEmpty()) {
                    double value = Double.parseDouble(currentInput);
                    value = value / 100;
                    currentInput = String.valueOf(value);
                    display.setText(formatResult(value));
                }
                break;
        }
    }

    private double calculate(double a, double b, String op) {
        switch (op) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                return b != 0 ? a / b : 0; // Evito divisioni per zero
            default:
                return 0;
        }
    }

    // Casting per gestione risultati
    private String formatResult(double value) {
        if (value == (long) value) {
            return String.valueOf((long) value);
        }
        return String.valueOf(value);
    }
}
