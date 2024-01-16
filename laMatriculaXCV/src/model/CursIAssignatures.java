package model;


import java.util.*;

/**
 * @author Xavier Coll Vilafranca
 * @version 1.1
 */

public class CursIAssignatures {

	/*
	 * Each hashmap will contain its corresponding subjects
	 * 	 */
	public static String[] cursos;
	public static HashMap<String, Integer> aSMX1;
	public static HashMap<String, Integer> aSMX2;
	public static HashMap<String, Integer> aDAW1;
	public static HashMap<String, Integer> aDAW2;
	public static HashMap<String, Integer> aDAM1;
	public static HashMap<String, Integer> aDAM2;



	/*
	 * We'll use this map in the combobox for the users to select th subjects
	 */
	public static void cursos() {

		cursos = new String[] {"-- Tria un curs -- ","CFGM SMX1", "CFGM SMX2", "CFGS DAW1","CFGS DAW2", "CFGS DAM1","CFGS DAM2" };

	}


	/*
	 *  assigns each course map its subjects
	 *	Because this way we can easily add them to the combobox when they choose the course
	 */
	public static void assignatures() {


		aSMX1 = new HashMap<String, Integer>();
		aSMX1.put("Muntatje i manteniment", 14);
		aSMX1.put("Xarxes Locals", 14);
		aSMX1.put("Aplicacions Ofimàtiques", 16);
		aSMX1.put("Sistemes operatius monousuari", 10);
		aSMX1.put("Formació i orientació laboral", 6);



		aSMX2 = new HashMap<String, Integer>();
		aSMX2.put("Seguretat Informàtica", 6);
		aSMX2.put("Web", 5);
		aSMX2.put("Serveis en Xarxa", 8);
		aSMX2.put("Sistemes operatius en xarxa", 8);
		aSMX2.put("Empresa i iniciativa emprenedora", 3);



		aDAW1 = new HashMap<String, Integer>();

		aDAW1.put("Sistemes informàtics", 10);
		aDAW1.put("Programació", 14);
		aDAW1.put("Entorns de desenvolupament", 6);
		aDAW1.put("Llenguatge de marques", 8);
		aDAW1.put("Base de dades", 16);
		aDAW1.put("Formació i orientació laboral", 6);

		aDAW2 = new HashMap<String, Integer>();
		aDAW2.put("Web entorn client", 6);
		aDAW2.put("Web entorn servidor", 8);
		aDAW2.put("Desplegament web", 5);
		aDAW2.put("Disseny d'interficies", 8);
		aDAW2.put("Empresa i iniciativa emprenedora", 3);
		aDAW2.put("FCT", 27);
		aDAW2.put("Projecte empresarial", 3);



		aDAM1 = new HashMap<String, Integer>();
		aDAM1.put("Sistemes informàtics", 10);
		aDAM1.put("Programació", 14);
		aDAM1.put("Entorns de desenvolupament", 6);
		aDAM1.put("Llenguatge de marques", 8);
		aDAM1.put("Base de dades", 16);
		aDAM1.put("Formació i orientació laboral", 6);

		aDAM2 = new HashMap<String, Integer>();
		aDAM2.put("Desenvolupament d'interficies", 8);
		aDAM2.put("Programació Android", 4);
		aDAM2.put("Programació de serveis i processos", 4);
		aDAM2.put("Gestió empresarial", 5);
		aDAM2.put("Accés a dades", 6);
		aDAM2.put("Empresa i iniciativa emprenedora", 3);
		aDAM2.put("FCT", 27);
		aDAM2.put("Projecte empresarial", 3);





	}
}
