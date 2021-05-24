package MeetingManager.controller;

import MeetingManager.model.Meeting;
import MeetingManager.service.MeetingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MeetingController {

    private MeetingService meetingService;

    public MeetingController(MeetingService meetingService) {
        this.meetingService = meetingService;
    }

    @GetMapping("/meetings/{id}")
    public Meeting getMeeting(@PathVariable int id) {
        return meetingService.getMeeting(id);
    }

    @PostMapping("/meetings")
    public Meeting createMeeting(@RequestBody Meeting meeting){
        return meetingService.createMeeting(meeting);
    }

    @DeleteMapping("/meetings/{id}")
    public int deleteMeeting(@PathVariable int id){
        return meetingService.deleteMeeting(id);
    }

    @PutMapping("/meetings")
    public Meeting updateMeeting(@RequestBody Meeting meeting){
        return meetingService.updateMeeting(meeting);
    }

    @GetMapping("/meetings")
    public List<Meeting>  getMeetings(){
        return meetingService.getMeetings();
    }
}
