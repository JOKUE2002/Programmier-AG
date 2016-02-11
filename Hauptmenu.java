import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.*;


@SuppressWarnings("serial")
public class Hauptmenu extends JFrame implements ActionListener{

	static Movement m;
	public JPanel p;
	public JButton start;
	public JButton credi;
	public JButton ende;
	public JButton laden;
	public JButton musik;
	boolean music = true;
	public String[] Codes ={"21543","15946","44568","15357","54545"};
	
	public Hauptmenu(Movement m1) {
		super(" Menu ");
		m = m1;
		p = new JPanel();
		start = new JButton("Spiel Starten");
		laden = new JButton("Spiel Laden");
		credi = new JButton("Credits");
		musik = new JButton("Einstellungen");
		ende  = new JButton("Spiel Beenden");
		start.setBounds(120, 40,  160, 40);
		laden.setBounds(120, 120, 160, 40);
		credi.setBounds(120, 200, 160, 40);
		musik.setBounds(120, 280, 160, 40);
		ende .setBounds(120, 360, 160, 40);
		start.addActionListener(this);
		credi.addActionListener(this);
		ende .addActionListener(this);
		laden.addActionListener(this);
		musik.addActionListener(this);
		p.setLayout(null);
		p.add(start);
		p.add(laden);
		p.add(credi);
		p.add(musik);
		p.add(ende);
		setContentPane(p);
	}
	
	public static void main(String[] args) throws IOException {
		Hauptmenu f = new Hauptmenu(m);
		f.setSize(400, 480);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		//fERTIG
	}
	//test
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == start){
			try {
                Spiel spiel = new Spiel(0, music);
				this.setVisible(false);
			} catch (IOException e1) {
                        JOptionPane.showMessageDialog(null, "ERROR while Loading... \nPlease Try again later, or send an email to\ninfo.javaprograms@gmail.com");}
		}
		if(e.getSource() == laden){
			int code = Integer.parseInt(JOptionPane.showInputDialog("Geben Sie einen Level - Code ein", "CODE EINGABE"));
			if(code == 9258369){
				try {
					new Spiel(100, music);
				} catch (IOException e1) {}
			}else{
				if(laden(code)){
					try {
						Spiel s = new Spiel(0, music);
						this.setVisible(false);
					} catch (IOException e1){}
				}else{
					JOptionPane.showMessageDialog(null, "Falscher Code! VERARSCH MICH NICHT!!!");
				}
			}
		}
		if(e.getSource() == credi){
			JOptionPane.showMessageDialog(null,"TextAdventure\nEin Spiel der ProgrammierAG des Alstergymnasiums H.-U.\nMusik ausgewählt von Jan Stegemann\nMatrizen von David Kowalk\nMaps von Tim Wolf und Jonas Matenia\nProgrammierung von Jonas Kühn\nLayout von Kevin Altenburg\nIdee von Hr. & Fr. Stichel", "CREDITS",JOptionPane.INFORMATION_MESSAGE);
		}
		if(e.getSource() == musik){
			int goon = JOptionPane.showConfirmDialog(null, "Wollen Sie Musik?", "Einstellungen", JOptionPane.YES_NO_OPTION);
			if(goon == JOptionPane.YES_OPTION){
				music = true;
			}
			if(goon == JOptionPane.NO_OPTION){
				music = false;
			}
		}
		if(e.getSource() == ende){
			int a = JOptionPane.showConfirmDialog(null, "Wollen sie das Spiel wirklich beenden?", "BEENDEN", JOptionPane.YES_NO_OPTION);
			if(a == JOptionPane.YES_OPTION){
				JOptionPane.showMessageDialog(null, "Schade... \nBis zum naechsten mal!\nTSCHUESS!!");
				System.exit(0);
			}
			if(a == JOptionPane.NO_OPTION){
				JOptionPane.showMessageDialog(null, "Super! Dann auf ins Abenteuer!");
			}
		}
	}

	private boolean laden(int NR) {
		boolean b = false;
		for(int i = 0; i < Codes.length; i++)
		if(NR == Integer.parseInt(Codes[i])){
			b = true;
		}
		return b;
		
	}
	
}
