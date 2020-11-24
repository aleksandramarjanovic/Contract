package main;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;

public class UgovorKontroler {

    @FXML
    private TextField id;
    @FXML
    private TextField ime;
    @FXML
    private TextField prezime;
    @FXML
    private TextField adresa;
    @FXML
    private ToggleGroup trajanje;
    @FXML
    private ToggleGroup brzina;
    @FXML
    private ToggleGroup protok;

    @FXML
    private Button saveBtn;
    @FXML
    private Button seeAll;
    @FXML
    private Button delete;
   
    @FXML
    private URL location;
    @FXML
    private ResourceBundle resources;

    ObservableList<Ugovor> ugovori = FXCollections.<Ugovor>observableArrayList();
    Ugovor ugovor;
    
    private static Integer brojUgovora = 0;

    @FXML
    TableView<Ugovor> tabela = new TableView<>();
    

    public UgovorKontroler() {
    }

    @FXML
    private void initialize() {
        ugovor = new Ugovor();

        ime.textProperty().bindBidirectional(ugovor.imeProperty());
        prezime.textProperty().bindBidirectional(ugovor.prezimeProperty());
        adresa.textProperty().bindBidirectional(ugovor.adresaProperty());
    }

    @FXML
    private void sacuvajUgovor() {
       
            RadioButton trajanjeUgovora = (RadioButton) trajanje.getSelectedToggle();
            if (trajanje.getSelectedToggle() == null) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("Izaberite polje trajanje ugovora");
                alert.showAndWait();
                return;
            }
            String trajanjeUgovoraString = trajanjeUgovora.getText();
            
            ToggleButton brzinaInt = (ToggleButton) brzina.getSelectedToggle();
            if (brzina.getSelectedToggle() == null) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("Izaberite polje brzina interneta");
                alert.showAndWait();
                return;
            }
            String brzinaInterneta = brzinaInt.getText();
            
            RadioButton protokInterneta = (RadioButton) protok.getSelectedToggle();
            if (protok.getSelectedToggle() == null) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("Izaberite polje protok interneta");
                alert.showAndWait();
                return;
            }
            String protokString = protokInterneta.getText();
             if ((ime.getText().equals("") || (prezime.getText().equals("") || (adresa.getText().equals(""))))) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Popunite sva polja");
            alert.showAndWait();
            } else {
            
            brojUgovora++;
            
            ugovori.add(new Ugovor(brojUgovora, ime.getText(), prezime.getText(), adresa.getText(), trajanjeUgovoraString, brzinaInterneta, protokString));
            Alert a = new Alert(Alert.AlertType.INFORMATION);
            String br = String.valueOf(brojUgovora);
            a.setTitle("Uspesno ste dodali ugovor id_broj: "+br);
            a.setContentText("Ime_korisnika: " + ime.getText()+"\n"+ "Prezime: "+prezime.getText()+"\n"+ "Trajanje_ugovora: "+trajanjeUgovoraString);
            a.showAndWait();
            ime.setText("");
            prezime.setText("");
            adresa.setText("");
            if (trajanje.getSelectedToggle() != null) {
                trajanje.getSelectedToggle().setSelected(false);
            }
            if (brzina.getSelectedToggle() != null) {
                brzina.getSelectedToggle().setSelected(false);
            }
            if (protok.getSelectedToggle() != null) {
                protok.getSelectedToggle().setSelected(false);
            }
            tabela.setItems(null);
        }

    }

    @FXML
    private void vratiUgovore() {
       
        List<Ugovor> ugovor = tabela.getItems();
        tabela.setItems(ugovori);
           
          }
    
    @FXML
    private void obrisiUgovor() {
           if (!ugovori.isEmpty()) {
            ugovori = tabela.getItems();
            int index = tabela.selectionModelProperty().getValue().getSelectedIndex();
            if(index>-1){
            Ugovor selectedUgovor = tabela.getSelectionModel().getSelectedItem();
            ugovori.remove(index);
            }
            }else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Ne postoje ugovori u bazi");
            alert.showAndWait();
        }

    }

    @FXML
    private void closeForm() {
        Platform.exit();

    }

}
