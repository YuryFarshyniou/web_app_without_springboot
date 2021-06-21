package by.yurachel.web_app.controller.phone;

import by.yurachel.web_app.entity.Phone;
import by.yurachel.web_app.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/phones")
public class PhoneController {

    private IService<Phone> service;

    @Autowired
    public void setService(IService<Phone> service) {
        this.service = service;
    }

    @GetMapping()
    public String phoneList(Model model) {
        model.addAttribute("phones", service.findAll());
        return "phones/phoneCatalog";
    }

    @GetMapping("/{id}")
    public String phonePage(@PathVariable("id") int id, Model model) {
        model.addAttribute("phone", service.findById(id));
        return "phones/showPhone";
    }

    @GetMapping("/new")
    public String addNewPhone(Model model) {
        model.addAttribute("newPhone", new Phone());
        return "phones/newPhone";
    }

    @PostMapping
    public String create(@ModelAttribute("newPhone") Phone phone) {
        service.create(phone);
        return "redirect:/phones";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        service.removeById(id);
        return "redirect:/phones";
    }


}
