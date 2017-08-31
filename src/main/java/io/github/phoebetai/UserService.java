package io.github.phoebetai;
// done
public interface UserService {
	User findByEmail(String email);
	void save(User user);
}
