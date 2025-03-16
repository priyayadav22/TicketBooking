package org.example.utils;

import org.mindrot.jbcrypt.BCrypt;

public class UserServiceUtil {

    public static String hashPassword(String password){
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    public static boolean checkPassword(String password, String hashedPassword){
        return BCrypt.checkpw(password, hashedPassword);
    }
    //bcrypt used to secure pswd hashing
    //bcrypt.gensalt generates a random salt that will be used to hash the pswd
    //it increase security by making the same pswd hash differently evey time
    //bcrypt.hashpw (pswd,salt)--- hash pswd using given salt --- hash pswd is irreversible
    //bcrypt.checkpw(pswd, hashpswd) -- verifies if a given password matches the stored hashed pswd
}
