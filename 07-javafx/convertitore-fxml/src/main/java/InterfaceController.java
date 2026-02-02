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
    private Button dollconverti;
    @FXML
    public Label output;

    private void convert(ActionEvent event) {
        Button caller = (Button) event.getSource();
        if (caller == eur_converti) {
            System.out.println("converto da euro per dio");
        } else {
            System.out.println("converto da dollaro");
        }
    }

}
