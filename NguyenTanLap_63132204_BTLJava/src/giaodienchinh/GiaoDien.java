package giaodienchinh;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GiaoDien extends JFrame {
    public GiaoDien()
    {
        setResizable(false);
        this.setTitle("Shop thú cưng");
        this.setSize(1500, 700);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        this.setLayout(new BorderLayout(5, 10));

        JPanel panelChinh = new JPanel();

        //buton in hoa dơn
        JButton jbtHoaDon = new JButton("Hóa dơn");

        jbtHoaDon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jbtHoaDon.setVisible(true);
            }
        });





        JPanel jpHoaDon= new JPanel();
        JPanel jpThongKe = new JPanel();
        JPanel jpDichVu = new JPanel();
        JPanel jpKhachHang = new JPanel();

    }
}
