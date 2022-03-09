package br.com.maratona.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;
import java.util.ArrayList;
import br.com.maratona.models.Maratona;
import br.com.maratona.repositories.MaratonaRepository;

@Controller
public class MaratonaController {

    @Autowired
    MaratonaRepository participantRepository;

    @GetMapping(value = "")
    public String getIndex() {
        return "maratona/index";
    }

    @GetMapping(value = "/")
    public String get_Index() {
        return "maratona/index";
    }

    @GetMapping(value = "/maratona/cadastro")
    public String getCadastro() {
        return "maratona/cadastro";
    }

    @GetMapping(value = "/participantes")
    public ModelAndView getMaratona_participantes() {

        List<Maratona> listParticipant = new ArrayList<>();

        listParticipant = participantRepository.findAll();

        ModelAndView mv = new ModelAndView("maratona/participantes");
        mv.addObject("listParticipant", listParticipant);
        return mv;
    }

    @PostMapping(value = "/maratona/subscription")
    public String getParticipantes(Maratona participante) {
        participantRepository.save(participante);
        return "redirect:/participantes";
    }

    @GetMapping(value = "/excluir/{id}")
    public String excluir(@PathVariable Long id) {
        participantRepository.deleteById(id);
        return "redirect:/participantes";
    }

    @GetMapping(value = "/participante/{id}")
    public ModelAndView getMethodName(@PathVariable Long id) {
        Optional<Maratona> participant = participantRepository.findById(id);

        if (participant.isPresent()) {
            ModelAndView mv = new ModelAndView("maratona/detalhes");
            mv.addObject("participant", participant.get());
            return mv;
        } else {
            return new ModelAndView("redirect:/participantes");
        }
    }

}
