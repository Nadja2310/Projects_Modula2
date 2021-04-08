package telran.demo.contacts.repo;

import telran.demo.contacts.entity.Contact;

import java.util.List;

public interface IContactRepo {

    void  save(Contact contact);

    Contact find(int id);

    Contact remove(int id);

    List<Contact> findAll();
}
