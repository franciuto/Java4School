import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SetupController {

    @FXML
    private ComboBox<Integer> cmbNumero;
    @FXML
    private VBox boxNomi;
    @FXML
    private Label lblErrore;

    private final List<TextField> campiNome = new ArrayList<>();
    private final String[] alias = { "il Rosso", "il Blu", "il Verde", "il Nero" };

    @FXML
    public void initialize() {
        cmbNumero.getItems().addAll(2, 3, 4);
        cmbNumero.setValue(2);
        aggiornaBoxNomi(2);
    }

    @FXML
    private void onNumeroChanged() {
        if (cmbNumero.getValue() != null) {
            aggiornaBoxNomi(cmbNumero.getValue());
        }
    }

    private void aggiornaBoxNomi(int numero) {
        boxNomi.getChildren().clear();
        campiNome.clear();
        for (int i = 0; i < numero; i++) {
            TextField txt = new TextField();
            txt.setPromptText("Nickname Mago " + (i + 1) + " (" + alias[i] + ")");
            txt.setMaxWidth(250);
            campiNome.add(txt);
        }
        boxNomi.getChildren().addAll(campiNome);
    }

    @FXML
    private void onStartClicked() {
        List<String> nomi = new ArrayList<>();
        for (TextField txt : campiNome) {
            String nome = txt.getText().trim();
            if (nome.isEmpty()) {
                lblErrore.setText("Inserisci tutti i nickname!");
                return;
            }
            nomi.add(nome);
        }

        // crea i maghi
        Spell[] tuttiGliSpell = {
                new Spell("Palla di Fuoco", 7, 10, Spell.Tipo.ATTACCO),
                new Spell("Fulmine", 5, 7, Spell.Tipo.ATTACCO),
                new Spell("Dardo Magico", 3, 4, Spell.Tipo.ATTACCO),
                new Spell("Cura Leggera", 4, 8, Spell.Tipo.CURA),
                new Spell("Cura Potente", 8, 15, Spell.Tipo.CURA)
        };

        List<Wizard> maghi = new ArrayList<>();
        for (int i = 0; i < nomi.size(); i++) {
            Wizard w = new Wizard(nomi.get(i), alias[i]);
            for (Spell s : tuttiGliSpell) {
                w.addSpell(s);
            }
            maghi.add(w);
        }

        // carica la schermata battaglia
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/battaglia.fxml"));
            VBox root = loader.load();
            BattagliaController controller = loader.getController();
            controller.initGame(new Arena(maghi));

            Stage stage = (Stage) boxNomi.getScene().getWindow();
            stage.setScene(new Scene(root, 750, 650));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
