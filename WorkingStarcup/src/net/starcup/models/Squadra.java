/**
 * 
 */

package net.starcup.models;

//import java.sql.*;

 
/**
 * @author simone
 *
 */
public class Squadra  extends StarcupModel { 
//	public static final String selectSQL = "Select * From Squadra Order by IdSquadra asc";

	private Long idsquadra;
	private String nomesquadra;
	private String tipologia;
	private Long codgruppo;
	private Long codutente;
	private String stemma;
	private Long codicesquadra;

	public Squadra () {
		super();
	}
	
	/**
	 * @param idsquadra
	 * @param nomesquadra
	 * @param tipologia
	 * @param codgruppo
	 * @param codutente
	 * @param stemma
	 * @param codicesquadra
	 */
	public Squadra(long idsquadra, String nomesquadra, String tipologia, long codgruppo,
			long codutente, String stemma, long codicesquadra) {
		super();
		this.idsquadra = idsquadra;
		this.nomesquadra = nomesquadra;
		this.tipologia = tipologia;
		this.codgruppo = codgruppo;
		this.codutente = codutente;
		this.stemma = stemma;
		this.codicesquadra = codicesquadra;
	}
	public long getIdSquadra() {
		return idsquadra;
	}
	public void setIdSquadra(long idsquadra) {
		this.idsquadra = new Long(idsquadra);
	}
	public String getNomeSquadra() {
		return nomesquadra;
	}
	public void setNomeSquadra(String nomesquadra) {
		this.nomesquadra = nomesquadra;
	}
	public String getTipologia() {
		return tipologia;
	}
	public void setTipologia(String tipologia) {
		this.tipologia = tipologia;
	}
	public long getCodGruppo() {
		return codgruppo;
	}
	public void setCodGruppo(long codgruppo) {
		this.codgruppo = new Long(codgruppo);
	}
	public long getCodUtente() {
		return codutente;
	}
	public void setCodUtente(long codutente) {
		this.codutente = new Long(codutente);
	}
	public String getStemma() {
		return stemma;
	}
	public void setStemma(String stemma) {
		this.stemma = stemma;
	}
	public long getCodiceSquadra() {
		return codicesquadra;
	}
	public void setCodiceSquadra(long codicesquadra) {
		this.codicesquadra = new Long(codicesquadra);
	}
	
	
}


