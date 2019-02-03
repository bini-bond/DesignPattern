import java.io.Serializable;


public class SwimmerSexData extends SwimData implements Cloneable, Serializable {

    private SwimData swimData;

    public SwimmerSexData(SwimData data) {

       swimData = (SwimData) data.deepClone();
       this.swimmers = swimData.swimmers;

    }

    public void filterBySex(int selection){
        for(int i=0;i<swimmers.size();i++){
            Swimmer sw = (Swimmer) swimmers.get(i);

                if(!sw.isFemale()){
                    System.out.println(sw.getName());
                    swimmers.remove(i);
                }

            else if(selection == 1){
                if(sw.isFemale()){
                    System.out.println(sw.getName());
                    swimmers.remove(i);
                }
            }

        }


    }

}
