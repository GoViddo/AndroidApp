package blockchainvideoapp.com.goviddo.goviddoandroid.fragments;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.Fragment;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SwitchCompat;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.Indicators.PagerIndicator;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;
import com.pnikosis.materialishprogress.ProgressWheel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

import blockchainvideoapp.com.goviddo.goviddoapp.R;
import blockchainvideoapp.com.goviddo.goviddoapp.adapter.RecyclerAdapter;
import blockchainvideoapp.com.goviddo.goviddoapp.coreclass.BackgrounFullLayoutChange;
import blockchainvideoapp.com.goviddo.goviddoapp.coreclass.BackgroundChangeCallingFragment;
import blockchainvideoapp.com.goviddo.goviddoapp.coreclass.RecyclerModel;

public class HomeFragment extends Fragment implements BaseSliderView.OnSliderClickListener, ViewPagerEx.OnPageChangeListener{

    // we will be loading 15 items per page or per load
    // you can change this to fit your specifications.
    // When you change this, there will be no need to update your php page,
    // as php will be ordered what to load and limit by android java
    private static final int LOAD_LIMIT = 15;

    // last id to be loaded from php page,
    // we will need to keep track or database id field to know which id was loaded last
    // and where to begin loading
    private String lastId = "0"; // this will issued to php page, so no harm make it string

    // we need this variable to lock and unlock loading more
    // e.g we should not load more when volley is already loading,
    // loading will be activated when volley completes loading
    private boolean itShouldLoadMore = true;

    // initialize adapter and data structure here
    private RecyclerAdapter recyclerAdapter;
    private ArrayList<RecyclerModel> recyclerModels;

    ProgressWheel progressWheel;

    SliderLayout mDemoSlider;
    PagerIndicator mPagerIndicator;


    SwitchCompat switchAB;

    BackgrounFullLayoutChange mBackgrounFullLayoutChange;

    BackgroundChangeCallingFragment mBackgroundChangeCallingFragment;

    RecyclerView recyclerView;

    Toolbar toolbar;

    CoordinatorLayout mCoordinatorLayoutBaseActivity;

    NestedScrollView mScrollView;

    TextView mTextTitleOfList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        mBackgrounFullLayoutChange = new BackgrounFullLayoutChange();

        View view = inflater.inflate(R.layout.homefragment, container, false);
        setHasOptionsMenu(true);


        mCoordinatorLayoutBaseActivity = getActivity().findViewById(R.id.mainActivityCoordinatorLayout);


        mTextTitleOfList = view.findViewById(R.id.textTitleOfList);

        // you must assign all objects to avoid nullPointerException
        recyclerModels = new ArrayList<>();

        recyclerAdapter = new RecyclerAdapter(recyclerModels);

        recyclerView =  view.findViewById(R.id.loadmore_recycler_view);



         progressWheel =  view.findViewById(R.id.progress_wheel);

        mDemoSlider = view.findViewById(R.id.slider);
        mPagerIndicator = view.findViewById(R.id.custom_indicator);


        mScrollView = view.findViewById(R.id.scrollview);



        HashMap<String,String> url_maps = new HashMap<String, String>();
        url_maps.put("Hannibal", "http://static2.hypable.com/wp-content/uploads/2013/12/hannibal-season-2-release-date.jpg");
        url_maps.put("Big Bang Theory", "http://tvfiles.alphacoders.com/100/hdclearart-10.png");
        url_maps.put("House of Cards", "http://cdn3.nflximg.net/images/3093/2043093.jpg");
        url_maps.put("Game of Thrones", "http://drsjit.tech/img/game_of_thrones.jpg");

        /*HashMap<String,Integer> file_maps = new HashMap<String, Integer>();
        file_maps.put("Hannibal",R.drawable.hannibal);
        file_maps.put("Big Bang Theory",R.drawable.bigbang);
        file_maps.put("House of Cards",R.drawable.house);
        file_maps.put("Game of Thrones", R.drawable.game_of_thrones);*/

        for(String name : url_maps.keySet()){
            TextSliderView textSliderView = new TextSliderView(getActivity());
            // initialize a SliderLayout
            textSliderView
                    .description(name)
                    .image(url_maps.get(name))
                    .setScaleType(BaseSliderView.ScaleType.Fit)
                    .setOnSliderClickListener(this);

            //add your extra information
            textSliderView.bundle(new Bundle());
            textSliderView.getBundle()
                    .putString("extra",name);

            mDemoSlider.addSlider(textSliderView);
        }
        mDemoSlider.setPresetTransformer(SliderLayout.Transformer.Accordion);
        mDemoSlider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        mDemoSlider.setCustomAnimation(new DescriptionAnimation());
        mDemoSlider.setDuration(4000);
        mDemoSlider.addOnPageChangeListener(this);





























        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setHasFixedSize(true);

        //we can now set adapter to recyclerView;
        recyclerView.setAdapter(recyclerAdapter);

        firstLoadData();



        mScrollView.getViewTreeObserver().addOnScrollChangedListener(new ViewTreeObserver.OnScrollChangedListener() {
            @Override
            public void onScrollChanged()
            {
                View view = (View)mScrollView.getChildAt(mScrollView.getChildCount() - 1);

                int diff = (view.getBottom() - (mScrollView.getHeight() + mScrollView
                        .getScrollY()));



                if (diff == 0) {
                    loadMore();
                }
            }
        });















        //Returning the layout file after inflating
        //Change R.layout.tab1 in you classes
        return view;


    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {

        inflater.inflate(R.menu.main, menu);
        super.onCreateOptionsMenu(menu, inflater);


        final MenuItem toggle = menu.findItem(R.id.switchId);
        switchAB =  toggle.getActionView().findViewById(R.id.switchAB);

        if (BackgrounFullLayoutChange.getFlag() == 2)
        {
            switchAB.setChecked(true);
        }
        else {
            switchAB.setChecked(false);
        }


        switchAB.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView,
                                         boolean isChecked) {
                if (isChecked) {
                   // Toast.makeText(getActivity(), "ON", Toast.LENGTH_SHORT).show();



                    mBackgrounFullLayoutChange.setFlag(2);



                    mBackgrounFullLayoutChange.setCoordinatorLayout(mCoordinatorLayoutBaseActivity,getActivity());
                    mBackgrounFullLayoutChange.setTextView(mTextTitleOfList,getActivity());


                    mBackgroundChangeCallingFragment = new BackgroundChangeCallingFragment(2,getActivity());


                    recyclerAdapter.notifyDataSetChanged();

                } else {
                  //  Toast.makeText(getActivity(), "OFF", Toast.LENGTH_SHORT).show();

                    mBackgrounFullLayoutChange.setFlag(1);

                    mBackgrounFullLayoutChange.setCoordinatorLayout(mCoordinatorLayoutBaseActivity,getActivity());
                    mBackgrounFullLayoutChange.setTextView(mTextTitleOfList,getActivity());
                    mBackgroundChangeCallingFragment = new BackgroundChangeCallingFragment(1,getActivity());


                    recyclerAdapter.notifyDataSetChanged();

                }
            }
        });




    }
















    // this function will load 15 items as indicated in the LOAD_LIMIT variable field
    private void firstLoadData() {

        String url = "http://hacksmile.com/hack_smile_tutorials/loadmore.php?limit="+LOAD_LIMIT;


        itShouldLoadMore = false; // lock this guy,(itShouldLoadMore) to make sure,
        // user will not load more when volley is processing another request
        // only load more when  volley is free

        final ProgressDialog progressDialog = new ProgressDialog(getActivity());
        progressDialog.setMessage("Loading...");
        progressDialog.setCancelable(false);
        progressDialog.show();


        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                progressDialog.dismiss();
                // remember here we are in the main thread, that means,
                //volley has finished processing request, and we have our response.
                // What else are you waiting for? update itShouldLoadMore = true;
                itShouldLoadMore = true;

                if (response.length() <= 0) {
                    // no data available
                    Toast.makeText(getActivity(), "No data available", Toast.LENGTH_SHORT).show();

                    return;
                }

                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject jsonObject = response.getJSONObject(i);

                        // please note this last id how we have updated it
                        // if there are 4 items for example, and we are ordering in descending order,
                        // then last id will be 1. This is because outside a loop, we will get the last
                        // value [Thanks to JAVA]

                        lastId = jsonObject.getString("id");
                        String title = jsonObject.getString("title");
                        String description = jsonObject.getString("description");

                        recyclerModels.add(new RecyclerModel(title, description));
                        recyclerAdapter.notifyDataSetChanged();

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

                // please note how we have updated our last id variable which is initially 0 (String)
                // outside the loop, java will return the last value, so here it will
                // certainly give us lastId that we need

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // also here, volley is not processing, unlock it should load more
                itShouldLoadMore = true;
                progressDialog.dismiss();
                Toast.makeText(getActivity(), "network error!", Toast.LENGTH_SHORT).show();

            }
        });

        Volley.newRequestQueue(getActivity()).add(jsonArrayRequest);


    }









    private void loadMore() {


        String url = "http://hacksmile.com/hack_smile_tutorials/loadmore.php?action=loadmore&lastId="+ lastId+"&limit="+LOAD_LIMIT;
        // our php page starts loading from 250 to 1, because we have [ORDER BY id DESC]
        // So until you clearly understand everything, for this tutorial use ORDER BY ID DESC
        // so we will do something like this to the php page
        //==============================================
        // $limit = $_GET['limit']
        // $lastId = $_GET['lastId']
        // then [SELECT * FROM table_name WHERE id < $lastId ORDER_BY id DESC LIMIT $limit ]
        // here we shall load 15 items from table where lastId id less than last loaded id

        // if you are using [ASC] in sql, your query might change to tis
        // then [SELECT * FROM table_name WHERE id > $lastId ORDER_BY id DESC LIMIT $limit ]
        // for this tutorial let's stick to [DESC]


        itShouldLoadMore = false; // lock this until volley completes processing

        // progressWheel is just a loading spinner, please see the content_main.xml

        progressWheel.setVisibility(View.VISIBLE);

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                progressWheel.setVisibility(View.GONE);

                // since volley has completed and it has our response, now let's update
                // itShouldLoadMore

                itShouldLoadMore = true;

                if (response.length() <= 0) {
                    // we need to check this, to make sure, our dataStructure JSonArray contains
                    // something
                    Toast.makeText(getActivity(), "no data available", Toast.LENGTH_SHORT).show();
                    return; // return will end the program at this point
                }

                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject jsonObject = response.getJSONObject(i);

                        // please note how we have updated the lastId variable
                        // if there are 4 items for example, and we are ordering in descending order,
                        // then last id will be 1. This is because outside a loop, we will get the last
                        // value

                        lastId = jsonObject.getString("id");
                        String title = jsonObject.getString("title");
                        String description = jsonObject.getString("description");

                        recyclerModels.add(new RecyclerModel(title, description));
                        recyclerAdapter.notifyDataSetChanged();

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                progressWheel.setVisibility(View.GONE);
                // volley finished and returned network error, update and unlock  itShouldLoadMore
                itShouldLoadMore = true;
               // Toast.makeText(getActivity(), "Failed to load more, network error", Toast.LENGTH_SHORT).show();

            }
        });

        Volley.newRequestQueue(getActivity()).add(jsonArrayRequest);

    }



    @Override
    public void onStop() {
        mDemoSlider.stopAutoCycle();
        super.onStop();
    }

    @Override
    public void onSliderClick(BaseSliderView slider) {
        Toast.makeText(getActivity(),slider.getBundle().get("extra") + "",Toast.LENGTH_SHORT).show();
    }



    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {}

    @Override
    public void onPageSelected(int position) {
        Log.d("Slider Demo", "Page Changed: " + position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {}







}
