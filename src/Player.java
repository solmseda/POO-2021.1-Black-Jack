import java.util.ArrayList;
import java.util.List;
public class Player {
	public List<Card>hand = new ArrayList<Card>();
	
	
	public Integer HandValue() {
		int sum=0;
		for (int i=0;i<this.hand.size();i++) {
			sum+=this.hand.get(i).valor;
			}
		return sum;
	}
	
	public Boolean Busted() {
		int hand= HandValue();
		
		if (hand>21) {
			return true;
		}
		return false;
	}
}
