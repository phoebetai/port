package io.github.phoebetai;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class UserValidator implements Validator {

	@Autowired
	private UserService userService;
	
    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }
	
	@Override
	public void validate(Object obj, Errors e) {
		User user = (User) obj;
		
		// email validation
		if (userService.findByEmail(user.getEmail()) != null) {
			e.rejectValue("email", "Email already registered");
		}
		
		// password validation
		if (!user.getPasswordConfirm().equals(user.getPassword())) {
			e.rejectValue("passwordConfirm", "Password don't match");
		}
	}
}
