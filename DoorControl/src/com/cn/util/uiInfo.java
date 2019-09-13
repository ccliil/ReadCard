package rfid.DoorControl.src.com.cn.util;
import rfid.DoorControl.src.com.cn.activity.ui.MainFrame;
import rfid.DoorControl.src.com.cn.peopleInfo.people;

import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;

import javax.swing.*;
public class uiInfo extends JFrame {
    JFrame frame;
    JPanel panel,panel_add;
    JLabel lab0,lab1,lab2,lab3,lab4,lab5,lab6;
   public JTextField txtName,txtId,txtDom,txtMajor,txtPhone,txtIdCard;
    JButton btnAdd,btnShow;
    public uiInfo(){
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;
        frame = new JFrame("卡片用户信息");
        frame.setBounds(screenWidth / 3, screenHeight / 4, 450, 300); // 设置位置及大小
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.lightGray);
        frame.getContentPane().setLayout(null); // 使用绝对布局
        frame.setResizable(false); // 设置窗口大小不可变
        panel = new JPanel();
        panel.setBounds(2, 0, 440, 40);
        panel.setBackground(Color.lightGray);
        panel.setVisible(true);
        panel.setLayout(new GridLayout(1, 3, 2, 0));

        btnAdd = new JButton("新增");
        btnAdd.setFont(new Font("宋体", 1, 12)); // 设置字体 格式 大小
        btnAdd.setVisible(true);
        panel.add(btnAdd);
        btnAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                panel.setVisible(true);
                people people=new people(txtName.getText(),txtId.getText(),txtDom.getText(),txtMajor.getText(),txtPhone.getText(),txtIdCard.getText());
                operationIc ic=new operationIc();
                try {
                    ic.addPerson(people);
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
                txtMajor.setText("");
                txtDom.setText("");
                txtName.setText("");
                txtId.setText("");
                txtPhone.setText("");
                txtIdCard.setText("");
            }
        });
        btnShow=new JButton("显示");
        btnShow.setFont(new Font("宋体",1,12));
        btnShow.setVisible(true);
        panel.add(btnShow);
            btnShow.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                    people people=new people();
                    operationIc ic=new operationIc();
                    try {
                        MainFrame  mainFrame=new MainFrame();
                        //txtIdCard.setText(mainFrame.mSendData.getText());
                        people=ic.showPerson(txtIdCard.getText());
                        //people=ic.showPerson(mainFrame.mDataView.getText());
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                    txtName.setText(people.getName());
                    txtDom.setText(people.getDom());
                    txtMajor.setText(people.getMajor());
                    txtPhone.setText(people.getPhone());
                    txtId.setText(people.getId());
                    txtIdCard.setText(people.getIdCard());
                }
            });
        frame.getContentPane().add(panel);
        Font font = new Font("宋体", 1, 16);

        panel_add = new JPanel();
        panel_add.setBounds(2, 45, 440, 225);
        panel_add.setBackground(Color.lightGray);
        panel_add.setVisible(true);
        panel_add.setLayout(new GridLayout(4, 2, 20, 20));
        lab0 = new JLabel("姓名：");
        lab0.setFont(font);
        lab0.setHorizontalAlignment(SwingConstants.CENTER);
        lab0.setVisible(true);
        panel_add.add(lab0);


        txtName = new JTextField();
        txtName.setFont(font);
        txtName.setVisible(true);
        panel_add.add(txtName);

        lab1 = new JLabel("学号：");
        lab1.setFont(font);
        lab1.setHorizontalAlignment(SwingConstants.CENTER);
        lab1.setVisible(true);
        panel_add.add(lab1);



        txtId = new JTextField();
        txtId.setFont(font);
        txtId.setVisible(true);
        panel_add.add(txtId);


        lab2 = new JLabel("寝室号：");
        lab2.setFont(font);
        lab2.setHorizontalAlignment(SwingConstants.CENTER);
        lab2.setVisible(true);
        panel_add.add(lab2);


        txtDom = new JTextField();
        txtDom.setFont(font);
        txtDom.setVisible(true);
        panel_add.add(txtDom);


        lab3= new JLabel("专业：");
        lab3.setFont(font);
        lab3.setHorizontalAlignment(SwingConstants.CENTER);
        lab3.setVisible(true);
        panel_add.add(lab3);



        txtMajor= new JTextField();
        txtMajor.setFont(font);
        txtMajor.setVisible(true);
        panel_add.add(txtMajor);


        lab4 = new JLabel("联系方式：");
        lab4.setFont(font);
        lab4.setHorizontalAlignment(SwingConstants.CENTER);
        lab4.setVisible(true);
        panel_add.add(lab4);


        txtPhone = new JTextField();
        txtPhone.setFont(font);
        panel_add.add(txtPhone);
        txtPhone.setVisible(true);

        lab5=new JLabel("卡号：");
        lab5.setFont(font);
        lab5.setVisible(true);
        panel_add.add(lab5);

        txtIdCard=new JTextField();
        txtIdCard.setFont(font);
        panel_add.add(txtIdCard);
        txtIdCard.setVisible(true);

        lab6=new JLabel("");
        lab6.setFont(font);
        lab6.setSize(60,20);
        panel_add.add(lab6);
        lab6.setVisible(true);

        frame.getContentPane().add(panel_add);
        frame.setVisible(true);

    }

    public static void main(String[] args) {
        uiInfo uiInfo=new uiInfo();
        try {
            Dbutil.getConnection();
            //uiInfo.lab6.setRsizable();
           uiInfo.lab6.setText("数据库连接成功");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);

            }

        });
        uiInfo.txtIdCard.setText(new MainFrame().mDataView.getText());

    }
}
