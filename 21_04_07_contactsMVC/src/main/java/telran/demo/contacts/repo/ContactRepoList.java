package telran.demo.contacts.repo;

import org.springframework.stereotype.Repository;
import telran.demo.contacts.entity.Contact;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Repository
public class ContactRepoList implements IContactRepo {
    ArrayList<Contact> contacts;
    private int lastUsedId;

    public ContactRepoList() {
        this.contacts = new ArrayList<>();
        contacts.add(new Contact(1, "Vasya", "Vasin", 21));
        contacts.add(new Contact(2, "Petya", "Peterson", 22));
        this.lastUsedId = 2;
    }

    @Override
    public void save(Contact contact) {
        if (contact.getId() <= 0) {
            contact.setId(++lastUsedId);
            contacts.add(contact);
        } else {
            int currIdx = getIndex(contact.getId());
            contacts.set(currIdx, contact);
        }
    }

    @Override
    public Contact find(int id) {
        return contacts.get(getIndex(id));
    }

    @Override
    public Contact remove(int id) {
        Contact contact = contacts.get(getIndex(id));
        contacts.remove(contact);
        return contact;
    }

    @Override
    public List<Contact> findAll() {
        if (contacts.isEmpty()) {
            contacts = new ArrayList<>();
            return contacts;
        } else
            return contacts;
    }

    private int getIndex(int index) {
        for (int i = 0; i < contacts.size(); i++) {
            Contact contact = contacts.get(i);
            if (contact.getId() == index)
                return i;
        }
        return -1;
    }
}
