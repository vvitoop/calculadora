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

import calculadora_logica.MatricesLogica;

public class Matrices extends JPanel {
    private JTextField textField_filas1;
    private JTextField textField_columnas1;
    private JTextField textField_filas2;
    private JTextField textField_columnas2;
    private int filas1, columnas1, filas2, columnas2;
    private JPanel ingresoMatrices;
    private JScrollPane scrollPane;
    private double[][] matriz1;
    private double[][] matriz2;
    private double escalar;
    private JTextField[][] textFields_m1;
    private JTextField[][] textFields_m2;
    JButton btnLimpiar = new JButton("Limpiar");
    JTextField txtFieldEscalar = new JTextField();

    /**
     * 
     */
    private static final long serialVersionUID = -5675253837319735216L;

    /**
     * Create the panel.
     */
    public Matrices() {
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
        lblIngreseEscalarsi.setBounds(879, 500, 377, 43);
        bg.add(lblIngreseEscalarsi);

        txtFieldEscalar.setHorizontalAlignment(SwingConstants.RIGHT);
        txtFieldEscalar.setColumns(10);
        txtFieldEscalar.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
        txtFieldEscalar.setBounds(1026, 554, 100, 43);
        bg.add(txtFieldEscalar);

        JPanel resultado = new JPanel();
        resultado.setLayout(null);
        resultado.setBackground(new Color(80, 80, 80));
        resultado.setBounds(20, 56, 1236, 83);
        bg.add(resultado);

        JLabel lblResultadoNum = new JLabel(" ");
        lblResultadoNum.setHorizontalAlignment(SwingConstants.RIGHT);
        lblResultadoNum.setForeground(new Color(220, 220, 220));
        lblResultadoNum.setFont(new Font("Segoe UI Semibold", Font.BOLD, 17));
        lblResultadoNum.setBounds(10, 11, 1216, 61);
        resultado.add(lblResultadoNum);
        

        JLabel lblOperacion = new JLabel("Seleccione una operación:");
        lblOperacion.setHorizontalAlignment(SwingConstants.CENTER);
        lblOperacion.setForeground(new Color(220, 220, 220));
        lblOperacion.setFont(new Font("Segoe UI Semibold", Font.BOLD, 18));
        lblOperacion.setBounds(879, 150, 377, 43);
        bg.add(lblOperacion);

        JLabel lblMatrices = new JLabel("Matrices");
        lblMatrices.setBounds(10, 5, 1264, 43);
        lblMatrices.setHorizontalAlignment(SwingConstants.CENTER);
        lblMatrices.setForeground(new Color(220, 220, 220));
        lblMatrices.setFont(new Font("Segoe UI Semibold", Font.BOLD, 24));
        bg.add(lblMatrices);

        JLabel lblDim1 = new JLabel("Filas Matriz 1:");
        lblDim1.setLocation(50, 150);
        lblDim1.setSize(180, 43);
        lblDim1.setHorizontalAlignment(SwingConstants.CENTER);
        lblDim1.setForeground(new Color(220, 220, 220));
        lblDim1.setFont(new Font("Segoe UI Semibold", Font.BOLD, 18));
        bg.add(lblDim1);

        textField_filas1 = new JTextField();
        textField_filas1.setSize(100, 43);
        textField_filas1.setHorizontalAlignment(SwingConstants.RIGHT);
        textField_filas1.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
        textField_filas1.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                textField_filas1.setBorder(BorderFactory.createLineBorder(new Color(97, 105, 120), 2));
            }

            @Override
            public void focusLost(FocusEvent e) {
                textField_filas1.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
            }
        });
        textField_filas1.setLocation(240, 150);
        bg.add(textField_filas1);
        textField_filas1.setColumns(10);

        JLabel lblColumnas1 = new JLabel("Columnas Matriz 1:");
        lblColumnas1.setLocation(50, 200);
        lblColumnas1.setSize(180, 43);
        lblColumnas1.setHorizontalAlignment(SwingConstants.CENTER);
        lblColumnas1.setForeground(new Color(220, 220, 220));
        lblColumnas1.setFont(new Font("Segoe UI Semibold", Font.BOLD, 18));
        bg.add(lblColumnas1);

        textField_columnas1 = new JTextField();
        textField_columnas1.setSize(100, 43);
        textField_columnas1.setHorizontalAlignment(SwingConstants.RIGHT);
        textField_columnas1.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
        textField_columnas1.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                textField_columnas1.setBorder(BorderFactory.createLineBorder(new Color(97, 105, 120), 2));
            }

            @Override
            public void focusLost(FocusEvent e) {
                textField_columnas1.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
            }
        });
        textField_columnas1.setLocation(240, 200);
        bg.add(textField_columnas1);
        textField_columnas1.setColumns(10);

        JLabel lblDim2 = new JLabel("Filas Matriz 2:");
        lblDim2.setLocation(370, 150);
        lblDim2.setSize(180, 43);
        lblDim2.setHorizontalAlignment(SwingConstants.CENTER);
        lblDim2.setForeground(new Color(220, 220, 220));
        lblDim2.setFont(new Font("Segoe UI Semibold", Font.BOLD, 18));
        bg.add(lblDim2);

        textField_filas2 = new JTextField();
        textField_filas2.setSize(100, 43);
        textField_filas2.setHorizontalAlignment(SwingConstants.RIGHT);
        textField_filas2.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
        textField_filas2.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                textField_filas2.setBorder(BorderFactory.createLineBorder(new Color(97, 105, 120), 2));
            }

            @Override
            public void focusLost(FocusEvent e) {
                textField_filas2.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
            }
        });
        textField_filas2.setLocation(560, 150);
        bg.add(textField_filas2);
        textField_filas2.setColumns(10);

        JLabel lblColumnas2 = new JLabel("Columnas Matriz 2:");
        lblColumnas2.setLocation(350, 200);
        lblColumnas2.setSize(200, 59);
        lblColumnas2.setHorizontalAlignment(SwingConstants.CENTER);
        lblColumnas2.setForeground(new Color(220, 220, 220));
        lblColumnas2.setFont(new Font("Segoe UI Semibold", Font.BOLD, 18));
        bg.add(lblColumnas2);

        textField_columnas2 = new JTextField();
        textField_columnas2.setSize(100, 43);
        textField_columnas2.setHorizontalAlignment(SwingConstants.RIGHT);
        textField_columnas2.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
        textField_columnas2.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                textField_columnas2.setBorder(BorderFactory.createLineBorder(new Color(97, 105, 120), 2));
            }

            @Override
            public void focusLost(FocusEvent e) {
                textField_columnas2.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
            }
        });
        textField_columnas2.setLocation(560, 204);
        bg.add(textField_columnas2);
        textField_columnas2.setColumns(10);

        ingresoMatrices = new JPanel();

        JButton btnContinuar = new JButton("Ingresar Dimensiones");
        createButton(btnContinuar);
        btnContinuar.setLocation(400, 270);
        btnContinuar.setSize(180, 40);
        btnContinuar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String inputFilas1 = textField_filas1.getText().trim();
                String inputColumnas1 = textField_columnas1.getText().trim();
                String inputFilas2 = textField_filas2.getText().trim();
                String inputColumnas2 = textField_columnas2.getText().trim();

                if (inputFilas1.isEmpty() || inputColumnas1.isEmpty() || inputFilas2.isEmpty() || inputColumnas2.isEmpty()) {
                    lblResultadoNum.setText("Por favor ingrese dimensiones válidas primero");
                    return;
                }
                try {
                    filas1 = Integer.parseInt(textField_filas1.getText());
                    columnas1 = Integer.parseInt(textField_columnas1.getText());
                    filas2 = Integer.parseInt(textField_filas2.getText());
                    columnas2 = Integer.parseInt(textField_columnas2.getText());
                    ingresoMatrices.removeAll();
                    matriz1 = new double[filas1][columnas1];
                    matriz2 = new double[filas2][columnas2];
                    textFields_m1 = new JTextField[filas1][columnas1];
                    textFields_m2 = new JTextField[filas2][columnas2];

                    ingresoMatrices.setLayout(null);
                    ingresoMatrices.setBackground(new Color(70, 70, 70));
                    ingresoMatrices.setPreferredSize(new Dimension(840 + columnas1, 50 + filas1 * 50));

                    if (scrollPane != null) {
                        bg.remove(scrollPane);
                    }

                    for (JTextField[] row : textFields_m1) {
                        for (JTextField textField : row) {
                            if (textField != null) {
                                bg.remove(textField);
                            }
                        }
                    }
                    for (JTextField[] row : textFields_m2) {
                        for (JTextField textField : row) {
                            if (textField != null) {
                                bg.remove(textField);
                            }
                        }
                    }

                    for (int i = 0; i < filas1; i++) {
                        for (int j = 0; j < columnas1; j++) {
                            textFields_m1[i][j] = new JTextField();
                            configurarEstilo(textFields_m1[i][j]);
                            textFields_m1[i][j].setLocation(50 + j * 60, 50 + i * 50);
                            textFields_m1[i][j].setSize(50, 30);
                            ingresoMatrices.add(textFields_m1[i][j]);
                        }
                    }

                    for (int i = 0; i < filas2; i++) {
                        for (int j = 0; j < columnas2; j++) {
                            textFields_m2[i][j] = new JTextField();
                            configurarEstilo(textFields_m2[i][j]);
                            textFields_m2[i][j].setLocation(350 + j * 60, 50 + i * 50);
                            textFields_m2[i][j].setSize(50, 30);
                            ingresoMatrices.add(textFields_m2[i][j]);
                        }
                    }

                    scrollPane = new JScrollPane(ingresoMatrices);
                    scrollPane.setBounds(20, 320, 800, 300);
                    scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
                    scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
                    scrollPane.setBorder(BorderFactory.createLineBorder(new Color(70, 70, 70)));

                    bg.add(scrollPane);

                    JLabel lblMatriz1 = new JLabel("Matriz 1");
                    lblMatriz1.setHorizontalAlignment(SwingConstants.CENTER);
                    lblMatriz1.setForeground(new Color(220, 220, 220));
                    lblMatriz1.setFont(new Font("Segoe UI Semibold", Font.BOLD, 16));
                    lblMatriz1.setLocation(52, 10);
                    lblMatriz1.setSize(100, 43);
                    ingresoMatrices.add(lblMatriz1);

                    JLabel lblMatriz2 = new JLabel("Matriz 2");
                    lblMatriz2.setHorizontalAlignment(SwingConstants.CENTER);
                    lblMatriz2.setForeground(new Color(220, 220, 220));
                    lblMatriz2.setFont(new Font("Segoe UI Semibold", Font.BOLD, 16));
                    lblMatriz2.setLocation(352, 10);
                    lblMatriz2.setSize(100, 43);
                    ingresoMatrices.add(lblMatriz2);

                    bg.add(btnLimpiar);

                    bg.revalidate();
                    bg.repaint();
                } catch (NumberFormatException ex) {
                    lblResultadoNum.setText("Por favor ingrese dimensiones válidas primero");
                }
            }
        });
        bg.add(btnContinuar);

        JButton btnSuma = new JButton("Suma");
        btnSuma.setLocation(883, 204);
        btnSuma.setSize(180, 40);
        createButton(btnSuma);

        btnSuma.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (filas1 > 0 && columnas1 > 0 && filas2 > 0 && columnas2 > 0 && textFields_m1 != null && textFields_m2 != null) {
                    try {
                        matriz1 = obtenerMatrizDesdeJTextField(textFields_m1);
                        matriz2 = obtenerMatrizDesdeJTextField(textFields_m2);

                        if (matriz1 == null || matriz2 == null) {
                            lblResultadoNum.setText("Por favor ingrese números válidos en todos los campos");
                        } else if (matriz1.length != matriz2.length || matriz1[0].length != matriz2[0].length) {
                            lblResultadoNum.setText("Las matrices deben tener las mismas dimensiones para sumarlas");
                        } else {
                            double[][] resultado = MatricesLogica.sumaMatrices(matriz1, matriz2);
                            lblResultadoNum.setText("" + Arrays.deepToString(resultado));
                        }
                    } catch (NumberFormatException e1) {
                        lblResultadoNum.setText("Por favor ingrese números válidos en todos los campos");
                    }
                } else {
                    lblResultadoNum.setText("Por favor ingrese dimensiones válidas primero");
                }
            }
        });
        bg.add(btnSuma);

        JButton btnResta = new JButton("Resta");
        btnResta.setLocation(1083, 204);
        btnResta.setSize(180, 40);
        createButton(btnResta);
        btnResta.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (filas1 > 0 && columnas1 > 0 && filas2 > 0 && columnas2 > 0 && textFields_m1 != null && textFields_m2 != null) {
                    try {
                        matriz1 = obtenerMatrizDesdeJTextField(textFields_m1);
                        matriz2 = obtenerMatrizDesdeJTextField(textFields_m2);

                        if (matriz1 == null || matriz2 == null) {
                            lblResultadoNum.setText("Por favor ingrese números válidos en todos los campos");
                        } else if (matriz1.length != matriz2.length || matriz1[0].length != matriz2[0].length) {
                            lblResultadoNum.setText("Las matrices deben tener las mismas dimensiones para restarlas");
                        } else {
                            double[][] resultado = MatricesLogica.restaMatrices(matriz1, matriz2);
                            lblResultadoNum.setText("" + Arrays.deepToString(resultado));
                        }
                    } catch (NumberFormatException e1) {
                        lblResultadoNum.setText("Por favor ingrese números válidos en todos los campos");
                    }
                } else {
                    lblResultadoNum.setText("Por favor ingrese dimensiones válidas primero");
                }
            }
        });
        bg.add(btnResta);

        JButton btnMultiplicacionEscalar = new JButton("Multiplicacion Escalar");
        btnMultiplicacionEscalar.setLocation(883, 281);
        btnMultiplicacionEscalar.setSize(180, 40);
        createButton(btnMultiplicacionEscalar);
        btnMultiplicacionEscalar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String textoEscalar = txtFieldEscalar.getText();
                if (textoEscalar.isEmpty()) {
                    lblResultadoNum.setText("Ingrese un escalar valido");
                }
                if (filas1 > 0 && columnas1 > 0 && textFields_m1 != null) {
                    try {
                        matriz1 = obtenerMatrizDesdeJTextField(textFields_m1);
                        escalar = Double.parseDouble(textoEscalar);

                        if (matriz1 == null) {
                            lblResultadoNum.setText("Por favor ingrese números válidos en todos los campos");
                        } else {
                            double[][] resultado = MatricesLogica.multiplicacionEscalarPorMatriz(escalar, matriz1);
                            lblResultadoNum.setText("" + Arrays.deepToString(resultado));
                        }
                    } catch (NumberFormatException e1) {
                        lblResultadoNum.setText("Por favor ingrese números válidos en todos los campos o ingrese escalar valido");
                    }
                } else {
                    lblResultadoNum.setText("Por favor ingrese dimensiones válidas primero");
                }
            }
        });
        bg.add(btnMultiplicacionEscalar);

        JButton btnProductoMatrices = new JButton("Multiplicacion");
        btnProductoMatrices.setLocation(1083, 281);
        btnProductoMatrices.setSize(180, 40);
        createButton(btnProductoMatrices);
        btnProductoMatrices.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (filas1 > 0 && columnas1 > 0 && filas2 > 0 && columnas2 > 0 && textFields_m1 != null && textFields_m2 != null) {
                    try {
                        matriz1 = obtenerMatrizDesdeJTextField(textFields_m1);
                        matriz2 = obtenerMatrizDesdeJTextField(textFields_m2);

                        if (matriz1 == null || matriz2 == null) {
                            lblResultadoNum.setText("Por favor ingrese números válidos en todos los campos");
                        } else if (matriz1[0].length != matriz2.length) {
                            lblResultadoNum.setText("El número de columnas de la primera matriz debe ser igual al número de filas de la segunda matriz");
                        } else {
                            double[][] resultado = MatricesLogica.productoMatrices(matriz1, matriz2);
                            lblResultadoNum.setText("" + Arrays.deepToString(resultado));
                        }
                    } catch (NumberFormatException e1) {
                        lblResultadoNum.setText("Por favor ingrese números válidos en todos los campos");
                    }
                } else {
                    lblResultadoNum.setText("Por favor ingrese dimensiones válidas primero");
                }
            }
        });
        bg.add(btnProductoMatrices);

        JButton btnDivisionMatrices = new JButton("Division");
        btnDivisionMatrices.setLocation(883, 355);
        btnDivisionMatrices.setSize(180, 40);
        createButton(btnDivisionMatrices);
        btnDivisionMatrices.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (filas1 > 0 && columnas1 > 0 && filas2 > 0 && columnas2 > 0 && textFields_m1 != null && textFields_m2 != null) {
                    try {
                        matriz1 = obtenerMatrizDesdeJTextField(textFields_m1);
                        matriz2 = obtenerMatrizDesdeJTextField(textFields_m2);

                        if (matriz1 == null || matriz2 == null) {
                            lblResultadoNum.setText("Por favor ingrese números válidos en todos los campos");
                        } else if (matriz2.length != matriz2[0].length) {
                            lblResultadoNum.setText("La segunda matriz debe ser cuadrada para poder calcular su inversa");
                        } else {
                            double[][] inversaMatriz2 = MatricesLogica.inversaMatriz(matriz2);
                            if (inversaMatriz2 == null) {
                                lblResultadoNum.setText("La segunda matriz no tiene inversa");
                            } else if (matriz1[0].length != inversaMatriz2.length) {
                                lblResultadoNum.setText("El número de columnas de la primera matriz debe ser igual al número de filas de la inversa de la segunda matriz");
                            } else {
                                double[][] resultado = MatricesLogica.productoMatrices(matriz1, inversaMatriz2);
                                lblResultadoNum.setText("" + Arrays.deepToString(resultado));
                            }
                        }
                    } catch (NumberFormatException e1) {
                        lblResultadoNum.setText("Por favor ingrese números válidos en todos los campos");
                    }
                } else {
                    lblResultadoNum.setText("Por favor ingrese dimensiones válidas primero");
                }
            }
        });
        bg.add(btnDivisionMatrices);

        JButton btnInversaMatriz = new JButton("Inversa");
        btnInversaMatriz.setLocation(1083, 355);
        btnInversaMatriz.setSize(180, 40);
        createButton(btnInversaMatriz);
        btnInversaMatriz.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (filas1 > 0 && columnas1 > 0 && textFields_m1 != null) {
                    try {
                        matriz1 = obtenerMatrizDesdeJTextField(textFields_m1);

                        if (matriz1 == null) {
                            lblResultadoNum.setText("Por favor ingrese números válidos en todos los campos. Inversa solo se hace con matriz 1");
                        } else if (matriz1.length != matriz1[0].length) {
                            lblResultadoNum.setText("La matriz debe ser cuadrada para encontrar su inversa");
                        } else {
                            double[][] resultado = MatricesLogica.inversaMatriz(matriz1);
                            if (resultado == null) {
                            	lblResultadoNum.setText("El determinante de la matriz es 0, no es invertible");
                            } else {
                            	lblResultadoNum.setText("" + Arrays.deepToString(resultado));
                            }
                        }
                    } catch (NumberFormatException e1) {
                        lblResultadoNum.setText("Por favor ingrese números válidos en todos los campos");
                    }
                } else {
                    lblResultadoNum.setText("Por favor ingrese dimensiones válidas primero");
                }
            }
        });
        bg.add(btnInversaMatriz);

        JButton btnDeterminanteMatriz = new JButton("Determinante");
        btnDeterminanteMatriz.setLocation(883, 433);
        btnDeterminanteMatriz.setSize(180, 40);
        createButton(btnDeterminanteMatriz);
        btnDeterminanteMatriz.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (filas1 > 0 && columnas1 > 0 && textFields_m1 != null) {
                    try {
                        matriz1 = obtenerMatrizDesdeJTextField(textFields_m1);

                        if (matriz1 == null) {
                            lblResultadoNum.setText("Por favor ingrese números válidos en todos los campos");
                        } else if (matriz1.length != matriz1[0].length) {
                            lblResultadoNum.setText("La matriz debe ser cuadrada para encontrar su determinante");
                        } else {
                            double resultado = MatricesLogica.determinanteMatriz(matriz1);
                            lblResultadoNum.setText("" + resultado);
                        }
                    } catch (NumberFormatException e1) {
                        lblResultadoNum.setText("Por favor ingrese números válidos en todos los campos");
                    }
                } else {
                    lblResultadoNum.setText("Por favor ingrese dimensiones válidas primero");
                }
            }
        });
        bg.add(btnDeterminanteMatriz);

        btnLimpiar.setLocation(1083, 433);
        btnLimpiar.setSize(180, 40);
        createButton(btnLimpiar);
        btnLimpiar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textField_filas1.setText("");
                textField_columnas1.setText("");
                textField_filas2.setText("");
                textField_columnas2.setText("");
                txtFieldEscalar.setText("");
                lblResultadoNum.setText("");
                for (JTextField[] row : textFields_m1) {
                    for (JTextField textField : row) {
                        if (textField != null) {
                            textField.setText("");
                        }
                    }
                }
                for (JTextField[] row : textFields_m2) {
                    for (JTextField textField : row) {
                        if (textField != null) {
                            textField.setText("");
                        }
                    }
                }
            }
        });
        bg.add(btnLimpiar);
        

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

    private double[][] obtenerMatrizDesdeJTextField(JTextField[][] textFields) {
        double[][] matriz = new double[textFields.length][textFields[0].length];
        for (int i = 0; i < textFields.length; i++) {
            for (int j = 0; j < textFields[i].length; j++) {
                matriz[i][j] = Double.parseDouble(textFields[i][j].getText().trim());
            }
        }
        return matriz;
    }
}
