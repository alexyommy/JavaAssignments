import java.util.HashMap;
import java.util.Set;

public class Hashmatique{
    public static void main(String[] args) {
        HashMap<String, String> trackList = new HashMap<String, String>();
        trackList.put("Waves", "Miguel");
        trackList.put("Say So", "Doja Cat");
        trackList.put("Real As It Gets", "Lil Baby");
        trackList.put("Emotionless", "Drake");
        System.out.println(trackList.get("Emotionless"));
        Set<String> keys = trackList.keySet();
        for(String key: keys) {
            System.out.println(key + ": " + trackList.get(key));
        }
    }
}