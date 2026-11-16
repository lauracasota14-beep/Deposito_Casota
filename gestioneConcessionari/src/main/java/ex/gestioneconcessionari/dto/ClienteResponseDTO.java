package ex.gestioneconcessionari.dto;

public class ClienteResponseDTO {

    private Long id;
    
    private String nome;
    
    private String cognome;
    
    private String email;
    
    private String concessionarioNome;
    
    private String concessionarioCitta;
    
    private String casaMadreNome;
    
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
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getConcessionarioNome() {
		return concessionarioNome;
	}
	public void setConcessionarioNome(String concessionarioNome) {
		this.concessionarioNome = concessionarioNome;
	}
	public String getConcessionarioCitta() {
		return concessionarioCitta;
	}
	public void setConcessionarioCitta(String concessionarioCitta) {
		this.concessionarioCitta = concessionarioCitta;
	}
	public String getCasaMadreNome() {
		return casaMadreNome;
	}
	public void setCasaMadreNome(String casaMadreNome) {
		this.casaMadreNome = casaMadreNome;
	}
    
    
}