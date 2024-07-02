package calculadora_GUI;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class MenuPrincipal extends JFrame {
	
	JPanel calcContent = new JPanel();

    /**
	 * 
	 */
	private static final long serialVersionUID = 7861776557986765903L;
	private JPanel contentPane;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
            	MenuPrincipal frame = new MenuPrincipal();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public MenuPrincipal() {
        setBackground(new Color(52, 52, 52));
        setTitle("Calculadora");
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setSize(1300, 850);
        setLocationRelativeTo(null); 
        contentPane = new JPanel();
        contentPane.setBackground(new Color(52, 52, 52)); 
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        
        calcContent.setBackground(new Color(70, 70, 70));
        calcContent.setBounds(0, 123, 1284, 688);
        contentPane.add(calcContent);
        calcContent.setLayout(null);
        
     // --------------------------------- LBL BIENVENIDA ---------------------------------
        
        JLabel lblbienvenidoALa = new JLabel("¡Bienvenido!");
        lblbienvenidoALa.setHorizontalAlignment(SwingConstants.CENTER);
        lblbienvenidoALa.setForeground(new Color(220, 220, 220));
        lblbienvenidoALa.setFont(new Font("Segoe UI Semibold", Font.BOLD, 30));
        lblbienvenidoALa.setBounds(10, 270, 1264, 28);
        calcContent.add(lblbienvenidoALa);
        
     // --------------------------------- LBL SELECCIONAR OPCION ---------------------------------
        
        JLabel lblSeleccion = new JLabel("Seleccione una opci\u00F3n");
        lblSeleccion.setBounds(10, 309, 1264, 19);
        calcContent.add(lblSeleccion);
        lblSeleccion.setForeground(new Color(220, 220, 220));
        lblSeleccion.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 20));
        lblSeleccion.setHorizontalAlignment(SwingConstants.CENTER);
        
     // --------------------------------- PANEL BOTONES ---------------------------------
        
        JPanel botones = new JPanel();
        botones.setBackground(new Color(52, 52, 52));
        botones.setBounds(10, 11, 1264, 101);
        contentPane.add(botones);
        botones.setLayout(null);
        
        
        
       
     // --------------------------------- CONFIRMACION ANTES DE SALIR ---------------------------------
        
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
            	
            	UIManager.put("OptionPane.background", new Color(52, 52, 52));
                UIManager.put("Panel.background", new Color(52, 52, 52));
                UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 14));
                UIManager.put("OptionPane.messageForeground", new Color(220, 220, 220));
                UIManager.put("OptionPane.buttonFont", new Font("Segoe UI Semibold", Font.PLAIN, 12));
                UIManager.put("Button.background", new Color(100, 105, 120));
                UIManager.put("Button.foreground", Color.WHITE);
                
                int response = JOptionPane.showConfirmDialog(
                		MenuPrincipal.this,
                        "¿Está seguro que desea salir?",
                        "Confirmar salida",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE
                );
                if (response == JOptionPane.YES_OPTION) {
                    dispose(); 
                }
            }
        });
        
        
        
        	// --------------------------------- BASICAS ---------------------------------
        
        				JButton btnBasicas = new JButton("Basicas");
        				btnBasicas.setBounds(36, 26, 180, 40);
        				botones.add(btnBasicas);
        
        				btnBasicas.addActionListener(new ActionListener() {
        					public void actionPerformed(ActionEvent e) {
        						//MenuBasicas menuBasicas = new MenuBasicas(MenuPrincipal.this);
        						//menuBasicas.setVisible(true);
        						//setVisible(false);
        						Basicas basicas = new Basicas();
        						ShowPanel(basicas);
        					}
        				});
        				createButton(btnBasicas);
        
        	// --------------------------------- VECTORES ---------------------------------
        				JButton btnVectores = new JButton("Vectores");
        				btnVectores.setBounds(359, 26, 180, 40);
        				botones.add(btnVectores);
        
        				btnVectores.addActionListener(new ActionListener() {
        					public void actionPerformed(ActionEvent e) {
        						//MenuVectores menuVectores = new MenuVectores(MenuPrincipal.this);
        						//menuVectores.setVisible(true);
        						//setVisible(false);
        						Vectores vectores = new Vectores();
        						ShowPanel(vectores);
        					}
        				});
        				createButton(btnVectores);
        
                
             // --------------------------------- MATRICES ---------------------------------
                        JButton btnMatrices = new JButton("Matrices");
                        btnMatrices.setBounds(722, 26, 180, 40);
                        botones.add(btnMatrices);
                        
                        btnMatrices.addActionListener(new ActionListener() {
                        	public void actionPerformed(ActionEvent e) {
                        		//MenuMatrices menuMatrices = new MenuMatrices(MenuPrincipal.this);
                        		//menuMatrices.setVisible(true);
                                //setVisible(false);
                        		Matrices matrices = new Matrices();
                            	ShowPanel(matrices);
                        	}
                        });
                        createButton(btnMatrices);
                        
                     // --------------------------------- SISTEMA DE ECUACIONES ---------------------------------
                        
                        JButton btnEcuaciones = new JButton("Sistema de ecuaciones");
                        btnEcuaciones.setBounds(1039, 26, 180, 40);
                        botones.add(btnEcuaciones);
                        
                        btnEcuaciones.addActionListener(new ActionListener() {
                        	public void actionPerformed(ActionEvent e) {
                        		//MenuEcuaciones menuEcuaciones = new MenuEcuaciones(MenuPrincipal.this);
                        		//menuEcuaciones.setVisible(true);
                                //setVisible(false);
                        		Ecuaciones ecuaciones = new Ecuaciones();
                            	ShowPanel(ecuaciones);
                        	}
                        });
                        createButton(btnEcuaciones);
                        
    }
    
    private void ShowPanel(JPanel p) {
        p.setSize(1284, 607);
        p.setLocation(0, 0);
        
        calcContent.removeAll();
        calcContent.add(p);
        calcContent.revalidate();
        calcContent.repaint();
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
