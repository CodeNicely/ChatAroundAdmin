package project.codenicely.admin.a1mile.a1mileadmin.restroom.model;

/**
 * Created by meghal on 10/3/17.
 */

public class RestRoomStatusUpdateData {

    private boolean success;
    private String message;
    private int position;

    public RestRoomStatusUpdateData(boolean success, String message, int position) {
        this.success = success;
        this.message = message;
        this.position = position;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public int getPosition() {
        return position;
    }
}
