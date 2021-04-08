package telran.demo.contacts.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import telran.demo.contacts.entity.Contact;
import telran.demo.contacts.repo.IContactRepo;

import java.util.List;

@Service
public class ContactService {
    IContactRepo contactRepo;

    public ContactService(@Qualifier("contactRepoList") IContactRepo contactRepo) {
  //  public ContactService(@Qualifier("contactRepoMap") IContactRepo contactRepo) {
        this.contactRepo = contactRepo;
    }

    public List<Contact> getAll() {
        return contactRepo.findAll();
    }

    public Contact get(int id) {
        return contactRepo.find(id);
    }

    public void save(Contact contact) {
        contactRepo.save(contact);
    }

    public Contact remove(int id) {
        return contactRepo.remove(id);
    }
}
