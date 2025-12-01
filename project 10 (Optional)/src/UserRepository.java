import java.util.Optional;

public class UserRepository {
    //成员方法
    public Optional<User> findUserByName(String name) {
        if (name.equals("Albert")) {
            return Optional.of(new User("Albert","Albert Shen"));
        } else {
            return Optional.empty();
        }
    }
}
