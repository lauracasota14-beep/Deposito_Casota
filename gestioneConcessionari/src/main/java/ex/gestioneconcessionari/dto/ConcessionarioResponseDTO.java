package ex.gestioneconcessionari.dto;

import java.math.BigDecimal;

public class ConcessionarioResponseDTO {

    private Long id;
    
    private String nome;
    
    private String citta;
    
    private BigDecimal fatturato;
    
    private String casaMadreNome;
    
    private Integer numeroClienti;
    
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCitta() {
		return citta;
	}
	public void setCitta(String citta) {
		this.citta = citta;
	}
	public BigDecimal getFatturato() {
		return fatturato;
	}
	public void setFatturato(BigDecimal fatturato) {
		this.fatturato = fatturato;
	}
	public String getCasaMadreNome() {
		return casaMadreNome;
	}
	public void setCasaMadreNome(String casaMadreNome) {
		this.casaMadreNome = casaMadreNome;
	}
	public Integer getNumeroClienti() {
		return numeroClienti;
	}
	public void setNumeroClienti(Integer numeroClienti) {
		this.numeroClienti = numeroClienti;
	}
}