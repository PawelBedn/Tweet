package bednarowski.pawel.tweet.service;

import com.sun.xml.bind.v2.TODO;
import org.springframework.stereotype.Service;

import java.util.function.Predicate;

@Service
public class EmailValidatorService implements Predicate<String> {
    @Override
    public boolean test(String s) {
      //  TODO: email regex validator
        return true;
    }
}
