import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.util.Timer;
import java.util.TimerTask;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.SourceDataLine;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;



@SuppressWarnings("serial")
public class Fenster extends JFrame implements ActionListener, KeyListener{
	//BITTE ZEILE 177 ÜBERARBEITEN... FEHLER: Exception in thread "AWT-EventQueue-0" java.lang.NullPointerException at Fenster.actionPerformed(Fenster.java:177)
	public JPanel PanelShop, KnöpfeAngebote, KnöpfeSteuer;
	public JButton kaufen;
	public JButton zurück;
	public JButton[] angebote;
	public static final int Angebote = 3;
	public static final String[] preise = {"5", "15", "20"};
	public static final String[] text = {".\\wood_sword.png", ".\\iron_sword.png", ".\\diamond_sword.png"};
	public static final boolean[] schwerter = {false,false,false};
	static int CASH = 0;
	boolean shop = false;
	boolean musik = true;
	JPanel P;
	JButton kMusik;
	static JButton[] B = new JButton[9];
	static JTextArea A;
	static Movement m;
	JButton ShopKnopf;
	static Color color = Color.DARK_GRAY;
	 Clip clip;
	JButton ChooseMusik;
//	JPanel S = new Shop();
	
	static int sec = 0;
	public Timer timer = new Timer();
	public TimerTask task = new TimerTask(){

		@Override
		public void run() {
			sec++;
			System.out.println(sec);
			Text();
		}};
	
	public Fenster(Movement m1, int geld, boolean music) {
		super("World Adventure");
		addKeyListener(this);
		musik = music;
		JPanel subPanel = new JPanel();
		P = new JPanel();
		A = new JTextArea();
		ShopKnopf = new JButton();
		ShopKnopf.addActionListener(this);
		setFocusable(true);
		CASH = geld;
		m = m1;
		ChooseMusik = new JButton("Musik wählen");
		ChooseMusik.addActionListener(this);
		P.add(ChooseMusik, BorderLayout.PAGE_END);
		for(int i = 0; i < B.length; i++){
			B[i] = new JButton();
			subPanel.add(B[i]);
			B[i].setFont(new Font("ARIAL", Font.BOLD, 64));
			B[i].setForeground(Color.ORANGE);
			B[i].addActionListener(this);
		}
		
		kMusik = new JButton();
		if(music){
			play(null, ".\\musik");
			kMusik.setText(" MUSIK ON ");
			kMusik.setForeground(Color.GREEN);
		}else{
			kMusik.setText(" MUSIK OFF "); 
			kMusik.setForeground(Color.RED);
		}
		kMusik.setBackground(Color.BLUE);
		kMusik.addActionListener(this);
		kMusik.setFont(new Font("ARIAL", Font.BOLD, 32));
		kMusik.setSize(600, 100);
		
		
		P.setLayout(new BorderLayout());
		P.add(kMusik, BorderLayout.PAGE_END);
		subPanel.setLayout(new GridLayout(3, 3));
		P.add(subPanel, BorderLayout.CENTER);
		
		P.add(ShopKnopf, BorderLayout.PAGE_START);
		ShopKnopf.setSize(600, 50);
		P.add(A, BorderLayout.LINE_END);
		
		A.setFont(new Font("ARIAL", Font.BOLD, 32));
		A.setBackground(Color.BLUE);
		A.setForeground(Color.ORANGE);
		A.setEditable(false);
		A.setFocusable(false);
		
		B[1].setBackground(Color.BLUE);
		B[3].setBackground(Color.BLUE);
		B[5].setBackground(Color.BLUE);
		B[7].setBackground(Color.BLUE);
		
		B[1].setText("N");
		B[5].setText("O");
		B[3].setText("W");
		B[7].setText("S");
		
		
		ShopKnopf.setIcon(new ImageIcon(".\\Coin.png"));		
		Text();
		
		setContentPane(P);
		setResizable(true);
		//Musik();
	}
	
	

	public static void Text(){
		String Temp = "";
		switch(m.getZiel(m.getPositionY(), m.getPositionX())){
		case "S": Temp = "Start"; color = Color.DARK_GRAY; break;
		case "E": Temp = "Ausgang";break;
		case "T": Temp = "Stadt"; color = Color.ORANGE;break;
		case "X": Temp = "Mauer"; break;
		case "F": Temp = "Wald"; color = Color.GREEN;break;
		case "=": Temp = "Weg"; color = Color.LIGHT_GRAY;break;
		case "C": Temp = "Höhle"; color = Color.BLACK;break;
		case "D": Temp = "Wüste"; color = Color.YELLOW;break;
		case "M": Temp = "Berg"; color = Color.WHITE;break;
		}
		// 0,2,4,6,8
		B[0].setBackground(color);
		B[2].setBackground(color);
		B[4].setBackground(color);
		B[6].setBackground(color);
		B[8].setBackground(color);
		A.setText(Temp + "\n" + m.getGebiet() + "\nX: " + m.getPositionX() + "\nY: " + m.getPositionY()  + "\nZeit: " + sec + "\n"+ CASH + " G");
	}
	
	public JPanel Shop() {
		PanelShop = new JPanel();
		KnöpfeAngebote = new JPanel();
		KnöpfeSteuer = new JPanel();
		kaufen = new JButton("Kaufen");
		zurück = new JButton("Zurück zum Spiel");
		angebote = new JButton[Angebote];
		for(int i = 0; i< angebote.length; i++){
			angebote[i] = new JButton();
			angebote[i].setIcon(new ImageIcon(text[i]));
			KnöpfeAngebote.add(angebote[i]);
			angebote[i].addActionListener(this);
		}
		kaufen.addActionListener(this);
		zurück.addActionListener(this);
		KnöpfeSteuer.add(kaufen);
		KnöpfeSteuer.add(zurück);
		PanelShop.add(KnöpfeAngebote);
		PanelShop.add(KnöpfeSteuer);
		return(PanelShop);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(!shop){
			if(e.getSource() == kMusik){
				musik = !musik;
				if(musik){
					play(null, ".\\musik");
					kMusik.setText(" MUSIK ON ");
					kMusik.setForeground(Color.GREEN);
				}else{
					stop(null, ".\\musik");
					kMusik.setText(" MUSIK OFF ");
					kMusik.setForeground(Color.RED);
				}
				requestFocus();
			}
			if(e.getSource() == B[1]){
				m.geheTop();
				geld();
				Text();
				requestFocus();
			}
			if(e.getSource() == ShopKnopf){
				setPanel(Shop());
				shop = true;
				validate();
				requestFocus();
			}
			if(e.getSource() == B[3]){
				m.geheLeft();
				geld();
				Text();
				requestFocus();
			}
			if(e.getSource() == B[7]){
				m.geheBot();
				geld();
				Text();
				requestFocus();
			}
			if(e.getSource() == B[5]){
				m.geheRight();
				geld();
				Text();
				requestFocus();
			}
		}else{
			if(e.getSource() == zurück){
				setPanel(P);
				shop = false;
				validate();
				requestFocus();
			}
			if(e.getSource() == angebote[0]){
				schwerter[0] = true;
				angebote[0].setBackground(Color.YELLOW);
				requestFocus();
			}
			if(e.getSource() == angebote[1]){
				schwerter[1] = true;
				angebote[1].setBackground(Color.YELLOW);
				requestFocus();
			}
			if(e.getSource() == angebote[2]){
				schwerter[2] = true;
				angebote[2].setBackground(Color.YELLOW);
				requestFocus();
			}
			if(e.getSource() == kaufen){
				int kaufPreis = 0;
				for(int i = 0; i<=2; i++){
					if(schwerter[i] = true){
						kaufPreis += Integer.parseInt(preise[i]);
					}
					requestFocus();
				}
				//ende For
				if(CASH >= kaufPreis){
					int confirm = JOptionPane.showConfirmDialog(null,"WILLST DU DIESE ARTIKEL WIRKLICH KAUFEN?", "KAUFBESTÄTIGUNG", JOptionPane.YES_NO_OPTION);
					if(confirm == JOptionPane.YES_OPTION){
						JOptionPane.showMessageDialog(null, "Ihr Kauf war erfolgreich!");
						CASH-=kaufPreis;
					}else{
						JOptionPane.showMessageDialog(null, "Ihr Kauf wurde abgebrochen!");
					}
				}else{
					int zuwenig = kaufPreis - CASH;
					JOptionPane.showMessageDialog(null, "Du brauchst ersteinmal Geld, bevor du dir diese Artikel kaufen kannst!\nDu hast "+zuwenig+" zuwenig!");
				}
				requestFocus();
			}
		}
		
	}
	
	public void geld() {
		if(m.getPositionX() == 4 && m.getPositionY() == 17){
			System.out.println("Kein Geld wegen Ausgang...");
		}else{
			int rnd = (int)(Math.random()*5)+1;
			if(rnd == 5){
				CASH++; 
				System.out.println("DU HAST GELD GEFUNDEN"); 
				JOptionPane.showMessageDialog(null, "DU HAST GELD GEKRIEGT!");
			}
		}
	}

	
	
	public void setPanel(JPanel p) {
		this.setContentPane(p);
	}

	@Override
	public void keyReleased(KeyEvent e) {
	if(e.getKeyCode() == KeyEvent.VK_UP){
		m.geheTop();
		geld();
		Text();
	}
	if(e.getKeyCode() == KeyEvent.VK_LEFT){
		m.geheLeft();
		geld();
		Text();	
	}
	if(e.getKeyCode() == KeyEvent.VK_RIGHT){
		m.geheRight();
		geld();
		Text();
	}
	if(e.getKeyCode() == KeyEvent.VK_DOWN){
		m.geheBot();
		geld();
		Text();
	}	
}

	@Override
	public void keyPressed(KeyEvent e) {}

	@Override
	public void keyTyped(KeyEvent e) {}
	
	
	private void play(Object codeBase, String fileName) {
        try {
            clip = AudioSystem.getClip();  //<---
            File file = new File(fileName + ".wav");
            AudioInputStream ais = AudioSystem.getAudioInputStream(file);
            clip.open(ais);
            clip.start();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void stop(Object codeBase, String fileName) {
        try {
            if (clip != null) {
                clip.stop();
                clip.close();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
