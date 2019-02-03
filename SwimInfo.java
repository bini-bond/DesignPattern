import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class SwimInfo extends Frame implements ActionListener {
    private SwimData sdata, sxdata = null;
    private SwimmerSexData ssd = null;
    private List swList, cloneList;

    private Button Clone, Refresh, Quit;

    JRadioButton male;
    JRadioButton female;


    private Swimmer sw;

    public SwimInfo() {
        super("Table");
        sdata = new SwimData("swimmers.txt");

        setGUI();
        loadswList();
    }

    //-
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if (obj == Clone)
            cloneAndLoad();
        if (obj == Refresh)
            loadswList();
        if(obj == male){

        }
        if (obj == Quit)
            System.exit(0);
    }

    //-
    private void cloneAndLoad() {
//        sxdata = (SwimData)sdata.deepClone();
        sxdata = (SwimData) sdata.clone();
        sxdata.sortByTime();

        iterate(cloneList, sxdata);
    }

    //-
    private void loadswList() {
        iterate(swList, sdata);
    }
    private void filterBysex(int choice){
       ssd = new SwimmerSexData(sdata);

        ssd.filterBySex(choice);

        iterate(cloneList, ssd);
    }
    private void iterate(List swList, SwimData sdata) {
        swList.removeAll();
        for (int i = 0; i < sdata.size(); i++) {
            sw = sdata.getSwimmer(i);
            swList.add(sw.getName() + " " + sw.getTime());
        }
    }

    //-

    private void setGUI() {
        setLayout(new GridLayout(1, 3));
        setBackground(Color.lightGray);
        swList = new List(25);
        cloneList = new List(25);
        Panel cp = new Panel();
        add(swList);
        add(cp);
        add(cloneList);
        Clone = new Button("ByTime >");
        Refresh = new Button("<Refresh");
        Quit = new Button("Quit");
        JRadioButton male = new JRadioButton("Male");
        male.setMnemonic(KeyEvent.VK_B);
//        birdButton.setActionCommand(filterSex);
        male.addActionListener(actionEvent -> filterBysex(1));

        female = new JRadioButton("Female");

        female.setMnemonic(KeyEvent.VK_C);
       female.addActionListener(actionEvent -> filterBysex(0));

        cp.setLayout(new GridLayout(3, 1));
        Panel p1 = new Panel();
        cp.add(p1);
        p1.add(Clone);
        Panel p2 = new Panel();
        cp.add(p2);
        p2.add(Refresh);


        ButtonGroup group = new ButtonGroup();
        JButton jButton = new JButton("Click");
        group.add(male);
        group.add(female);

        Panel radioPanel = new Panel();
        cp.add(radioPanel);
        radioPanel.setLayout(new GridLayout(3, 1));
        radioPanel.add(male);
        radioPanel.add(female);


        Panel p3 = new Panel();
        cp.add(p3);
        p3.add(Quit);
        Clone.addActionListener(this);
        Refresh.addActionListener(this);
        Quit.addActionListener(this);
        setBounds(100, 100, 500, 400);
        setVisible(true);
    }

    //-
    static public void main(String argv[]) {
        new SwimInfo();
    }
}

