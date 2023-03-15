package it.polito.tdp.alien;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.alien.model.Translate;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {

	private Translate model;
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnClearText;

    @FXML
    private Button btnTranslate;

    @FXML
    private TextArea txtResult;

    @FXML
    private TextField txtWord;

    @FXML
    void doClear(ActionEvent event) {

    	this.txtWord.clear();
    	this.txtResult.clear();
    	
    }

    @FXML
    void doTranslate(ActionEvent event) {
    	
    	this.txtResult.clear();
    	
    	String testo = this.txtWord.getText().toLowerCase();
    	
    	String[] arr = testo.split(" ");
    	
    	//System.out.println("Txttesto: " + testo.length());
    	//System.out.println("Arr_: " + arr.length);
    	
    	// Controlli
    	
    	if(testo.length() == 0 || arr.length == 0) {
    		this.txtResult.setText("Inserisci una o due parole!");
    	}
    	
    	if(!arr[0].matches("[a-zA-Z?]*")) {
    		this.txtResult.setText("Inserire solo caratteri alfabetici!");	
    	}
    	
    	if(arr.length > 1) {
        	if(!arr[1].matches("[a-zA-Z?]*")) {
        		this.txtResult.setText("Inserire solo caratteri alfabetici!");
        	}
    	}
    	
    	
    	if(arr.length == 2) { // aggiungere traduzione
    		
    		this.model.addWord(arr[0], arr[1]);
    		
    	} else if(arr.length == 1 && testo.length() > 0) {
    		
    		String ris = this.model.stampaTraduzione(arr[0]);
    		
    		this.txtResult.setText(ris);
    	}
    	
    	
    }

    @FXML
    void initialize() {
        assert btnClearText != null : "fx:id=\"btnClearText\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnTranslate != null : "fx:id=\"btnTranslate\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtWord != null : "fx:id=\"txtWord\" was not injected: check your FXML file 'Scene.fxml'.";

    }

	public void setModel(Translate model) {
		this.model = model;
	}

	
}
