package controller;

import view.View;
import model.Model;

/**
 * 
 * @author Tobias Tefke
 * 
 * Hier wird die Logik des Programms beschrieben

 */
public class Controller {	
	/**
	 * 
	 * @param model Model
	 * @param view View
	 * 
	 * Im Konstruktor setzen wir die Referenzen auf die Model-
	 * und View-Objekte.
	 */
	public Controller(Model model, View view) {
		/*
		 *  Bei Klick soll die Methode handle() aufgerufen werden.
		 *  Alternativ kann auch eine Klasse angegeben werden, die das
		 *  Interface EventHandler implementiert.
		 *  
		 *  Wir haben das Interface in den Handler-Klassen implementiert,
		 *  von daher koennen wir einfach eine Referenz auf die Objekte
		 *  üebergeben
		 */
		MouseClickHandler mCH = new MouseClickHandler(model, view);
		KeyEventHandler kEH = new KeyEventHandler(model, view);
		
		// Listener fuer Schaltflaechen -> bei Mausklick auf diese
		view.getBeendenButton().setOnMouseClicked(mCH);
		view.getUebertragenButton().setOnMouseClicked(mCH);
		view.getCounterButton().setOnMouseClicked(mCH);
		view.getCheckBox().setOnMouseClicked(mCH);
		
		// Listener fuer Strichmaennchen  -> bei Tastendruck
		view.getScene().setOnKeyPressed(kEH);
		
		// Strichmaennchen auf Anfangswerte verschieben
		view.getStrichmaennchenView().setX(600);
		view.getStrichmaennchenView().setY(200);
	}
}

/*
 * Alternativ koennten wir auch die Listener direkt in dieser Klasse erstellen (als anonyme Klasse). Dies wuerde dann so aussehen:
         
         	view.getBeendenButton().setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				System.exit(0);
			}	
		});
		
 
 * Durch die Anwendung von Lambda-Ausdruecken koennen wir dies verkuerzen:

		view.getBeendenButton().setOnMouseClicked(event -> {
				System.exit(0);
		});

 * Java erkennt diesen Ausdruck und verwandelt ihn intern in den oberen.
 * Damit koennen wir uns Tipparbeit ersparen. Ausserdem ist der Code besser lesbar.
 * Allerdings koennen wir Lambda-Ausdruecke nur auf Interfaces anwenden, die nur eine
 * einzige Methode vorschreiben, da in den Lamba-Ausdruecken klar sein muss, welche Methode wir implementieren.
 * 
 * Bei vielen Listenern, ist es ratsam, die Ereignisse in nach Ereignistyp(Event) getrennten Klassen auszuwerten (wie hier).
 */