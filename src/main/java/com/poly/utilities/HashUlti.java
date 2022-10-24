package com.poly.utilities;

import org.mindrot.jbcrypt.BCrypt;

public class HashUlti {
    // chiều mã hóa
    public static String hash(String plain) {
        String salt = BCrypt.gensalt();
        return BCrypt.hashpw(plain, salt);
    }
    
    // chiều kiểm tra
    public static boolean verify(String plain, String hashed) {
        return BCrypt.checkpw(plain, hashed);
    }
}
