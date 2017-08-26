/**
 * 
 */

package net.starcup.models;


/**
 * @author simone
 *
 */
public class Gruppo extends StarcupModel {
//	public static final String selectSQL = "Select * From Gruppo Order by IdGruppo asc";
	
	private long idgruppo;
	private String denominazione;
	private int up;
	private int zp;

	public long getIdGruppo() {
		return idgruppo;
	}

	public void setIdGruppo(long idgruppo) {
		this.idgruppo = idgruppo;
	}

	public String getDenominazione() {
		return denominazione;
	}

	public void setDenominazione(String denominazione) {
		this.denominazione = denominazione;
	}

	public int getUP() {
		return up;
	}

	public void setUP(int up) {
		this.up = up;
	}

	public int getZP() {
		return zp;
	}

	public void setZP(int zp) {
		this.zp = zp;
	}

	
	public Gruppo () {
		super();
	}
	
	/**
	 * @param idsquadra
	 * @param nomesquadra
	 * @param tipologia
	 * @param codgruppo
	 * @param codreferente
	 * @param codutente
	 * @param stemma
	 * @param codicesquadra
	 */
	public Gruppo(long idgruppo, String denominazione, int up, int zp) {
		super();
		this.idgruppo = idgruppo;
		this.denominazione = denominazione;
		this.up = up;
		this.zp = zp;
	}

	

	
	
}


