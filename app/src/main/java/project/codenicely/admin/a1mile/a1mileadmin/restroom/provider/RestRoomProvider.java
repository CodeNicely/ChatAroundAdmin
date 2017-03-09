package project.codenicely.admin.a1mile.a1mileadmin.restroom.provider;


import project.codenicely.admin.a1mile.a1mileadmin.restroom.OnRestRoomApiResponse;

/**
 * Created by meghal on 19/2/17.
 */

public interface RestRoomProvider {

    void requestRestRooms(String user_id, OnRestRoomApiResponse onRestRoomApiResponse);


}
