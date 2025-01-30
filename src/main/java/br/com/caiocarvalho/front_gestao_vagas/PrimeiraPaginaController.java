package br.com.caiocarvalho.front_gestao_vagas;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class PrimeiraPaginaController {

    @GetMapping("/home")
    public String primeiraPaginaHtml(Model model) {

        model.addAttribute("msgController", "Eis me aqui Senhor");
        return "primeiraPagina";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "candidate/login";
    }

    @PostMapping("/create")
    public String cadastroCandidate(String nome_do_candidato) {
        System.out.println("Nome do candidato é:" + nome_do_candidato);
        return "/candidate/login";
    }
}
