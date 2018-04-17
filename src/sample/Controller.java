package sample;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyEvent;


public class Controller {


    private String napis;
    private String napis2 = "Tutaj wklej tekst lub załaduj z menu:\n" +
            "public class PolishWords {\n" +
            "    public static void main(String[] args) {\n" +
            "        File file = new File(\"jakis_path\");\n" +
            "        try {\n" +
            "            InputStreamReader inputStreamReader =\n" +
            "                    new InputStreamReader(new FileInputStream(file), \"UTF-8\")\n" +
            "        } catch (UnsupportedEncodingException e) {\n" +
            "            e.printStackTrace();\n" +
            "        } catch (FileNotFoundException e) {\n" +
            "            e.printStackTrace();\n" +
            "        }   ";

    private char[] tablica = new char[napis2.length()];

    @FXML
    TextArea pisz;

    @FXML
    Label labelka;

    @FXML
    Label errors;

    @FXML
    TextArea oknoTekstu;

    @FXML
    public void pisze() {
        pisz.addEventFilter(KeyEvent.KEY_TYPED, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {

                napis = pisz.getText();
                tablica = napis.toCharArray();
                labelka.setText("Pozostało znaków: " + (napis2.length() - tablica.length));
                char[] tab1 = napis.toCharArray();
                char[] tab2 = napis2.toCharArray();
                int blad = 0;
                for (int i = 0; i < tab1.length; i++) {
                    if (tab1[i] != tab2[i]) blad++;
                }
                errors.setText("Liczba błędów: " + blad);
            }
        });
    }
}
