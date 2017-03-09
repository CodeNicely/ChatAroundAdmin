package project.codenicely.admin.a1mile.a1mileadmin.restroom.provider;


import project.codenicely.admin.a1mile.a1mileadmin.restroom.OnRestRoomApiResponse;
import project.codenicely.admin.a1mile.a1mileadmin.restroom.OnRestRoomStatusUpdateResponse;

/**
 * Created by meghal on 19/2/17.
 */

public interface RestRoomProvider {

    void requestRestRooms(String user_id,
                          OnRestRoomApiResponse onRestRoomApiResponse);

    void requestRestroomStatusUpdate(String adminToken,
                                     String restroomId,
                                     boolean verify,
                                     int position,
                                     OnRestRoomStatusUpdateResponse onRestRoomStatusUpdateResponse);


}
