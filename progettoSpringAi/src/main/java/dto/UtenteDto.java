package dto;

public record UtenteDto(
        Long id,
        String nome,
        String cognome,
        String email
) {
}