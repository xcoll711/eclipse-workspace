package model;

import javax.swing.*;
import java.util.*;

import view.View;

/**
 * This class contains static methods related to handling assignments and credits.
 * 
 *@author Xavier Coll Vilafranca
 *@version 1.1 09-11-2023
 *@see view.View
 *@see model.CursIAssignatures#cursos()
 */



/*
 * "If your program isn't worth documenting, it probably isn't worth running"
 * J. Nagler. 1995
 * Coding Style and Good Computing Practices
*/
public class Functions {

	/**
	 * Adds a selected subject to the JTextArea and updates the total credits.
	 *
	 * @param selectedItem The selected item from the JComboBox.
	 * @param taPreuCredit The JTextArea for entering credit price.
	 * @param lblPreuTotal The JLabel for displaying total price.
	 * @param credits      List to store credits of selected subjects.
	 * 
	 * @throws NumberFormatException If the creditString cannot be parsed to a valid double.
	 * @throws NullPointerException   If the selected item is null.
	 */
	public static void addAssignatura(String selectedItem, JTextArea taPreuCredit, JLabel lblPreuTotal, ArrayList<Double> credits) {
		try {
			// Check if the selected item is valid and not already added
			if (!View.taAssignatures.getText().contains(selectedItem) && selectedItem != null && !selectedItem.trim().isEmpty()) {
				View.taAssignatures.append(selectedItem + "\n");

				// Obtains the number of credits if available
				String creditString = selectedItem.substring(selectedItem.indexOf(":") + 2).trim();

				// Check if creditString is not null or empty before parsing it
				if (!creditString.isEmpty()) {
					try {
						double credit = Double.parseDouble(creditString);
						credits.add(credit);

						// Update the sum of credits using the method
						updateSumCredits(credits, taPreuCredit, lblPreuTotal);

					} catch (NumberFormatException ex) {
						System.err.println("Invalid credit value: " + creditString + " is not a number.");
					}
				} else {
					System.err.println("-- Credit value is empty.");
				}
			} else {
				System.err.println("-- Selected item is null, empty or already used.");
			}
		} catch (NullPointerException ex) {
			System.err.println("-- Selected item is empty.");
		} catch (Exception ex) {
			System.err.println(ex.getMessage());
		}
	}

	/**
	 * Resets the user interface elements and data structures.
	 *
	 * @param cbCurs      The JComboBox for selecting courses.
	 * @param assignatures A HashMap storing assignments for a selected course.
	 * @param credits      List to store credits of selected subjects.
	 * 
	 */
	public static void reinicia(JComboBox<String> cbCurs, HashMap<String, Integer> assignatures, ArrayList<Double> credits) {
		try {
			// Reset all user interface elements and data structures to default values
			cbCurs.setSelectedIndex(0);
			View.cbAssignatures.removeAllItems();
			assignatures.clear();
			credits.clear();
			View.lblPreuTotal.setText("Preu Total = 0.0 €");
			View.taAssignatures.setText(null);

		} catch (Exception ex) {
			System.err.println(ex.getMessage());
		}
	}

	/**
	 * Shows the assignments based on the selected course.
	 *
	 * @param cbCurs      The JComboBox for selecting courses.
	 * @param assignatures A HashMap storing assignments for a selected course.
	 * 
	 * @throws NullPointerException If a NullPointerException occurs during the assignment retrieval process.
	 */
	public static void chooseCursAndAssignatura(JComboBox<String> cbCurs, HashMap<String, Integer> assignatures) {
		try {
			int i = 0;

			// Restart everything before putting all the new assignments
			View.cbAssignatures.removeAllItems();
			assignatures.clear();

			// Gets the selected course and puts all the assignments inside it
			int selected = cbCurs.getSelectedIndex();
			switch (selected) {
			case 1 -> assignatures.putAll(CursIAssignatures.aSMX1);
			case 2 -> assignatures.putAll(CursIAssignatures.aSMX2);
			case 3 -> assignatures.putAll(CursIAssignatures.aDAW1);
			case 4 -> assignatures.putAll(CursIAssignatures.aDAW2);
			case 5 -> assignatures.putAll(CursIAssignatures.aDAM1);
			case 6 -> assignatures.putAll(CursIAssignatures.aDAM2);
			}

			// Insert each assignment one by one into the JComboBox
			for (String icurs : assignatures.keySet()) {
				View.cbAssignatures.addItem(icurs + " - Credits: " + assignatures.get(icurs) + " ");
				i++;
			}

			// Handle potential null pointer exception by ignoring it
		} catch (NullPointerException ex) {

			// Catch and handle other exceptions
		} catch (Exception ex) {
			System.err.println(ex.getMessage());
		}
	}

	/**
	 * Updates the total credits based on the selected subjects and credit price.
	 *
	 * @param credits       List of credits of selected subjects.
	 * @param taPreuCredit  The JTextArea for entering credit price.
	 * @param lblPreuTotal  The JLabel for displaying total price.
	 * @throws NumberFormatException If the credit price cannot be parsed to a valid double.
	 */
	public static void updateSumCredits(ArrayList<Double> credits, JTextArea taPreuCredit, JLabel lblPreuTotal) {

		double sumCredits = 0;

		// Calculate the total sum of credits
		for (Double c : credits) {
			sumCredits += c;
		}

		try {
			// Parse the credit price from the JTextArea
			double preuCredits = Double.parseDouble(taPreuCredit.getText());

			// Calculate the total price and update the JLabel
			lblPreuTotal.setText("Preu Total = " + String.valueOf(sumCredits * preuCredits > 0 ? preuCredits * sumCredits : 0) + " €");
		} catch (NumberFormatException ex) {
			lblPreuTotal.setText("Preu Total = 0.0 €");
			System.err.println("Invalid preuCredit value: " + taPreuCredit.getText());
		}
	}
	
	/**
	 * Fill the ComboBox cbCurs with the array cursos declared in model.CursIAssignatures
	 */
	public static void fillCbCurs() {
		// Initialize the available courses
	    model.CursIAssignatures.cursos();
	    
	    for(String icurs : model.CursIAssignatures.cursos) {
	        View.cbCurs.addItem(icurs);
	    }
	}
}
