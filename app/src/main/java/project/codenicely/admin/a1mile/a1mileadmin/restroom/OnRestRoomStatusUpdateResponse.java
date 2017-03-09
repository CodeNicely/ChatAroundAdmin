package project.codenicely.admin.a1mile.a1mileadmin.restroom;

import project.codenicely.admin.a1mile.a1mileadmin.restroom.model.RestRoomStatusUpdateData;

/**
 * Created by meghal on 10/3/17.
 */

public interface OnRestRoomStatusUpdateResponse {

    void onSuccess(RestRoomStatusUpdateData restRoomStatusUpdateData);
    void onFailure(String message);

}
