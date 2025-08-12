package com.emranhss.project.repository;

import com.emranhss.project.entity.Token;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

<<<<<<< HEAD
import java.awt.*;
=======
>>>>>>> 0e3f204ff0631cca9428023e610dc5f1a7106550
import java.util.List;
import java.util.Optional;

@Repository
public interface ITokenRepo extends JpaRepository<Token, Long> {

    Optional<Token> findByToken(String  token);

    @Query("""
    Select t from Token t inner join User u on t.user.id= u.id
<<<<<<< HEAD
    where t.user.id= :userId and t.logout=false
""")
    List<Token> findAllTokenByUser(int userId);


=======
    where t.user.id= :userId and t.logOut = false
""")
    List<Token> findAllTokenByUser(int userId);

>>>>>>> 0e3f204ff0631cca9428023e610dc5f1a7106550
}

