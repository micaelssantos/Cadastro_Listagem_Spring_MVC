package br.senac.tads.dsw.exercicio.repositorio;

import br.senac.tads.dsw.exercicio.modelo.Pessoa;
import java.util.List;

/**
 *
 * @author Micael Santos
 */
public interface PessoaRepository {
    
    List<Pessoa> findAll();
    Pessoa save(Pessoa pes);
}
