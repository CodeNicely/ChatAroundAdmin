package project.codenicely.admin.a1mile.a1mileadmin.restroom.view;


import java.util.List;

import project.codenicely.admin.a1mile.a1mileadmin.restroom.model.RestRoomDetails;

/**
 * Created by meghal on 19/2/17.
 */

public interface RestRoomView {


    void showLoader(boolean show);

    void showMessage(String message);

    void onReceived(List<RestRoomDetails> restRoomDetailsList);
}
