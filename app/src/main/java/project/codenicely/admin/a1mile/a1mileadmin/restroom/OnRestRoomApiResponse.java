package project.codenicely.admin.a1mile.a1mileadmin.restroom;


import project.codenicely.admin.a1mile.a1mileadmin.restroom.model.RestRoomData;

/**
 * Created by meghal on 19/2/17.
 */

public interface OnRestRoomApiResponse {


    void onSuccess(RestRoomData restRoomData);

    void onFailure(String message);
}
