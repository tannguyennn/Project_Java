package login;

import giaodienchinh.GiaoDien;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FormDangNhap extends JFrame {
    public FormDangNhap() {
        setResizable(false);
        this.setTitle("Shop thú cưng");
        this.setSize(500, 250);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        Font font1 = new Font("Tahoma", Font.BOLD, 23);
        Font font2 = new Font("Tahoma", Font.BOLD, 15);
        Font font3 = new Font("Tahoma", Font.ITALIC, 10);


        JPanel panel = new JPanel();
        this.add(panel);
        panel.setLayout(null);
        //tieu de
        JLabel lbTieuDe = new JLabel("Shop thú cưng");
        lbTieuDe.setBounds(170, 20, 200, 40);
        lbTieuDe.setFont(font1);
        lbTieuDe.setForeground(Color.RED);
        panel.add(lbTieuDe);
        //acc
        JLabel lbTK = new JLabel("Tài khoản");
        lbTK.setFont(font2);
        lbTK.setBounds(120, 65, 80, 25);

        JTextField txTK = new JTextField();
        txTK.setBounds(200, 65, 200, 25);
        panel.add(lbTK);
        panel.add(txTK);

        //pass
        JLabel lbMK = new JLabel("Mật khẩu");
        lbMK.setBounds(120, 100, 80, 25);
        lbMK.setFont(font2);
        JPasswordField txMK = new JPasswordField();
        txMK.setBounds(200, 100, 200, 25);
        panel.add(lbMK);
        panel.add(txMK);
        //quen mk
        JLabel lbquenmk = new JLabel("Quên mật khẩu?");
        lbquenmk.setBounds(200, 175, 100, 25);
        lbquenmk.setFont(font3);
        lbquenmk.setForeground(Color.PINK);

        lbquenmk.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new QuenMK().setVisible(true);
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                lbquenmk.setForeground(Color.RED);
            }
        });
        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                lbquenmk.setForeground(Color.BLACK);
            }
        });
        panel.add(lbquenmk);
        //hien thong báo
        JLabel lbThongBao = new JLabel();
        lbThongBao.setBounds(200, 125, 200, 25);
        lbThongBao.setFont(font3);
        lbThongBao.setForeground(Color.RED);
        panel.add(lbThongBao);

        //button dang nhap
        JButton jbtDN = new JButton("Đăng nhập");
        jbtDN.setFont(new Font("Tahoma", Font.BOLD, 13));
        jbtDN.setFocusable(false);//tat vien xung quanh button
        jbtDN.setBounds(200, 150, 140, 25);

        jbtDN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String tk = txTK.getText();
                String mk = txMK.getText();
                String fileName = "login.txt";
                String ms, taiKhoan, matKhau;
                try {
                    BufferedReader in = new BufferedReader(new FileReader(fileName));
                    ms = in.readLine();
                    while (ms!=null) {
                        taiKhoan = in.readLine();
                        matKhau = in.readLine();
                        if (tk.equals(taiKhoan) && mk.equals(matKhau)) {

                           GiaoDien g = new GiaoDien(ms);
                           g.setVisible(true);
                        }
                        ms = in.readLine();
                    }
                    in.close();
                    lbThongBao.setText("Tài khoản hoặc mật khẩu không đúng!!!");
                } catch (IOException iox) {
                    System.out.println("Problem reading " + fileName);
                }

            }
        });
        panel.add(jbtDN);

        this.setVisible(true);
    }

}
