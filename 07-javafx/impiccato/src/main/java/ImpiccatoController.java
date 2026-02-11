import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;

public class ImpiccatoController {

    private Random randomGenerator = new Random();
    private String wordChoice;
    private StringBuilder wordToGuess;
    private int wrongGuesses;
    private Set<Character> usedLetters = new HashSet<>();

    @FXML
    private ImageView imgImpiccato;

    @FXML
    private Label lblParolaDaIndovinare;

    private ArrayList<String> words = new ArrayList<>();

    @FXML
    private void keyEvent(KeyEvent event) {
        String text = event.getText();
        if (text.length() == 1) {
            char letter = Character.toLowerCase(text.charAt(0));
            if (Character.isLetter(letter)) {
                tryHandler(letter);
            }
        }
        lblParolaDaIndovinare.setText(wordToGuess.toString().replace("", " ").strip());
    }


    @FXML
    private void initialize() {
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(getClass().getResourceAsStream("/1000_parole_italiane_comuni.txt")))) {
            String line;
            while ((line = reader.readLine()) != null) {
                words.add(line.trim());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        gameInitialization();
    }

    private void gameInitialization() {
        setImageFromStage(0);
        wordChoice = getRandomWord(words);
        usedLetters.clear();
        System.out.println(wordChoice);
        wrongGuesses = 0;
        wordToGuess = new StringBuilder();
        for (int i = 0; i < wordChoice.length(); i++) {
            wordToGuess.append('_');
        }
        lblParolaDaIndovinare.setText(wordToGuess.toString().replace("", " ").strip());
    }

    private void tryHandler(char letter) {
        if (usedLetters.contains(letter)) {
            wrongGuesses++;
            setImageFromStage(wrongGuesses);
            if (wrongGuesses == 10) {
                showAlert("Hai perso", "La parola era: " + wordChoice);
                gameInitialization();
            }
            return;
        }

        usedLetters.add(letter);
        if (wordChoice.indexOf(letter) != -1) {
            for (int i = 0; i < wordChoice.length(); i++) {
                if (wordChoice.charAt(i) == letter) {
                    wordToGuess.setCharAt(i, letter);
                }
            lblParolaDaIndovinare.setText(wordToGuess.toString().replace("", " ").strip());
            }
        } else {
            wrongGuesses++;
            setImageFromStage(wrongGuesses);
        }

        if (wrongGuesses == 10) {
            showAlert("Hai perso", "La parola era: " + wordChoice);
            gameInitialization();
        }
        if (wordToGuess.indexOf("_") == -1) {
            showAlert("Hai vinto!!", "aura!");
            gameInitialization();
        }
    }

    private void setImageFromStage(int stage) {
        try {
            imgImpiccato.setImage(new Image(getClass().getResourceAsStream("/images/" + stage + ".png")));
        } catch (Exception e) {
            System.err.println("Errore nel caricamento dell'immagine: " + stage + ".png");
            e.printStackTrace();
        }
    }

    private String getRandomWord(ArrayList<String> wordList) {
        int index = randomGenerator.nextInt(wordList.size());
        return wordList.get(index);
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
