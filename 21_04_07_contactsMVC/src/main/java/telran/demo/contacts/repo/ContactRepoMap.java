package telran.demo.contacts.repo;

import org.springframework.stereotype.Repository;
import telran.demo.contacts.entity.Contact;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class ContactRepoMap implements IContactRepo {
    HashMap<Integer, Contact> contactById;
    private Integer lastUsedId;

    public ContactRepoMap() {
        this.contactById = new HashMap<Integer, Contact>();
        contactById.put(1, new Contact(1, "Vasya", "Vasin", 21));
        contactById.put(2, new Contact(2, "Petya", "Peterson", 22));
        this.lastUsedId = 2;
    }

    @Override
    public void save(Contact contact) {
        if (contact.getId() <= 0) {
            contact.setId(++lastUsedId);
            contactById.put(lastUsedId, contact);
        } else {
            contactById.put(contact.getId(), contact);
        }
    }

    @Override
    public Contact find(int id) {
        return contactById.get(id);
    }

    @Override
    public Contact remove(int id) {
        Contact contact = contactById.get(id);
        contactById.remove(id);
        return contact;
    }

    @Override
    public List<Contact> findAll() {
        return new ArrayList<Contact>(contactById.values());
    }
}
