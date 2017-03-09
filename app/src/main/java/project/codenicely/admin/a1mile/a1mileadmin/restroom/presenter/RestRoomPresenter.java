package project.codenicely.admin.a1mile.a1mileadmin.restroom.presenter;

/**
 * Created by meghal on 19/2/17.
 */

public interface RestRoomPresenter {

    void requestRestrooms(String admin_token);

    void requestRestroomStatusUpdate(String adminToken,String restroomId,boolean verify,int position);

}
