package message.demo.web;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import message.demo.domain.writing;
import message.demo.service.WritingService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@Slf4j
@RequiredArgsConstructor
public class controller {

    private final WritingService writingService;
    @GetMapping("/list")
    public String showList(Model model) {
        List<writing> writing = writingService.findWriting();
        model.addAttribute("writings", writing);
        return "/writings/list";
    }

    @GetMapping("/home")
    public String home() {
        return "/home";
    }

    @GetMapping("/writings/new")
    public String createForm(Model model) {
        model.addAttribute("writingForm", new writingForm());
        return "/writings/createWritingForm";
    }

    @PostMapping("/writings/new")
    public String create(writingForm form, BindingResult result) {
        log.info("hi i'm here");
        writing writing = new writing();
        writing.setContent(form.getContent());
        writing.setTitle(form.getTitle());

        writingService.join(writing);

        return "redirect:/";
    }

    @GetMapping("/writings")
    public String list(Model model) {
        List<writing> writings = writingService.findWriting();
        model.addAttribute("writings", writings);
        return "writings/writingList";
    }

}
