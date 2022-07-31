package com.softdelete.services;


// import org.hibernate.Filter;
// import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softdelete.models.entities.User;
import com.softdelete.models.repositories.UserRepository;

// import jakarta.persistence.EntityManager;

@Service
public class UserService {

   // @Autowired
   // private EntityManager entityManager;
   
   @Autowired
   private UserRepository userRepository;

   public Iterable<User> findAll(){

      // Session session = entityManager.unwrap(Session.class);
      // Filter filter = session.enableFilter("filterUser");
      return userRepository.findAll();
   }

   public User save(User user){
      return userRepository.save(user);
   }

   public String delete(long id) {
      try {
         userRepository.deleteById(id);
         return "user has deleted:v";
      } catch (Exception e) {
         throw new RuntimeException("failed to delete "+e);
      }
   }
}
