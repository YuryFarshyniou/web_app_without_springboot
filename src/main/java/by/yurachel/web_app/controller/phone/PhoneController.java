package by.yurachel.web_app.controller.phone;

import by.yurachel.web_app.dao.DaoProvider;
import by.yurachel.web_app.entity.Phone;
import by.yurachel.web_app.service.IService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/phones")
public class PhoneController {
    private static final Logger LOGGER = LogManager.getLogger(PhoneController.class);

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
    public String create(@ModelAttribute("newPhone") @Valid Phone phone,
                         BindingResult bindingResult) {
        service.create(phone);
        if (bindingResult.hasErrors()) {
            return "phones/newPhone";
        }
        return "redirect:/phones";
    }

    @GetMapping("/{id}/updatePhone")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("phone", service.findById(id));
        return "phones/updatePhone";
    }

    @PatchMapping("/{id}")
    public String update(@PathVariable int id,
                         @ModelAttribute("person") @Valid Phone phone,
                         BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return"phones/updatePhone";
        }
        service.updateById(id, phone);
        return"redirect:/phones";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        service.removeById(id);
        return "redirect:/phones";
    }


}
