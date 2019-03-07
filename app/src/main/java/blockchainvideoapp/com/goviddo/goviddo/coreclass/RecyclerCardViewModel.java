package blockchainvideoapp.com.goviddo.goviddo.coreclass;

public class RecyclerCardViewModel{

String name,heading;
int count;



    public RecyclerCardViewModel(String heading, int count) {
        this.heading = heading;
        this.count = count;
    }

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public String getName() {
        return name;
    }

    public int getCount() {
        return count;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
