import java.io.Serializable;
import java.util.StringTokenizer;

class Swimmer implements Serializable {
    private String name;

    private int age;

    private String club;

    private float time;

    private boolean female;

    public Swimmer(String dataline) {

        StringTokenizer st = new StringTokenizer(dataline, ",");
        name = st.nextToken();
        age = new Integer(st.nextToken().trim()).intValue();
        club = st.nextToken().trim();
        time = new Float(st.nextToken().trim()).floatValue();
        //System.out.println(name+" "+time);
        String sx = st.nextToken().trim().toUpperCase();
        female = sx.equals("F");
    }

    public boolean isFemale() {
        return female;
    }

    public int getAge() {
        return age;
    }

    public float getTime() {
        return time;
    }

    public String getName() {
        return name;
    }

    public String getClub() {
        return club;
    }
}