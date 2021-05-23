package MeetingManager.service;

import MeetingManager.Meeting;
import MeetingManager.controller.DatabaseConnector;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MeetingService {

    private DatabaseConnector databaseConnector;

    public MeetingService(DatabaseConnector databaseConnector) {
        this.databaseConnector = databaseConnector;
    }

    public Meeting getMeeting(int id){
        return databaseConnector.getMeeting(id);
    }

    public Meeting createMeeting(Meeting meeting){
        return databaseConnector.createMeeting(meeting);
    }

    public int deleteMeeting(int id){
        return databaseConnector.deleteMeeting(id);
    }

    public Meeting updateMeeting(Meeting meeting){
        return databaseConnector.updateMeeting(meeting);
    }

    public List<Meeting> getMeetings(){
        return databaseConnector.getMeetings();
    }
}
