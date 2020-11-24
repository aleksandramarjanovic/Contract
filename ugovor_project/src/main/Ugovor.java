package main;

import java.util.ArrayList;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Ugovor {

    private final IntegerProperty id = new SimpleIntegerProperty(this, "id", 0);
    private final StringProperty ime = new SimpleStringProperty(this, "ime", "");
    private final StringProperty prezime = new SimpleStringProperty(this, "prezime", "");
    private final StringProperty adresa = new SimpleStringProperty(this, "adresa", "");
    private final StringProperty trajanje = new SimpleStringProperty(this, "trajanje", "");
    private final StringProperty brzina = new SimpleStringProperty(this, "brzina", "");
    private final StringProperty protok = new SimpleStringProperty(this, "protok", "");


    public Ugovor() {

    }

    public Ugovor(Integer id,String ime, String prezime, String adresa, String trajanje, String brzina, String protok) {

        this.id.set(id);
        this.ime.set(ime);
        this.prezime.set(prezime);
        this.adresa.set(adresa);
        this.trajanje.set(trajanje);
        this.brzina.set(brzina);
        this.protok.set(protok);
    }

    public Ugovor(Integer id) {
        this.id.set(id);
    }

    public Integer getId() {
        return id.get();
    }

    public void setId(Integer id) {
        this.id.set(id);
    }

    public IntegerProperty idProperty() {
        return id;
    }

    public Ugovor(String ime) {
        this.ime.set(ime);
    }

    public String getIme() {
        return ime.get();
    }

    public void setIme(String ime) {
        this.ime.set(ime);
    }

    public StringProperty imeProperty() {
        return ime;
    }

    public String getPrezime() {
        return prezime.get();
    }

    public void setPrezime(String prezime) {
        this.prezime.set(prezime);
    }

    public StringProperty prezimeProperty() {
        return prezime;
    }

    public String getAdresa() {
        return adresa.get();
    }

    public void setAdresa(String adresa) {
        this.adresa.set(adresa);
    }

    public StringProperty adresaProperty() {
        return adresa;
    }
    
    public String getTrajanje() {
	return trajanje.get();
    }

    public void setTrajanje(String trajanje) {
	this.trajanje.set(trajanje);
    }

    public StringProperty trajanjeProperty() {
	return trajanje;
    }
    
    public String getBrzina() {
	return brzina.get();
    }

    public void setBrzina(String brzina) {
	this.brzina.set(brzina);
    }

    public StringProperty brzinaProperty() {
	return brzina;
    }
    
    public String getProtok() {
	return trajanje.get();
    }

    public void setProtok(String protok) {
	this.protok.set(protok);
    }

    public StringProperty protokProperty() {
	return protok;
    }
   
}
