package ex.gestioneconcessionari.dto;

import java.math.BigDecimal;

public class CasaMadreResponseDTO {

    private Long id;
    
    private String ragioneSociale;
    
    private String paese;
    
    private BigDecimal fatturatoAnnuo;
    
    private Integer numeroConcessionari;
    
    private BigDecimal fatturatoTotaleConcessionari;
    
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	public String getRagioneSociale() {
		return ragioneSociale;
	}
	public void setRagioneSociale(String ragioneSociale) {
		this.ragioneSociale = ragioneSociale;
	}
	public String getPaese() {
		return paese;
	}
	public void setPaese(String paese) {
		this.paese = paese;
	}
	public BigDecimal getFatturatoAnnuo() {
		return fatturatoAnnuo;
	}
	public void setFatturatoAnnuo(BigDecimal fatturatoAnnuo) {
		this.fatturatoAnnuo = fatturatoAnnuo;
	}
	public Integer getNumeroConcessionari() {
		return numeroConcessionari;
	}
	public void setNumeroConcessionari(Integer numeroConcessionari) {
		this.numeroConcessionari = numeroConcessionari;
	}
	public BigDecimal getFatturatoTotaleConcessionari() {
		return fatturatoTotaleConcessionari;
	}
	public void setFatturatoTotaleConcessionari(BigDecimal fatturatoTotaleConcessionari) {
		this.fatturatoTotaleConcessionari = fatturatoTotaleConcessionari;
	}
}