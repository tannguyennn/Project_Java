package login;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class QuenMK extends JFrame {
    public QuenMK() {
        setResizable(false);
        this.setTitle("Shop thú cưng");
        this.setSize(500, 300);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);

        Font font1 = new Font("Tahoma", Font.BOLD, 20);
        Font font2 = new Font("Tahoma", Font.BOLD, 12);
        Font font3 = new Font("Tahoma", Font.ITALIC, 10);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        //tieu de
        JLabel lbTieuDe = new JLabel("QUÊN MẬT KHẨU");
        lbTieuDe.setBounds(200, 20, 200, 35);
        lbTieuDe.setFont(font1);
        lbTieuDe.setForeground(Color.RED);
        panel.add(lbTieuDe);

        //mã số nhân viên
        JLabel lbMS = new JLabel("Mã số NV");
        lbMS.setBounds(120, 65, 80, 25);
        JTextField txMS = new JTextField();
        txMS.setBounds(200, 65, 200, 25);
        panel.add(lbMS);
        panel.add(txMS);

        //tên đăng nhập
        JLabel lbTK = new JLabel("Tài khoản:");
        lbTK.setBounds(120, 100, 80, 25);
        lbTK.setFont(font2);
        JTextField txTK = new JTextField();
        txTK.setBounds(200, 100, 200, 25);
        panel.add(lbTK);
        panel.add(txTK);

        //mật khẩu
        JLabel lbMK = new JLabel("Mật khẩu:");
        lbMK.setBounds(120, 130, 80, 25);
        lbMK.setFont(font2);
        JTextField txMK = new JTextField();
        txTK.setBounds(200, 130, 200, 25);
        txMK.setEnabled(false);
        panel.add(lbMK);
        panel.add(txMK);

        //hien thong báo
        JLabel lbThongBao = new JLabel();
        lbThongBao.setBounds(200, 130, 200, 25);
        lbThongBao.setFont(font3);
        lbThongBao.setForeground(Color.RED);
        panel.add(lbThongBao);

        //button xác nhận
        JButton jbtxacnhan = new JButton("Xác nhận");
        jbtxacnhan.setFont(font2);
        jbtxacnhan.setFocusable(false);//tat vien xung quanh button
        jbtxacnhan.setBounds(200, 150, 90, 25);
        jbtxacnhan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String tk = txTK.getText();
                String ms = txMS.getText();
                String fileName = "login.txt";
                String maSo, taiKhoan, matKhau;

                int a = 0;
                try {
                    BufferedReader in = new BufferedReader(new FileReader(fileName));
                    maSo = in.readLine();
                    taiKhoan = in.readLine();
                    matKhau = in.readLine();
                    while (matKhau != null) {
                        if (tk.equals(taiKhoan) && ms.equals(maSo)) {
                            a = 1;
                            break;
                        }
                        maSo = in.readLine();
                        taiKhoan = in.readLine();
                        matKhau = in.readLine();
                    }
                    in.close();
                    if (a == 0) lbThongBao.setText("không có tài khoản này");
                    else {
                        txMK.setText(matKhau);
                    }
                } catch (IOException iox) {
                    System.out.println("Problem reading " + fileName);
                }

            }
        });
        panel.add(jbtxacnhan);
        this.add(panel);
    }
}
