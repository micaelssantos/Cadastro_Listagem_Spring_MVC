package br.senac.tads.dsw.exercicio.controle;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Micael Santos
 */
@Controller
public class IndexControle {
    
	@GetMapping("/")
	public ModelAndView index() {
		ModelAndView mv =  new ModelAndView("/index");	
		return mv;
	}
    
}
