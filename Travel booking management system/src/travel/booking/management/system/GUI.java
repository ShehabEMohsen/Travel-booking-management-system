/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package travel.booking.management.system;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.swing.JOptionPane.showMessageDialog;


public class GUI extends JFrame {

    JButton btnManager, btnCustomer, btnSubmit, btnAddG, btnEditG, btnDeleteG, btnDisplayG,
            btnChoice1, btnChoice2, btnAddC, btnEditC, btnDeleteC, btnDisplayC, AddTGSubmit, AddCSubmit, CSubmit,btnback, btpay,RCSubmit,btcheck;

    JLabel lbl1, lbl2, lbl3, lblTfname, lblTlname, lblTage, lblTid, lblCfname, lblClname, lblCage, lblCid, lblCgender,lblTourType,lblNumberOfSeats,Cfnamelbl, Clnamelbl,Cagelbl, Cidlbl,lblTypeofticket,lblpersons,lblfrom,lblto,lblsum,lblchange,lblpay,lblsumresult,lblchangeresult,lblenterpersons,lblday,lblmonth,lblyear,lblerrordate;

    JPasswordField txt1, txt2, txt3;

    JTextField txtTfname, txtTlname, txtTage, txtTid, txtCfname, txtClname, txtCage, txtCid, txtCgender,txtNumberOfSeats, cfnametxt,clnametxt,cidtxt,cagetxt,persontxt,paytxt,changetxt;

    JComboBox tourTypes, startDay, startMonth, startYear, endDay,endMonth,endYear,typeofticket,fromday,frommonth,fromyear,to_day,to_month,to_year;

    JRadioButton genderM, genderF;

    ButtonGroup group = new ButtonGroup();

    Listen l = new Listen();

    JButton back = new JButton(new ImageIcon("Back.PNG"));
    int stage;
    private JRadioButton Available;
    private JRadioButton NotAvailable;
    private ButtonGroup group2 = new ButtonGroup();

    public GUI() {
        setTitle("Travel Management");
//        setBackground(Color.BLUE);
//        setForeground(Color.BLUE);
        setLayout(null);

        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        revalidate();
        repaint();
        setVisible(true);
        Frame0();
        setLocationRelativeTo(null);


        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getContentPane().removeAll();
                setSize(600,600);
                if(stage == 2){

                    remove(back);

                    stage--;
                    Frame0();
                    revalidate();

                }
                else if(stage == 3){
                    setSize(400,200);
                    stage--;
                    Frame1();
                    revalidate();
                    repaint();
                }
                else if(stage == 4){
                    setSize(600,600);
                    stage--;
                    Frame2();
                    revalidate();
                    repaint();
                }
                else if(stage == 5){
                    setSize(600,600);
                    stage--;
                    Frame2();
                    revalidate();
                    repaint();
                }
            }
        });
        //Action Listeners
        btnManager.addActionListener(l);
        btnCustomer.addActionListener(l);
        btnDisplayG = new JButton("Display Tour Guide");
        btnDisplayG.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getContentPane().removeAll();
                getContentPane().revalidate();
                setSize(601,601);
                setSize(600,600 );
                try {
                    DisplayTour_guide();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                } catch (ClassNotFoundException classNotFoundException) {
                    classNotFoundException.printStackTrace();
                }
            }
        });


    }

    public void Frame0(){
    lbl1 = new JLabel("Welcome to our Travel Booking System");
    lbl1.setBounds(170, 0, 300, 100);
    btnManager = new JButton("Manager");
    btnManager.setBounds(140, 80, 300, 150);
    btnCustomer = new JButton("Reservation");
    btnCustomer.setBounds(140, 300, 300, 150);
    stage = 1;
    add(lbl1);
    add(btnManager);
    add(btnCustomer);

    btnManager.addActionListener(l);
    btnCustomer.addActionListener(l);
}

    public void Frame1() {
        //Manager password outlay
        back.setBounds(0,0,50,50);
        back.setBackground(Color.WHITE);
        back.setOpaque(false);
        back.setBorder(BorderFactory.createEmptyBorder());
        add(back);
        stage = 2;
        setTitle("Login");
        setLayout(null);
        lbl1 = new JLabel("Enter your password");
        lbl1.setBounds(50, 53, 150, 50);

        txt1 = new JPasswordField(15);
        txt1.setBounds(200, 70, 150, 20);

        btnSubmit = new JButton("Submit");
        btnSubmit.setBounds(135, 100, 120, 30);
        add(lbl1);
        add(txt1);
        add(btnSubmit);
        //Action Listener
        btnSubmit.addActionListener(l);
    }

    public void Frame2() {
        back.setBounds(0,0,50,50);
        back.setBackground(Color.WHITE);
        back.setOpaque(false);
        add(back);
        stage = 3;
        setTitle("Manager Screen");
        setSize(600, 600);
        setLayout(null);
        btnChoice1 = new JButton("Tour Guide Management");
        btnChoice1.setBounds(140, 80, 300, 150);

        btnChoice2 = new JButton("Customer Management");
        btnChoice2.setBounds(140, 300, 300, 150);

        add(btnChoice1);
        add(btnChoice2);

        //Action listener
        btnChoice1.addActionListener(l);
        btnChoice2.addActionListener(l);
    }

    public void Frame3() {
        //Manage Tour Guides
        back.setBounds(0,0,50,50);
        back.setBackground(Color.WHITE);
        back.setOpaque(false);
        add(back);
        stage = 4;
        setSize(600, 600);
        setLayout(null);

        setTitle("Tour Guide Management Screen");
//        lbl1=new JLabel("What would you like to do?");
//        lbl1.setBounds(170,0,300,100);

        btnAddG = new JButton("Add Tour Guide");
        btnAddG.setBounds(95, 100, 400, 51);

        btnEditG = new JButton("Edit Tour Guide");
        btnEditG.setBounds(95, 200, 400, 51);
        btnEditG.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getContentPane().removeAll();
                revalidate();
                repaint();
                setSize(601,601);
                setSize(600,600);
                try {
                    EditGuide();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                } catch (ClassNotFoundException classNotFoundException) {
                    classNotFoundException.printStackTrace();
                }
            }
        });

        btnDeleteG = new JButton("Delete Tour Guide");
        btnDeleteG.setBounds(95, 300, 400, 51);
        btnDeleteG.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getContentPane().removeAll();
                getContentPane().revalidate();
                setSize(601,601);
                setSize(600,600 );
                try {
                    DeleteGuide();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                } catch (ClassNotFoundException classNotFoundException) {
                    classNotFoundException.printStackTrace();
                }
            }
        });

        btnDisplayG.setBounds(95, 400, 400, 51);

        add(btnAddG);
        add(btnEditG);
        add(btnDeleteG);
        add(btnDisplayG);

        //Action Listeners
        btnAddG.addActionListener(l);
        btnEditG.addActionListener(l);
        btnDeleteG.addActionListener(l);
        btnDisplayG.addActionListener(l);
    }

    public void Frame4() {
        stage = 4;
        back.setBounds(0,0,50,50);
        back.setBackground(Color.WHITE);
        back.setOpaque(false);
        add(back);
        setSize(600, 600);
        setLayout(null);

        setTitle("Customer Management Screen");
//        lbl1=new JLabel("What would you like to do?");
//        lbl1.setBounds(170,0,300,100);

        btnAddC = new JButton("Add Customer");
        btnAddC.setBounds(95, 100, 400, 51);

        btnEditC = new JButton("Edit Customer");
        btnEditC.setBounds(95, 200, 400, 51);

        btnDeleteC = new JButton("Delete Customer");
        btnDeleteC.setBounds(95, 300, 400, 51);

        btnDisplayC = new JButton("Display Customer");
        btnDisplayC.setBounds(95, 400, 400, 51);

        add(btnAddC);
        add(btnEditC);
        add(btnDeleteC);
        add(btnDisplayC);

        //Action Listener
        btnAddC.addActionListener(l);
        btnDisplayC.addActionListener(l);
        btnDeleteC.addActionListener(l);
        btnEditC.addActionListener(l);

    }

    public void AddTFrame() {
        setSize(600, 600);
        setLayout(null);
        back.setBounds(0,0,50,50);
        back.setBackground(Color.WHITE);
        back.setOpaque(false);
        back.setBorder(BorderFactory.createEmptyBorder());
        add(back);
        setTitle("Add Tour Guide");

        lblTfname = new JLabel("First Name");
        lblTfname.setFont(new Font("Serif", 20, 20));
        lblTfname.setBounds(150, 50, 150, 20);

        lblTlname = new JLabel("Last Name");
        lblTlname.setFont(new Font("Serif", 20, 20));
        lblTlname.setBounds(150, 75, 150, 70);

        lblTage = new JLabel("Age");
        lblTage.setFont(new Font("Serif", 20, 20));
        lblTage.setBounds(150, 125, 80, 70);

        lblTid = new JLabel("ID");
        lblTid.setFont(new Font("Serif", 20, 20));
        lblTid.setBounds(150, 175, 80, 70);

        JLabel lblTgender = new JLabel("Gender");
        lblTgender.setFont(new Font("Serif", 20, 20));
        lblTgender.setBounds(150, 300, 80, 70);

        JLabel lblTtrips = new JLabel("no. of trips");
        lblTtrips.setFont(new Font("Serif", 20, 20));
        lblTtrips.setBounds(150, 225, 110, 70);

        JLabel lblAvailable = new JLabel("Availability");
        lblAvailable.setFont(new Font("Serif", 20, 20));
        lblAvailable.setBounds(150, 375, 100, 70);

        txtTfname = new JTextField(15);
        txtTfname.setBounds(300, 50, 150, 20);

        txtTlname = new JTextField(15);
        txtTlname.setBounds(300, 100, 150, 20);

        txtTage = new JTextField(15);
        txtTage.setBounds(300, 150, 150, 20);

        txtTid = new JTextField(15);
        txtTid.setBounds(300, 200, 150, 20);

        JTextField txtTtrips = new JTextField(15);
        txtTtrips.setBounds(300, 250, 150, 20);

        genderM = new JRadioButton("Male");
        genderF = new JRadioButton("Female");
        genderM.setBounds(300, 300, 80, 80);
        genderF.setBounds(380, 300, 80, 80);

        Available= new JRadioButton("Available");
        NotAvailable = new JRadioButton("Not available");
        Available.setBounds(300, 370, 80, 80);
        NotAvailable.setBounds(380, 370, 100, 80);

        group.add(genderM);
        group.add(genderF);


        group2.add(Available);
        group2.add(NotAvailable);

        AddTGSubmit = new JButton("Submit");
        AddTGSubmit.setFont(new Font("Serif", 20, 20));
        AddTGSubmit.setBounds(230, 470, 120, 40);

        add(lblTfname);
        add(lblTlname);
        add(lblTage);
        add(lblTid);
        add(lblTgender);
        add(lblTtrips);
        add(lblAvailable);
        add(txtTfname);
        add(txtTlname);
        add(txtTage);
        add(txtTid);
        add(txtTtrips);
        add(genderM);
        add(genderF);
        add(Available);
        add(NotAvailable);


        add(AddTGSubmit);

        //Action Listener
        AddTGSubmit.addActionListener(l);
        AddTGSubmit.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e)  {
                AddTGSubmit.addActionListener(l);
                char option;
                if(genderM.isSelected()){
                    option = 'm';
                }
                else{
                    option = 'f';
                }
                String option2;
                if(Available.isSelected()){
                    option2 = "Available";
                }
                else{
                    option2 = "NotAvailable";
                }
                ArrayList <Tour_Guide> Guide = new ArrayList();
                Guide.add(new Tour_Guide(txtTfname.getText(), txtTlname.getText(),Integer.parseInt(txtTage.getText()),Integer.parseInt(txtTid.getText()),option,Integer.parseInt(txtTtrips.getText()),option2));
                try {
                    Files.writeguide(Guide);
                } catch (IOException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        });
    }

    public void AddCFrame() {
        setSize(600, 600);
        setLayout(null);
        back.setBounds(0,0,50,50);
        back.setBackground(Color.WHITE);
        back.setOpaque(false);
        add(back);
        stage = 5;
        setTitle("Add Customer");

        lblCfname = new JLabel("First Name");
        lblCfname.setFont(new Font("Serif", 20, 20));
        lblCfname.setBounds(150, 75, 150, 70);

        lblClname = new JLabel("Last Name");
        lblClname.setFont(new Font("Serif", 20, 20));
        lblClname.setBounds(150, 150, 150, 70);

        lblCage = new JLabel("Age");
        lblCage.setFont(new Font("Serif", 20, 20));
        lblCage.setBounds(150, 200, 80, 70);

        lblCid = new JLabel("ID");
        lblCid.setFont(new Font("Serif", 20, 20));
        lblCid.setBounds(150, 250, 80, 70);

        lblCgender = new JLabel("Gender");
        lblCgender.setFont(new Font("Serif", 20, 20));
        lblCgender.setBounds(150, 300, 80, 70);

        txtCfname = new JTextField(15);
        txtCfname.setBounds(300, 100, 150, 20);

        txtClname = new JTextField(15);
        txtClname.setBounds(300, 175, 150, 20);

        txtCage = new JTextField(15);
        txtCage.setBounds(300, 230, 150, 20);

        txtCid = new JTextField(15);
        txtCid.setBounds(300, 280, 150, 20);

        genderM = new JRadioButton("Male");
        genderF = new JRadioButton("Female");
        genderM.setBounds(300, 300, 80, 80);
        genderF.setBounds(380, 300, 80, 80);

        AddCSubmit = new JButton("Submit");
        AddCSubmit.setFont(new Font("Serif", 20, 20));
        AddCSubmit.setBounds(230, 470, 120, 40);
        group.add(genderM);
        group.add(genderF);
        add(lblCfname);
        add(lblClname);
        add(lblCage);
        add(lblCid);
        add(txtCfname);
        add(txtClname);
        add(txtCage);
        add(txtCid);
        add(lblCgender);
        add(genderM);
        add(genderF);
        add(AddCSubmit);


        //Action Listener
        AddCSubmit.addActionListener(l);
        AddCSubmit.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e)  {
                //String name,String lastname, int age, int ID,char gender

                char option;
                if(genderM.isSelected()){
                    option = 'm';
                }
                else{
                    option = 'f';
                }
                ArrayList <Customer> cus = new ArrayList();
                cus.add(new Customer(txtCfname.getText(), txtClname.getText(),Integer.parseInt(txtCage.getText()),Integer.parseInt(txtCid.getText()),option));
                try {
                    // Customer c = new Customer(txtCfname.getText(), txtClname.getText(),Integer.parseInt(txtCage.getText()),Integer.parseInt(txtCid.getText()),option);
                    Files.writecus(cus);
                } catch (IOException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        });
    }

    public void CustomerInterface() 
    {
        setSize(750, 700);
        setLayout(null);
        this.setLocation(200, 20);

        setTitle("Add Customer");
 
        lblCfname = new JLabel("First Name");
        lblCfname.setFont(new Font("Serif", 20, 20));
        lblCfname.setBounds(100, 30, 150, 70);

        lblClname = new JLabel("Last Name");
        lblClname.setFont(new Font("Serif", 20, 20));
        lblClname.setBounds(100, 80, 150, 70);

        lblCage = new JLabel("Age");
        lblCage.setFont(new Font("Serif", 20, 20));
        lblCage.setBounds(100, 130, 80, 70);

        lblCid = new JLabel("ID");
        lblCid.setFont(new Font("Serif", 20, 20));
        lblCid.setBounds(100, 180, 80, 70);

        lblCgender = new JLabel("Gender");
        lblCgender.setFont(new Font("Serif", 20, 20));
        lblCgender.setBounds(100, 230, 80, 70);

        txtCfname = new JTextField(15);
        txtCfname.setBounds(250, 55, 150, 20);

        txtClname = new JTextField(15);
        txtClname.setBounds(250, 110, 150, 20);

        txtCage = new JTextField(15);
        txtCage.setBounds(250, 160, 150, 20);

        txtCid = new JTextField(15);
        txtCid.setBounds(250, 210, 150, 20);

        genderM = new JRadioButton("Male");
        genderF = new JRadioButton("Female");
        genderM.setBounds(250, 230, 80, 80);
        genderF.setBounds(340, 230, 80, 80);

        lblTypeofticket=new JLabel("Type of ticket");
        lblTypeofticket.setFont(new Font("Serif", 20, 20));
        lblTypeofticket.setBounds(485,310,130,70);
        
        typeofticket = new JComboBox(new String[]{"Platinum","Gold","Silver"});
        typeofticket.setBounds(600,320,100,50);
        
        lblTourType=new JLabel("Tour Type");
        lblTourType.setFont(new Font("Serif", 20, 20));
        lblTourType.setBounds(15,320,140,50);
        
        tourTypes=new JComboBox(new String[]{"General","Family","Couples"});
        tourTypes.setBounds(110,325,100,50);
        
        
        lblpersons=new JLabel("no. of tickets:");
        lblto=new JLabel("To:");
        lblfrom=new JLabel("From:");
        
        lblenterpersons=new JLabel();
        lblenterpersons.setBounds(330,280,170,70);
        lblenterpersons.setForeground(Color.red);
        lblenterpersons.setFont(new Font("Serif", 10, 15));
        
        
        lblpersons.setBounds(220,310,130,70);
        lblpersons.setFont(new Font("Serif", 20, 20));
        
        persontxt=new JTextField(15);
        persontxt.setBounds(330,325,100,40);
        
        lblfrom.setBounds(100,390,70,50);
        lblfrom.setFont(new Font("Serif", 20, 20));
        
        lblto.setBounds(120,440,70,50);
        lblto.setFont(new Font("Serif", 20, 20));
        
        lblday=new JLabel("D");
        lblday.setFont(new Font("Serif", 20, 20));
        lblday.setBounds(230,370,40,30);
        lblmonth=new JLabel("M");
         lblmonth.setBounds(330,370,40,30);
        lblmonth.setFont(new Font("Serif", 20, 20));
        lblyear=new JLabel("Y");
         lblyear.setBounds(430,370,40,30);
        lblyear.setFont(new Font("Serif", 20, 20));
        
        fromday =new JComboBox(new String[]{"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"});
        frommonth =new JComboBox(new String[]{"1","2","3","4","5","6","7","8","9","10","11","12"});
        fromyear =new JComboBox(new String[]{"2021","2022","2023","2024","2025","2026","2027","2028","2029","2030","2031"});
        
        to_day =new JComboBox(new String[]{"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"});
        to_month =new JComboBox(new String[]{"1","2","3","4","5","6","7","8","9","10","11","12"});
        to_year =new JComboBox(new String[]{"2021","2022","2023","2024","2025","2026","2027","2028","2029","2030","2031"});
        
        fromday.setBounds(200,400,70,50);
        frommonth.setBounds(300,400,70,50);
        fromyear.setBounds(400,400,70,50);
        
        to_day.setBounds(200,470,70,50);
        to_month.setBounds(300,470,70,50);
        to_year.setBounds(400,470,70,50);
        
        lblerrordate=new JLabel();
        lblerrordate.setFont(new Font("Serif",20,15));
        lblerrordate.setBounds(480,410,250,50);
        
        btcheck=new JButton("Check");
        btcheck.setBounds(500,460,70,40);
        
        lblsum=new JLabel("Sum:");
        lblsum.setBounds(100,510,70,50);
        lblsum.setFont(new Font("Serif",20,20));
        
        lblsumresult=new JLabel();
        lblsumresult.setBounds(150,510,70,50);
        lblsumresult.setFont(new Font("Serif",20,20));
        
        
        lblpay=new JLabel("Pay");
        lblpay.setBounds(100,560,70,50);
        lblpay.setFont(new Font("Serif",20,20));
        
        paytxt=new JTextField(15);
        paytxt.setBounds(150,575,70,30);
        
        btpay=new JButton("PAY");
        btpay.setBounds(250,575,60,40);
        
        lblchange=new JLabel("change:");
        lblchange.setBounds(100,610,70,50);
        lblchange.setFont(new Font("Serif",20,20));
        
        lblchangeresult=new JLabel("");
        lblchangeresult.setBounds(170,610,300,50);
        lblchangeresult.setFont(new Font("Serif",20,20));
        
        
        RCSubmit = new JButton("Submit");
        RCSubmit.setFont(new Font("Serif", 20, 20));
        RCSubmit.setBounds(450, 600, 100, 40);
        
        
        
        group.add(genderM);
        group.add(genderF);
        add(lblCfname);
        add(lblClname);
        add(lblCage);
        add(lblCid);
        add(txtCfname);
        add(txtClname);
        add(txtCage);
        add(txtCid);
        add(lblCgender);
        add(genderM);
        add(genderF);
        add(RCSubmit);
        add(lblTypeofticket);
        add(lblpersons);
        add(lblfrom);
        add(lblto);
        add(typeofticket);
        add(fromday);
        add(frommonth);
        add(fromyear);
        add(to_day);
        add(to_month);
        add(to_year);
        add(persontxt);
        add(lblsum);
        add(lblpay);
        add(lblchange);
        add(paytxt);
        add(btpay);
        add(lblsumresult);
        add(lblchangeresult);
        add(lblTourType);
        add(tourTypes);
        add(lblenterpersons);
        add(lblday);
        add(lblmonth);
        add(lblyear);
        add(lblerrordate);
        add(btcheck);
        //
      //  typeofticket.addActionListener(RL);
        //Action Listener
        typeofticket.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                
            
            if(e.getSource()==typeofticket)
            {
                int sum=0;
                if(typeofticket.getSelectedIndex() ==0)
                {
                 
               sum = Integer.parseInt(persontxt.getText());
               sum*=200;
               lblsumresult.setText(String.valueOf(sum));
                }
                if(typeofticket.getSelectedIndex() ==1)
                {
                 
               sum = Integer.parseInt(persontxt.getText());
               sum*=150;
               lblsumresult.setText(String.valueOf(sum));
                }
                if(typeofticket.getSelectedIndex() ==2)
                {
                 
               sum = Integer.parseInt(persontxt.getText());
               sum*=100;
               lblsumresult.setText(String.valueOf(sum));
                }
            }  
            }
            
        });
        tourTypes.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if(e.getSource()==tourTypes)
                {
                    if(tourTypes.getSelectedIndex()==2)
                    {
                        persontxt.setText("2");
                    }
                    else
                         lblenterpersons.setText("Enter number of persons");
                }
            }
        });
        btcheck.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if(e.getSource()==btcheck)
                {
                     lblerrordate.setText("");
                  //  boolean x=false;
                     if((to_month.getSelectedIndex()==1)&&((to_day.getSelectedIndex()==29)||(to_day.getSelectedIndex()==30)))
                            {
                                lblerrordate.setText("February doesn't have 30 or 31 days");
                                lblerrordate.setForeground(Color.red);
                                
                            }
                    else if((frommonth.getSelectedIndex()==1)&&((fromday.getSelectedIndex()==29)||(fromday.getSelectedIndex()==30)))
                            {
                                lblerrordate.setText("February doesn't have 30 or 31 days");
                                lblerrordate.setForeground(Color.red);
                            }
                  else  if(to_year.getSelectedIndex()<fromyear.getSelectedIndex())
                    {
                        lblerrordate.setText("Error in the Year");
                        lblerrordate.setForeground(Color.red);
                    }
                  else  if(to_year.getSelectedIndex()==fromyear.getSelectedIndex())
                  {
                    if(to_month.getSelectedIndex()<frommonth.getSelectedIndex())
                    {
                        lblerrordate.setText("Error in the Month");
                        lblerrordate.setForeground(Color.red);
                       
                    }
                    else
                    {
                         lblerrordate.setText("The date is available...");
                                lblerrordate.setForeground(Color.green);
                    }
                  
                     if(to_month.getSelectedIndex()==frommonth.getSelectedIndex())
                    {    
                     if(to_day.getSelectedIndex()<=fromday.getSelectedIndex())
                    {
                        lblerrordate.setText("Error in the day");
                        lblerrordate.setForeground(Color.red);
                    }
                     else
                     {
                         lblerrordate.setText("The date is available...");
                                lblerrordate.setForeground(Color.green);
                     }
                     
                    }
                  } 
                    else
                    {
                        lblerrordate.setText("The date is available...");
                                lblerrordate.setForeground(Color.green);
                    }
                    
                }
            }
        });
btpay.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                 if(e.getSource()==btpay)
                 {
                   int amountpaid=Integer.valueOf(paytxt.getText());
                   
                if(amountpaid>=Integer.valueOf(lblsumresult.getText()))
                {
                    amountpaid-=(Integer.valueOf(lblsumresult.getText()));
              
                 lblchangeresult.setText(String.valueOf(amountpaid));
                }
                else{
                     lblchangeresult.setText("");
                     lblchangeresult.setText("Payment insufficiant...Try Again");
                }
               //  lblchangeresult.setText(String.valueOf(amountpaid-(Integer.valueOf(change))));
                 }
            
            }
            
            
        });        RCSubmit.addActionListener(l);
        RCSubmit.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e)  {
                //String name,String lastname, int age, int ID,char gender

                char option;
                if(genderM.isSelected()){
                    option = 'm';
                }
                else{
                    option = 'f';
                }
                ArrayList <Customer> cus = new ArrayList();
                cus.add(new Customer(txtCfname.getText(), txtClname.getText(),Integer.parseInt(txtCage.getText()),Integer.parseInt(txtCid.getText()),option));
                try {
                    // Customer c = new Customer(txtCfname.getText(), txtClname.getText(),Integer.parseInt(txtCage.getText()),Integer.parseInt(txtCid.getText()),option);
                    Files.writecus(cus);
                } catch (IOException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        });
     
    }
       
        
    

    public void Reservation(){
        int[] months31=new int[31];
        for(int i=0;i<31;i++)
        {
            months31[i]=i+1;
        }

        int[] months30=new int[30];
        for(int i=0;i<30;i++)
        {
            months30[i]=i+1;
        }

        int[] feb=new int[28];
        for(int i=0;i<28;i++)
        {
            feb[i]=i+1;
        }

        lblTourType=new JLabel("Tour Type");
        tourTypes=new JComboBox(new String[]{"General","Family","Couples"});

        lblNumberOfSeats=new JLabel("Number of seats");
        txtNumberOfSeats=new JTextField(8);

        startMonth=new JComboBox(new String[]{"1","2","3","4","5","6","7","8","9","10","11","12"});
        startYear=new JComboBox(new String[]{"2021","2022","2023","2024","2025","2026","2027","2028","2029","2030"});

        endMonth=new JComboBox(new String[]{"1","2","3","4","5","6","7","8","9","10","11","12"});
        endYear=new JComboBox(new String[]{"2021","2022","2023","2024","2025","2026","2027","2028","2029","2030"});

    }

    public class Listen implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            getContentPane().revalidate();
            if (e.getSource() == btnManager) {
                getContentPane().removeAll();
                setSize(400, 200);
                Frame1();
            }
            if (e.getSource() == btnCustomer) {

                getContentPane().removeAll();
                setSize(601, 601);
                setSize(600, 600);
                CustomerInterface();
            }
            if (e.getSource() == btnSubmit) {
                if (txt1.getText().equals("12345")) {
                    getContentPane().removeAll();
                    setSize(600, 600);
                    Frame2();
                } else {
                    showMessageDialog(null, "Password Incorrect");
                    txt1.setText("");
                }

            }
            if (e.getSource() == btnChoice1) {
                getContentPane().removeAll();
                setSize(601, 601);
                setSize(600, 600);
                Frame3();
            }
            if (e.getSource() == btnChoice2) {
                getContentPane().removeAll();
                setSize(601, 601);
                setSize(600, 600);
                Frame4();
            }
            if (e.getSource() == btnAddG) {
                getContentPane().removeAll();
                setSize(601, 601);
                setSize(600, 600);
                AddTFrame();
            }
            if (e.getSource() == btnAddC) {
                getContentPane().removeAll();
                setSize(601, 601);
                setSize(600, 600);
                AddCFrame();
            }
            if (e.getSource() == CSubmit) {
                if (txtCfname.getText().equals("") || txtClname.getText().equals("") || txtCage.getText().equals("") || txtCid.getText().equals("") || group.getSelection() == null) {
                    showMessageDialog(null, "Input Incomplete");
                    txtCfname.setText("");
                    txtClname.setText("");
                    txtCage.setText("");
                    txtCid.setText("");
                } else {
                    showMessageDialog(null, "Customer Added");
                    getContentPane().removeAll();
                    setSize(601, 601);
                    setSize(600, 600);
                    Frame2();
                }
            }
            if (e.getSource() == AddTGSubmit) {
                if (txtTfname.getText().equals("") || txtTlname.getText().equals("") || txtTage.getText().equals("") || txtTid.getText().equals("")) {
                    showMessageDialog(null, "Input Incomplete");
                    txtTfname.setText("");
                    txtTlname.setText("");
                    txtTage.setText("");
                    txtTid.setText("");
                } else {
                    showMessageDialog(null, "Tour Guide Added");
                    getContentPane().removeAll();
                    setSize(601, 601);
                    setSize(600, 600);
                    Frame2();
                }
            }
            if (e.getSource() == AddCSubmit) {
                if (txtCfname.getText().equals("") || txtClname.getText().equals("") || txtCage.getText().equals("") || txtCid.getText().equals("") || group.getSelection() == null) {
                    showMessageDialog(null, "Input Incomplete");
                    txtCfname.setText("");
                    txtClname.setText("");
                    txtCage.setText("");
                    txtCid.setText("");
                } else {
                    showMessageDialog(null, "Customer Added");
                    getContentPane().removeAll();
                    setSize(601, 601);
                    setSize(600, 600);
                    Frame2();
                }
            }
             if (e.getSource() == RCSubmit) {
                if (txtCfname.getText().equals("") || txtClname.getText().equals("") || txtCage.getText().equals("") || txtCid.getText().equals("") || group.getSelection() == null) {
                    showMessageDialog(null, "Input Incomplete");
                    txtCfname.setText("");
                    txtClname.setText("");
                    txtCage.setText("");
                    txtCid.setText("");
                } else {
                    showMessageDialog(null, "Customer Added");
                    getContentPane().removeAll();
                    setSize(601, 601);
                    setSize(600, 600);
                    Frame0();
                }
             }
            if(e.getSource()== btnDisplayC){
                getContentPane().removeAll();
                getContentPane().revalidate();
                setSize(601, 601);
                setSize(600, 600);
                try {
                    DisplayCustomer();
                } catch (IOException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            //btnDeleteC
            if(e.getSource()== btnDeleteC){
                getContentPane().removeAll();
                getContentPane().revalidate();
                setSize(601, 601);
                setSize(600, 600);
                try {
                    DeleteCustomer();
                } catch (IOException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(e.getSource()==btnEditC){
                getContentPane().removeAll();
                getContentPane().revalidate();
                setSize(601, 601);
                setSize(600, 600);
                try {
                    EditCustomer();
                } catch (IOException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
//                 if(e.getSource()==editCus2){
//                      getContentPane().removeAll();
//                    getContentPane().revalidate();
//                    setSize(601, 601);
//                    setSize(600, 600);
//                     try {
//                    EditCustomer();
//                } catch (IOException ex) {
//                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
//                } catch (ClassNotFoundException ex) {
//                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
//                }
//                 }

        }
    }

    public void DisplayCustomer() throws FileNotFoundException, IOException, ClassNotFoundException{
        ArrayList <Customer> cus = Files.readcus();
        back.setBounds(0,0,50,50);
        back.setBackground(Color.WHITE);
        back.setOpaque(false);
        add(back);
stage = 5;
        JLabel lbl = new JLabel ("FirstName   "+"LastName   "+"Age   "+"Gender   "+"ID   ");
        lbl.setBounds(100,25 , 400, 50);
        add(lbl);

//        ArrayList <JLabel> lbl1=new ArrayList();
//

        int num = 50;
        for (int i = 0; i < cus.size(); i++) {

            JLabel lbl2 =new JLabel(cus.get(i).getName() +"          "+cus.get(i).getLName() +"          "+cus.get(i).getAge() +"         "+cus.get(i).getGender() +"         "+cus.get(i).getID() );
            lbl2.setBounds(100,num,300,50);
            num+=50;
            add(lbl2);
        }

        //input.close();
        // JLabel lbl2 = new JLabel("<html> </html>");

    }

    public void DeleteCustomer() throws IOException, FileNotFoundException, ClassNotFoundException{
        stage = 5;
        back.setBounds(0,0,50,50);
        back.setBackground(Color.WHITE);
        back.setOpaque(false);
        add(back);
        JLabel lbl = new JLabel("List of Customers:");
        lbl.setBounds(100,10 , 400, 50);
        add(lbl);
        DisplayCustomer();

        JLabel lbl2 = new JLabel("delete ID:");
        lbl2.setBounds(140,430 , 80, 40);
        add(lbl2);
        JTextField txtf = new JTextField();
        txtf.setBounds(200,430, 100,40 );
        add(txtf);
        //12345
        ArrayList <Customer> cus1 = Files.readcus();

        JButton submitDel= new JButton ("Submit");
        submitDel.setBounds(300, 430, 120, 40);
        add(submitDel);

        submitDel.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e){
                for (int i = 0; i < cus1.size(); i++) {
                    if(cus1.get(i).getID()==Integer.parseInt(txtf.getText())){

                        cus1.remove(i);

                        try {
                            FileOutputStream fos = new FileOutputStream("Customer.txt");
                            ObjectOutputStream oos= new ObjectOutputStream(fos);
                            oos.writeObject(cus1);

                        } catch (IOException ex) {
                            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        JOptionPane.showMessageDialog(null,"Successfully Deleted");
                        getContentPane().removeAll();
                        getContentPane().revalidate();
                        setSize(601, 601);
                        setSize(600, 600);
                        Frame4();
                        break;
                    }
                }
            }
        });

    }

    public void EditCustomer() throws IOException, FileNotFoundException, ClassNotFoundException{
        stage = 5;
        back.setBounds(0,0,50,50);
        back.setBackground(Color.WHITE);
        back.setOpaque(false);
        add(back);
        getContentPane().removeAll();
        getContentPane().revalidate();
        setSize(601, 601);
        setSize(600, 600);

        JLabel lbl = new JLabel("List of Customers:");
        lbl.setBounds(100,10 , 400, 50);
        add(lbl);
        DisplayCustomer();

        JLabel lbl2 = new JLabel("Edit ID:");
        lbl2.setBounds(140,430 , 80, 40);
        add(lbl2);
        JTextField txtf = new JTextField();
        txtf.setBounds(200,430, 100,40 );
        add(txtf);
        //12345
        ArrayList <Customer> cus2 = Files.readcus();

        JButton editCus= new JButton ("Submit");
        editCus.setBounds(300, 430, 120, 40);
        add(editCus);

        editCus.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                int index = 0;
                for (int i = 0; i < cus2.size(); i++)  {
                    index = i;
                    if(cus2.get(i).getID()==Integer.parseInt(txtf.getText())){
                        getContentPane().removeAll();
                        getContentPane().revalidate();
                        setSize(601, 601);
                        setSize(600, 600);

                        int num = 50;


                        JLabel lbl2 =new JLabel(cus2.get(i).getName() +"          "+cus2.get(i).getLName() +"          "+cus2.get(i).getAge() +"         "+cus2.get(i).getGender() +"         "+cus2.get(i).getID() );
                        lbl2.setBounds(100,num,300,50);
                        num+=50;
                        add(lbl2);


                        Cfnamelbl = new JLabel("First Name");
                        Cfnamelbl.setFont(new Font("Serif", 20, 20));
                        Cfnamelbl.setBounds(150, 75, 150, 70);

                        Clnamelbl = new JLabel("Last Name");
                        Clnamelbl.setFont(new Font("Serif", 20, 20));
                        Clnamelbl.setBounds(150, 150, 150, 70);

                        Cagelbl = new JLabel("Age");
                        Cagelbl.setFont(new Font("Serif", 20, 20));
                        Cagelbl.setBounds(150, 200, 80, 70);

                        Cidlbl = new JLabel("ID");
                        Cidlbl.setFont(new Font("Serif", 20, 20));
                        Cidlbl.setBounds(150, 250, 80, 70);

                        cfnametxt= new JTextField(15);
                        cfnametxt.setBounds(300, 100, 150, 20);

                        clnametxt= new JTextField(15);
                        clnametxt.setBounds(300, 175, 150, 20);

                        cagetxt= new JTextField(15);
                        cagetxt.setBounds(300, 230, 150, 20);

                        cidtxt= new JTextField(15);
                        cidtxt.setBounds(300, 280, 150, 20);

                        add(Cfnamelbl);
                        add(Clnamelbl);
                        add(Cagelbl);
                        add(Cidlbl);

                        add(cfnametxt);
                        add(clnametxt);
                        add(cagetxt);
                        add(cidtxt);
                        JButton editCus2= new JButton ("Submit");
                        editCus2.setBounds(300, 430, 120, 40);
                        add(editCus2);
                        editCus2.addActionListener(new ActionListener(){
                            @Override
                            public void actionPerformed(ActionEvent e){
                                Customer cus=new Customer();
                                int index=0;
                                for (int j = 0; j < cus2.size(); j++) {
                                    if(cus2.get(j).getID()==Integer.parseInt(txtf.getText())){
                                        cus= cus2.get(j);
                                        index =j;

                                    }
                                }
                                String FirstName= (!cfnametxt.getText().equals(""))?cfnametxt.getText():cus.getName();
                                String LastName = (!clnametxt.getText().equals(""))?clnametxt.getText():cus.getLName();
                                int age=  (!cagetxt.getText().equals(""))?Integer.parseInt(cagetxt.getText()):cus.getAge();
                                int ID =(!cidtxt.getText().equals(""))?Integer.parseInt(cidtxt.getText()):cus.getID();
                                Customer client = new Customer(FirstName,LastName,age,ID,cus.getGender());
                                cus2.set(index,client);
                                try {
                                    JOptionPane.showMessageDialog(null, "customer change has made");

                                    FileOutputStream fos = new FileOutputStream("Customer.txt");
                                    ObjectOutputStream oos= new ObjectOutputStream(fos);
                                    oos.writeObject(cus2);

                                    getContentPane().removeAll();
                                    getContentPane().revalidate();
                                    setSize(601, 601);
                                    setSize(600, 600);
                                    EditCustomer();
                                }catch (IOException ex) {
                                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                                } catch (ClassNotFoundException ex) {
                                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                                }


                            }
                        });
                        revalidate();
                        repaint();
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "customer does not exist");
                        break;
                    }

                }
            }



        });

    }

    public void DisplayTour_guide() throws FileNotFoundException, IOException, ClassNotFoundException{
        stage = 5;
        back.setBackground(Color.WHITE);
        back.setBounds(0,0,50,50);
        back.setOpaque(false);
        back.setBorder(BorderFactory.createEmptyBorder());
        add(back);
        ArrayList <Tour_Guide> guide = Files.readguide();

        JLabel lbl = new JLabel ("FirstName   "+"LastName   "+"Age   "+"Gender   "+"ID   "+"salary"     +"  no. of trips  "      +" availability");
        lbl.setBounds(100,25 , 450, 50);
        add(lbl);

//        ArrayList <JLabel> lbl1=new ArrayList();
//

        int num = 50;
        for (int i = 0; i < guide.size(); i++) {

            JLabel lbl2 =new JLabel(guide.get(i).getName() +"          "+guide.get(i).getLName() +"          "+guide.get(i).getAge() +"         "+guide.get(i).getGender() +"         "+guide.get(i).getID()+"         "+guide.get(i).calcSalary()+"         "+guide.get(i).getNum()+"         "+((guide.get(i).getAvailable() == true)? "available" :"not available"));
            lbl2.setBounds(100,num,500,50);
            num+=50;
            add(lbl2);
        }

        //input.close();
        // JLabel lbl2 = new JLabel("<html> </html>");

    }

    int index = 0;
    public void EditGuide() throws IOException, ClassNotFoundException {
        stage = 5;
        back.setBounds(0,0,50,50);
        back.setBackground(Color.WHITE);
        back.setOpaque(false);
        add(back);
        getContentPane().removeAll();
        getContentPane().revalidate();
        setSize(601, 601);
        setSize(600, 600);

        JLabel lbl = new JLabel("List of Tour guides:");
        lbl.setBounds(100,10 , 400, 50);
        add(lbl);
        DisplayTour_guide();

        JLabel lbl2 = new JLabel("Edit ID:");
        lbl2.setBounds(140,430 , 80, 40);
        add(lbl2);
        JTextField txtf = new JTextField();
        txtf.setBounds(200,430, 100,40 );
        add(txtf);
        //12345
        ArrayList <Tour_Guide> guide = Files.readguide();

        JButton editCus= new JButton ("Submit");
        editCus.setBounds(300, 430, 120, 40);
        add(editCus);

        editCus.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {

                boolean chh = true;
                int in = 0;
                for (int i = 0; i < guide.size(); i++) {

                    if (guide.get(i).getID() == Integer.parseInt(txtf.getText())) {
                        index = i;
                        in = i;
                        chh = true;
                        break;
                    } else {
                        chh = false;
                    }


                }
                if (chh == true) {
                    getContentPane().removeAll();
                    getContentPane().revalidate();
                    setSize(601, 601);
                    setSize(600, 600);

                    int num = 50;


                    JLabel lbl2 = new JLabel(guide.get(index).getName() + "          " + guide.get(index).getLName() + "          " + guide.get(index).getAge() + "         " + guide.get(index).getGender() + "         " + guide.get(index).getID() + "         " + guide.get(index).calcSalary() + "         " + guide.get(index).getAvailable() + "         " + guide.get(index).getNum());
                    lbl2.setBounds(100, num, 400, 50);
                    num += 50;
                    add(lbl2);


                    lblTfname = new JLabel("First Name");
                    lblTfname.setFont(new Font("Serif", 20, 20));
                    lblTfname.setBounds(150, 100, 150, 20);

                    lblTlname = new JLabel("Last Name");
                    lblTlname.setFont(new Font("Serif", 20, 20));
                    lblTlname.setBounds(150, 125, 150, 70);

                    lblTage = new JLabel("Age");
                    lblTage.setFont(new Font("Serif", 20, 20));
                    lblTage.setBounds(150, 175, 80, 70);

                    lblTid = new JLabel("ID");
                    lblTid.setFont(new Font("Serif", 20, 20));
                    lblTid.setBounds(150, 225, 80, 70);

                    JTextField txtTtrips = new JTextField(15);
                    txtTtrips.setBounds(300, 307, 150, 20);

                    JLabel lblTtrips = new JLabel("no. of trips");
                    lblTtrips.setFont(new Font("Serif", 20, 20));
                    lblTtrips.setBounds(150, 275, 110, 70);

                    JLabel lblAvailable = new JLabel("Availability");
                    lblAvailable.setFont(new Font("Serif", 20, 20));
                    lblAvailable.setBounds(150, 325, 100, 70);

                    txtTfname = new JTextField(15);
                    txtTfname.setBounds(300, 100, 150, 20);

                    txtTlname = new JTextField(15);
                    txtTlname.setBounds(300, 150, 150, 20);

                    txtTage = new JTextField(15);
                    txtTage.setBounds(300, 200, 150, 20);

                    txtTid = new JTextField(15);
                    txtTid.setBounds(300, 250, 150, 20);


                    Available = new JRadioButton("Available");
                    NotAvailable = new JRadioButton("Not available");
                    Available.setBounds(300, 335, 80, 50);
                    NotAvailable.setBounds(380, 335, 100, 50);


                    group2.add(Available);
                    group2.add(NotAvailable);

                    AddTGSubmit = new JButton("Submit");
                    AddTGSubmit.setFont(new Font("Serif", 20, 20));
                    AddTGSubmit.setBounds(230, 470, 120, 40);

                    add(lblTfname);
                    add(lblTlname);
                    add(lblTage);
                    add(lblTid);
                    add(txtTtrips);
                    add(lblTtrips);
                    add(lblAvailable);
                    add(txtTfname);
                    add(txtTlname);
                    add(txtTage);
                    add(txtTid);
                    add(Available);
                    add(NotAvailable);
                    revalidate();
                    repaint();

                    add(AddTGSubmit);
                    AddTGSubmit.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            ArrayList<Tour_Guide> guide = null;
                            try {
                                guide = Files.readguide();
                            } catch (IOException ioException) {
                                ioException.printStackTrace();
                            } catch (ClassNotFoundException classNotFoundException) {
                                classNotFoundException.printStackTrace();
                            }
                            Tour_Guide cus = guide.get(index);
                            String FirstName = (!txtTfname.getText().equals("")) ? txtTfname.getText() : cus.getName();
                            String LastName = (!txtTlname.getText().equals("")) ? txtTlname.getText() : cus.getLName();
                            int age = (!txtTage.getText().equals("")) ? Integer.parseInt(txtTage.getText()) : cus.getAge();
                            int ID = (!txtTid.getText().equals("")) ? Integer.parseInt(txtTid.getText()) : cus.getID();
                            boolean avai = true;
                            if (Available.isSelected() == false && NotAvailable.isSelected() == false) {
                                avai = cus.getAvailable();
                            } else {
                                avai = (Available.isSelected() == true) ? true : false;
                            }
                            int num = (!txtTtrips.getText().equals("")) ? Integer.parseInt(txtTtrips.getText()) : cus.getNum();
                            guide.set(index, new Tour_Guide(FirstName, LastName, age, ID, cus.getGender(), num, (avai == true) ? "Available" : "NotAvailable"));
                            try {
                                JOptionPane.showMessageDialog(null, "customer change has made");

                                FileOutputStream fos = new FileOutputStream("TourGuides.txt");
                                ObjectOutputStream oos = new ObjectOutputStream(fos);
                                oos.writeObject(guide);

                                getContentPane().removeAll();
                                getContentPane().revalidate();
                                setSize(601, 601);
                                setSize(600, 600);
                                EditGuide();
                            } catch (IOException ex) {
                                Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                            } catch (ClassNotFoundException ex) {
                                Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                            }


                        }


                    });
                    revalidate();
                    repaint();
                }
                else{
                    JOptionPane.showMessageDialog(null,"Wrong ID");
                }

            }
        });





}

    public void DeleteGuide() throws IOException, ClassNotFoundException {
        stage = 5;
        back.setBounds(0,0,50,50);
        back.setBackground(Color.WHITE);
        back.setOpaque(false);
        add(back);
        JLabel lbl = new JLabel("List of Guides:");
        lbl.setBounds(100,10 , 400, 50);
        add(lbl);
        DisplayTour_guide();

        JLabel lbl2 = new JLabel("delete ID:");
        lbl2.setBounds(140,430 , 80, 40);
        add(lbl2);
        JTextField txtf = new JTextField();
        txtf.setBounds(200,430, 100,40 );
        add(txtf);
        //12345
        ArrayList <Tour_Guide> cus1 = Files.readguide();

        JButton submitDel= new JButton ("Submit");
        submitDel.setBounds(300, 430, 120, 40);
        add(submitDel);

        submitDel.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e){
                for (int i = 0; i < cus1.size(); i++) {
                    if(cus1.get(i).getID()==Integer.parseInt(txtf.getText())){

                        cus1.remove(i);

                        try {
                            FileOutputStream fos = new FileOutputStream("TourGuides.txt");
                            ObjectOutputStream oos= new ObjectOutputStream(fos);
                            oos.writeObject(cus1);

                        } catch (IOException ex) {
                            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        JOptionPane.showMessageDialog(null,"Successfully Deleted");
                        getContentPane().removeAll();
                        getContentPane().revalidate();
                        setSize(601, 601);
                        setSize(600, 600);
                        Frame3();
                        break;
                    }
                }
            }
        });
    }
}

