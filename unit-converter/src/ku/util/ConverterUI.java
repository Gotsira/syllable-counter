package ku.util;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import javax.swing.*;

/**
 * Java UI for the unit converter.
 * 
 * @author Sirasath Piyapootinun
 *
 */
public class ConverterUI extends JFrame {
	private JTextField input;
	private JTextField output;
	private JMenuBar menuBar;
	private JComboBox<Unit> inputBox;
	private JComboBox<Unit> outputBox;
	private JButton convert;
	private JButton clear;
	private JLabel equals;
	private JMenu menu;
	private DecimalFormat df;
	private UnitConverter converter;

	/**
	 * Constructor to initialize the UI.
	 * 
	 * @param converter
	 *            is the converter for the units.
	 */
	public ConverterUI(UnitConverter converter) {
		super("Unit Converter");
		this.converter = converter;
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		initComponents();
	}

	/**
	 * Initialize and add actions for the components of the ConverterUI.
	 */
	public void initComponents() {
		this.setLocation(500, 500);
		this.setLayout(new GridLayout());
		menuBar = new JMenuBar();
		menu = new JMenu("Unit Type");
		equals = new JLabel("=");
		equals.setHorizontalAlignment(JTextField.CENTER);
		input = new JTextField(5);
		output = new JTextField(5);
		inputBox = new JComboBox();
		outputBox = new JComboBox();
		convert = new JButton("Convert!");
		clear = new JButton("Clear");
		df = new DecimalFormat("0.000");

		for (UnitType utype : UnitType.class.getEnumConstants()) {
			JMenuItem menuItem = new JMenuItem(utype.name());
			menuItem.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					inputBox.removeAllItems();
					outputBox.removeAllItems();
					input.setText("");
					output.setText("");
					Unit[] units = converter.getUnits(utype);
					for (Unit name : units) {
						inputBox.addItem(name);
						outputBox.addItem(name);
					}
				}
			});

			menu.add(menuItem);
		}

		JMenuItem exit = new JMenuItem("Exit");

		exit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		menu.add(exit);

		convert.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Unit in = (Unit) inputBox.getSelectedItem();
				Unit out = (Unit) outputBox.getSelectedItem();
				double amount;
				String result;
				try {
					amount = Double.parseDouble(input.getText());
					result = df.format(converter.convert(amount, in, out));
					output.setText(result);
					input.setForeground(Color.BLACK);
				} catch (RuntimeException e2) {
					input.setForeground(Color.RED);
				}
				if (input.getText().equals("") && !output.getText().equals("")) {
					try {
						input.setForeground(Color.BLACK);
						output.setForeground(Color.BLACK);
						amount = Double.parseDouble(output.getText());
						result = df.format(converter.convert(amount, out, in));
						input.setText(result);
					} catch (RuntimeException e1) {
						output.setForeground(Color.RED);
					}
				} else if (input.getText().equals("") && output.getText().equals("")) {
					input.setForeground(Color.BLACK);
				}

			}
		});

		clear.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				input.setText("");
				output.setText("");
			}
		});

		menuBar.add(menu);
		this.setJMenuBar(menuBar);
		this.add(input);
		this.add(inputBox);
		this.add(equals);
		this.add(output);
		this.add(outputBox);
		this.add(convert);
		this.add(clear);

		this.pack();

	}
	
	/**
	 * Runs the ConverterUI.
	 */
	void run() {
		this.setVisible(true);
	}

//	public static void main(String[] args) {
//		UnitConverter c = new UnitConverter();
//		ConverterUI ui = new ConverterUI(c);
//		ui.run();
//	}
}
