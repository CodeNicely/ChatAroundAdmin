package project.codenicely.admin.a1mile.a1mileadmin.restroom.view;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import project.codenicely.admin.a1mile.a1mileadmin.R;
import project.codenicely.admin.a1mile.a1mileadmin.helper.Keys;
import project.codenicely.admin.a1mile.a1mileadmin.restroom.model.RestRoomDetails;
import project.codenicely.admin.a1mile.a1mileadmin.restroom.presenter.RestRoomPresenter;
import project.codenicely.admin.a1mile.a1mileadmin.restroom.presenter.RestRoomPresenterImpl;
import project.codenicely.admin.a1mile.a1mileadmin.restroom.provider.RetrofitRestRoomProvider;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * Use the {@link RestRoomFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RestRoomFragment extends Fragment implements RestRoomView {

    // TODO: Rename parameter arguments, choose names that match

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final String TAG = "RestRoomFragment";

    private final static int CONNECTION_FAILURE_RESOLUTION_REQUEST = 9000;

    private double latitude;
    private double longitude;

    private static View view;
    private Context context;
    private RestRoomAdapter restRoomAdapter;


    @BindView(R.id.progressBar)
    ProgressBar progressBar;

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;


    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public RestRoomFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment RestRoomFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static RestRoomFragment newInstance(String param1, String param2) {
        RestRoomFragment fragment = new RestRoomFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        if (view != null) {
            ViewGroup parent = (ViewGroup) view.getParent();
            if (parent != null)
                parent.removeView(view);
        }
        try {
            view = inflater.inflate(R.layout.fragment_restroom, container, false);
        } catch (InflateException e) {
        /* map is already there, just return view as it is */
        }


        ButterKnife.bind(this, view);
        context = getContext();
        restRoomAdapter = new RestRoomAdapter(context);


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(restRoomAdapter);


        RestRoomPresenter restRoomPresenter = new RestRoomPresenterImpl(this, new RetrofitRestRoomProvider());
        restRoomPresenter.requestRestrooms(Keys.KEY_ADMIN_TOKEN);

        return view;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    }

    // TODO: Rename method, update argument and hook method into UI event

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        onDestroy();
    }

    @Override
    public void showLoader(boolean show) {
        if (show) {

            recyclerView.setVisibility(View.GONE);
            progressBar.setVisibility(View.VISIBLE);
        } else {
            progressBar.setVisibility(View.GONE);
            recyclerView.setVisibility(View.VISIBLE);

        }
    }

    @Override
    public void showMessage(String message) {

        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();

    }


    @Override
    public void onReceived(List<RestRoomDetails> restRoomDetailsList) {

        Log.d("Data Received", String.valueOf(restRoomDetailsList.size()));
        restRoomAdapter.setData(restRoomDetailsList);
        restRoomAdapter.notifyDataSetChanged();


    }

}
