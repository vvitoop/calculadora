package calculadora_GUI;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Ecuaciones_3x3 extends JPanel {
	
	private JTextField InputA1;
    private JTextField InputB1;
    private JTextField InputC1;
    private JTextField InputTI1;
    private JTextField InputA2;
    private JTextField InputB2;
    private JTextField InputC2;
    private JTextField InputTI2;
    private JTextField InputA3;
    private JTextField InputB3;
    private JTextField InputC3;
    private JTextField InputTI3;
    private JLabel Resultado;

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public Ecuaciones_3x3() {
		setBackground(new Color(255, 255, 255));
		setSize(1254, 520);
		setLayout(null);
		
		JPanel bg = new JPanel();
		bg.setBackground(new Color(70, 70, 70));
		bg.setBounds(0, 0, 1254, 520);
		add(bg);
		bg.setLayout(null);
		
		InputA1 = new JTextField();
		InputA1.setHorizontalAlignment(SwingConstants.RIGHT);
        InputA1.setBounds(465, 11, 40, 36);
        bg.add(InputA1);
        InputA1.setColumns(10);
        txtFieldStyle(InputA1);

        InputB1 = new JTextField();
        InputB1.setHorizontalAlignment(SwingConstants.RIGHT);
        InputB1.setBounds(552, 11, 40, 36);
        bg.add(InputB1);
        InputB1.setColumns(10);
        txtFieldStyle(InputB1);
        
        InputC1 = new JTextField();
        InputC1.setHorizontalAlignment(SwingConstants.RIGHT);
        InputC1.setBounds(638, 11, 40, 36);
        bg.add(InputC1);
        InputC1.setColumns(10);
        txtFieldStyle(InputC1);

        InputTI1 = new JTextField();
        InputTI1.setHorizontalAlignment(SwingConstants.RIGHT);
        InputTI1.setBounds(744, 11, 40, 36);
        bg.add(InputTI1);
        InputTI1.setColumns(10);
        txtFieldStyle(InputTI1);

        InputA2 = new JTextField();
        InputA2.setHorizontalAlignment(SwingConstants.RIGHT);
        InputA2.setBounds(465, 76, 40, 36);
        bg.add(InputA2);
        InputA2.setColumns(10);
        txtFieldStyle(InputA2);

        InputB2 = new JTextField();
        InputB2.setHorizontalAlignment(SwingConstants.RIGHT);
        InputB2.setBounds(552, 76, 40, 36);
        bg.add(InputB2);
        InputB2.setColumns(10);
        txtFieldStyle(InputB2);
        
        InputC2 = new JTextField();
        InputC2.setHorizontalAlignment(SwingConstants.RIGHT);
        InputC2.setBounds(638, 76, 40, 36);
        bg.add(InputC2);
        InputC2.setColumns(10);
        txtFieldStyle(InputC2);

        InputTI2 = new JTextField();
        InputTI2.setHorizontalAlignment(SwingConstants.RIGHT);
        InputTI2.setBounds(744, 76, 40, 36);
        bg.add(InputTI2);
        InputTI2.setColumns(10);
        txtFieldStyle(InputTI2);
        
        InputA3 = new JTextField();
        InputA3.setHorizontalAlignment(SwingConstants.RIGHT);
        InputA3.setBounds(465, 137, 40, 36);
        bg.add(InputA3);
        InputA3.setColumns(10);
        txtFieldStyle(InputA3);

        InputB3 = new JTextField();
        InputB3.setHorizontalAlignment(SwingConstants.RIGHT);
        InputB3.setBounds(552, 137, 40, 36);
        bg.add(InputB3);
        InputB3.setColumns(10);
        txtFieldStyle(InputB3);

        InputC3 = new JTextField();
        InputC3.setHorizontalAlignment(SwingConstants.RIGHT);
        InputC3.setBounds(638, 137, 40, 36);
        bg.add(InputC3);
        InputC3.setColumns(10);
        txtFieldStyle(InputC3);

        InputTI3 = new JTextField();
        InputTI3.setHorizontalAlignment(SwingConstants.RIGHT);
        InputTI3.setBounds(744, 137, 40, 36);
        bg.add(InputTI3);
        InputTI3.setColumns(10);
        txtFieldStyle(InputTI3);
        
        Resultado = new JLabel("x:  , y:  , z:  ");
        Resultado.setFont(new Font("Segoe UI Semibold", Font.BOLD, 22));
        Resultado.setForeground(Color.WHITE);
        Resultado.setBounds(10, 278, 1234, 47);
        bg.add(Resultado);
        Resultado.setHorizontalAlignment(SwingConstants.CENTER);

        JButton Calcular = new JButton("Calcular");
        Calcular.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		String inputA1 = InputA1.getText();
                String inputB1 = InputB1.getText();
                String inputC1 = InputB1.getText();
                String inputTI1 = InputTI1.getText();
                String inputA2 = InputA2.getText();
                String inputB2 = InputB2.getText();
                String inputC2 = InputC2.getText();
                String inputTI2 = InputTI2.getText();
                String inputA3 = InputA3.getText();
                String inputB3 = InputB3.getText();
                String inputC3 = InputB3.getText();
                String inputTI3 = InputTI3.getText();

                if (inputA1.isEmpty() || inputB1.isEmpty() || inputC1.isEmpty() ||
                	inputTI1.isEmpty() || inputA2.isEmpty() || inputB2.isEmpty() ||
                	inputC2.isEmpty() || inputTI2.isEmpty() || inputA3.isEmpty() ||
                	inputB3.isEmpty() || inputC3.isEmpty() || inputTI3.isEmpty()) {
                	Resultado.setText("Porfavor, ingrese numeros validos");
                } else {
                	try {
                		double a1 = Double.parseDouble(InputA1.getText());
                        double b1 = Double.parseDouble(InputB1.getText());
                        double c1 = Double.parseDouble(InputC1.getText());
                        double ti1 = Double.parseDouble(InputTI1.getText());
                        double a2 = Double.parseDouble(InputA2.getText());
                        double b2 = Double.parseDouble(InputB2.getText());
                        double c2 = Double.parseDouble(InputC2.getText());
                        double ti2 = Double.parseDouble(InputTI2.getText());
                		double a3 = Double.parseDouble(InputA3.getText());
                		double b3 = Double.parseDouble(InputB3.getText());
                		double c3 = Double.parseDouble(InputC3.getText());
                		double ti3 = Double.parseDouble(InputTI3.getText());

                        double[][] A = { { a1, b1, c1 }, { a2, b2, c2 }, { a3, b3, c3 } };
                        double[] B = { ti1, ti2, ti3 };

                        double[] resultado = resolverSistema3x3(A, B);
                        if (resultado != null) {
                        	Resultado.setText("x: " + resultado[0] + ", y: " + resultado[1] + ", z: " + resultado[2]);
                        } else {
                            Resultado.setText("Sin solución única");
                        }
                	} catch (NumberFormatException e1) {
                		Resultado.setText("Porfavor, ingrese numeros validos");
                	}
                }
        	}
        });
		createButton(Calcular);
        Calcular.setBounds(533, 213, 180, 40);
        bg.add(Calcular);
        
        
        JButton btnLimpiar = new JButton("Limpiar");
        btnLimpiar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		InputA1.setText("");
                InputB1.setText("");
                InputC1.setText("");
                InputTI1.setText("");
                InputA2.setText("");
                InputB2.setText("");
                InputC2.setText("");
                InputTI2.setText("");
                InputA3.setText("");
                InputB3.setText("");
                InputC3.setText("");
                InputTI3.setText("");
                Resultado.setText("x:  , y:  , z:  ");
        	}
        });
		createButton(btnLimpiar);
		btnLimpiar.setBounds(533, 356, 180, 40);
        bg.add(btnLimpiar);
        
        JLabel lblTI1_2 = new JLabel("+");
        lblTI1_2.setHorizontalAlignment(SwingConstants.CENTER);
        lblTI1_2.setForeground(Color.WHITE);
        lblTI1_2.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 20));
        lblTI1_2.setBounds(505, 137, 49, 36);
        bg.add(lblTI1_2);
        
        JLabel lblTI1_2_1 = new JLabel("+");
        lblTI1_2_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblTI1_2_1.setForeground(Color.WHITE);
        lblTI1_2_1.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 20));
        lblTI1_2_1.setBounds(505, 76, 49, 36);
        bg.add(lblTI1_2_1);
        
        JLabel lblTI1_2_2 = new JLabel("+");
        lblTI1_2_2.setHorizontalAlignment(SwingConstants.CENTER);
        lblTI1_2_2.setForeground(Color.WHITE);
        lblTI1_2_2.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 20));
        lblTI1_2_2.setBounds(505, 11, 49, 36);
        bg.add(lblTI1_2_2);
        
        JLabel lblTI1_2_2_1 = new JLabel("+");
        lblTI1_2_2_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblTI1_2_2_1.setForeground(Color.WHITE);
        lblTI1_2_2_1.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 20));
        lblTI1_2_2_1.setBounds(590, 11, 49, 36);
        bg.add(lblTI1_2_2_1);
        
        JLabel lblTI1_2_2_2 = new JLabel("+");
        lblTI1_2_2_2.setHorizontalAlignment(SwingConstants.CENTER);
        lblTI1_2_2_2.setForeground(Color.WHITE);
        lblTI1_2_2_2.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 20));
        lblTI1_2_2_2.setBounds(590, 76, 49, 36);
        bg.add(lblTI1_2_2_2);
        
        JLabel lblTI1_2_2_3 = new JLabel("+");
        lblTI1_2_2_3.setHorizontalAlignment(SwingConstants.CENTER);
        lblTI1_2_2_3.setForeground(Color.WHITE);
        lblTI1_2_2_3.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 20));
        lblTI1_2_2_3.setBounds(590, 137, 49, 36);
        bg.add(lblTI1_2_2_3);
        
        JLabel lblTI1_2_2_1_1 = new JLabel("=");
        lblTI1_2_2_1_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblTI1_2_2_1_1.setForeground(Color.WHITE);
        lblTI1_2_2_1_1.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 20));
        lblTI1_2_2_1_1.setBounds(688, 11, 49, 36);
        bg.add(lblTI1_2_2_1_1);
        
        JLabel lblTI1_2_2_1_1_1 = new JLabel("=");
        lblTI1_2_2_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblTI1_2_2_1_1_1.setForeground(Color.WHITE);
        lblTI1_2_2_1_1_1.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 20));
        lblTI1_2_2_1_1_1.setBounds(688, 76, 49, 36);
        bg.add(lblTI1_2_2_1_1_1);
        
        JLabel lblTI1_2_2_1_1_2 = new JLabel("=");
        lblTI1_2_2_1_1_2.setHorizontalAlignment(SwingConstants.CENTER);
        lblTI1_2_2_1_1_2.setForeground(Color.WHITE);
        lblTI1_2_2_1_1_2.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 20));
        lblTI1_2_2_1_1_2.setBounds(688, 132, 49, 36);
        bg.add(lblTI1_2_2_1_1_2);
	}
	
	public static double[] resolverSistema3x3(double[][] A, double[] B) {
        double a1 = A[0][0], b1 = A[0][1], c1 = A[0][2], d1 = B[0];
        double a2 = A[1][0], b2 = A[1][1], c2 = A[1][2], d2 = B[1];
        double a3 = A[2][0], b3 = A[2][1], c3 = A[2][2], d3 = B[2];

        double determinant = a1 * (b2 * c3 - b3 * c2) -
                             b1 * (a2 * c3 - a3 * c2) +
                             c1 * (a2 * b3 - a3 * b2);

        if (determinant == 0) {
            return null;
        }

        double determinantX = d1 * (b2 * c3 - b3 * c2) -
                              b1 * (d2 * c3 - d3 * c2) +
                              c1 * (d2 * b3 - d3 * b2);

        double determinantY = a1 * (d2 * c3 - d3 * c2) -
                              d1 * (a2 * c3 - a3 * c2) +
                              c1 * (a2 * d3 - a3 * d2);

        double determinantZ = a1 * (b2 * d3 - b3 * d2) -
                              b1 * (a2 * d3 - a3 * d2) +
                              d1 * (a2 * b3 - a3 * b2);

        double x = determinantX / determinant;
        double y = determinantY / determinant;
        double z = determinantZ / determinant;

        return new double[] { x, y, z };
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
		
		private void txtFieldStyle(JTextField txt) {
			txt.setFont(new Font("Segoe UI Semibold", Font.BOLD, 15));
			txt.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2)); 
	        
			txt.addFocusListener(new FocusListener() { 
	            @Override
	            public void focusGained(FocusEvent e) {
	            	txt.setBorder(BorderFactory.createLineBorder(new Color(97, 105, 120), 2)); 
	            }

	            @Override
	            public void focusLost(FocusEvent e) {
	            	txt.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2)); 
	            }
	        });
		}
}
