package swing.mvc;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JFrame;

public class SplitPane extends JFrame
{
	JLabel lLewy = new JLabel();
	JLabel lPrawy = new JLabel();
	
	JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, new JScrollPane(lLewy),new JScrollPane(lPrawy));

	public SplitPane(){
		lLewy.setIcon(new ImageIcon());
		lPrawy.setIcon(new ImageIcon());
	}
	
	public static void main(String[] args){
		
	}
}
