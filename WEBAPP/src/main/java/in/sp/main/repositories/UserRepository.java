package in.sp.main.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import in.sp.main.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    List<User> findByTitleContaining(String title);
}