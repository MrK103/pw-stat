package by.mrk.pwstat.repository;

import by.mrk.pwstat.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    @Query(value = "SELECT count (u.id) FROM User u")
    Integer getAllCount();
}
