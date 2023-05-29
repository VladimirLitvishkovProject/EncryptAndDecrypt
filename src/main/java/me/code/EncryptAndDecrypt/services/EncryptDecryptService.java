package me.code.EncryptAndDecrypt.services;
///

import java.util.stream.Collectors;
import me.code.EncryptAndDecrypt.dto.CaesarRequest;
import org.springframework.stereotype.Service;

@Service
public class EncryptDecryptService {

    private final String ruAlfavit = "RU";
    private final String enAlfavit = "EN";

    public String CaesarCode(CaesarRequest request) {
        String result = request.getCode().toLowerCase().trim().chars().mapToObj(c -> {
            switch (request.getAlfavit().toUpperCase().trim()) {
                case ruAlfavit:
                    c = checkAndFixCharForCaesar(c, 'а', 'я', request.getCoefficient());
                    break;
                case enAlfavit:
                    c = checkAndFixCharForCaesar(c, 'a', 'z', request.getCoefficient());
                    break;
                default:
            }
            return String.valueOf((char) c);
        }).collect(Collectors.joining());

        return result;
    }

    private char checkAndFixCharForCaesar(int c, char start, char finish, int fixCoefficient) {
        if (c >= start && c <= finish) {
            c += fixCoefficient;
            if (c < start) {
                c = finish + (c - start) + 1;
            } else if (c > finish) {
                c = start + (c - finish) - 1;
            }
        }
        return (char) c;
    }

}
