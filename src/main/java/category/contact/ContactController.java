package category.contact;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/contacts")
public class ContactController {

    @Autowired
    ContactRepository contactRepository;

    @PostMapping("")
    public String contact(Contact contact){
        System.out.println("확인해보자"+ contact);
        contactRepository.save(contact);
        return "redirect:/contactInput";
    }

    @GetMapping("")
    public String contactInput(Model model){
        model.addAttribute("input",contactRepository.findAll());
        return "/category/contact";
    }
}