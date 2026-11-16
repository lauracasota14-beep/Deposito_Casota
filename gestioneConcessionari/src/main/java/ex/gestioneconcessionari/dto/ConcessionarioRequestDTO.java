package ex.gestioneconcessionari.dto;

import java.math.BigDecimal;

public class ConcessionarioRequestDTO {

    private String nome;
    
    private String citta;
    
    private String indirizzo;
    
    private String telefono;
    
    private BigDecimal fatturato;
    
    private Long casaMadreId;
    
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
	public String getIndirizzo() {
		return indirizzo;
	}
	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public BigDecimal getFatturato() {
		return fatturato;
	}
	public void setFatturato(BigDecimal fatturato) {
		this.fatturato = fatturato;
	}
	public Long getCasaMadreId() {
		return casaMadreId;
	}
	public void setCasaMadreId(Long casaMadreId) {
		this.casaMadreId = casaMadreId;
	}
}
