package View;
import java.util.Observable;

@SuppressWarnings("deprecation")
public class GameScreenPanelSignal extends Observable{

	public void send(boolean bool) {
		setChanged();
		notifyObservers(bool);
	}

}