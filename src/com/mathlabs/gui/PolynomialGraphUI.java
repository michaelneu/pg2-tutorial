package com.mathlabs.gui;

import com.mathlabs.drawing.Canvas;
import com.mathlabs.graphs.*;
import com.mathlabs.graphs.Point;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

public class PolynomialGraphUI extends JFrame {
    private static final int GRID_GAP = 10;

    private List<JFormattedTextField> inputs;
    private JFrame frame = this;

    public PolynomialGraphUI() {
        this.inputs = new ArrayList<>();

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout(GRID_GAP, GRID_GAP));

        // create inputs area

        JPanel inputsPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, GRID_GAP, GRID_GAP));
        this.add(inputsPanel, BorderLayout.WEST);

        // create degree input
        JPanel degreePanel = new JPanel(new GridLayout(1, 2, GRID_GAP, GRID_GAP));
        degreePanel.add(new JLabel(" Degree: "));

        JSpinner degreeInput = new JSpinner(new SpinnerNumberModel(0, 0, 10, 1));
        degreeInput.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent changeEvent) {
                for (Component component : inputsPanel.getComponents()) {
                    inputsPanel.remove(component);
                }

                int degree = (int)degreeInput.getValue() + 1;

                inputs.clear();

                inputsPanel.add(new JLabel("f(x) = "));

                NumberFormat format = NumberFormat.getNumberInstance();
                format.setGroupingUsed(false);

                for (int i = 0; i < degree; i++) {
                    JFormattedTextField field = new JFormattedTextField(format);
                    field.setColumns(3);

                    inputs.add(field);
                    inputsPanel.add(field);

                    int exponent = degree - i - 1;

                    if (exponent != 0) {
                        inputsPanel.add(new JLabel("<html>x<sup>" + exponent + "</sup> + "));
                    }
                }

                // force-render the inputs
                inputsPanel.revalidate();

                // resize the window to fit all text fields
                frame.pack();
            }
        });

        degreePanel.add(degreeInput);

        this.add(degreePanel, BorderLayout.NORTH);

        // create draw button
        JButton drawButton = new JButton("Draw");
        drawButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    double[] values = new double[inputs.size()];

                    for (int i = 0; i < inputs.size(); i++) {
                        JFormattedTextField field = inputs.get(i);
                        String text = field.getText().trim();

                        if (text.length() == 0) {
                            values[i] = 0;
                        } else {
                            values[i] = Double.parseDouble(text);
                        }
                    }

                    Canvas canvas = new Canvas(300, 300, new Point(-1, 1), new Point(1, -1));

                    canvas.setBackground("white");
                    canvas.draw(new Polynomial(values), "black");
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(frame, "Something happened", "Something happened", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        this.add(drawButton, BorderLayout.SOUTH);

        // create initial input controls
        degreeInput.setValue(1);

        this.pack();
    }
}
