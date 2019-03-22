package blockchainvideoapp.com.goviddo.goviddo.coreclass;

public class HomeRecyclerModel {


    private String mTitle;
    private String mDescription;

    public HomeRecyclerModel(String title, String description) {
        this.mTitle = title;
        this.mDescription = description;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getDescription() {
        return mDescription;
    }


}