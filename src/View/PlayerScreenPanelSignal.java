package View;
import java.util.Observable;

@SuppressWarnings("deprecation")
public class PlayerScreenPanelSignal extends Observable{

	public void send(boolean bool) {
		setChanged();
		notifyObservers(bool);
	}

}