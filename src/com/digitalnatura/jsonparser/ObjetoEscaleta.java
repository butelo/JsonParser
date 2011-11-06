package com.digitalnatura.jsonparser;

public class ObjetoEscaleta {

	String intext = null;
	String dianoche = null;
	String lugar = null;
	String accion = null;
	String personajes = null;
	
	
	public ObjetoEscaleta( String pIntExt, 
			String pDiaNoche, String pLugar,String pAccion, String pPersonaje
			) {

		this.intext = pIntExt;
		this.dianoche = pDiaNoche;
		this.lugar = pLugar;

		this.accion = pAccion;
		this.personajes = pPersonaje;


	}

	public String getIntext() {
		return intext;
	}

	public void setIntext(String intext) {
		this.intext = intext;
	}

	public String getDianoche() {
		return dianoche;
	}

	public void setDianoche(String dianoche) {
		this.dianoche = dianoche;
	}

	public String getLugar() {
		return lugar;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}

	public String getAccion() {
		return accion;
	}

	public void setAccion(String accion) {
		this.accion = accion;
	}

	public String getPersonajes() {
		return personajes;
	}

	public void setPersonajes(String personajes) {
		this.personajes = personajes;
	}

	@Override
	public String toString() {
		return "ObjetoEscaleta [intext=" + intext + ", dianoche=" + dianoche
				+ ", lugar=" + lugar + ", accion=" + accion + ", personajes="
				+ personajes + "]";
	}

}
