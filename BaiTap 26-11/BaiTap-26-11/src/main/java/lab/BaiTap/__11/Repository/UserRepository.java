package lab.BaiTap.__11.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lab.BaiTap.__11.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {}