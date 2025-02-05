package br.com.caiocarvalho.front_gestao_vagas.modules.candidate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.caiocarvalho.front_gestao_vagas.modules.candidate.service.CandidateService;

import org.springframework.web.bind.annotation.PostMapping;


@Controller
@RequestMapping("/candidate")
public class CandidateController {

    @Autowired
    private CandidateService candidateService;

    @GetMapping("/login")
    public String login() {
        return "candidate/login";
    }

    @PostMapping("/signIn")
    public String signIn(RedirectAttributes redirectAttributes, String username, String password) {
        this.candidateService.login(username, password);

        if (username.equals("caio")) {
            return "candidate/profile";
        }

        redirectAttributes.addFlashAttribute("error_message", "Usuário/Senha incorretos");
        return "redirect:/candidate/login";
    }

}
