package ex.gestioneconcessionari.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "CASA_MADRE")
public class CasaMadre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ragione_sociale", nullable = false, length = 100)
    private String ragioneSociale;

    @Column(name = "sede_legale", nullable = false, length = 100)
    private String sedeLegale;

    @Column(nullable = false, length = 50)
    private String paese;

    @Column(name = "anno_fondazione")
    private Integer annoFondazione;
    					//precision: massimo 15 cifre totali, scale:due cifre dopo la vrigola
    @Column(name = "fatturato_annuo", precision = 15, scale = 2)
    private BigDecimal fatturatoAnnuo;
    
    @OneToMany(mappedBy = "casaMadre")
    private List<Concessionario> concessionari = new ArrayList<>();

	public List<Concessionario> getConcessionari() {
		return concessionari;
	}

	public void setConcessionari(List<Concessionario> concessionari) {
		this.concessionari = concessionari;
	}

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
