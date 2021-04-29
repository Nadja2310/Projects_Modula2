package telran.contacts_db.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import telran.contacts_db.entity.Contact;
import java.util.Collection;
import java.util.List;

public interface IContactRepo extends CrudRepository<Contact,Integer> {
    Collection<Contact> findAllByName(String name);

      List<Contact> findAllByNameContainingIgnoreCaseOrLastNameContainingIgnoreCase(String name, String lastName);

      @Query("select c from Contact c where upper(c.name) like %upper(:pattern)% or upper(c.lastName) like %upper(:pattern)%")
      Collection<Contact> findAllContainingPattern(@Param("pattern") String pattern);
}
