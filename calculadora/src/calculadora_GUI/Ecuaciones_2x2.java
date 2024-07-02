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

public class Ecuaciones_2x2 extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private JTextField InputA1;
    private JTextField InputB1;
    private JTextField InputTI1;
    private JTextField InputA2;
    private JTextField InputB2;
    private JTextField InputTI2;
    private JLabel Resultado;

	/**
	 * Create the panel.
	 */
	public Ecuaciones_2x2() {
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
        InputA1.setBounds(507, 36, 40, 36);
        bg.add(InputA1);
        InputA1.setColumns(10);
        txtFieldStyle(InputA1);

        InputB1 = new JTextField();
        InputB1.setHorizontalAlignment(SwingConstants.RIGHT);
        InputB1.setBounds(614, 36, 40, 36);
        bg.add(InputB1);
        InputB1.setColumns(10);
        txtFieldStyle(InputB1);

        InputTI1 = new JTextField();
        InputTI1.setHorizontalAlignment(SwingConstants.RIGHT);
        InputTI1.setBounds(709, 36, 40, 36);
        bg.add(InputTI1);
        InputTI1.setColumns(10);
        txtFieldStyle(InputTI1);

        InputA2 = new JTextField();
        InputA2.setHorizontalAlignment(SwingConstants.RIGHT);
        InputA2.setBounds(507, 125, 40, 36);
        bg.add(InputA2);
        InputA2.setColumns(10);
        txtFieldStyle(InputA2);

        InputB2 = new JTextField();
        InputB2.setHorizontalAlignment(SwingConstants.RIGHT);
        InputB2.setBounds(614, 125, 40, 36);
        bg.add(InputB2);
        InputB2.setColumns(10);
        txtFieldStyle(InputB2);

        InputTI2 = new JTextField();
        InputTI2.setHorizontalAlignment(SwingConstants.RIGHT);
        InputTI2.setBounds(709, 124, 40, 36);
        bg.add(InputTI2);
        InputTI2.setColumns(10);
        txtFieldStyle(InputTI2);

        JLabel lblTI1 = new JLabel("+");
        lblTI1.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 20));
        lblTI1.setHorizontalAlignment(SwingConstants.CENTER);
        lblTI1.setForeground(Color.WHITE);
        lblTI1.setBounds(557, 36, 39, 36);
        bg.add(lblTI1);
        
        JLabel lblTI1_1 = new JLabel("=");
        lblTI1_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblTI1_1.setForeground(Color.WHITE);
        lblTI1_1.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 20));
        lblTI1_1.setBounds(660, 36, 39, 36);
        bg.add(lblTI1_1);
        
        JLabel lblTI1_2 = new JLabel("+");
        lblTI1_2.setHorizontalAlignment(SwingConstants.CENTER);
        lblTI1_2.setForeground(Color.WHITE);
        lblTI1_2.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 20));
        lblTI1_2.setBounds(557, 121, 39, 36);
        bg.add(lblTI1_2);
        
        JLabel lblTI1_1_1 = new JLabel("=");
        lblTI1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblTI1_1_1.setForeground(Color.WHITE);
        lblTI1_1_1.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 20));
        lblTI1_1_1.setBounds(664, 125, 39, 36);
        bg.add(lblTI1_1_1);        

        Resultado = new JLabel("x:  , y:  ");
        Resultado.setFont(new Font("Segoe UI Semibold", Font.BOLD, 22));
        Resultado.setForeground(Color.WHITE);
        Resultado.setBounds(10, 278, 1234, 47);
        bg.add(Resultado);
        Resultado.setHorizontalAlignment(SwingConstants.CENTER);

        JButton Calcular = new JButton("Calcular");
		createButton(Calcular);
        Calcular.setBounds(533, 213, 180, 40);
        bg.add(Calcular);
        

        Calcular.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	String inputA1 = InputA1.getText();
                String inputB1 = InputB1.getText();
                String inputTI1 = InputTI1.getText();
                String inputA2 = InputA2.getText();
                String inputB2 = InputB2.getText();
                String inputTI2 = InputTI2.getText();

                if (inputA1.isEmpty() || inputB1.isEmpty() || inputTI1.isEmpty() ||
                    inputA2.isEmpty() || inputB2.isEmpty() || inputTI2.isEmpty()) {
                	Resultado.setText("Porfavor, ingrese numeros validos");
                } else {
                	try {
                		double a1 = Double.parseDouble(InputA1.getText());
                        double b1 = Double.parseDouble(InputB1.getText());
                        double ti1 = Double.parseDouble(InputTI1.getText());
                        double a2 = Double.parseDouble(InputA2.getText());
                        double b2 = Double.parseDouble(InputB2.getText());
                        double ti2 = Double.parseDouble(InputTI2.getText());

                        double[][] A = { { a1, b1 }, { a2, b2 } };
                        double[] B = { ti1, ti2 };

                        double[] resultado = resolverSistema2x2(A, B);
                        if (resultado != null) {
                            Resultado.setText("x: " + resultado[0] + ", y: " + resultado[1]);
                        } else {
                            Resultado.setText("Sin solución única");
                        }
                	} catch (NumberFormatException e1) {
                		Resultado.setText("Porfavor, ingrese numeros validos");
                	}
                }
                
            }
        });
        
        JButton btnLimpiar = new JButton("Limpiar");
        btnLimpiar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		InputA1.setText("");
                InputB1.setText("");
                InputTI1.setText("");
                InputA2.setText("");
                InputB2.setText("");
                InputTI2.setText("");
                Resultado.setText("x:  , y:  ");
        	}
        });
		createButton(btnLimpiar);
		btnLimpiar.setBounds(533, 356, 180, 40);
        bg.add(btnLimpiar);
        
        

	}
	
	public static double[] resolverSistema2x2(double[][] A, double[] B) {
        double a1 = A[0][0], b1 = A[0][1], c1 = B[0];
        double a2 = A[1][0], b2 = A[1][1], c2 = B[1];

        double determinant = a1 * b2 - a2 * b1;

        if (determinant == 0) {
            return null;
        }

        double x = (c1 * b2 - c2 * b1) / determinant;
        double y = (a1 * c2 - a2 * c1) / determinant;

        return new double[] { x, y };
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

