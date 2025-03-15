package org.example.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.entities.Train;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class TrainService {

    private List<Train> trainList;
    private ObjectMapper mapper = new ObjectMapper();
    public static final String TrainJSON_PATH = "../localDb/trains.json";

    public TrainService() throws IOException {
        File trainJson = new File(TrainJSON_PATH);
        trainList = mapper.readValue(trainJson, new TypeReference<List<Train>>(){});
    }

    public List<Train> searchTrains(String source, String destination){
        return trainList.stream().filter(train->validTrain(train, source, destination));
    }

    public boolean validTrain(Train train, String source, String destination){

    }

    public void addTrain(Train t){
        Optional<Train> existngTrain = trainList.stream().filter(train ->train.getTrainNo().equalsIgnoreCase(t.getTrainNo())).findFirst();
    }


}
