package project.codenicely.admin.a1mile.a1mileadmin.restroom.api;

import project.codenicely.admin.a1mile.a1mileadmin.helper.Urls;
import project.codenicely.admin.a1mile.a1mileadmin.restroom.model.RestRoomStatusUpdateData;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by meghal on 10/3/17.
 */

public interface RestRoomStatusUpdateApi {

    @FormUrlEncoded
    @POST(Urls.SUB_URL_ADMIN_UPDATE_RESTROOM_STATUS)
    Call<RestRoomStatusUpdateData> requestRestRoomStatusUpdate(
            @Field("adminToken") String adminToken,
            @Field("restRoomId") String restRoomId,
            @Field("verify") boolean verify,
            @Field("position") int position


    );


}
