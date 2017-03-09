package project.codenicely.admin.a1mile.a1mileadmin.restroom.presenter;

/**
 * Created by meghal on 19/2/17.
 */

public interface RestRoomPresenter {

    void requestRestrooms(String admin_token);

    void requestRestroomStatusUpdate(String admin_token,String restroom_id,boolean verify,int position);

}
