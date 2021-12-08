package br.senac.tads.dsw.exercicio.controle;

import br.senac.tads.dsw.exercicio.modelo.Pessoa;
import br.senac.tads.dsw.exercicio.repositorio.PessoaRepository;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author Micael Santos
 */
@Controller
@RequestMapping("/pessoa")
public class PessoaControle {

    @Autowired
    private PessoaRepository repository;

    @GetMapping
    public ModelAndView listar() {
        List<Pessoa> resultados = repository.findAll();
        return new ModelAndView("/pessoa/pessoas").addObject("listaPessoas", resultados);
    }

    @GetMapping("/cadastrar-pessoa")
    public ModelAndView adicionar() {
        return new ModelAndView("/pessoa/cadastrar-pessoa").addObject("pessoa", new Pessoa());
    }
      
    @PostMapping("/salvar")
    public ModelAndView salvar(@ModelAttribute @Valid Pessoa pessoa,
            BindingResult bindingResult,
            RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            ModelAndView mvErro = new ModelAndView("pessoa/cadastrar-pessoa");
            return mvErro;
        }
        repository.save(pessoa);
        redirectAttributes.addFlashAttribute("msgSucesso", pessoa.getNome()+" adicionado com sucesso!");
        return new ModelAndView("redirect:/pessoa");
    }
}