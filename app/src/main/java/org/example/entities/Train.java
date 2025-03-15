package org.example.entities;

import java.sql.Time;
import java.util.List;
import java.util.Map;

public class Train {
    private String trainId;
    private String trainNo;
    private List<List<Integer>> seat;
    private Map<String, Time> stationTime;
    private List<String> stations;

    public Train(){}

    public Train(String trainId, String trainNo, List<List<Integer>> seat, Map<String, Time> stationTime, List<String> stations) {
        this.trainId = trainId;
        this.trainNo = trainNo;
        this.seat = seat;
        this.stationTime = stationTime;
        this.stations = stations;
    }

    public String getTrainId() {
        return trainId;
    }

    public String getTrainNo() {
        return trainNo;
    }

    public List<List<Integer>> getSeat() {
        return seat;
    }

    public Map<String, Time> getStationTime() {
        return stationTime;
    }

    public List<String> getStations() {
        return stations;
    }

    public void setTrainId(String trainId) {
        this.trainId = trainId;
    }

    public void setTrainNo(String trainNo) {
        this.trainNo = trainNo;
    }

    public void setSeat(List<List<Integer>> seat) {
        this.seat = seat;
    }

    public void setStationTime(Map<String, Time> stationTime) {
        this.stationTime = stationTime;
    }

    public void setStations(List<String> stations) {
        this.stations = stations;
    }

    public String getTrainInfo(){
        return String.format("Train Id : %s . Train No. : %s", trainId, trainNo);
    }
}
