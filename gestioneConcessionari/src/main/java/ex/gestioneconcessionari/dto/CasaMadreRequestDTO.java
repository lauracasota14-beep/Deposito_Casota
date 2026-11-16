package ex.gestioneconcessionari.dto;

import java.math.BigDecimal;

public class CasaMadreRequestDTO {

    private String ragioneSociale;
    
    private String sedeLegale;
    
    private String paese;
    
    private Integer annoFondazione;
    
    private BigDecimal fatturatoAnnuo;
    
	public String getRagioneSociale() {
		return ragioneSociale;
	}
	
	public void setRagioneSociale(String ragioneSociale) {
		this.ragioneSociale = ragioneSociale;
	}
	public String getSedeLegale() {
		return sedeLegale;
	}
	public void setSedeLegale(String sedeLegale) {
		this.sedeLegale = sedeLegale;
	}
	public String getPaese() {
		return paese;
	}
	public void setPaese(String paese) {
		this.paese = paese;
	}
	public Integer getAnnoFondazione() {
		return annoFondazione;
	}
	public void setAnnoFondazione(Integer annoFondazione) {
		this.annoFondazione = annoFondazione;
	}
	public BigDecimal getFatturatoAnnuo() {
		return fatturatoAnnuo;
	}
	public void setFatturatoAnnuo(BigDecimal fatturatoAnnuo) {
		this.fatturatoAnnuo = fatturatoAnnuo;
	}
    
    
}