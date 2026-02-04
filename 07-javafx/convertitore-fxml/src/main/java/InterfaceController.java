import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class InterfaceController {
    @FXML
    private TextField eur_input;
    @FXML
    private TextField doll_input;
    @FXML
    private Button eur_converti;
    @FXML
    private Button doll_convert;
    @FXML
    public Label output;

    @FXML
    private void convert(ActionEvent event) {
        Button caller = (Button) event.getSource();
        
        try {
            if (caller == eur_converti) {
                // Conversione da EUR a USD
                String eurText = eur_input.getText().trim();
                if (eurText.isEmpty()) {
                    output.setText("Inserisci un valore in euro");
                    return;
                }
                
                double eurAmount = Double.parseDouble(eurText);
                double usdAmount = eurAmount * 1.1; // Tasso di cambio EUR -> USD
                
                output.setText(String.format("%.2f EUR = %.2f USD", eurAmount, usdAmount));
                doll_input.setText(String.format("%.2f", usdAmount));
                
            } else {
                // Conversione da USD a EUR
                String usdText = doll_input.getText().trim();
                if (usdText.isEmpty()) {
                    output.setText("Inserisci un valore in dollari");
                    return;
                }
                
                double usdAmount = Double.parseDouble(usdText);
                double eurAmount = usdAmount / 1.1; // Tasso di cambio USD -> EUR
                
                output.setText(String.format("%.2f USD = %.2f EUR", usdAmount, eurAmount));
                eur_input.setText(String.format("%.2f", eurAmount));
            }
            
        } catch (NumberFormatException e) {
            output.setText("Inserisci un numero valido");
        }
    }

}
