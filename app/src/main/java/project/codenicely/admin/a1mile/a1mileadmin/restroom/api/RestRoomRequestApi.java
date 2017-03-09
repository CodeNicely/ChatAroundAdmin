package project.codenicely.admin.a1mile.a1mileadmin.restroom.api;


import project.codenicely.admin.a1mile.a1mileadmin.helper.Urls;
import project.codenicely.admin.a1mile.a1mileadmin.restroom.model.RestRoomData;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by meghal on 20/2/17.
 */

public interface RestRoomRequestApi {

    @GET(Urls.SUB_URL_ADMIN_RESTROOM_LIST)
    Call<RestRoomData> requestRestRooms(
            @Query("admin_token") String admin_token
    );


}
