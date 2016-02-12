
public class Shop {
	int Preis_R_1 = 5;
	int Preis_R_2 = 15;
	int Preis_R_3 = 30;
	
	int Preis_B_1 = 10;
	int Preis_B_2 = 25;
	
	int Preis_S_1 = 2;
	int Preis_S_2 = 7;
	int Preis_S_3 = 17;
	
	public int getPreis(String Name, int lvl){
		int temp = 0;
		if(Name == "B" && lvl == 1){
			temp = Preis_B_1;
		}
		if(Name == "B" && lvl == 2){
			temp = Preis_B_2;
		}
		if(Name == "R" && lvl == 1){
			temp = Preis_R_1;
		}
		if(Name == "R" && lvl == 2){
			temp = Preis_R_2;
		}
		if(Name == "R" && lvl == 3){
			temp = Preis_R_3;
		}
		if(Name == "S" && lvl == 1){
			temp = Preis_S_1;
		}
		if(Name == "S" && lvl == 2){
			temp = Preis_S_2;
		}
		if(Name == "S" && lvl == 3){
			temp = Preis_S_3;
		}

		return temp;
	}
}
