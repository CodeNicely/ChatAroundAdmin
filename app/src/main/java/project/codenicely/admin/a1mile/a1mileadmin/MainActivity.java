package project.codenicely.admin.a1mile.a1mileadmin;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;

import project.codenicely.admin.a1mile.a1mileadmin.helper.Keys;
import project.codenicely.admin.a1mile.a1mileadmin.image_viewer.ImageViewerActivity;
import project.codenicely.admin.a1mile.a1mileadmin.restroom.view.RestRoomFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setFragment(new RestRoomFragment(), "RestRoomFragment");

    }

    public void openImageViewer(String url, int position) {

        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(url);

        Intent intent = new Intent(this, ImageViewerActivity.class);
        intent.putStringArrayListExtra(Keys.KEY_IMAGE_LIST, arrayList);
        intent.putExtra(Keys.KEY_POSITION_IMAGE, position);
        startActivity(intent);
    }


    public void openGoogleMaps(double latitude, double longitude) {
        Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
                Uri.parse("http://maps.google.com/maps?daddr=" + latitude + "," + longitude));
        startActivity(intent);
    }


    public void openImageViewer(ArrayList<String> urlList, int position) {

        Intent intent = new Intent(this, ImageViewerActivity.class);
        intent.putStringArrayListExtra(Keys.KEY_IMAGE_LIST, urlList);
        intent.putExtra(Keys.KEY_POSITION_IMAGE, position);
        startActivity(intent);
    }

    public void setFragment(Fragment fragment, String title) {
        if (fragment != null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container_body, fragment);
            fragmentTransaction.commit();

        }
    }
}
