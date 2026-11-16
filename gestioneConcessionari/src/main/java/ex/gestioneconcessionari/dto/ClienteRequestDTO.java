package ex.gestioneconcessionari.dto;

public class ClienteRequestDTO {

    private String nome;
    
    private String cognome;
    
    private String email;
    
    private String telefono;
    
    private Long concessionarioId;
    
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
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public Long getConcessionarioId() {
		return concessionarioId;
	}
	public void setConcessionarioId(Long concessionarioId) {
		this.concessionarioId = concessionarioId;
	}
    
    
}