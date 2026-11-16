package ex.gestioneconcessionari.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name = "CLIENTE")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String nome;

    @Column(nullable = false, length = 50)
    private String cognome;
    //unique valore non può essre duplicato
    @Column(unique = true, length = 100)
    private String email;

    @Column(length = 20)
    private String telefono;

    @Column(
        name = "data_registrazione",
        nullable = false,
        updatable = false,
        columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP"
    )
    private LocalDateTime dataRegistrazione;
    //optional il collegamento è obbligatorio
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "concessionario_id", nullable = false)
    private Concessionario concessionario;

    @PrePersist
    private void impostaDataRegistrazione() {
        if (dataRegistrazione == null) {
            dataRegistrazione = LocalDateTime.now();
        }
    }

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

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public LocalDateTime getDataRegistrazione() {
		return dataRegistrazione;
	}

	public void setDataRegistrazione(LocalDateTime dataRegistrazione) {
		this.dataRegistrazione = dataRegistrazione;
	}

	public Concessionario getConcessionario() {
		return concessionario;
	}

	public void setConcessionario(Concessionario concessionario) {
		this.concessionario = concessionario;
	}
}