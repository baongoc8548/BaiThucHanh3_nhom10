/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CS434B;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

/**
 *
 * @author ADMIN
 */
public class PT_Bac2 extends JFrame{
    JTextField txtA,txtB,txtC,txtKQ;
    JButton btnGiai,btnXoa,btnThoat;
    
    

    public PT_Bac2(String title) throws HeadlessException {
        super(title);
        initUI();
    }

    private void initUI() {
        this.setSize(400,300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
         Container con=getContentPane();
        con.setLayout(new BorderLayout());
        JPanel pnBorder =new JPanel(new BorderLayout(5,5));
        //Tạo vùng North
        JPanel pnNorth =new JPanel();
        pnNorth.setBackground(Color.gray);
        JLabel lblTittle=new JLabel("Giải phương trình bậc 2");
        Font fTittle =new Font("Tahoma", Font.BOLD, 22); {
        lblTittle.setFont(fTittle);
        pnNorth.add(lblTittle);
        //end tạo vùng North
        
        //Tạo vùng South
        JPanel pnSouth =new JPanel();
        Border bdSouth= BorderFactory.createLineBorder(Color.RED,1);
        TitledBorder titleSouth=new TitledBorder(bdSouth, "Chọn thao tác");
        pnSouth.setBorder(titleSouth);
        JButton btnGiai=new JButton("Giải");
        JButton btnXoa=new JButton("Xóa");
        JButton btnThoat=new JButton("Thoát");
        pnSouth.add(btnGiai);
        pnSouth.add(btnXoa);
        pnSouth.add(btnThoat);
        //End tạo vung South
        
     
        
        //tạo vùng center
        JPanel pnCenter=new JPanel();
        pnCenter.setLayout(new BoxLayout(pnCenter, BoxLayout.Y_AXIS));
        Border bdCenter= BorderFactory.createLineBorder(Color.BLUE,1);
        TitledBorder titleCenter=new TitledBorder(bdCenter, "Nhập a,b,c: ");
        pnCenter.setBorder(titleCenter);
        JPanel pnA=new JPanel();
        JLabel lblA =new JLabel("a: ");
        txtA=new JTextField(10);
        pnA.add(lblA);
        pnA.add(txtA);
        pnCenter.add(pnA);
         JPanel pnB=new JPanel();
        JLabel lblB =new JLabel("b: ");
        txtB=new JTextField(10);
        pnB.add(lblB);
        pnB.add(txtB);
        pnCenter.add(pnB);
         JPanel pnC=new JPanel();
         JLabel lblC =new JLabel("c: ");
        txtC=new JTextField(10);
        pnC.add(lblC);
        pnC.add(txtC);
        pnCenter.add(pnC);
        
        // ket qua
        JPanel pnKQ=new JPanel();
        JLabel lblKQ=new JLabel("Kết quả: ");
         pnKQ.add(lblKQ);
        pnCenter.add(pnKQ);
        JPanel pnOutput=new JPanel();
        txtKQ= new JTextField(12);
        txtKQ.setEnabled(false);
        txtKQ.setHorizontalAlignment(SwingConstants.CENTER);
        pnOutput.setLayout(new FlowLayout(FlowLayout.CENTER));
        pnOutput.add(txtKQ);
        pnCenter.add(pnOutput);
        
        //end tạo vùng center
        pnBorder.add(pnNorth,BorderLayout.NORTH);
        pnBorder.add(pnSouth,BorderLayout.SOUTH);
        pnBorder.add(pnCenter,BorderLayout.CENTER);
        this.add(pnBorder);
    }      
   
    }
     private void addEvents()
    {
        btnThoat.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.exit(1);
            }

            @Override
            public void mousePressed(MouseEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseExited(MouseEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        btnXoa.addMouseListener(new MouseListener(){
            @Override
            public void mouseClicked(MouseEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mousePressed(MouseEvent e) {
              txtKQ.setText("");
              txtA.setText("");
              txtB.setText("");
              txtC.setText("");
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseExited(MouseEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
            });
        btnGiai.addMouseListener(new MouseListener(){
            @Override
            public void mouseClicked(MouseEvent e) {
                try{
                double a=Double.parseDouble(txtA.getText());
                double b=Double.parseDouble(txtB.getText());
                double c=Double.parseDouble(txtC.getText());
                double delta=b*b-4*a*c;
                double x1,x2;
                if(delta>0)
                {
                    x1=(double)((-b+ Math.sqrt(a))/(2*a));
                    x2=(double)((-b- Math.sqrt(a))/(2*a));
                    txtKQ.setText("x="+ x1+"va x2= "+ x2);
                }
                else if(delta==0){
                    x1=(-b/ (2*a));
                    txtKQ.setText("x1=x2"+x1);
                }
                else{
                    txtKQ.setText("phuong trinh vo nghiem");
                }
                }catch(Exception e2)
                {
               JOptionPane.showMessageDialog(null, " Input khong hop le");
                }
                }
                 

            @Override
            public void mousePressed(MouseEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseExited(MouseEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });}
  
    public static void main(String[] args) {   
               new PT_Bac2("Giải phương trình bậc 2").setVisible(true);
    }}
    
    

