package telran.demo.contacts.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import telran.demo.contacts.entity.Contact;
import telran.demo.contacts.repo.ContactRepoList;
import telran.demo.contacts.repo.ContactRepoMap;
import telran.demo.contacts.repo.IContactRepo;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class Config {

   /* @Bean
    @Qualifier("contactRepoList")
    public IContactRepo contactRepoList(){
        *//*List<Contact> contacts = new ArrayList<>();

        {
            contacts.add(new Contact(1, "Vasya", "Vasin", 21));
            contacts.add(new Contact(2, "Petya", "Peterson", 22));
        }*//*
        return new ContactRepoList();
    }

    @Bean
    @Qualifier("contactRepoMap")
    public IContactRepo contactRepoMap(){

        return new ContactRepoMap();
    }*/
}
