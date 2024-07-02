package calculadora_GUI;

import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.Cursor;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.SwingConstants;

import calculadora_logica.BasicasLogica;

public class Basicas extends JPanel {
	
	public String operacionSeleccionada;

	/**
	 * 
	 */
	private static final long serialVersionUID = -3190306822851808581L;

	/**
	 * Create the panel.
	 */
	public Basicas() {
		setBackground(new Color(255, 255, 255));
		setSize(1284, 688);
		setLayout(null);
		
		JPanel bg = new JPanel();
		bg.setBackground(new Color(70, 70, 70));
		bg.setBounds(0, 0, 1284, 688);
		add(bg);
		bg.setLayout(null);
		
		// --------------------------------- TITULO ---------------------------------
		
		JLabel lblBasicas = new JLabel("Basicas");
		lblBasicas.setBounds(10, 5, 1264, 69);
		lblBasicas.setHorizontalAlignment(SwingConstants.CENTER);
		lblBasicas.setForeground(new Color(220, 220, 220));
		lblBasicas.setFont(new Font("Segoe UI Semibold", Font.BOLD, 26));
		bg.add(lblBasicas);
		
		// --------------------------------- PANEL ASIDE ---------------------------------
        
        JPanel aside = new JPanel();
        aside.setBackground(new Color(80, 80, 80));
        aside.setBounds(24, 188, 338, 489);
        bg.add(aside);
        aside.setLayout(null);
        
     // --------------------------------- PANEL RESULTADO ---------------------------------
        
        JPanel resultado = new JPanel();
        resultado.setBounds(24, 85, 1236, 83);
        resultado.setBackground(new Color(80, 80, 80));
        bg.add(resultado);
        resultado.setLayout(null);
        
     // --------------------------------- LABEL RESULTADO NUMERO ---------------------------------
        
        JLabel lblResultadoNum = new JLabel(" ");
        lblResultadoNum.setBounds(10, 11, 1216, 61);
        resultado.add(lblResultadoNum);
        lblResultadoNum.setForeground(new Color(220, 220, 220));
        lblResultadoNum.setFont(new Font("Segoe UI Semibold", Font.BOLD, 26)); 
        lblResultadoNum.setHorizontalAlignment(SwingConstants.RIGHT);
        
     // --------------------------------- LABEL TEXT FIELD 1 ---------------------------------
        
        JLabel lblNum1 = new JLabel();
        lblNum1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNum1.setBounds(52, 117, 73, 40);
        aside.add(lblNum1);
        lblNum1.setText("Numero 1:");
        lblNum1.setForeground(new Color(220, 220, 220));
        lblNum1.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
        
     // --------------------------------- LABEL TEXT FIELD 2 ---------------------------------
        
        JLabel lblNum2 = new JLabel();
        lblNum2.setHorizontalAlignment(SwingConstants.CENTER);
        lblNum2.setBounds(52, 205, 73, 40);
        aside.add(lblNum2);
        lblNum2.setText("Numero 2:");
        lblNum2.setForeground(new Color(220, 220, 220));
        lblNum2.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
        
     // --------------------------------- LABEL INGRESO DATOS ---------------------------------
        
        JLabel lblIngresoDeDatos = new JLabel("Ingreso de datos");
        lblIngresoDeDatos.setBounds(10, 34, 318, 43);
        aside.add(lblIngresoDeDatos);
        lblIngresoDeDatos.setHorizontalAlignment(SwingConstants.CENTER);
        lblIngresoDeDatos.setForeground(new Color(220, 220, 220));
        lblIngresoDeDatos.setFont(new Font("Segoe UI Semibold", Font.BOLD, 22));
        
     // --------------------------------- TEXT FIELD 1 ---------------------------------
        
        JTextField txtFieldNum1 = new JTextField();
        txtFieldNum1.setHorizontalAlignment(SwingConstants.RIGHT);
        txtFieldNum1.setBounds(135, 119, 100, 40);
        aside.add(txtFieldNum1);
        txtFieldNum1.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2)); 
        
        txtFieldNum1.addFocusListener(new FocusListener() { 
        	@Override
            public void focusGained(FocusEvent e) {
                txtFieldNum1.setBorder(BorderFactory.createLineBorder(new Color(97, 105, 120), 2)); 
            }
        	@Override
            public void focusLost(FocusEvent e) {
                txtFieldNum1.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2)); 
            }
        });
        
     // --------------------------------- TEXT FIELD 2 ---------------------------------
        
        JTextField txtFieldNum2 = new JTextField();
        txtFieldNum2.setHorizontalAlignment(SwingConstants.RIGHT);
        txtFieldNum2.setBounds(135, 207, 100, 40);
        aside.add(txtFieldNum2);
        txtFieldNum2.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2)); 
        
        txtFieldNum2.addFocusListener(new FocusListener() { 
            @Override
            public void focusGained(FocusEvent e) {
                txtFieldNum2.setBorder(BorderFactory.createLineBorder(new Color(97, 105, 120), 2)); 
            }

            @Override
            public void focusLost(FocusEvent e) {
                txtFieldNum2.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2)); 
            }
        });
        
     // --------------------------------- PANEL BOTONES ---------------------------------
        
        JPanel botones = new JPanel();
        botones.setBackground(new Color(80, 80, 80));
        botones.setBounds(382, 188, 878, 489);
        bg.add(botones);
        botones.setLayout(null);
        
     // --------------------------------- LABEL OPERACION ---------------------------------
        
        JLabel lblOperacion = new JLabel("Seleccione la operacion:");
    	lblOperacion.setHorizontalAlignment(SwingConstants.CENTER);
    	lblOperacion.setForeground(new Color(220, 220, 220));
    	lblOperacion.setFont(new Font("Segoe UI Semibold", Font.BOLD, 22));
    	lblOperacion.setBounds(10, 30, 858, 43);
    	botones.add(lblOperacion);
	    
	    
	    // --------------------------------- SUMA ---------------------------------
	    
	    JButton btnSuma = new JButton("Suma");
	    btnSuma.setBounds(125, 122, 180, 40);
	    createButton(btnSuma);
        
        botones.add(btnSuma);
        btnSuma.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	lblNum1.setText("Numero 1:");
    			lblNum2.setText("Numero 2:");
            	String textNum1 = txtFieldNum1.getText();
            	String textNum2 = txtFieldNum2.getText();
            	
                if (textNum1.isEmpty() || textNum2.isEmpty()) {
                    lblResultadoNum.setText("Por favor ingrese n�meros v�lidos");
                } else {
                    try {
                        double num1 = Double.parseDouble(textNum1);
                        double num2 = Double.parseDouble(textNum2);
                        double resultado = BasicasLogica.suma(num1, num2);
                        
                        lblResultadoNum.setText(" " + resultado);
                    } catch (NumberFormatException e1) {
                        lblResultadoNum.setText("Por favor ingrese n�meros v�lidos");
                    }
                }
            }
        });
        
        // --------------------------------- RESTA ---------------------------------
        
        JButton btnResta = new JButton("Resta");
        btnResta.setBounds(572, 122, 180, 40);
        createButton(btnResta);
    
    	botones.add(btnResta);
    	
    	btnResta.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			lblNum1.setText("Numero 1:");
    			lblNum2.setText("Numero 2:");
    			String textNum1 = txtFieldNum1.getText();
    	    	String textNum2 = txtFieldNum2.getText();
    			
                if (textNum1.isEmpty() || textNum2.isEmpty()) {
                    lblResultadoNum.setText("Por favor ingrese n�meros v�lidos");
                } else {
                    try {
                        double num1 = Double.parseDouble(textNum1);
                        double num2 = Double.parseDouble(textNum2);
                        double resultado = BasicasLogica.resta(num1, num2);
                        
                        lblResultadoNum.setText(" " + resultado);
                    } catch (NumberFormatException e1) {
                        lblResultadoNum.setText("Por favor ingrese n�meros v�lidos");
                    }
                }
    		}
    	});
    	
    	// --------------------------------- MULTIPLICACION ---------------------------------
    	
    	JButton btnMult = new JButton("Multiplicacion");
    	btnMult.setBounds(125, 203, 180, 40);
    	createButton(btnMult);

    	botones.add(btnMult);
    	
    	btnMult.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			lblNum1.setText("Numero 1:");
    			lblNum2.setText("Numero 2:");
    			String textNum1 = txtFieldNum1.getText();
    	    	String textNum2 = txtFieldNum2.getText();
    			
                if (textNum1.isEmpty() || textNum2.isEmpty()) {
                    lblResultadoNum.setText("Por favor ingrese n�meros v�lidos");
                } else {
                    try {
                        double num1 = Double.parseDouble(textNum1);
                        double num2 = Double.parseDouble(textNum2);
                        double resultado = BasicasLogica.multiplicacion(num1, num2);
                        
                        lblResultadoNum.setText(" " + resultado);
                    } catch (NumberFormatException e1) {
                        lblResultadoNum.setText("Por favor ingrese n�meros v�lidos");
                    }
                }
    		}
    	});
    	
    	// --------------------------------- DIVISION ---------------------------------
    	
    	JButton btnDiv = new JButton("Division");
    	btnDiv.setBounds(572, 203, 180, 40);
    	createButton(btnDiv);

    	botones.add(btnDiv);
    	
    	btnDiv.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			lblNum1.setText("Dividendo:");
    			lblNum2.setText("Divisor:");
    			String textNum1 = txtFieldNum1.getText();
    	    	String textNum2 = txtFieldNum2.getText();
    			
                if (textNum1.isEmpty() || textNum2.isEmpty()) {
                    lblResultadoNum.setText("Por favor ingrese n�meros v�lidos");
                } else {
                    try {
                        double num1 = Double.parseDouble(textNum1);
                        double num2 = Double.parseDouble(textNum2);
                        double resultado = 0;
                        if (Double.isNaN(BasicasLogica.division(num1, num2))) {
                        	lblResultadoNum.setText("Division invalida");
                        	return;
                        } else {
                        	resultado = BasicasLogica.division(num1, num2);
                        }
                        
                        lblResultadoNum.setText(" " + resultado);
                    } catch (NumberFormatException e1) {
                        lblResultadoNum.setText("Por favor ingrese n�meros v�lidos");
                    }
                }
    		}
    	});
    	
    	// --------------------------------- POTENCIA ---------------------------------
    	
    	JButton btnPotencia = new JButton("Potencia");
    	btnPotencia.setBounds(125, 283, 180, 40);
    	createButton(btnPotencia);
    	botones.add(btnPotencia);
    	
    	btnPotencia.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			lblNum1.setText("Base:");
    			lblNum2.setText("Exponente:");
    			String textNum1 = txtFieldNum1.getText();
    	    	String textNum2 = txtFieldNum2.getText();
    			
                if (textNum1.isEmpty() || textNum2.isEmpty()) {
                    lblResultadoNum.setText("Por favor ingrese n�meros v�lidos");
                } else {
                    try {
                        double num1 = Double.parseDouble(textNum1);
                        double num2 = Double.parseDouble(textNum2);
                        double resultado = 0;
                        if (Double.isNaN(BasicasLogica.potencia(num1, num2))) {
                        	lblResultadoNum.setText("Potencia invalida");
                        	return;
                        } else {
                        	resultado = BasicasLogica.potencia(num1, num2);
                        }
                        
                        lblResultadoNum.setText(" " + resultado);
                    } catch (NumberFormatException e1) {
                        lblResultadoNum.setText("Por favor ingrese n�meros v�lidos");
                    }
                }
    		}
    	});
    	
    	// --------------------------------- RAIZ ---------------------------------
    	
	    JButton btnRaiz = new JButton("Raiz");
	    btnRaiz.setBounds(572, 283, 180, 40);
	    createButton(btnRaiz);
    	botones.add(btnRaiz);
    	
    	btnRaiz.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			lblNum1.setText("Radicando:");
    			lblNum2.setText("Indice:");
    			String textNum1 = txtFieldNum1.getText();
    	    	String textNum2 = txtFieldNum2.getText();
    			
                if (textNum1.isEmpty() || textNum2.isEmpty()) {
                    lblResultadoNum.setText("Por favor ingrese n�meros v�lidos");
                } else {
                    try {
                        double num1 = Double.parseDouble(textNum1);
                        double num2 = Double.parseDouble(textNum2);
                        double resultado = 0;
                        if (Double.isNaN(BasicasLogica.raiz(num1, num2))) {
                        	lblResultadoNum.setText("Raiz invalida");
                        	return;
                        } else {
                        	resultado = BasicasLogica.raiz(num1, num2);
                        }
                        
                        lblResultadoNum.setText(" " + resultado);
                    } catch (NumberFormatException e1) {
                        lblResultadoNum.setText("Por favor ingrese n�meros v�lidos");
                    }
                }
    		}
    	});
	    		
    	
    	// --------------------------------- LIMPIAR ---------------------------------
    	
    	 JButton btnLimpiar = new JButton("Limpiar");
    	 btnLimpiar.addActionListener(new ActionListener() {
    	 	public void actionPerformed(ActionEvent e) {
    	 		txtFieldNum1.setText("");
    	        txtFieldNum2.setText("");
    	        lblNum1.setText("Numero 1:");
    			lblNum2.setText("Numero 2:");
    	        lblResultadoNum.setText("");
    	 	}
    	 });
    	 
    	 btnLimpiar.setBounds(78, 296, 180, 40);
         aside.add(btnLimpiar);
         createButton(btnLimpiar);               	
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
