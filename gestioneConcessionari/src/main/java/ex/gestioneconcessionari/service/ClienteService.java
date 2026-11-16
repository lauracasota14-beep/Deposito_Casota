package ex.gestioneconcessionari.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import ex.gestioneconcessionari.dto.ClienteRequestDTO;
import ex.gestioneconcessionari.dto.ClienteResponseDTO;
import ex.gestioneconcessionari.entity.Cliente;
import ex.gestioneconcessionari.entity.Concessionario;
import ex.gestioneconcessionari.repository.ClienteRepository;
import ex.gestioneconcessionari.repository.ConcessionarioRepository;

@Service
@Transactional(readOnly = true)
public class ClienteService {

    private final ClienteRepository clienteRepository;
    private final ConcessionarioRepository concessionarioRepository;

    public ClienteService(
            ClienteRepository clienteRepository,
            ConcessionarioRepository concessionarioRepository) {

        this.clienteRepository = clienteRepository;
        this.concessionarioRepository = concessionarioRepository;
    }

    //i get
    public List<ClienteResponseDTO> trovaTutti() {

        List<Cliente> clienti = clienteRepository.findAll();
        List<ClienteResponseDTO> risposta = new ArrayList<>();

        for (Cliente cliente : clienti) {
            risposta.add(convertiInDTO(cliente));
        }

        return risposta;
    }

    public ClienteResponseDTO trovaPerId(Long id) {

        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Cliente non trovato con ID: " + id
                ));

        return convertiInDTO(cliente);
    }

    //inseriscee
    @Transactional
    public ClienteResponseDTO inserisci(ClienteRequestDTO richiesta) {

        controllaDati(richiesta);

        if (richiesta.getEmail() != null
                && clienteRepository.existsByEmail(richiesta.getEmail())) {
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    "Email già utilizzata"
            );
        }

        Concessionario concessionario = concessionarioRepository
                .findById(richiesta.getConcessionarioId())
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Concessionario non trovato"
                ));

        Cliente cliente = new Cliente();

        cliente.setNome(richiesta.getNome());
        cliente.setCognome(richiesta.getCognome());
        cliente.setEmail(richiesta.getEmail());
        cliente.setTelefono(richiesta.getTelefono());
        cliente.setConcessionario(concessionario);

        Cliente salvato = clienteRepository.save(cliente);

        return convertiInDTO(salvato);
    }

    //modifica
    @Transactional
    public ClienteResponseDTO modifica(
            Long id, ClienteRequestDTO richiesta) {

        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Cliente non trovato con ID: " + id
                ));

        controllaDati(richiesta);

        if (richiesta.getEmail() != null
                && clienteRepository.existsByEmailAndIdNot(
                        richiesta.getEmail(), id)) {
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    "Email già utilizzata"
            );
        }

        Concessionario concessionario = concessionarioRepository
                .findById(richiesta.getConcessionarioId())
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Concessionario non trovato"
                ));

        cliente.setNome(richiesta.getNome());
        cliente.setCognome(richiesta.getCognome());
        cliente.setEmail(richiesta.getEmail());
        cliente.setTelefono(richiesta.getTelefono());
        cliente.setConcessionario(concessionario);

        Cliente salvato = clienteRepository.save(cliente);

        return convertiInDTO(salvato);
    }

    //elimina
    @Transactional
    public String elimina(Long id) {

        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Cliente non trovato con ID: " + id
                ));

        clienteRepository.delete(cliente);

        return "Cliente con ID " + id + " eliminato con successo";
    }

    private void controllaDati(ClienteRequestDTO richiesta) {

        if (richiesta.getNome() == null
                || richiesta.getNome().isBlank()) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "Il nome è obbligatorio"
            );
        }

        if (richiesta.getCognome() == null
                || richiesta.getCognome().isBlank()) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "Il cognome è obbligatorio"
            );
        }

        if (richiesta.getConcessionarioId() == null) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "L'ID del concessionario è obbligatorio"
            );
        }
    }

    private ClienteResponseDTO convertiInDTO(Cliente cliente) {

        ClienteResponseDTO dto = new ClienteResponseDTO();

        dto.setId(cliente.getId());
        dto.setNome(cliente.getNome());
        dto.setCognome(cliente.getCognome());
        dto.setEmail(cliente.getEmail());

        dto.setConcessionarioNome(
                cliente.getConcessionario().getNome()
        );

        dto.setConcessionarioCitta(
                cliente.getConcessionario().getCitta()
        );

        dto.setCasaMadreNome(
                cliente.getConcessionario()
                        .getCasaMadre()
                        .getRagioneSociale()
        );

        return dto;
    }
}