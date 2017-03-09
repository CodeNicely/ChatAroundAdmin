package project.codenicely.admin.a1mile.a1mileadmin.image_viewer;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.alexvasilkov.gestures.Settings;
import com.alexvasilkov.gestures.views.GestureImageView;

import java.util.ArrayList;

import project.codenicely.admin.a1mile.a1mileadmin.R;
import project.codenicely.admin.a1mile.a1mileadmin.helper.Urls;
import project.codenicely.admin.a1mile.a1mileadmin.helper.image_loader.GlideImageLoader;
import project.codenicely.admin.a1mile.a1mileadmin.helper.image_loader.ImageLoader;


/**
 * This class extends PagerAdapter
 * image url list is passed as a list to this adapter
 * <p>
 * Created by Meghal on 6/9/2016.
 */
public class ImageViewerPagerAdapter extends PagerAdapter {

    private static final String TAG = "OrderDetailsPagerAdptr";
    private Context context;
    private ArrayList<String> imageUrlList = new ArrayList<>();
    private LayoutInflater layoutInflater;
    private ImageLoader imageLoader;

    ImageViewerPagerAdapter(Context context, ArrayList<String> imageUrlList) {

        this.context = context;
        this.imageUrlList = imageUrlList;
        imageLoader = new GlideImageLoader(context);
        Log.i(TAG, "Contructor called");
    }


    @Override
    public int getCount() {
        Log.i(TAG, "Count : " + imageUrlList.size());

        return this.imageUrlList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        Log.i(TAG, "isView");

        return view == (object);
    }

    @Override
    public Object instantiateItem(final ViewGroup container, int position) {

        final GestureImageView imageView;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        String url = imageUrlList.get(position);


        Log.i(TAG, "Initiate item  Urls :" + url);
        View view = layoutInflater.inflate(R.layout.image_viewer_item, container, false);

        imageView = (GestureImageView) view.findViewById(R.id.imageView);

        // imageView.getController().getSettings()
        //        imageView.setMaxZoom(1f);

        //        .setFitMethod(Settings.Fit.INSIDE)
        ProgressBar progressBar = (ProgressBar) view.findViewById(R.id.progressBar);

        //   imageView.getController().getSettings().enableGestures();
        // The code is for gesture image view #
        imageView.getController().getSettings()
                .setMaxZoom(5f)
                .setPanEnabled(true)
                .setZoomEnabled(true)
                .setDoubleTapEnabled(true)
                .setRotationEnabled(false)
                .setRestrictRotation(false)
                .setOverscrollDistance(10f, 10f)
                .setOverzoomFactor(3f)
                .setFitMethod(Settings.Fit.INSIDE)
                //.setFillViewport(true)
                //    .setFitMethod(Settings.Fit.INSIDE)
                .setGravity(Gravity.CENTER);
        if (context instanceof ImageViewerActivity) {
            ((ImageViewerActivity) context).enableScroll(imageView);
        }

        imageLoader.loadImage(Urls.BASE_URL + "ImageReturn?ImageName=" + url, imageView, progressBar);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        //     (container).removeView((CropperView) object);
    }
}
