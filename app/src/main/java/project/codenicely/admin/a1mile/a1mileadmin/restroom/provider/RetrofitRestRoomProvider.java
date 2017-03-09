package project.codenicely.admin.a1mile.a1mileadmin.restroom.provider;


import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import project.codenicely.admin.a1mile.a1mileadmin.helper.Urls;
import project.codenicely.admin.a1mile.a1mileadmin.restroom.OnRestRoomApiResponse;
import project.codenicely.admin.a1mile.a1mileadmin.restroom.OnRestRoomStatusUpdateResponse;
import project.codenicely.admin.a1mile.a1mileadmin.restroom.api.RestRoomRequestApi;
import project.codenicely.admin.a1mile.a1mileadmin.restroom.api.RestRoomStatusUpdateApi;
import project.codenicely.admin.a1mile.a1mileadmin.restroom.model.RestRoomData;
import project.codenicely.admin.a1mile.a1mileadmin.restroom.model.RestRoomStatusUpdateData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by meghal on 19/2/17.
 */

public class RetrofitRestRoomProvider implements RestRoomProvider {

    private Retrofit retrofit;

    public RetrofitRestRoomProvider() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor)
                .build();


        retrofit = new Retrofit.Builder()
                .baseUrl(Urls.BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }


    @Override
    public void requestRestRooms(String user_id, final OnRestRoomApiResponse onRestRoomApiResponse) {

        RestRoomRequestApi restRoomRequestApi = retrofit.create(RestRoomRequestApi.class);
        Call<RestRoomData> call = restRoomRequestApi.requestRestRooms(user_id);
        /*call.enqueue(new Callback<RestRoomData>() {
            @Override
            public void onResponse(Call<List<RestRoomDetails>> call, Response<List<RestRoomDetails>> response) {
                onRestRoomApiResponse.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<List<RestRoomDetails>> call, Throwable t) {

                t.printStackTrace();
                onRestRoomApiResponse.onFailure("Failed to connect to server");
            }
        });*/

        call.enqueue(new Callback<RestRoomData>() {
            @Override
            public void onResponse(Call<RestRoomData> call, Response<RestRoomData> response) {
                onRestRoomApiResponse.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<RestRoomData> call, Throwable t) {

                onRestRoomApiResponse.onFailure("Something Went Wrong");
            }
        });
    }

    @Override
    public void requestRestroomStatusUpdate(String adminToken,
                                            String restroomId,
                                            boolean verify,
                                            int position,
                                            final OnRestRoomStatusUpdateResponse onRestRoomStatusUpdateResponse) {

        RestRoomStatusUpdateApi restRoomStatusUpdateApi = retrofit
                .create(RestRoomStatusUpdateApi.class);

        Call<RestRoomStatusUpdateData> call = restRoomStatusUpdateApi
                .requestRestRoomStatusUpdate(adminToken, restroomId, verify, position);

        call.enqueue(new Callback<RestRoomStatusUpdateData>() {
            @Override
            public void onResponse(Call<RestRoomStatusUpdateData> call,
                                   Response<RestRoomStatusUpdateData> response) {

                onRestRoomStatusUpdateResponse.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<RestRoomStatusUpdateData> call, Throwable t) {

                t.printStackTrace();
                onRestRoomStatusUpdateResponse.onFailure("Unable to connect to Servers. Please Check" +
                        " your Connection");
            }
        });

    }
}
