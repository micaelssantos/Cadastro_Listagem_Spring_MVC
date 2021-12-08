package br.senac.tads.dsw.exercicio.repositorio;

import br.senac.tads.dsw.exercicio.modelo.Pessoa;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.stereotype.Service;

/**
 *
 * @author Micael Santos
 */
@Service
public class PessoaRepositoryMock implements PessoaRepository {

    private Map<Integer, Pessoa> mapPessoas;

    private int sequenciaId = 0;

    public PessoaRepositoryMock() {
        mapPessoas = new ConcurrentHashMap<>();
    }

    @Override
    public List<Pessoa> findAll() {
        return new ArrayList<>(mapPessoas.values());
    }

    @Override
    public Pessoa save(Pessoa pes) {
        if (pes.getId() == null) {
            pes.setId(++sequenciaId);
        }
        mapPessoas.put(pes.getId(), pes);
        return pes;
    }
}
