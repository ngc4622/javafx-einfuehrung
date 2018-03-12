package controller;

import model.Model;
import view.View;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.KeyCode;

/**
 * 
 * @author Tobias Tefke
 * 
 * Implementierung des Interfaces EventHandler.
 * Genaueres siehe Kommentare in MouseClickHandler.
 *
 */
public class KeyEventHandler implements EventHandler<KeyEvent> {
	private Model model;
	private View view;
	
	public KeyEventHandler(Model model, View view) {
		this.model = model;
		this.view = view;
	}
	
	@Override
	public void handle(KeyEvent event) {
		// speichere die bisherige x- und y-Verschiebung der ImageView
		int x = model.getStrichmaennchenXOffset();
		int y = model.getStrichmaennchenYOffset();
		// lege offset fest: wir verschieben die ImageView um 15 Pixel
		int offset = 15;
		
		/*
		 * Hier geben wir an, dass wir nur auf bestimmte KeyCodes (entspricht dem
		 * Druecken einer bestimmten Taste) reagieren wollen.
		 * 
		 * Die Methoden setTranslateX/Y erlauben es uns, das Objekt, von dem aus wir
		 * die Methode ausrufen, um die als Parameter uebergebene Anzahl Pixel in die
		 * angegebene Richtung (X/Y-Achse) zu verschieben.
		 * 
		 * Zum Schluss aendern wir noch die bisherigen Werte fuer die X-und Y-Verschiebung
		 */
		if (event.getCode() == KeyCode.W) {
			view.getStrichmaennchenView().setTranslateY(y - offset);
			y -= offset;
		}
		if (event.getCode() == KeyCode.S) {
			view.getStrichmaennchenView().setTranslateY(y + offset);
			y += offset;
		}
		if (event.getCode() == KeyCode.A) {
			view.getStrichmaennchenView().setTranslateX(x - offset);
			x -= offset;
		}
		if (event.getCode() == KeyCode.D) {
			view.getStrichmaennchenView().setTranslateX(x + offset);
			x += offset;
		}
		
		// neue Werte im Model speichern
		model.setStrichmaennchenXOffset(x);
		model.setStrichmaennchenYOffset(y);
	}
}
