package controller;

import model.Model;
import view.View;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

/**
 *
 * Wir implementieren das Interface (entspricht in etwa einer abstrakten Klasse)
 * EventHandler<MouseEvent>, damit wir auf Mausklicks reagieren koennen.
 * 
 * Durch das Interface EventHandler machen wir erst einmal bekannt, dass wir
 * auf Events, die in JavaFX stattfinden, reagieren wollen.
 * 
 * In den spitzen Klammern geben wir den genauen Typ des Events an,
 * hier MouseEvents. Dies zeigt, dass wir hier auf MouseEvents,
 * also v.a. Klicks reagieren wollen.
 * 
 * Die Angabe des genauen Events ist noetig, da das Interface dies so vorschreibt.
 * Ausserdem ist der Code besser lesbar, wenn wir pro Klasse nur auf ein Event reagieren.
 *
 */
public class MouseClickHandler implements EventHandler<MouseEvent> {
	private Model model;
	private View view;
	
	/**
	 * Konstruktor: speichere Referenzen auf Model und View
	 * @param model Referenz auf das Model-Objekt
	 * @param view Referenz auf das View-Objekt
	 */
	public MouseClickHandler(Model model, View view) {
		this.model = model;
		this.view = view;
	}

	/**
	 * Handle-Methode:
	 * legt fest, was bei Mausklick passiert.
	 * Durch getSource() fragen wir ab, welches Objekt geklickt wurde.
	 */	
	@Override
	public void handle(MouseEvent event) {
		if (event.getSource() == view.getBeendenButton()) {
			// Programm beenden
			System.exit(0);
		}
		if (event.getSource() == view.getUebertragenButton()) {
			// den Text aus dem Textfeld in das Label kopieren
			view.getEinLabel().setText(view.getTextEingabe().getText());
		}
		if (event.getSource() == view.getCounterButton()) {
			// Counter-Variable im Model hochzaehlen
			model.setCounter(model.getCounter() + 1);
			// Text im Counter-Button neu setzen
			view.getCounterButton().setText("Counter: " + model.getCounter());
		}
		if (event.getSource() == view.getCheckBox()) {
			// Status der Checkbox im Model abspeichern
			model.setChecked(view.getCheckBox().isSelected());
			// frage ab, ob die CheckBox ausgewaehlt ist oder nicht
			if (model.isChecked()) {
				/*
				 * Falls die Checkbox angeklickt wurde, den Text aendern und die Eingabebox
				 * deaktivieren
				 */
				view.getCheckBoxLabel().setText("Checkbox ausgewaehlt");
				view.getTextEingabe().setDisable(true);
			} else { // und umgekehrt
				view.getCheckBoxLabel().setText("Checkbox nicht ausgewaehlt");
				view.getTextEingabe().setDisable(false);
			}
		}
	}
}
