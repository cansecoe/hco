package com.hitss.swf.hco.catalogo.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hitss.swf.hco.catalogo.service.Constantes;

public class Prueba {

	public static void main(String[] args) {
		SimpleDateFormat formatter = new SimpleDateFormat(Constantes.FORMATO_FECHA_FILTRO);
		try {
			calcularHorasHabiles(formatter.parse("2015 03"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static List<Integer> calcularHorasHabiles(Date mes) {
		Map<Integer, Integer> horas = crearMapa();
		Calendar inicio = Calendar.getInstance();
		inicio.setTime(mes);

		Calendar fin = Calendar.getInstance();
		fin.setTime(mes);
		fin.set(Calendar.DAY_OF_MONTH, inicio.getActualMaximum(Calendar.DAY_OF_MONTH));

		Integer semana = 1;
		Integer diaASumar = 1;

		while (inicio.getTimeInMillis() <= fin.getTimeInMillis()) {
			
			if (inicio.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY
					&& inicio.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY) {
				sumarHora(semana, horas);
				diaASumar = 1;
			} else {
				diaASumar = 2;
				semana++;
			}
			inicio.add(Calendar.DAY_OF_MONTH, diaASumar);
		} 

		return new ArrayList<Integer>(horas.values());
	}

	private static void sumarHora(Integer semana, Map<Integer, Integer> horas) {
		horas.put(semana, horas.get(semana) + 8);
	}

	private static Map<Integer, Integer> crearMapa() {
		Map<Integer, Integer> response = new HashMap<Integer, Integer>(5);
		for(int  i = 1 ; i <= 5 ; i++) {
			response.put(i, 0);
		}
		return response;
	}

}
