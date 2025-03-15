package org.example.services;
import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.entities.User;
import java.io.File;
import java.util.Optional;

public class UserBookingService {
    private User user;
    private static final String USERS_PATH = "../localDb/users.json"; // static cs we want it in memory and final bcz we dont want anyone to change it
    private List<User> userList;
    private static final ObjectMapper mapper = new ObjectMapper(); //to map the user_id with userId.  so helps in mapping(serialization deseralization

    public UserBookingService( User user) throws IOException {
        this.user = user;
        loadUserListFromFile();
    }

    public UserBookingService() throws IOException {
        loadUserListFromFile();
    }

    private void loadUserListFromFile() throws IOException {
        File userBookingFile = new File(USERS_PATH);
        userList = mapper.readValue(userBookingFile, new TypeReference<List<User>>(){});
    }

//    public Boolean loginUser(){
//        Optional<User> foundUser = userList.stream()
//                .filter(user -> {return user.getUsername().equals(user.getUsername()) && UserServiceUtil.checkPassword(user.getPassword(), user.getHashPassword());
//                }).findFirst();
//
//        return foundUser.isPresent();
//    }
}
