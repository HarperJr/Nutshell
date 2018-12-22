package controller;

import model.ObjectModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import repository.ObjectRepository;
import repository.ObjectRepositoryImpl;
import java.util.List;

@Controller
public class MainController {

    private ObjectRepository objectRepository;

    @Autowired
    public MainController(ObjectRepositoryImpl objectRepository) {
        this.objectRepository = objectRepository;
    }

    @RequestMapping(value = "/")
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/all")
    public String all(Model model) {
        final List<ObjectModel> objects = objectRepository.getAll();
        model.addAttribute("objects", objects);
        return "object/all";
    }

    @RequestMapping(value = "/edit/{id}")
    public String edit(Model model, @PathVariable String id) {
        final ObjectModel object = objectRepository.find(Integer.parseInt(id));
        model.addAttribute("object", object);
        return "object/edit";
    }

    @RequestMapping(value = "/edit/apply", method = RequestMethod.POST)
    public String editObject(Model model, ObjectModel object) {
        objectRepository.update(object);
        return "redirect:/all";
    }

    @RequestMapping(value = "/delete/{id}")
    public String delete(Model model, @PathVariable String id) {
        final ObjectModel object = objectRepository.find(Integer.parseInt(id));
        objectRepository.delete(object);
        return "redirect:/all";
    }

    @RequestMapping(value = "/insert")
    public String insert(Model model) {
        return "object/insert";
    }

    @RequestMapping(value = "/insert/apply")
    public String insert(Model model, ObjectModel object) {
        objectRepository.insert(object);
        return "redirect:/all";
    }
}
