package calculadora_GUI;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Ecuaciones extends JPanel {
	
	JPanel ecuacionesCont = new JPanel();

	/**
	 * 
	 */
	private static final long serialVersionUID = -5183706765198707334L;

	/**
	 * Create the panel.
	 */
	public Ecuaciones() {
		setBackground(new Color(255, 255, 255));
		setSize(1284, 688);
		setLayout(null);
		
		JPanel bg = new JPanel();
		bg.setBackground(new Color(70, 70, 70));
		bg.setBounds(0, 0, 1284, 688);
		add(bg);
		bg.setLayout(null);
		
		JLabel lblBasicas = new JLabel("Sistema de ecuaciones");
		lblBasicas.setBounds(10, 5, 1264, 43);
		lblBasicas.setHorizontalAlignment(SwingConstants.CENTER);
		lblBasicas.setForeground(new Color(220, 220, 220));
		lblBasicas.setFont(new Font("Arial", Font.BOLD, 24));
		bg.add(lblBasicas);
		ecuacionesCont.setBackground(new Color(70, 70, 70));
		
		
		ecuacionesCont.setBounds(20, 157, 1254, 520);
		bg.add(ecuacionesCont);
		ecuacionesCont.setLayout(null);
		
		JButton btn2x2 = new JButton("2x2");
		btn2x2.setBounds(314, 85, 180, 40);
        bg.add(btn2x2);
        
        btn2x2.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		Ecuaciones_2x2 ecuaciones_2x2 = new Ecuaciones_2x2();
            	ShowPanel(ecuaciones_2x2);
        	}
        });
        createButton(btn2x2);
        
        JButton btn3x3 = new JButton("3x3");
        btn3x3.setBounds(817, 85, 180, 40);
        bg.add(btn3x3);
        
        btn3x3.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		Ecuaciones_3x3 ecuaciones_3x3 = new Ecuaciones_3x3();
        		ShowPanel(ecuaciones_3x3);
        	}
        });
        createButton(btn3x3);
	}
	
	private void ShowPanel(JPanel p) {
        p.setSize(1254, 520);
        p.setLocation(0, 0);
        
        ecuacionesCont.removeAll();
        ecuacionesCont.add(p);
        ecuacionesCont.revalidate();
        ecuacionesCont.repaint();
    }
    
    private void createButton(JButton b) {
    	 b.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
         b.setForeground(Color.WHITE);
         b.setBackground(new Color(97, 105, 120)); 
         b.setCursor(new Cursor(Cursor.HAND_CURSOR));
         b.setFocusPainted(false);
         b.setBorderPainted(false);
         b.setOpaque(true);
 
         b.addMouseListener(new MouseAdapter() {
             @Override
             	public void mouseEntered(MouseEvent e) {
             		b.setBackground(new Color(117, 125, 150)); 
             	}
 
             @Override
             	public void mouseExited(MouseEvent e) {
             		b.setBackground(new Color(97, 105, 120));
             	}
         });
    }
}
