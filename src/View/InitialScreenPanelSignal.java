package View;
import java.util.Observable;

@SuppressWarnings("deprecation")
public class InitialScreenPanelSignal extends Observable{

	public void send(boolean gameReady) {
		setChanged();
		notifyObservers(gameReady);
	}

}