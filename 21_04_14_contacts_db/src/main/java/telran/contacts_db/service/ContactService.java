package telran.contacts_db.service;

import org.springframework.stereotype.Service;
import telran.contacts_db.entity.Contact;
import telran.contacts_db.repo.IContactRepo;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//the domain logic lies here
@Service
public class ContactService {
    IContactRepo contactRepo;

    public ContactService(IContactRepo contactRepo) {
        this.contactRepo = contactRepo;
    }

    public List<Contact> getAll() {

        Iterable<Contact> contacts=contactRepo.findAll();
        Iterator<Contact> iterator=contacts.iterator();
        List<Contact> res=new ArrayList<>();
        for (Contact contact:contacts){
            res.add(contact);
        }
    return res;
    }

    public Contact get(int id) {
        return contactRepo.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public void save(Contact contact) {
        contactRepo.save(contact);
    }

    public Contact remove(int id) {
        Contact res=get(id);
        contactRepo.deleteById(id);
        return res;
    }

    // TODO create a method which will be searching contacts by a pattern
    public List<Contact> getSearchContacts() {

        Iterable<Contact> contacts=contactRepo.findAll();
        Iterator<Contact> iterator=contacts.iterator();
        List<Contact> res=new ArrayList<>();
        for (Contact contact:contacts){
            res.add(contact);
        }
        return res;}
}
