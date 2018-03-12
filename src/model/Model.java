package model;

/**
 * 
 * @author Model-Klasse.
 *         Hier werden die Daten des Programms gespeichert
 *
 */
public class Model {
	// Counter: speichere, wie oft der Button gedrueckt wurde
	private int counter;
	/*
	 * Offsets fuer die strichmaenchenView:
	 *   speichern wie weit die ImageView, die das Strichmuennchen zeigt,
	 *   von den urspruenglichen x- und y-Werten verschoben ist.
	 */
	private int strichmaennchenXOffset;
	private int strichmaennchenYOffset;
	/*
	 *  Speichere, ob die CheckBox angeklickt (checked) ist oder nicht.
	 */
	private boolean checked;
	
	/**
	 * Konstruktor: initialisiere Variablen
	 */
	public Model() {
		counter = 0;
		strichmaennchenXOffset = 0;
		strichmaennchenYOffset = 0;
		checked = false;
	}
	
	/*
	 * Getter und Setter: Erlauben uns den Zugriff auf die privaten Variablen
	 * von ausserhalb dieser Klasse
	 */
	public void setStrichmaennchenXOffset(int strichmaennchenX) {
		this.strichmaennchenXOffset = strichmaennchenX;
	}

	public void setStrichmaennchenYOffset(int strichmaennchenY) {
		this.strichmaennchenYOffset = strichmaennchenY;
	}

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

	public int getStrichmaennchenXOffset() {
		return strichmaennchenXOffset;
	}

	public int getStrichmaennchenYOffset() {
		return strichmaennchenYOffset;
	}

	public int getCounter() {
		return counter;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}
}
