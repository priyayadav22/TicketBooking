package org.example.services;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.entities.Train;
import org.example.entities.User;
import org.example.utils.UserServiceUtil;

import java.io.File;
import java.util.Optional;
import java.util.Scanner;

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

    public Boolean loginUser(){
        Optional<User> foundUser = userList.stream().filter(user1 -> {
            return user.getUsername().equals(user.getUsername()) && UserServiceUtil.checkPassword(user.getPassword(), user.getHashPassword());
        }).findFirst();
        return foundUser.isPresent();
    }
    public Boolean signUp(User user){
        try{
            userList.add(user);
            saveUserListToFile();
            return Boolean.TRUE;
        } catch (IOException e) {
            return Boolean.FALSE;
        }
    }

    public void saveUserListToFile() throws IOException {
        File userBookingFile = new File(USERS_PATH);
        mapper.writeValue(userBookingFile, userList);
    }

    public Boolean cancelBooking(String ticketId){
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the ticket ID: ");
        ticketId = sc.nextLine();

        if(ticketId.isEmpty() || ticketId == null){
            System.out.println("Ticket ID cannot be empty");
            return Boolean.FALSE;
        }
        String finalTicketId = ticketId;
        boolean removed = user.getTicketsBooked().removeIf(user -> user.getTicketId().equals(finalTicketId));
        if(removed){
            System.out.println("Ticket ID " + finalTicketId + " has been removed");
            return Boolean.TRUE;
        }
        else{
            System.out.println("Ticket ID " + finalTicketId + " has not been removed");
            return Boolean.FALSE;
        }
    }

    public void fetchBooking(){
        Optional<User> userFetched = userList.stream().filter(user -> {return user.getUsername().equals(user.getUsername());}).findFirst();
        if(userFetched.isPresent()){
            userFetched.get().printTickets();
        }
    }

    public List<Train> getTrains(String source, String destination){
        try{
            TrainService trainService = new TrainService();
            return  trainService.searchTrains(source, destination);
        } catch (IOException e) {
            return new ArrayList<>();
        }
    }

    public List<List<Integer>> fetchSeats(Train train){
        return train.getSeat();
    }

    public Boolean BookTrainSeats(Train train, int row, int seat){
        try{
            TrainService trainService = new TrainService();
            List<List<Integer>> seats = train.getSeat();
            if(row >= 0 && seat >=0 && seat < seats.size() && row < seats.get(row).size()){
                if(seats.get(row).get(seat) == 0){
                    seats.get(row).set(seat, 1);
                    train.setSeat(seats);
                    trainService.addTrain(train);
                    return true;
                }
                else
                    return false;
            }
        } catch (IOException e) {
            return Boolean.FALSE;
        }
        return null;
    }
}
