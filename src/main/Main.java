package main;

import controller.Controller;
import javafx.application.Application;
import javafx.stage.Stage;
import model.Model;
import view.View;

/**
 * 
 * @author Tobias Tefke
 * 
 * 
 * Die Klasse Main erbt von der JavaFX-Klasse Application.
 * Damit stehen uns alle Funktionen, um eine grafische Benutzeroberflaeche
 * zu erstellen, zur Verfuegung.
 * 
 * Im Umkerschluss muessen wir die Methode start(Stage stage) implementieren,
 * da in dieser angegeben wird, was zum Start des Programmes erfolgt.
 * 
 * Eine main(String[] args)-Methode ist fuer JavaFX-Programme nicht mehr erforderlich.
 * Sie wird durch die Methode start(Stage stage) ersetzt.
 * Da es jedoch bei der Benutzung von aelteren Java-Versionen dazu kommen kann,
 * dass start(Stage stage) nicht richtig erkannt wird, wird in der Regel trotzdem
 * die main()-Methode beibehalten, um dann ueber diese das Programm starten zu koennen.
 * 
 * 
 * Alternativ koennten wir dies auch als View-Klasse nutzen, da wir in der Methode start()
 * direkt das Aussehen des Programms festlegen koennen.
 * 
 * Bei getrennten Klassen (wir hier) haben wir allerdings den Vorteil,
 * dass dann die main()-Methode in eine separate Klasse ausgelagert ist und damit in der
 * View-Klasse nicht als stoerend empfunden werden kann.
 * Ausserdem koennten wir duch diese Klasse zwischen mehreren Programmansichten
 * wechseln, ohne das Fenster neu erstellen zu muessen. 
 */
public class Main extends Application {
	/* Unsere View-Klasse. Dort definieren wir das Aussehen des Programms */
	private View view;
	
	/**
	 * Konstruktor: Erstellt die Objekte, die fuer den Programmstart erforderlich sind
	 */
	public Main() {
		// Erstelle unser View-Objekt
		view = new View();
		// Erstelle das Model
		Model model = new Model();
		// Erstelle den Controller
		new Controller(model, view);
	}
	
	/** main()-Methode als Rueckfall-Option fuer aeltere Java-Versionen
	 * 
	 * @param args ueber das args[]-Feld koennen Kommandozeilenparameter uebergeben werden.
	 *             Da Programme mit grafischen Benutzeroberflaechen in der Regel ueber keine
	 *             Kommandozeilenparameter verfuegen, verwerfen wir das Feld.
	 */
	public static void main(String[] args) {
		/* ueber den Aufruf der Methode launch() wird das Programm gestartet,
		 * falls die start()-Methode nicht erkannt wird.
		 * 
		 * Die launch()-Methode stammt aus der Klasse Application (aus der wir erben).
		 * Sie ruft interne Methoden der Application-Klasse auf (u. a. auch unsere
		 * ueberschriebene start()-Methode).
		 */
		launch(args);
	}
	
	/**
	 * start()-Methode: initialisiert das Programm und startet es.
	 * @param primaryStage: Es muss ein Stage-Objekt uebergeben werden.
	 *                      Dieses dient als Container fuer die Benutzeroberflaeche
	 * 
	 */
	@Override
	public void start(Stage primaryStage) throws Exception {	
	    /*
	     * Definiere ein Stage()-Objekt. Dieses benoetigen wir als Zwischenspeicher,
	     * um die Stage, die vom Programm selbststaendig erstellt wurde,
	     * speichern zu koennen.
	     * 
	     *  Dann koennen wir anschliessend die Scene der automatisch erstellten Stage durch die
	     *  unserer View-Klasse ersetzen, um somit unsere Benutzeroberflaeche sichtbar zu machen.
	  	 */
		Stage stage = primaryStage;
		// Ersetze die Scene durch die der View-Klasse();
		stage.setScene(view.getScene());
		// Setzen des Fenstertitels
		stage.setTitle("Einfuehrung in JavaFX");
		// Groesse des Fensters festlegen (nur fuer Programmstart, kann vom Nutzer geaendert werden)
		stage.setHeight(600);
		stage.setWidth(1000);
		// Programm anzeigen
		stage.show();
	}
}
