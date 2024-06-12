package finalProject;
import java.util.Random;
public class Thing {
    Random ran = new Random();
    int thingId = ran.nextInt(10000);

    public int getThingId()
    {
        return this.thingId;
    }
}

