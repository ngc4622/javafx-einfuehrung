package view;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

/**
 * 
 * @author Tobias Tefke
 * 
 * Die View-Klasse. Hier definieren wir das Aussehen des Programms.
 *
 */

public class View {
	/*
	 * Unsere Scene: Sie stellt den Container fuer alle sichtbaren Objekte dar.
	 */
	private Scene scene;
	// Ein Button: auf einen Klick auf diesen soll das Programm beendet werden
	private Button beendenButton;
	// noch ein Button: bei Klick Text aus dem Textfeld in das Label uebertragen
	private Button uebertragenButton;
	// Counter-Button
	private Button counterButton;
	// Ein Textfeld zur Eingabe von Text
	private TextField textEingabe;
	// Checkbox: kann abgehakt werden
	private CheckBox checkBox;
	// Label: Text anzeigen
	private Label einLabel;
	// Label: Anzeigen, ob Checkbox abgehakt wurde oder nicht
	private Label checkBoxLabel;
	// ImageView: Bild anzeigen
	private ImageView strichmaennchenView;
	// StackPane: Elemente �bereinander anzeigen
	private StackPane stack;

	/**
	 * Erstelle unsere Objekte und fuege diese zum fertigen Aussehen zusammen
	 */
	public View() {
		/*
		 * Uebergebe ueber den Konstruktor des Buttons den Text,
		 * der in ihm angezeigt werden soll.
		 */
		beendenButton = new Button("Beenden");
		/*
		 * Button zur Uebertragung des Inhalts des Textfelds
		 * auf das Label
		 */
		uebertragenButton = new Button("Uebertragen");
		/*
		 * Counter-Button: bei Klick Counter-Variable erhoehen
		 */
		counterButton = new Button("Counter");
		/*
		 * Textfeld
		 * 
		 * PromptText: Ein Text, der dem Benutzer als Eingabehilfe angezeigt wird
		 */
		textEingabe = new TextField();
		textEingabe.setPromptText("Hier einen Text eingeben");
		/*
		 * CheckBox: Beschriftung kann im Konstruktor uebergeben werden
		 */
		checkBox = new CheckBox("angeklickt?");
		/*
		 * Label: Der Text, der angezeigt werden soll, kann im Konstruktor verwendet werden
		 */
		einLabel = new Label("Gib einen Text ein !");
		/*
		 * Label fuer die CheckBox
		 */
		checkBoxLabel = new Label("Klick die Checkbox");
		/*
		 *  Wir benutzen im Hintergrund des Programmes eine Tabelle.
		 * In dieser koennen wir die Schaltflaechen anordnen.
		 */
		GridPane layout = new GridPane();
		/*
		 * Hgap/Vgap: zwischen den einzelnen Spalten/Zeilen 10 jeweils Pixel Abstand
		 *            halten, damit die Elemente nicht zu gequetscht wirken.
		 */
		layout.setHgap(10);
		layout.setVgap(10);
		/*
		 * Padding: Tabelle 10 Pixel entfernt vom Rand anzeigen: keine Quetschung der
		 *          Elemente an den Rand
		 */
		layout.setPadding(new Insets (10, 10, 10, 10));
		/*
		 *  Der Button wird oben links eingefuegt.
		 * Im Methodenaufruft uebergeben wir zunaechst das Objekt,
		 * welches eingefuegt werden soll.
		 * 
		 * Danach folgen Spalte und Zeile.
		 * Spalten- und Zeilenzahl nehmen nach rechts unten zu.
		 */
		layout.add(beendenButton, 0, 0);
		/*
		 * Das Textfeld fuegen wir rechts neben dem beendenButton ein.
		 * Es ist allerdings drei Spalten breit
		 */
		layout.add(textEingabe,/* Spalte*/ 1, /*Zeile*/ 0,
				/* Anzahl der Spalten, die insgesamt belegt werden sollen (sinnvollerweise >= 1)*/ 3,
				/* Anzahl der Zeilen, die insgesamt belegt werden sollen (sinnvollerweise >= 1)*/1);
		// Der Uebertragen-Button ist unter dem beendenButton
		layout.add(uebertragenButton, 0, 1);
		// Das Label ist unter dem Textfeld
		layout.add(einLabel, 1, 1, 3, 1);
		// Counter ganz unten
		layout.add(counterButton, 0, 2);
		// CheckBox nebenan
		layout.add(checkBox, 1, 2);
		// Label rechts neben der CheckBox
		layout.add(checkBoxLabel, 2, 2);
		//versuche Strichmaennchen in ImageView anzeigen
		try {
			strichmaennchenView = new ImageView(new Image(new FileInputStream("res/bilder/strichmaennchen.png")));
		} catch (FileNotFoundException e) {
			/*
			 *  Falls die Datei nicht gefunden werden konnte,
			 *  gib die Fehlermeldung in der Konsole aus und
			 *  beende das Programm
			 */
			e.printStackTrace();
			System.exit(-1);
		}
		// Stichmaennchen verschieben
		// Bild nur auf 50% der Groesse anzeigen
		strichmaennchenView.setScaleX(0.5);
		strichmaennchenView.setScaleY(0.5);
		strichmaennchenView.setScaleZ(0.5);
		/*
		 * StackPane: erlaub uns, mehrere Panes (Ebenen)
		 * uebereinander zu stapeln
		 */
		stack = new StackPane();
		/*
		 * Um die Panes stapeln zu koennen, muessen
		 * wir auf die Liste, die die Ebenen beinhaltet
		 * zugreifen.
		 * 
		 * Wir speichern dies als Liste. In diesem Fall handelt es sich
		 * um den Typ ObservableList, eine spezielle Liste, die
		 * von JavaFX bereitgestellt wird.
		 * 
		 * In den spitzen Klammern geben wir an, welche Objekte in der
		 * Liste gespeichert werden koennen.
		 * 
		 * In diesem Fall speichern wir in der Liste Objekte der Klasse Node
		 * (und damit auch Objekte die von dieser Klasse erben).
		 * 
		 * Da Node die Elternklasse fast aller sichtbaren Elemente ist, koennen wir
		 * in diese Liste auch einzelze Elemente wie Buttons (oder hier ImageViews) speichern,
		 */
		ObservableList<Node> list = stack.getChildren();
		/*
		 * Hier fuegen wir alle Panes (oder sonstigen Elemente) der Liste hinzu.
		 * Da die Liste bereits mit der StackPane gekoppelt ist, werden in der Scene
		 * alle Elemente angezeigt, die sich in der Liste befinden.
		 * 
		 * layout beinhaltet weitere sichtbare Elemente.
		 * Diese sind jedoch bereits in layout angeordnet,
		 * so dass es reicht, nur layout einzubinden
		 */
		list.addAll(layout /* unterstes Element */, strichmaennchenView
				/* Element auf dem untersten Element usw. */);
		/*
		 *  Erstelle das Scene-Objekt.
		 * Das Layout uebergenen wir im Konstruktor.
		 */
		scene = new Scene(stack);
	}

	/*
	 * Getter: Erlauben es uns, von aussen (andere Klassen) auf die privaten Objekte zuzugreifen
	 */
	
	public StackPane getStack() {
		return stack;
	}

	public ImageView getStrichmaennchenView() {
		return strichmaennchenView;
	}

	public CheckBox getCheckBox() {
		return checkBox;
	}

	public Label getCheckBoxLabel() {
		return checkBoxLabel;
	}

	public Button getUebertragenButton() {
		return uebertragenButton;
	}

	public TextField getTextEingabe() {
		return textEingabe;
	}

	public Label getEinLabel() {
		return einLabel;
	}

	public Scene getScene() {
		return scene;
	}

	public Button getBeendenButton() {
		return beendenButton;
	}

	public Button getCounterButton() {
		return counterButton;
	}
}
