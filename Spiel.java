import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFrame;


public class Spiel {

	int x;
	int y;
	public static boolean g = false;
	
	public Spiel(int geld, boolean musik) throws IOException{
		Movement m = new Movement();
		System.out.println("Start");
		
		lesen(m);
		
		Fenster f1 = new Fenster(m, geld, musik);
		f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f1.setSize(600, 600);
		f1.setAlwaysOnTop(false);
		f1.setResizable(true);
		f1.setVisible(true);
		f1.timer.scheduleAtFixedRate(f1.task, 1000, 1000);
	}
	
	public void lesen(Movement m) throws IOException{
		
		String temp1;
		@SuppressWarnings("unused")
		String[] c;
		BufferedReader Datei = new BufferedReader(new FileReader(".\\Save2.txt"));
		System.out.println("Nach Datei");
		for(int a = 0; a<20; a++){
			temp1 = Datei.readLine();
			System.out.println(temp1);
			for(int b = 0; b<20; b++){
				String temp2 = temp1.substring(b, b+1);
				if(temp2.equals("S")){
					x = a;
					y = b;
				}
				m.setOrt(temp2, a, b);
				//Hello
			}
		}
		m.setX(x);
		m.setY(y);
		System.out.println("");
		Datei.close();
			


	}
}
