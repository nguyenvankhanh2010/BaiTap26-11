package lab.BaiTap.__11.Resolver;

import java.util.List;
import java.util.Optional;

import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Component;

import lab.BaiTap.__11.Repository.UserRepository;
import lab.BaiTap.__11.entity.User;

@Component
public class UserResolver {
    private final UserRepository userRepository;

    public UserResolver(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @QueryMapping
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    public User createUser(String fullname, String email, String password, String phone) {
        User user = new User();
        user.setFullname(fullname);
        user.setEmail(email);
        user.setPassword(password);
        user.setPhone(phone);
        return userRepository.save(user);
    }

    public User updateUser(Long id, String fullname, String email, String password, String phone) {
        Optional<User> userOpt = userRepository.findById(id);
        if (userOpt.isPresent()) {
            User user = userOpt.get();
            if (fullname != null) user.setFullname(fullname);
            if (email != null) user.setEmail(email);
            if (password != null) user.setPassword(password);
            if (phone != null) user.setPhone(phone);
            return userRepository.save(user);
        }
        return null; 
    }

    public Boolean deleteUser(Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
