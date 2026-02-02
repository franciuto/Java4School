import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

// convertitore valute euro dollari 
public class convertitore extends Application {
    private boolean sync = false;

    public void start(Stage finestra) {
        // etichette per le valute
        Label lblEuro = new Label("Euro €");
        Label lblDollaro = new Label("Dollari $");

        // campi di testo per inserire i valori
        TextField campoEuro = new TextField();
        campoEuro.setPromptText("importo in euro");    // placeholder euro
        TextField campoDollaro = new TextField();
        campoDollaro.setPromptText("importo in dollari");  // placehodler dollari

        // messaggio per errori di input
        Label msg = new Label();

        // quando modifico il campo euro aggiorno i dollari
        campoEuro.textProperty().addListener((obs, old, val) -> {
            if(sync) return;  // evito ricorsione infinita
            sync = true;
            try {
                if(val.isEmpty()) {
                    campoDollaro.setText("");  // svuoto se vuoto
                    msg.setText("");
                } else {
                    double euro = Double.parseDouble(val);
                    if(euro < 0) throw new NumberFormatException();  // no valori negatvii
                    double dollari = euro * 1.17;  // tasso di cambio euro -> dollari
                    campoDollaro.setText(String.format("%.2f", dollari));
                    msg.setText("");
                }
            } catch(NumberFormatException ex) {
                msg.setText("inserisci un numero valido");  // errore input non numerico
            }
            sync = false;
        });

        // quando modifico il campo dollari aggiorno gli euro
        campoDollaro.textProperty().addListener((obs, old, val) -> {
            if(sync) return;  // stessa logica per evitare loop
            sync = true;
            try {
                if(val.isEmpty()) {
                    campoEuro.setText("");  // svuoto se vuoto
                    msg.setText("");
                } else {
                    double dollari = Double.parseDouble(val);
                    if(dollari < 0) throw new NumberFormatException();  // controllo negativi
                    double euro = dollari / 1.17;  // conversoine inversa dollari -> euro
                    campoEuro.setText(String.format("%.2f", euro));
                    msg.setText("");
                }
            } catch(NumberFormatException ex) {
                msg.setText("inserisci un numero valido");
            }
            sync = false;
        });

        // layour
        VBox boxSx = new VBox(5, lblEuro, campoEuro);      // colonna sinistra euro
        VBox boxDx = new VBox(5, lblDollaro, campoDollaro);  // colonna destra dollari

        // frecce bidireazionali
        Label frecce = new Label("⇄");
        frecce.setStyle("-fx-font-size: 20px;"); // aumento dimensione

        // riga principale con le due colonne
        HBox riga = new HBox(15, boxSx, frecce, boxDx);

        // layout finale con messaggio sotto
        VBox root = new VBox(10, riga, msg);

        finestra.setTitle("Cambio Valuta");  // titolo finestra
        finestra.setScene(new Scene(root, 320, 100));
        finestra.show();
    }

    public static void main(String[] args) { launch(); }
}
