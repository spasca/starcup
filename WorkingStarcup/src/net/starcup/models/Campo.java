package net.starcup.models;

import javax.xml.bind.annotation .*;


import java.io.Serializable;

@XmlRootElement
public class Campo extends StarcupModel implements Serializable {
//	private static final long serialVersionUID = -1916838823334733330L;

	@XmlElement(name="idcampo")
	private long idcampo = 0;
	@XmlElement(name="denominazione")
	private String denominazione = null;
	@XmlElement(name="foto")
	private String foto = null;
	@XmlElement(name="gpslat")
	private float gpslat = 0.0f;
	@XmlElement(name="gpslon")
	private float gpslon = 0.0f;
	
	
	public long getIdcampo() {
		return idcampo;
	}
	public void setIdcampo(long idcampo) {
		this.idcampo = idcampo;
	}
	public String getDenominazione() {
		return denominazione;
	}
	public void setDenominazione(String denominazione) {
		this.denominazione = denominazione;
	}
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}
	public float getGpslat() {
		return gpslat;
	}
	public void setGpslat(float gpslat) {
		this.gpslat = gpslat;
	}
	public float getGpslon() {
		return gpslon;
	}
	public void setGpslon(float gpslon) {
		this.gpslon = gpslon;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	/**
	 * 
	 */
	public Campo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Campo(long idcampo, String denominazione, String foto, float gpslat, 
			float gpslon) {
		super();

		this.setIdcampo(idcampo);
		this.setDenominazione(denominazione);
		this.setFoto(foto);
		this.setGpslat(gpslat);
		this.setGpslon(gpslon);
		
	}
	
	
}
