package es.vir2al.todoapp.fwk.utils;

// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;

public class FwkPasswordUtils {
    
    // private Logger logger = LoggerFactory.getLogger(FwkPasswordUtils.class);

    public static String encodePassword(String passwordIn) {

        org.springframework.security.crypto.password.PasswordEncoder encoder
        = new org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder();

        return encoder.encode(passwordIn);

    }

}
