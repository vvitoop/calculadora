package calculadora_GUI;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;

import calculadora_logica.Vector3D;
import calculadora_logica.VectoresLogica;

public class Vectores extends JPanel {
	private JTextField textField_dimension;
    private int dimension;
    private JPanel ingresoVectores;
    private JScrollPane scrollPane;
    private double[] vector1;
    private double[] vector2;
    private double escalar;
    private JTextField[] textFields_v1;
    private JTextField[] textFields_v2;
    JButton btnLimpiar = new JButton("Limpiar");
    JTextField txtFieldEscalar = new JTextField();

	/**
	 * 
	 */
	private static final long serialVersionUID = -5675253837319735216L;

	/**
	 * Create the panel.
	 */
	public Vectores() {
		setBackground(new Color(255, 255, 255));
		setSize(1284, 688);
		setLayout(null);
		
		JPanel bg = new JPanel();
		bg.setBackground(new Color(70, 70, 70));
		bg.setBounds(0, 0, 1284, 688);
		add(bg);
		bg.setLayout(null);
		
		JLabel lblIngreseEscalarsi = new JLabel("Ingrese escalar:");
        lblIngreseEscalarsi.setHorizontalAlignment(SwingConstants.CENTER);
        lblIngreseEscalarsi.setForeground(new Color(220, 220, 220));
        lblIngreseEscalarsi.setFont(new Font("Segoe UI Semibold", Font.BOLD, 18));
        lblIngreseEscalarsi.setBounds(461, 428, 377, 43);
        bg.add(lblIngreseEscalarsi);
        
        txtFieldEscalar.setHorizontalAlignment(SwingConstants.RIGHT);
        txtFieldEscalar.setColumns(10);
        txtFieldEscalar.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
        txtFieldEscalar.setBounds(603, 482, 100, 43);
        bg.add(txtFieldEscalar);
		
		JPanel resultado = new JPanel();
        resultado.setLayout(null);
        resultado.setBackground(new Color(80, 80, 80));
        resultado.setBounds(20, 56, 1236, 83);
        bg.add(resultado);
        
        JLabel lblResultadoNum = new JLabel(" ");
        lblResultadoNum.setHorizontalAlignment(SwingConstants.RIGHT);
        lblResultadoNum.setForeground(new Color(220, 220, 220));
        lblResultadoNum.setFont(new Font("Segoe UI Semibold", Font.BOLD, 26));
        lblResultadoNum.setBounds(10, 11, 1216, 61);
        resultado.add(lblResultadoNum);
        
        JLabel lblOperacion = new JLabel("Seleccione una operación:");
        lblOperacion.setHorizontalAlignment(SwingConstants.CENTER);
        lblOperacion.setForeground(new Color(220, 220, 220));
        lblOperacion.setFont(new Font("Segoe UI Semibold", Font.BOLD, 18));
        lblOperacion.setBounds(879, 150, 377, 43);
        bg.add(lblOperacion);
		
		JLabel lblVectores = new JLabel("Vectores");
		lblVectores.setBounds(10, 5, 1264, 43);
		lblVectores.setHorizontalAlignment(SwingConstants.CENTER);
		lblVectores.setForeground(new Color(220, 220, 220));
		lblVectores.setFont(new Font("Segoe UI Semibold", Font.BOLD, 24));
		bg.add(lblVectores);
		
		JLabel lblDim = new JLabel("Ingrese la dimensión de los vectores:");
		lblDim.setLocation(461, 150);
		lblDim.setSize(377, 43);
		lblDim.setHorizontalAlignment(SwingConstants.CENTER);
		lblDim.setForeground(new Color(220, 220, 220));
		lblDim.setFont(new Font("Segoe UI Semibold", Font.BOLD, 18));
        bg.add(lblDim);
        
        textField_dimension = new JTextField();
		textField_dimension.setSize(100, 43);
		textField_dimension.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_dimension.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2)); 
        
		textField_dimension.addFocusListener(new FocusListener() { 
        	@Override
            public void focusGained(FocusEvent e) {
        		textField_dimension.setBorder(BorderFactory.createLineBorder(new Color(97, 105, 120), 2)); 
            }
        	@Override
            public void focusLost(FocusEvent e) {
        		textField_dimension.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2)); 
            }
        });
		textField_dimension.setLocation(603, 229);
        bg.add(textField_dimension);
        textField_dimension.setColumns(10);
        
        
        ingresoVectores = new JPanel();
        
        JButton btnContinuar = new JButton("Ingresar Dimension");
        createButton(btnContinuar);
        btnContinuar.setLocation(562, 328);
        btnContinuar.setSize(180, 40);
        btnContinuar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	String inputDimension = textField_dimension.getText().trim();
                
                if (inputDimension.isEmpty()) {
                    
                    lblResultadoNum.setText("Por favor ingrese una dimensión válida primero");
                    
                    
                    return; 
                }
                try {
                dimension = Integer.parseInt(textField_dimension.getText());
                ingresoVectores.removeAll();
                vector1 = new double[dimension];
                vector2 = new double[dimension];
                textFields_v1 = new JTextField[dimension];
                textFields_v2 = new JTextField[dimension];
                
                
                ingresoVectores.setLayout(null);
                ingresoVectores.setBackground(new Color(70, 70, 70));
                ingresoVectores.setPreferredSize(new Dimension(300, 50 + dimension * 50));
                
                if (scrollPane != null) {
                    bg.remove(scrollPane);
                }
                
                for (JTextField textField : textFields_v1) {
                    if (textField != null) {
                        bg.remove(textField);
                    }
                }
                for (JTextField textField : textFields_v2) {
                    if (textField != null) {
                        bg.remove(textField);
                    }
                }
                
                for (int i = 0; i < dimension; i++) {
                	textFields_v1[i] = new JTextField();
                    configurarEstilo(textFields_v1[i]);
                    textFields_v1[i].setLocation(50, 50 + i * 50);
                    textFields_v1[i].setSize(100, 30);
                    ingresoVectores.add(textFields_v1[i]);
                    
                    textFields_v2[i] = new JTextField();
                    configurarEstilo(textFields_v2[i]);
                    textFields_v2[i].setLocation(200, 50 + i * 50);
                    textFields_v2[i].setSize(100, 30);
                    ingresoVectores.add(textFields_v2[i]);
                }
                
                scrollPane = new JScrollPane(ingresoVectores);
                scrollPane.setBounds(20, 155, 350, 400);
                scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
                scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
                scrollPane.setBorder(BorderFactory.createLineBorder(new Color(70, 70, 70)));
                
                bg.add(scrollPane);
                
                JLabel lblVector1 = new JLabel("Vector 1");
        		lblVector1.setHorizontalAlignment(SwingConstants.CENTER);
        		lblVector1.setForeground(new Color(220, 220, 220));
        		lblVector1.setFont(new Font("Segoe UI Semibold", Font.BOLD, 16));
        		lblVector1.setLocation(52, 10);
        		lblVector1.setSize(100, 43);
        		ingresoVectores.add(lblVector1);

                JLabel lblVector2 = new JLabel("Vector 2");
                lblVector2.setHorizontalAlignment(SwingConstants.CENTER);
                lblVector2.setForeground(new Color(220, 220, 220));
                lblVector2.setFont(new Font("Segoe UI Semibold", Font.BOLD, 16));
        		lblVector2.setLocation(198, 10);
        		lblVector2.setSize(100, 43);
        		ingresoVectores.add(lblVector2);
        		
        		bg.add(btnLimpiar); 
                
                bg.revalidate();
                bg.repaint();
                } catch (NumberFormatException ex) {
                	lblResultadoNum.setText("Por favor ingrese una dimensión válida primero");
                }
                
            }
        });
        bg.add(btnContinuar); 		
        
        
        
        JButton btnSuma = new JButton("Suma");
        btnSuma.setLocation(983, 204);
        btnSuma.setSize(180, 40);
        createButton(btnSuma);
        
        btnSuma.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	if (dimension > 0 && textFields_v1 != null && textFields_v2 != null) {
                    try {
                        vector1 = obtenerVectorDesdeJTextField(textFields_v1);
                        vector2 = obtenerVectorDesdeJTextField(textFields_v2);

                        if (vector1 == null || vector2 == null) {
                            lblResultadoNum.setText("Por favor ingrese números válidos en todos los campos");
                        } else {
                        	double[] resultado = VectoresLogica.sumaVectores(vector1, vector2);
                        	lblResultadoNum.setText("" + Arrays.toString(resultado));
                        }
                    } catch (NumberFormatException e1) {
                        lblResultadoNum.setText("Por favor ingrese números válidos en todos los campos");
                    }
                } else {
                    lblResultadoNum.setText("Por favor ingrese una dimensión válida primero");
                }
            }
        });
        bg.add(btnSuma);

        JButton btnResta = new JButton("Resta");
        btnResta.setLocation(983, 281);
        btnResta.setSize(180, 40);
        createButton(btnResta);
        btnResta.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	if (dimension > 0 && textFields_v1 != null && textFields_v2 != null) {
                    try {
                        vector1 = obtenerVectorDesdeJTextField(textFields_v1);
                        vector2 = obtenerVectorDesdeJTextField(textFields_v2);

                        if (vector1 == null || vector2 == null) {
                            lblResultadoNum.setText("Por favor ingrese números válidos en todos los campos");
                        } else {
                        	double[] resultado = VectoresLogica.restaVectores(vector1, vector2);
                        	lblResultadoNum.setText("" + Arrays.toString(resultado));
                        }
                    } catch (NumberFormatException e1) {
                        lblResultadoNum.setText("Por favor ingrese números válidos en todos los campos");
                    }
                } else {
                    lblResultadoNum.setText("Por favor ingrese una dimensión válida primero");
                }
            }
        });
        bg.add(btnResta);

        JButton btnMultiplicacionEscalar = new JButton("Multiplicacion Escalar");
        btnMultiplicacionEscalar.setLocation(983, 355);
        btnMultiplicacionEscalar.setSize(180, 40);
        createButton(btnMultiplicacionEscalar);
        btnMultiplicacionEscalar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	String textoEscalar = txtFieldEscalar.getText();
            	if (textoEscalar.isEmpty()) {
            		lblResultadoNum.setText("Ingrese un escalar valido");
            	}
            	if (dimension > 0 && textFields_v1 != null) {
                    try {
                        vector1 = obtenerVectorDesdeJTextField(textFields_v1);
                        escalar = Double.parseDouble(textoEscalar);

                        if (vector1 == null || vector2 == null) {
                            lblResultadoNum.setText("Por favor ingrese números válidos en todos los campos");
                        } else {
                        	double[] resultado = VectoresLogica.multiplicacionEscalarPorVector(escalar, vector1);
                        	lblResultadoNum.setText("" + Arrays.toString(resultado));
                        }
                    } catch (NumberFormatException e1) {
                        lblResultadoNum.setText("Por favor ingrese números válidos en todos los campos o ingrese escalar valido");
                    }
                } else {
                    lblResultadoNum.setText("Por favor ingrese una dimensión válida primero");
                }
            }
        });
        bg.add(btnMultiplicacionEscalar);

        JButton btnProductoEscalar = new JButton("Producto Escalar");
        btnProductoEscalar.setLocation(983, 433);
        btnProductoEscalar.setSize(180, 40);
        createButton(btnProductoEscalar);
        btnProductoEscalar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	if (dimension > 0 && textFields_v1 != null && textFields_v2 != null) {
                    try {
                        vector1 = obtenerVectorDesdeJTextField(textFields_v1);
                        vector2 = obtenerVectorDesdeJTextField(textFields_v2);

                        if (vector1 == null || vector2 == null) {
                            lblResultadoNum.setText("Por favor ingrese números válidos en todos los campos");
                        } else {
                        	double resultado = VectoresLogica.productoEscalar(vector1, vector2);
                        	lblResultadoNum.setText("" + resultado);
                        }
                    } catch (NumberFormatException e1) {
                        lblResultadoNum.setText("Por favor ingrese números válidos en todos los campos");
                    }
                } else {
                    lblResultadoNum.setText("Por favor ingrese una dimensión válida primero");
                }
            }
        });
        bg.add(btnProductoEscalar);

        JButton btnProductoVectorial = new JButton("Producto Vectorial");
        btnProductoVectorial.setLocation(983, 510);
        btnProductoVectorial.setSize(180, 40);
        createButton(btnProductoVectorial);
        btnProductoVectorial.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	if (dimension != 3) {
                    lblResultadoNum.setText("El producto vectorial solo está definido para vectores tridimensionales");
                    return;
                }
            	try {
                    
                    Vector3D v1 = obtenerVectorTridimensional(textFields_v1);
                    Vector3D v2 = obtenerVectorTridimensional(textFields_v2);

                    
                    Vector3D productoVectorial = v1.productoVectorial(v2);

                    
                    lblResultadoNum.setText(String.format("(%f; %f; %f)",
                                                        productoVectorial.getX(), productoVectorial.getY(), productoVectorial.getZ()));
                } catch (NumberFormatException ex) {
                	lblResultadoNum.setText("Por favor ingrese números válidos en todos los campos");
                } catch (Exception ex) {
                	lblResultadoNum.setText("Por favor ingrese una dimensión válida primero");
                }
            }
        });
        bg.add(btnProductoVectorial);
        
        
        
        
        btnLimpiar.setLocation(110, 559);
        btnLimpiar.setSize(180, 40);
        createButton(btnLimpiar);
        btnLimpiar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	textField_dimension.setText("");
            	txtFieldEscalar.setText("");
            	lblResultadoNum.setText("");
                for (JTextField textField : textFields_v1) {
                    if (textField != null) {
                        textField.setText("");
                    }
                }
                for (JTextField textField : textFields_v2) {
                    if (textField != null) {
                        textField.setText(""); 
                    }
                }
            }
        });
                                                      
	}
	
	private void configurarEstilo(JTextField textField) {
		textField.setHorizontalAlignment(SwingConstants.RIGHT);
		textField.setBounds(620, 240, 100, 40);
		textField.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2)); 
        
		textField.addFocusListener(new FocusListener() { 
        	@Override
            public void focusGained(FocusEvent e) {
        		textField.setBorder(BorderFactory.createLineBorder(new Color(97, 105, 120), 2)); 
            }
        	@Override
            public void focusLost(FocusEvent e) {
        		textField.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2)); 
            }
        });
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
	
	private double[] obtenerVectorDesdeJTextField(JTextField[] textFields) {
	    double[] vector = new double[textFields.length];
	    for (int i = 0; i < textFields.length; i++) {
	        vector[i] = Double.parseDouble(textFields[i].getText().trim());
	    }
	    return vector;
	}
	
	private Vector3D obtenerVectorTridimensional(JTextField[] textFields) {
	    double x = Double.parseDouble(textFields[0].getText().trim());
	    double y = Double.parseDouble(textFields[1].getText().trim());
	    double z = Double.parseDouble(textFields[2].getText().trim());
	    return new Vector3D(x, y, z);
	}
}