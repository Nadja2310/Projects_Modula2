package telran.demo.contacts.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import telran.demo.contacts.entity.Contact;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ContactController {
    public List<Contact> contactsList = new ArrayList<>();
    static int lastUsedId = 2;

    public ContactController() {
        contactsList.add(new Contact(1, "Vasya", "Petrov", 21));
        contactsList.add(new Contact(2, "Petya", "Ivanov", 21));
    }

    private int getIndex(int index) {
        for (int i = 0; i < contactsList.size(); i++) {
            Contact contact = contactsList.get(i);
            if (contact.getId() == index)
                return i;
        }
        return -1;
    }

    @GetMapping("/contacts")
    public String contacts(Model model) {
        model.addAttribute("contacts", contactsList);
        return "contacts";
    }

    @GetMapping("/add-contact")
    public String addContact(Model model) {
        Contact newC = new Contact();
        newC.setAge(18);
        model.addAttribute("contact", newC);
        return "contact-form";
    }

    @GetMapping("/edit-contact/{id}")
    public String editContact(@PathVariable int id, Model model) {
        int currIdx = getIndex(id);
        Contact contact = contactsList.get(currIdx);
        model.addAttribute("contact", contact);
        return "contact-form";
    }

    @GetMapping("/contacts/{id}")
    public String contact(@PathVariable int id, Model model) {
        int currIdx = getIndex(id);
        Contact currContact = contactsList.get(currIdx);
        model.addAttribute("contact", currContact);
        return "user-details";
    }

    @PostMapping("/save-contact")
    public String saveContact(@ModelAttribute Contact contact) {
        if (contact.getId() > 0) {
            int currIdx = getIndex(contact.getId());
            contactsList.set(currIdx, contact);

        } else {
            lastUsedId++;
            contact.setId(lastUsedId);
            contactsList.add(contact);
        }
        return "redirect:/contacts";
    }

    @GetMapping("/delete-contact/{id}")
    public String deleteContact(@PathVariable int id) {
        int currIdx = getIndex(id);
        contactsList.remove(currIdx);
        return "redirect:/contacts";
    }

}
