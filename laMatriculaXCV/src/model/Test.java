package model;
import java.awt.*;

import view.View;
import controller.ActionListeners;


public class Test {

	/**
	 * Launch the application.
	 *@author Xavier Coll Vilafranca
	 *@version 1.1 09-11-2023
	 * @see view.View
	 * @see controller.ActionListeners
	 * @see model.CursIAssignatures
	 *
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					View window = new View();
					window.frame.setVisible(true);

					/*
					 * Calls the method *buttons* (with its path) 
					 * with a local acitonListeners (which is grabbing the info from that class)
					 */
					ActionListeners actionListeners = new ActionListeners();
					actionListeners.buttons();

					/*
					 * We need to initialize the assignatures first
					 */
					model.CursIAssignatures.assignatures();

				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
		});
	}





}
