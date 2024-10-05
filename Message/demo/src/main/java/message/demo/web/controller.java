package message.demo.web;

import lombok.RequiredArgsConstructor;
import message.demo.domain.writing;
import message.demo.service.WritingService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class controller {

    private final WritingService writingService;
    @GetMapping("/home")
    public String showList(Model model) {
        List<writing> writing = writingService.findWriting();
        model.addAttribute("writings", writing);
        return "/writings/list";
    }

}
