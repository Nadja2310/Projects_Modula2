package telran.demo.contacts.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import telran.demo.contacts.entity.Contact;
import telran.demo.contacts.service.ContactService;

import java.util.List;

@Controller
public class ContactController {
    private final ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping("/contacts")
     public String contacts(Model model) {
        List<Contact> contacts=contactService.getAll();
        model.addAttribute("contacts", contacts);
        return "contacts";
    }

    @GetMapping("/add-contact")
    public String addContact(Model model) {
        Contact newC = new Contact();
        model.addAttribute("contact", newC);
        return "contact-form";
    }

    @GetMapping("/edit-contact/{id}")
    public String editContact(@PathVariable int id, Model model) {
        Contact contact = contactService.get(id);
        model.addAttribute("contact", contact);
        return "contact-form";
    }

    @GetMapping("/contacts/{id}")
    public String contact(@PathVariable int id, Model model) {
        Contact currContact = contactService.get(id);
        model.addAttribute("contact", currContact);
        return "user-details";
    }

    @PostMapping("/save-contact")
    public String saveContact(@ModelAttribute Contact contact) {
       contactService.save(contact);
        return "redirect:/contacts";
    }

    @GetMapping("/delete-contact/{id}")
    public String deleteContact(@PathVariable int id) {
        contactService.remove(id);
        return "redirect:/contacts";
    }

    @GetMapping("/")
    public String homePage() {
        return "forward:/contacts";
    }
}
