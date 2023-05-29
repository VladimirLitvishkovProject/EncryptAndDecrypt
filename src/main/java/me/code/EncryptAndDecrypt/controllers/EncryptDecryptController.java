package me.code.EncryptAndDecrypt.controllers;
///

import java.util.HashMap;
import java.util.Map;
import jdk.jfr.BooleanFlag;
import me.code.EncryptAndDecrypt.dto.CaesarRequest;
import me.code.EncryptAndDecrypt.services.EncryptDecryptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EncryptDecryptController {
    
    @Autowired
    private EncryptDecryptService encryptDecryptService;
    
    @PostMapping("/caesar")
    public String CaesarCode(@RequestBody CaesarRequest request) {
        
        return encryptDecryptService.CaesarCode(request);
    }
    
    
    
    
    
    
//    private String[] alfavitRu = {"а", "б", "в", "г", "д", "е", "ё", "ж", "з", "и", "й", "к", "л", "м", "н", "о", "п", "р", "с", "т", "у", "ф", "х", "ц", "ч", "ш", "щ", "ъ", "ы", "ь", "э", "ю", "я"};
//    Map<String, Integer> alfavitWithValue = new HashMap<>();
//
//    @GetMapping("/decode")
//    public String decode(@RequestParam String code, @RequestParam String key, @RequestParam(name = "alfavit", required = false) String... alfavit) {
//        String result = "";
//        code = code.toLowerCase();
//        key = key.toLowerCase();
//        if (alfavit != null && alfavit.length > 0) {
//            for (int i = 0; i < alfavit.length; i++) {
//                alfavitWithValue.putIfAbsent(alfavit[i], i);
//            }
//        } else {
//            for (int i = 0; i < alfavitRu.length; i++) {
//                alfavitWithValue.putIfAbsent(alfavitRu[i], i);
//            }
//        }
//        code = code.trim();
//        String[] codeArray = code.split("");
//        
//        String[] keyArray = key.trim().split("");
//        String[] keyArrayForCode = new String[codeArray.length];
//        for (int i = 0, j = 0; i < keyArrayForCode.length; i++) {
//            keyArrayForCode[i] = codeArray[i].isBlank() ? " " : keyArray[j++ % keyArray.length];
//        }
//        int a, b, c;
//        for (int i = 0; i < codeArray.length; i++) {
//            if (codeArray[i].isBlank()) {
//                result += " ";
//                continue;
//            }
//            a = alfavitWithValue.get(codeArray[i]);
//            b = alfavitWithValue.get(keyArrayForCode[i]);
//            c = a - b < 0 ? a - b + alfavitWithValue.size() : a - b;
//            final int temp = c;
//            result += alfavitWithValue.entrySet().stream().filter((e) -> e.getValue() == temp).map((e) -> e.getKey()).findFirst().orElse("_");
//        }
//        
//        return result;
//    }
    
}
