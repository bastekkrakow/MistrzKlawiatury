package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyEvent;

import java.util.ArrayList;
import java.util.List;

public class Controller {

    StringBuilder input1 = new StringBuilder();
    char[] tablica = new char[100];
    int counter;
    int blad;
    char a;
    char b;
    String napis;
    String napis2 = "Tutaj wklej tekst lub załaduj z menu:";
    ArrayList lista = new ArrayList();

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
                counter = tablica.length - 1;
                System.out.println(tablica);
                labelka.setText("Pozostało znaków: " + (napis2.length() - tablica.length));
                typer();

            }
        });
    }

    @FXML
    public void typer() {
        char a = tablica[counter];
        char b = napis2.charAt(counter);
        System.out.println(tablica);
        System.out.println(napis2);
        System.out.println(a + " " + b);
        if (a != b) {
            blad = blad + 1;
            errors.setText("Liczba błędów: " + blad);
        }

    }


}
