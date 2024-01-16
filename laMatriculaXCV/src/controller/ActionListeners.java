package controller;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import model.Functions;
import view.View;

/**
 * This class contains ActionListeners for the GUI components in the application.
 *@author Xavier Coll Vilafranca
 *@version 1.1 09-11-2023
 *@see model.Functions
 *@see view.View
 * @see model.Functions#addAssignatura(String, JTextArea, JLabel, ArrayList)
 * @see model.Functions#reinicia(JComboBox, HashMap, ArrayList)
 * @see model.Functions#chooseCursAndAssignatura(JComboBox, HashMap)
 * @see model.Functions#updateSumCredits(ArrayList, JTextArea, JLabel)
 */
public class ActionListeners {

	// Declarations
	private HashMap<String, Integer> assignatures = new HashMap<>();
	private ArrayList<Double> credits = new ArrayList<>();

	/**
	 * Attaches ActionListeners to the buttons and other GUI components.
	 * We use ActionListener for buttons to capture user interactions.
	 */
	public void buttons() {

		// ActionListener for the "Afegeix" button
		View.btnAfegeix.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Grabs the selected item from the comboBox Assignatures and inserts it in the String
				String selectedItem = (String) View.cbAssignatures.getSelectedItem();

				// Calls the addAssignatura method to handle adding the selected item and updating credits
				Functions.addAssignatura(selectedItem, View.taPreuCredit, View.lblPreuTotal, credits);
			}
		});

		// ActionListener for the "Reinicia" button
		View.btnReinicia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Calls the reinicia method to reset the GUI components and data structures
				Functions.reinicia(View.cbCurs, assignatures, credits);
			}
		});

		// ActionListener for the JComboBox "cbCurs"
		View.cbCurs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Calls the chooseCursAndAssignatura method to update the assignments based on the selected course
				Functions.chooseCursAndAssignatura(View.cbCurs, assignatures);
			}
		});

		// DocumentListener for the JTextArea "taPreuCredit"
		View.taPreuCredit.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				// Calls the actualizarLabel method to update the total price when text is inserted
				actualizarLabel();
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				// Calls the actualizarLabel method to update the total price when text is removed
				actualizarLabel();
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				// We don't need this for the textarea, so no action is taken
			}

			private void actualizarLabel() {
				// Calls the updateSumCredits method to update the total price based on entered credits and price per credit
				Functions.updateSumCredits(credits, View.taPreuCredit, View.lblPreuTotal);
			}
		});
	}
}
