import java.math.RoundingMode;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class MainController implements Initializable {

    @FXML
    ComboBox<String> combo1;

    @FXML
    ComboBox<String> combo2;

    @FXML
    TextField textField1;

    @FXML
    Label labelRes;

    @FXML
    public void onConvertAction() {
        double resultat = 0d;
        DecimalFormat df = new DecimalFormat();
        df.setRoundingMode(RoundingMode.HALF_UP);
        df.setMaximumFractionDigits(2);
        // System.out.println(combo1.getSelectionModel().getSelectedIndex());
        // System.out.println(combo2.getSelectionModel().getSelectedIndex());

        switch (combo1.getSelectionModel().getSelectedIndex()) {

            case 0:

                if (combo2.getSelectionModel().getSelectedIndex() == 0) { // euro --> dollar
                    resultat = Double.parseDouble(textField1.getText()) * 1.18d;
                    labelRes.setText(String.valueOf(df.format(resultat) + " $")); // euro --> dollar
                    break;

                } else if (combo2.getSelectionModel().getSelectedIndex() == 2) { // euro bath
                    resultat = Double.parseDouble(textField1.getText()) * 38.23;
                    labelRes.setText(String.valueOf(df.format(resultat) + " B"));
                    break;
                }

                else { // on ne change rien
                    labelRes.setText("Veuillez choisir une devise ");

                }

                break;
            case 1:

                if (combo2.getSelectionModel().getSelectedIndex() == 1) { // dollar --> euro
                    resultat = Double.parseDouble(textField1.getText()) * 0.85d;
                    labelRes.setText(String.valueOf(df.format(resultat) + " €"));

                } else if (combo2.getSelectionModel().getSelectedIndex() == 2) { // euro bath
                    resultat = Double.parseDouble(textField1.getText()) * 32.29d;
                    labelRes.setText(String.valueOf(df.format(resultat) + " B"));
                    break;
                } else { // on ne fait rien
                    labelRes.setText("Veuillez choisir une devise ");
                }

                break;

            case 2: // 2-0 BATH dollar 2-1 bat euro 2-2 pas bon

                if (combo2.getSelectionModel().getSelectedIndex() == 0) {
                    resultat = Double.parseDouble(textField1.getText()) * 0.031d;
                    labelRes.setText(String.valueOf(df.format(resultat) + " $"));
                    break;

                } else if (combo2.getSelectionModel().getSelectedIndex() == 1) {
                    resultat = Double.parseDouble(textField1.getText()) * 0.026d;
                    labelRes.setText(String.valueOf(df.format(resultat) + " €"));
                    break;

                } else {
                    labelRes.setText("Veuillez choisir une devise ");
                }

                break;
            case 3:

        }

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        combo1.getItems().add("€ EURO");
        combo1.getItems().add("$ DOLLAR");
        combo1.getItems().add("B BATH");

        combo2.getItems().add("$ DOLLAR");
        combo2.getItems().add("€ EURO");
        combo2.getItems().add("B BATH");
        // init des valeurs par defaut dans les combo
        combo2.getSelectionModel().selectFirst();
        combo1.getSelectionModel().selectFirst();

    }

}