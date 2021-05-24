package MeetingManager.controller;

import MeetingManager.model.Meeting;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class DatabaseConnector {

    private Connection connection;

    public void connect(){
        String url = "jdbc:mysql://localhost:3306/meetings";
        String user = "root";
        String password = "admin";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            connection = DriverManager.getConnection(url, user, password);
        }catch (Exception e){
            System.out.println("Error: " + e.getMessage());
        }
    }

    public Meeting getMeeting(int id){
        connect();
        ResultSet resultSet;
        Meeting meeting = null;
        String selectString = "SELECT * FROM meeting WHERE id = " + id + ";";
        try {
            Statement statement = connection.createStatement();
            resultSet = statement.executeQuery(selectString);
            while (resultSet.next()){
                meeting = new Meeting();
                meeting.setId(resultSet.getInt("id"));
                meeting.setTitle(resultSet.getString("title"));
                meeting.setOwner(resultSet.getString("owner"));
                meeting.setDate(resultSet.getTimestamp("date").toString());
                meeting.setTopic(resultSet.getString("topic"));
            }
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return meeting;
    }

    public Meeting createMeeting(Meeting meeting){
        connect();
        String insertString = "INSERT INTO meeting (title, owner, date, topic) VALUES (?,?,?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(insertString);
            String title = meeting.getTitle();
            String owner = meeting.getOwner();
            String date = meeting.getDate();
            String topic = meeting.getTopic();
            preparedStatement.setString(1, title);
            preparedStatement.setString(2, owner);
            preparedStatement.setString(3, date);
            preparedStatement.setString(4, topic);
            preparedStatement.executeUpdate();
        } catch (SQLException ex){
            System.out.println(ex.getMessage());
        }
        return meeting;
    }

    public int deleteMeeting(int id){
        connect();
        String deleteString = "DELETE FROM meeting where id = ?";
        int rowsAffected = 0;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(deleteString);
            preparedStatement.setInt(1, id);
            rowsAffected = preparedStatement.executeUpdate();
        } catch (SQLException ex){
            System.out.println(ex.getMessage());
        }
        return rowsAffected;
    }

    public Meeting updateMeeting(Meeting meeting) {
        connect();
        String updateString = "UPDATE meeting SET title =?, owner =?, date =?, topic =? WHERE id =?";
        try {
            String title = meeting.getTitle();
            String owner = meeting.getOwner();
            String date = meeting.getDate();
            String topic = meeting.getTopic();
            int id = meeting.getId();
            PreparedStatement preparedStatement = connection.prepareStatement(updateString);
            preparedStatement.setString(1, title);
            preparedStatement.setString(2, owner);
            preparedStatement.setString(3, date);
            preparedStatement.setString(4, topic);
            preparedStatement.setInt(5, id);
            preparedStatement.executeUpdate();
        } catch (SQLException ex){
            System.out.println(ex.getMessage());
        }
        return meeting;
    }

    public List<Meeting> getMeetings(){
        connect();
        ResultSet resultSet;
        List<Meeting> meetings = new ArrayList<>();
        String selectString = "SELECT * FROM meeting;";
        try {
            Statement statement = connection.createStatement();
            resultSet = statement.executeQuery(selectString);
            while (resultSet.next()){
                Meeting meeting = new Meeting();
                meeting.setId(resultSet.getInt("id"));
                meeting.setTitle(resultSet.getString("title"));
                meeting.setOwner(resultSet.getString("owner"));
                meeting.setDate(resultSet.getTimestamp("date").toString());
                meeting.setTopic(resultSet.getString("topic"));
                meetings.add(meeting);
            }
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return meetings;
    }
}
