// Raquel Olhovetchi Ferreira da Silva
// Sol Castilho Ara�jo de Moraes S�da
// Victor Nielsen Ribeirete

package View;
import java.util.Observable;

@SuppressWarnings("deprecation")
public class PlayerScreenPanelSignal extends Observable{

	public void send(boolean bool) {
		setChanged();
		notifyObservers(bool);
	}

}