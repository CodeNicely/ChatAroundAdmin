package project.codenicely.admin.a1mile.a1mileadmin.restroom.presenter;


import project.codenicely.admin.a1mile.a1mileadmin.restroom.OnRestRoomApiResponse;
import project.codenicely.admin.a1mile.a1mileadmin.restroom.OnRestRoomStatusUpdateResponse;
import project.codenicely.admin.a1mile.a1mileadmin.restroom.model.RestRoomData;
import project.codenicely.admin.a1mile.a1mileadmin.restroom.model.RestRoomStatusUpdateData;
import project.codenicely.admin.a1mile.a1mileadmin.restroom.provider.RestRoomProvider;
import project.codenicely.admin.a1mile.a1mileadmin.restroom.view.RestRoomView;

/**
 * Created by meghal on 19/2/17.
 */

public class RestRoomPresenterImpl implements RestRoomPresenter {


    private RestRoomView restRoomView;
    private RestRoomProvider restRoomProvider;

    public RestRoomPresenterImpl(RestRoomView restRoomView, RestRoomProvider restRoomProvider) {
        this.restRoomView = restRoomView;
        this.restRoomProvider = restRoomProvider;
    }

    @Override
    public void requestRestrooms(String admin_token) {
        restRoomView.showLoader(true);
        restRoomProvider.requestRestRooms(admin_token, new OnRestRoomApiResponse() {

            @Override
            public void onSuccess(RestRoomData restRoomData) {
                restRoomView.showLoader(false);
                if (restRoomData.isSuccess()) {
                    restRoomView.onReceived(restRoomData.getRestroom_list());
                    restRoomView.showLoader(false);
                } else {
                    restRoomView.showMessage(restRoomData.getMessage());
                    restRoomView.showLoader(false);
                }
            }

            @Override
            public void onFailure(String message) {
                restRoomView.showLoader(false);
                restRoomView.showMessage("Something Went Wrong");
            }
        });

    }

    @Override
    public void requestRestroomStatusUpdate(String adminToken, String restroomId, boolean verify, int position) {
        restRoomView.showProgressDialog(true);
        restRoomProvider.requestRestroomStatusUpdate(adminToken, restroomId, verify, position,
                new OnRestRoomStatusUpdateResponse() {
                    @Override
                    public void onSuccess(RestRoomStatusUpdateData restRoomStatusUpdateData) {

                        if (restRoomStatusUpdateData.isSuccess()) {
                            restRoomView.onRestRoomStatusUpdate(restRoomStatusUpdateData);
                        }
                        restRoomView.showProgressDialog(false);
                        restRoomView.showMessage(restRoomStatusUpdateData.getMessage());

                    }

                    @Override
                    public void onFailure(String message) {

                        restRoomView.showProgressDialog(false);
                        restRoomView.showMessage(message);

                    }
                });

    }
}
