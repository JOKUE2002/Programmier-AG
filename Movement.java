import javax.swing.JOptionPane;

public class Movement {
	
	int y;
	int x;
	int TopPassierbar;
	int LeftPassierbar;
	int RightPassierbar;
	int BotPassierbar;
	String Top, Left, Right, Bot, Richtung;
	String AktuellesGebiet = "S"; 
	String[][] Ort = new String[20][20];
	
	public void setGebiet(int a, int b)
	{
		AktuellesGebiet = getOrt(a, b);
	}
	
	public String getGebiet()
	{
		return AktuellesGebiet;
	}
	
	public void setOrt(String temp2, int a, int b)
	{
		Ort[a][b] = temp2;
		if(temp2.equals("S")){
			x = a;
			y = b;
			System.out.println("START AT "+x+","+y);
		}
			
	}
	
	public void setX(int a){
		x = a;
	}
	public void setY(int a){
		y = a;
	}
	
	public String getOrt(int a, int b)
	{
		return Ort[a][b];
	}
	public int getPositionX()
	{
		return x;
	}
	public String getLeft()
	{
		return Ort[getPositionX()][getPositionY()-1];
	}
	public String getRight()
	{
		return Ort[getPositionX()][getPositionY()+1];
	}
	public String getZiel(int a, int b)
	{
		return Ort[a][b];
	}
	public String getBottom()
	{
		return Ort[getPositionX()][getPositionY()+1];
	}
	public int getPositionY()
	{
		return y;
	}
	String temp = getOrt(getPositionX(),getPositionY());
	
	void gebietBetreten() {
		switch(Richtung) {
		case "Top": geheTop(); break;
		case "Left" : geheLeft(); break;
		case "Right" : geheRight(); break;
		case "Bot" : geheBot(); break;
		}
	}
	
	void geheTop() {
		if (getGebiet().equals("=") || getGebiet().equals("S") || getGebiet().equals("E")) {
			
			switch (getZiel(getPositionY()-1, getPositionX())) {

			case "S": System.out.println("Du befindest dich wieder am Start!"); TopPassierbar = 1; break;
			case "X": JOptionPane.showMessageDialog(null, "Der Weg wird dir von einer Wand versperrt!"); TopPassierbar = 0; break;
			case "T": System.out.println("Du befindest dich in der Stadt!"); TopPassierbar = 1; break;
			case "E": JOptionPane.showMessageDialog(null, "Du hast den Ausgang gefunden!"); TopPassierbar = 1; break;
			case "F": System.out.println("Du befindest dich im Wald!"); TopPassierbar = 1; break;
			case "M": System.out.println("Du befindest dich in den Bergen!"); TopPassierbar = 1; break;
			case "D": System.out.println("Du befindest dich in der Wüste!"); TopPassierbar = 1; break;
			case "C": System.out.println("Du befindest dich in einem Verließ!"); TopPassierbar = 1; break;
			case "=": System.out.println("Du befindest dich auf einem weiterem Weg!"); TopPassierbar = 1; break;
			}
		} else if (getGebiet() != "=") {
			if (getZiel(getPositionY()-1, getPositionX()).equals(getGebiet()) || getZiel(getPositionY()-1, getPositionX()).equals("S") || getZiel(getPositionY()-1, getPositionX()).equals("E")) {
				switch(getZiel(getPositionY()-1, getPositionX())) {
				
				case "S": System.out.println("Du befindest dich immer noch am Start!"); TopPassierbar = 1; break;
				case "T": System.out.println("Du befindest dich immer noch in der Stadt!"); TopPassierbar = 1; break;
				case "F": System.out.println("Du befindest dich immer noch im Wald!"); TopPassierbar = 1; break;
				case "M": System.out.println("Du befindest dich immer noch in den Bergen!"); TopPassierbar = 1; break;
				case "D": System.out.println("Du befindest dich immer noch in der Wüste!"); TopPassierbar = 1; break;
				case "C": System.out.println("Du befindest dich immer noch in einem Verließ!"); TopPassierbar = 1; break;
				case "E": JOptionPane.showMessageDialog(null, "Du hast den Ausgang gefunden!"); TopPassierbar = 1; System.exit(1000);break;
				}
			} else if (getZiel(getPositionY()-1, getPositionX()).equals("=") || getZiel(getPositionY()-1, getPositionX()).equals("S") || getZiel(getPositionY()-1, getPositionX()).equals("E")) {
				System.out.println("Du befindest dich nun wieder auf dem Weg!");
				TopPassierbar = 1;
			} else {
				JOptionPane.showMessageDialog(null,"Du kannst diesen Ort nicht betreten!");
				TopPassierbar = 0;
			}
		}
		
		if(TopPassierbar == 1) {
			y = y - 1;
			AktuellesGebiet = getOrt(getPositionY(), getPositionX());
		}
		System.out.println("TopPassierbar: " + TopPassierbar);
	}
	
	void geheLeft() {
		if (getGebiet().equals("=") || getGebiet().equals("S") || getGebiet().equals("E")) {
			
			switch (getZiel(getPositionY(), getPositionX()-1)) {

			case "S": System.out.println("Du befindest dich wieder am Start!"); LeftPassierbar = 1; break;
			case "X": JOptionPane.showMessageDialog(null, "Der Weg wird dir von einer Wand versperrt!"); LeftPassierbar = 0; break;
			case "T": System.out.println("Du befindest dich in der Stadt!"); LeftPassierbar = 1; break;
			case "E": JOptionPane.showMessageDialog(null, "Du hast den Ausgang gefunden!"); LeftPassierbar = 1; break;
			case "F": System.out.println("Du befindest dich im Wald!"); LeftPassierbar = 1; break;
			case "M": System.out.println("Du befindest dich in den Bergen!"); LeftPassierbar = 1; break;
			case "D": System.out.println("Du befindest dich in der Wüste!"); LeftPassierbar = 1; break;
			case "C": System.out.println("Du befindest dich in einem Verließ!"); LeftPassierbar = 1; break;
			case "=": System.out.println("Du befindest dich auf einem weiterem Weg!"); LeftPassierbar = 1; break;
			}
		} else if (getGebiet() != "=") {
			if (getZiel(getPositionY(), getPositionX()-1).equals(getGebiet()) || getZiel(getPositionY(), getPositionX()-1).equals("S") || getZiel(getPositionY(), getPositionX()-1).equals("E")) {
				switch(getZiel(getPositionY(), getPositionX()-1)) {
				
				case "S": System.out.println("Du befindest dich immer noch am Start!"); LeftPassierbar = 1; break;
				case "T": System.out.println("Du befindest dich immer noch in der Stadt!"); LeftPassierbar = 1; break;
				case "F": System.out.println("Du befindest dich immer noch im Wald!"); LeftPassierbar = 1; break;
				case "M": System.out.println("Du befindest dich immer noch in den Bergen!"); LeftPassierbar = 1; break;
				case "D": System.out.println("Du befindest dich immer noch in der Wüste!"); LeftPassierbar = 1; break;
				case "C": System.out.println("Du befindest dich immer noch in einem Verließ!"); LeftPassierbar = 1; break;
				case "E": JOptionPane.showMessageDialog(null, "Du hast den Ausgang gefunden!"); TopPassierbar = 1; System.exit(1000);break;
				}
			} else if (getZiel(getPositionY(), getPositionX()-1).equals("=") || getZiel(getPositionY(), getPositionX()-1).equals("S") || getZiel(getPositionY(), getPositionX()-1).equals("E")) {
				System.out.println("Du befindest dich nun wieder auf dem Weg!");
				LeftPassierbar = 1;
			} else {
				JOptionPane.showMessageDialog(null,"Du kannst diesen Ort nicht betreten!");
				LeftPassierbar = 0;
			}
		}
		
		if(LeftPassierbar == 1) {
			x = x - 1;
			AktuellesGebiet = getOrt(getPositionY(), getPositionX());
		}
		System.out.println("LeftPassierbar: " + LeftPassierbar);
	}
	
	void geheRight() {
		if (getGebiet().equals("=") || getGebiet().equals("S") || getGebiet().equals("E")) {
			
			switch (getZiel(getPositionY(), getPositionX()+1)) {

			case "S": System.out.println("Du befindest dich wieder am Start!"); RightPassierbar = 1; break;
			case "X": JOptionPane.showMessageDialog(null, "Der Weg wird dir von einer Wand versperrt!"); RightPassierbar = 0; break;
			case "T": System.out.println("Du befindest dich in der Stadt!"); RightPassierbar = 1; break;
			case "E": JOptionPane.showMessageDialog(null, "Du hast den Ausgang gefunden!"); RightPassierbar = 1; break;
			case "F": System.out.println("Du befindest dich im Wald!"); RightPassierbar = 1; break;
			case "M": System.out.println("Du befindest dich in den Bergen!"); RightPassierbar = 1; break;
			case "D": System.out.println("Du befindest dich in der Wüste!"); RightPassierbar = 1; break;
			case "C": System.out.println("Du befindest dich in einem Verließ!"); RightPassierbar = 1; break;
			case "=": System.out.println("Du befindest dich auf einem weiterem Weg!"); RightPassierbar = 1; break;
			}
		} else if (getGebiet() != "=") {
			if (getZiel(getPositionY(), getPositionX()+1).equals(getGebiet()) || getZiel(getPositionY(), getPositionX()+1).equals("S") || getZiel(getPositionY(), getPositionX()+1).equals("E")) {
				switch(getZiel(getPositionY(), getPositionX()+1)) {
				
				case "S": System.out.println("Du befindest dich immer noch am Start!"); RightPassierbar = 1; break;
				case "T": System.out.println("Du befindest dich immer noch in der Stadt!"); RightPassierbar = 1; break;
				case "F": System.out.println("Du befindest dich immer noch im Wald!"); RightPassierbar = 1; break;
				case "M": System.out.println("Du befindest dich immer noch in den Bergen!"); RightPassierbar = 1; break;
				case "D": System.out.println("Du befindest dich immer noch in der Wüste!"); RightPassierbar = 1; break;
				case "C": System.out.println("Du befindest dich immer noch in einem Verließ!"); RightPassierbar = 1; break;
				case "E": JOptionPane.showMessageDialog(null, "Du hast den Ausgang gefunden!"); TopPassierbar = 1; System.exit(1000);break;
				}
			} else if (getZiel(getPositionY(), getPositionX()+1).equals("=") || getZiel(getPositionY()-1, getPositionX()).equals("S") || getZiel(getPositionY()-1, getPositionX()).equals("E")) {
				System.out.println("Du befindest dich nun wieder auf dem Weg!");
				RightPassierbar = 1;
			} else {
				JOptionPane.showMessageDialog(null,"Du kannst diesen Ort nicht betreten!");
				RightPassierbar = 0;
			}
		}
		
		if(RightPassierbar == 1) {
			x = x + 1;
			AktuellesGebiet = getOrt(getPositionY(), getPositionX());
		}
		System.out.println("RightPassierbar: " + RightPassierbar);
	}
	
	void geheBot() {
		if (getGebiet().equals("=") || getGebiet().equals("S") || getGebiet().equals("E")) {
			
			switch (getZiel(getPositionY()+1, getPositionX())) {

			case "S": System.out.println("Du befindest dich wieder am Start!"); BotPassierbar = 1; break;
			case "X": JOptionPane.showMessageDialog(null, "Der Weg wird dir von einer Wand versperrt!"); BotPassierbar = 0; break;
			case "T": System.out.println("Du befindest dich in der Stadt!"); BotPassierbar = 1; break;
			case "E": JOptionPane.showMessageDialog(null, "Du hast den Ausgang gefunden!"); BotPassierbar = 1; break;
			case "F": System.out.println("Du befindest dich im Wald!"); BotPassierbar = 1; break;
			case "M": System.out.println("Du befindest dich in den Bergen!"); BotPassierbar = 1; break;
			case "D": System.out.println("Du befindest dich in der Wüste!"); BotPassierbar = 1; break;
			case "C": System.out.println("Du befindest dich in einem Verließ!"); BotPassierbar = 1; break;
			case "=": System.out.println("Du befindest dich auf einem weiterem Weg!"); BotPassierbar = 1; break;
			}
		} else if (getGebiet() != "=") {
			if (getZiel(getPositionY()+1, getPositionX()).equals(getGebiet()) || getZiel(getPositionY()+1, getPositionX()).equals("S") || getZiel(getPositionY()+1, getPositionX()).equals("E")) {
				switch(getZiel(getPositionY()+1, getPositionX())) {
				
				case "S": System.out.println("Du befindest dich immer noch am Start!"); BotPassierbar = 1; break;
				case "T": System.out.println("Du befindest dich immer noch in der Stadt!"); BotPassierbar = 1; break;
				case "F": System.out.println("Du befindest dich immer noch im Wald!"); BotPassierbar = 1; break;
				case "M": System.out.println("Du befindest dich immer noch in den Bergen!"); BotPassierbar = 1; break;
				case "D": System.out.println("Du befindest dich immer noch in der Wüste!"); BotPassierbar = 1; break;
				case "C": System.out.println("Du befindest dich immer noch in einem Verließ!"); BotPassierbar = 1; break;
				case "E": JOptionPane.showMessageDialog(null, "Du hast den Ausgang gefunden!"); TopPassierbar = 1; System.exit(1000);break;
				}
			} else if (getZiel(getPositionY()+1, getPositionX()).equals("=") || getZiel(getPositionY()-1, getPositionX()).equals("S") || getZiel(getPositionY()-1, getPositionX()).equals("E")) {
				System.out.println("Du befindest dich nun wieder auf dem Weg!");
				BotPassierbar = 1;
			} else {
				JOptionPane.showMessageDialog(null,"Du kannst diesen Ort nicht betreten!");
				BotPassierbar = 0;
			}
		}
		
		if(BotPassierbar == 1) {
			y = y + 1;
			AktuellesGebiet = getOrt(getPositionY(), getPositionX());
		}
		System.out.println("BotPassierbar: " + BotPassierbar);
	}
}



