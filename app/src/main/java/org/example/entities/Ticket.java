package org.example.entities;

import java.time.LocalDate;

public class Ticket {
    private String ticketId;
    private String userId;
    private String status;
    private String source;
    private String destination;
    private Train train;
    private String dateOfTravel;

    public Ticket(){}

    public Ticket(String ticketId, String userId, String status, String source, String destination, Train train) {
        this.ticketId = ticketId;
        this.userId = userId;
        this.status = status;
        this.source = source;
        this.destination = destination;
        this.train = train;
        this.dateOfTravel = LocalDate.now().toString();
    }

    public String getTicketId() {
        return ticketId;
    }

    public String getUserId() {
        return userId;
    }

    public String getStatus() {
        return status;
    }

    public String getSource() {
        return source;
    }

    public String getDestination() {
        return destination;
    }

    public Train getTrain() {
        return train;
    }

    public String getDateOfTravel() {
        return dateOfTravel;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setTrain(Train train) {
        this.train = train;
    }

    public void setDateOfTravel(String dateOfTravel) {
        this.dateOfTravel = dateOfTravel;
    }

    public String getTicketInfo(){
        return String.format("Ticket Id: %s belong to userId: %s from %s to %s on %s", ticketId, userId, source, destination, dateOfTravel);
    }
}
