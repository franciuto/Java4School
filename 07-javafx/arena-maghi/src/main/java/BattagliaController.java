import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BattagliaController {

    enum Azione {
        ATTACCA("Attacca"),
        CURATI("Curati"),
        RIPOSA("Riposa");

        private final String label;

        Azione(String label) {
            this.label = label;
        }

        @Override
        public String toString() {
            return label;
        }
    }

    @FXML
    private VBox root;
    @FXML
    private Label lblTurno;
    @FXML
    private VBox panelStats;
    @FXML
    private Label lblMagoCorrente;
    @FXML
    private Label lblInfo;
    @FXML
    private ComboBox<Azione> cmbAzione;
    @FXML
    private ComboBox<String> cmbSpell;
    @FXML
    private ComboBox<String> cmbBersaglio;
    @FXML
    private Button btnConferma;
    @FXML
    private ListView<String> listLog;

    private ObservableList<String> logItems;
    private Arena arena;
    private List<Wizard> ordineTurno;
    private int indiceMagoCorrente;

    @FXML
    public void initialize() {
        logItems = FXCollections.observableArrayList();
        listLog.setItems(logItems);
        cmbAzione.getItems().addAll(Azione.values());
    }

    public void initGame(Arena arena) {
        this.arena = arena;
        iniziaTurno();
    }

    private void iniziaTurno() {
        if (arena.isGameOver()) {
            mostraVincitore();
            return;
        }

        int t = arena.nextTurn();
        lblTurno.setText("Turno " + t);
        logItems.add("--- TURNO " + t + " ---");

        ordineTurno = arena.getAliveWizards();
        indiceMagoCorrente = 0;

        aggiornaStats();
        preparaMago();
    }

    private void preparaMago() {
        if (indiceMagoCorrente >= ordineTurno.size()) {
            iniziaTurno();
            return;
        }

        Wizard mago = ordineTurno.get(indiceMagoCorrente);

        if (!mago.isAlive()) {
            indiceMagoCorrente++;
            preparaMago();
            return;
        }

        lblMagoCorrente.setText("Turno di: " + mago.getNome() + " " + mago.getAlias());
        lblInfo.setText("Potenza: " + mago.getPotenzaMagica() + " | Difesa: " + mago.getDifesa());

        cmbAzione.setValue(null);
        cmbSpell.getItems().clear();
        cmbSpell.setValue(null);
        cmbBersaglio.getItems().clear();
        cmbBersaglio.setValue(null);
        cmbSpell.setDisable(true);
        cmbBersaglio.setDisable(true);
        btnConferma.setDisable(false);
    }

    @FXML
    private void onAzioneChanged() {
        Azione azione = cmbAzione.getValue();
        if (azione == null)
            return;

        Wizard mago = ordineTurno.get(indiceMagoCorrente);
        cmbSpell.getItems().clear();
        cmbBersaglio.getItems().clear();

        if (azione == Azione.ATTACCA) {
            cmbSpell.setDisable(false);
            cmbBersaglio.setDisable(false);
            for (Spell s : mago.getSpellBook()) {
                if (s.getTipo() == Spell.Tipo.ATTACCO && mago.canCast(s)) {
                    cmbSpell.getItems()
                            .add(s.getNome() + " (mana: " + s.getCostoMana() + ", danno: " + s.getValoreBase() + ")");
                }
            }
            for (Wizard w : arena.getAliveWizards()) {
                if (w != mago) {
                    cmbBersaglio.getItems().add(w.getNome() + " (HP: " + w.getHp() + ")");
                }
            }
        } else if (azione == Azione.CURATI) {
            cmbSpell.setDisable(false);
            cmbBersaglio.setDisable(true);
            for (Spell s : mago.getSpellBook()) {
                if (s.getTipo() == Spell.Tipo.CURA) {
                    cmbSpell.getItems()
                            .add(s.getNome() + " (mana: " + s.getCostoMana() + ", cura: " + s.getValoreBase() + ")");
                }
            }
        } else {
            cmbSpell.setDisable(true);
            cmbBersaglio.setDisable(true);
        }
    }

    @FXML
    private void onConfermaClicked() {
        Azione azione = cmbAzione.getValue();
        if (azione == null) {
            lblInfo.setText("Scegli un azione");
            return;
        }

        Wizard mago = ordineTurno.get(indiceMagoCorrente);
        String risultato;

        if (azione == Azione.ATTACCA) {
            if (cmbSpell.getValue() == null || cmbBersaglio.getValue() == null) {
                lblInfo.setText("Scegli incantesimo e bersaglio");
                return;
            }
            int idxSpell = cmbSpell.getSelectionModel().getSelectedIndex();
            List<Spell> attacchi = new ArrayList<>();
            for (Spell s : mago.getSpellBook()) {
                if (s.getTipo() == Spell.Tipo.ATTACCO && mago.canCast(s))
                    attacchi.add(s);
            }
            Spell spell = attacchi.get(idxSpell);

            int idxTarget = cmbBersaglio.getSelectionModel().getSelectedIndex();
            List<Wizard> bersagli = new ArrayList<>();
            for (Wizard w : arena.getAliveWizards()) {
                if (w != mago)
                    bersagli.add(w);
            }
            Wizard target = bersagli.get(idxTarget);

            risultato = mago.cast(spell, target);

        } else if (azione == Azione.CURATI) {
            if (cmbSpell.getValue() == null) {
                lblInfo.setText("Scegli un incantesimo di cura");
                return;
            }
            int idxSpell = cmbSpell.getSelectionModel().getSelectedIndex();
            List<Spell> cure = new ArrayList<>();
            for (Spell s : mago.getSpellBook()) {
                if (s.getTipo() == Spell.Tipo.CURA && mago.canCast(s))
                    cure.add(s);
            }
            Spell spell = cure.get(idxSpell);
            risultato = mago.cast(spell, mago);

        } else {
            risultato = mago.rest();
        }

        logItems.add(risultato);
        listLog.scrollTo(logItems.size() - 1);

        for (Wizard w : arena.getWizards()) {
            if (!w.isAlive() && !logItems.contains(w.getNome() + " sconfitto")) {
                logItems.add(w.getNome() + " sconfitto");
            }
        }

        aggiornaStats();

        indiceMagoCorrente++;
        preparaMago();
    }

    private void aggiornaStats() {
        panelStats.getChildren().clear();
        Color[] colori = { Color.DARKRED, Color.DARKBLUE, Color.DARKGREEN, Color.BLACK };

        for (int i = 0; i < arena.getWizards().size(); i++) {
            Wizard w = arena.getWizards().get(i);

            double percentHp = (double) w.getHp() / w.getHpMax();
            ProgressBar barHp = new ProgressBar(percentHp);
            barHp.setPrefWidth(120);
            barHp.setStyle("-fx-accent: #4CAF50;");

            double percentMana = (double) w.getMana() / w.getManaMax();
            ProgressBar barMana = new ProgressBar(percentMana);
            barMana.setPrefWidth(120);
            barMana.setStyle("-fx-accent: #2196F3;");

            Label lblNome = new Label(w.getNome() + " " + w.getAlias());
            lblNome.setTextFill(i < colori.length ? colori[i] : Color.BLACK);
            lblNome.setStyle("-fx-font-weight: bold; -fx-min-width: 150;");

            Label lblHp = new Label("HP: " + w.getHp() + "/" + w.getHpMax());
            lblHp.setStyle("-fx-min-width: 80;");
            Label lblMana = new Label("Mana: " + w.getMana() + "/" + w.getManaMax());
            lblMana.setStyle("-fx-min-width: 90;");
            Label lblVel = new Label("Vel: " + w.getVelocita());

            if (!w.isAlive()) {
                lblNome.setTextFill(Color.GRAY);
                lblNome.setText(w.getNome() + " \uD83D\uDC80");
                lblHp.setTextFill(Color.GRAY);
                lblMana.setTextFill(Color.GRAY);
                lblVel.setTextFill(Color.GRAY);
            }

            HBox riga = new HBox(10, lblNome, lblHp, barHp, lblMana, barMana, lblVel);
            riga.setAlignment(Pos.CENTER_LEFT);
            panelStats.getChildren().add(riga);
        }
    }

    private void mostraVincitore() {
        Wizard vincitore = arena.getWinner();
        String msg = vincitore != null ? vincitore.getNome() + " " + vincitore.getAlias() + " ha vinto"
                : "Nessun vincitore";

        logItems.add(msg);

        lblMagoCorrente.setText(msg);
        lblMagoCorrente.setStyle("-fx-font-size: 18px; -fx-font-weight: bold; -fx-text-fill: #FFD700;");
        lblInfo.setText("Partita terminata al turno " + arena.getTurno());

        cmbAzione.setDisable(true);
        cmbSpell.setDisable(true);
        cmbBersaglio.setDisable(true);
        btnConferma.setDisable(true);

        Button btnNuova = new Button("Nuova Partita");
        btnNuova.setStyle(
                "-fx-background-color: #1976D2;" +
                        "-fx-text-fill: white;" +
                        "-fx-font-weight: bold;");
        btnNuova.setOnAction(e -> {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/setup.fxml"));
                VBox setupRoot = loader.load();
                Stage stage = (Stage) root.getScene().getWindow();
                stage.setScene(new Scene(setupRoot, 500, 500));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });

        root.getChildren().add(btnNuova);
    }
}
