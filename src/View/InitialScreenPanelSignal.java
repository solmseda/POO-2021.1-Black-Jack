// Raquel Olhovetchi Ferreira da Silva
// Sol Castilho Ara�jo de Moraes S�da
// Victor Nielsen Ribeirete

package View;
import java.util.Observable;

@SuppressWarnings("deprecation")
public class InitialScreenPanelSignal extends Observable{

	public void send(boolean gameReady) {
		setChanged();
		notifyObservers(gameReady);
	}

}