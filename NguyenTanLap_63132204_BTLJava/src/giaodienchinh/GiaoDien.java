package giaodienchinh;

import javax.swing.*;
import javax.swing.event.ListDataEvent;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;

public class GiaoDien extends JFrame {

    JPanel panelChinh = new JPanel();
    JButton jbtTrangChu = new JButton("Trang Chủ");

    JButton jbtHD = new JButton("Hóa đơn");
    JButton jbtTK = new JButton("Thống kê");
    JButton jbtDV = new JButton("Dịch vụ");
    JButton jbtKH = new JButton("Khách hàng");
    //panel
    JPanel jpTrangchu = new JPanel();
    JPanel jpHoaDon = new JPanel();
    JPanel jpThongKe = new JPanel();
    JPanel jpDichVu = new JPanel();
    JPanel jpKhachHang = new JPanel();

    String maNV, tenNV;

    public GiaoDien(String ms) {

        maNV = ms;
        String fileName = "nhanvien.txt";
        String ma, ten, nsinh,diachi,sdt,luong;
        try {
            BufferedReader in = new BufferedReader(new FileReader(fileName));
            ma = in.readLine();
            while (ma!=null) {
                ten = in.readLine();
                nsinh = in.readLine();
                diachi = in.readLine();
                sdt = in.readLine();
                luong = in.readLine();
                if(ma.equals(maNV))
                {
                    tenNV = ten;
                }
                ma = in.readLine();
            }
            in.close();
        } catch (IOException iox) {
            System.out.println("Problem reading " + fileName);
        }


        setResizable(false);
        this.setTitle("Shop thú cưng");
        this.setSize(1000, 700);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(null);

        Font font1 = new Font("Tahoma", Font.BOLD, 18);
        //panel hệ thống
        panelChinh.setLayout(new GridLayout(9, 1, 5, 5));
        panelChinh.setBackground(Color.GRAY);
        panelChinh.setBounds(0, 0, 150, 700);

        jbtTrangChu.setForeground(Color.PINK);
        jbtTrangChu.setFont(font1);


        //buton
        //button hóa đơn
        jbtHD.setFont(font1);
        jbtHD.setBackground(Color.GRAY);
        //button thống kê
        jbtTK.setFont(font1);
        jbtTK.setBackground(Color.GRAY);
        //button dịch vụ
        jbtDV.setFont(font1);
        jbtDV.setBackground(Color.GRAY);
        //button khách hàng
        jbtKH.setFont(font1);
        jbtKH.setBackground(Color.GRAY);

        panelKhachHang();
        panelthongKe();
        panelDichVu();
        panelHoaDon();
        reset();
        panelTrangchu();

        jpKhachHang.setBounds(150, 0, 850, 700);
        jpDichVu.setBounds(150, 0, 850, 700);
        jpHoaDon.setBounds(150, 0, 850, 700);
        jpThongKe.setBounds(150, 0, 850, 700);
        jpTrangchu.setBounds(150, 0, 850, 700);

        jbtTrangChu.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                reset();
                jpTrangchu.setVisible(true);
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                jbtTrangChu.setBackground(Color.blue);
                jbtTrangChu.setForeground(Color.YELLOW);
            }
        });
        jbtHD.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                reset();
                jpHoaDon.setVisible(true);
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                jbtHD.setBackground(Color.CYAN);
                jbtHD.setForeground(Color.YELLOW);
            }
        });
        jbtTK.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                reset();
                jpThongKe.setVisible(true);
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                jbtTK.setBackground(Color.CYAN);
                jbtTK.setForeground(Color.YELLOW);
            }
        });
        jbtDV.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                reset();
                jpDichVu.setVisible(true);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                jbtDV.setBackground(Color.CYAN);
                jbtDV.setForeground(Color.YELLOW);
            }
        });
        jbtKH.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                reset();
                jpKhachHang.setVisible(true);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                jbtKH.setBackground(Color.CYAN);
                jbtKH.setForeground(Color.YELLOW);
            }
        });

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                jbtHD.setBackground(Color.GRAY);
                jbtHD.setForeground(Color.BLACK);
                jbtTK.setBackground(Color.GRAY);
                jbtTK.setForeground(Color.BLACK);
                jbtDV.setBackground(Color.GRAY);
                jbtDV.setForeground(Color.BLACK);
                jbtKH.setBackground(Color.GRAY);
                jbtKH.setForeground(Color.BLACK);
                jbtTrangChu.setBackground(Color.GRAY);
                jbtTrangChu.setForeground(Color.PINK);
            }
        });

        this.add(jpTrangchu);
        this.add(jpThongKe);
        this.add(jpHoaDon);
        this.add(jpDichVu);
        this.add(jpKhachHang);

        panelChinh.add(jbtTrangChu);
        panelChinh.add(jbtHD);
        panelChinh.add(jbtTK);
        panelChinh.add(jbtDV);
        panelChinh.add(jbtKH);

        JLabel label = new JLabel("ten " +tenNV);
        panelChinh.add(label);

        this.add(panelChinh);

    }

    public void reset() {
        jpHoaDon.setVisible(false);
        jpThongKe.setVisible(false);
        jpDichVu.setVisible(false);
        jpKhachHang.setVisible(false);
        jpTrangchu.setVisible(false);
    }

    public void panelKhachHang() {
        jpKhachHang.setLayout(null);
        JLabel label = new JLabel("KHÁCH HÀNG");
        label.setBounds(300, 20, 250, 45);
        label.setFont(new Font("Tahoma", Font.BOLD, 30));
        label.setForeground(Color.PINK);
        jpKhachHang.add(label);


//       Column Names
        String[] columnNames = {"Mã khách hàng", "Tên khách hàng", "Giới tính", "Số điện thoại", "Số lần mua"};
        String[] row = new String[5];

        JTable jTable = new JTable();
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columnNames);
        jTable.setModel(model);
        //jcrollpanel
        JScrollPane sp = new JScrollPane();
        sp.setBounds(120, 100, 550, 200);
        sp.add(jTable);
        sp.setViewportView(jTable);
        jpKhachHang.add(sp);

        //button
        jbtKH.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.setRowCount(0);
                String fileName = "khachhang.txt";
                try {
                    BufferedReader in = new BufferedReader(new FileReader(fileName));

                    row[0] = in.readLine();
                    row[1] = in.readLine();
                    row[2] = in.readLine();
                    row[3] = in.readLine();
                    row[4] = in.readLine();
                    while (row[0] != null) {
                        model.addRow(row);
                        row[0] = in.readLine();
                        row[1] = in.readLine();
                        row[2] = in.readLine();
                        row[3] = in.readLine();
                        row[4] = in.readLine();
                    }
                    in.close();
                } catch (IOException iox) {
                    System.out.println("Problem reading " + fileName);
                }

            }

        });

        JPanel pThongTin = new JPanel(new GridLayout(6, 2, 5, 5));
        pThongTin.setBounds(120, 350, 250, 200);

        JLabel lbID = new JLabel("Mã khách hàng:");
        JTextField txID = new JTextField();
        pThongTin.add(lbID);
        pThongTin.add(txID);
        //
        JLabel lbTen = new JLabel("Tên Khách hàng:");
        JTextField txTen = new JTextField();
        pThongTin.add(lbTen);
        pThongTin.add(txTen);
        //
        JLabel lbGioiTinh = new JLabel("Giới tính:");
        JTextField txGioiTinh = new JTextField();
        pThongTin.add(lbGioiTinh);
        pThongTin.add(txGioiTinh);
        //
        JLabel lbSDT = new JLabel("Số điện thoại:");
        JTextField txSDT = new JTextField();
        pThongTin.add(lbSDT);
        pThongTin.add(txSDT);
        //
        JLabel lbSLMua = new JLabel("Số lần mua:");
        JTextField txSLMua = new JTextField();
        pThongTin.add(lbSLMua);
        pThongTin.add(txSLMua);


        JPanel pButton = new JPanel(new GridLayout(5, 1, 5, 5));
        pButton.setBounds(500, 350, 100, 200);

        JLabel lbloi = new JLabel();
        lbloi.setForeground(Color.RED);


        JButton jbtthem = new JButton("Thêm");
        pButton.add(jbtthem);
        jbtthem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                row[0] = txID.getText();
                row[1] = txTen.getText();
                row[2] = txGioiTinh.getText();
                row[3] = txSDT.getText();
                row[4] = txSLMua.getText();

                String fileName = "khachhang.txt";
                String ma, ten, gtinh, sdt, slm;
                int a = 0;
                try {
                    BufferedReader in = new BufferedReader(new FileReader(fileName));
                    FileWriter writer = new FileWriter(fileName, true);
                    ma = in.readLine();
                    ten = in.readLine();
                    gtinh = in.readLine();
                    sdt = in.readLine();
                    slm = in.readLine();
                    while (ma != null) {
                        if (ma.equals(row[0])) {
                            a = 1;
                            break;
                        } else {
                            ma = in.readLine();
                            ten = in.readLine();
                            gtinh = in.readLine();
                            sdt = in.readLine();
                            slm = in.readLine();
                        }
                    }
                    in.close();
                    if (a == 1) lbloi.setText("trùng mã khách hàng");
                    else {
                        writer.write(row[0] + "\n");
                        writer.write(row[1] + "\n");
                        writer.write(row[2] + "\n");
                        writer.write(row[3] + "\n");
                        writer.write(row[4] + "\n");
                        writer.close();
                        model.addRow(row);
                    }
                } catch (IOException ex) {
                    System.out.println("Problem reading " + fileName);
                }
            }
        });

        JButton jbtxoa = new JButton("Xóa");
        jbtxoa.setFont(new Font("Tahoma", Font.BOLD, 10));
        pButton.add(jbtxoa);
        jbtxoa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String fileName = "khachhang.txt";
                String filemoi = "khachhangtam.txt";
                String ma, ten, gtinh, sdt, slm;
                File nfile = new File(filemoi);
                File ofile = new File(fileName);
                try {
                    FileWriter writer = new FileWriter(filemoi, true);
                    BufferedReader in = new BufferedReader(new FileReader(ofile));
                    int n = jTable.getSelectedRow();
                    ma = in.readLine();
                    ten = in.readLine();
                    gtinh = in.readLine();
                    sdt = in.readLine();
                    slm = in.readLine();

                    while (ma != null) {
                        if (!ma.equals(model.getValueAt(n, 0).toString())) {
                            writer.write(ma + "\n");
                            writer.write(ten + "\n");
                            writer.write(gtinh + "\n");
                            writer.write(sdt + "\n");
                            writer.write(slm + "\n");
                        }
                        ma = in.readLine();
                        ten = in.readLine();
                        gtinh = in.readLine();
                        sdt = in.readLine();
                        slm = in.readLine();
                    }
                    writer.close();
                    in.close();
                    ofile.delete();
                    nfile.renameTo(new File(fileName));
                    if (n >= 0)
                        model.removeRow(n);

                } catch (IOException iox) {
                    System.out.println("Problem reading " + fileName);
                }
            }
        });
        pButton.add(lbloi);

        jpKhachHang.add(pThongTin);
        jpKhachHang.add(pButton);
    }

    public void panelDichVu() {
        jpDichVu.setLayout(null);
        JLabel label = new JLabel("DỊCH VỤ");
        label.setBounds(300, 20, 250, 45);
        label.setFont(new Font("Tahoma", Font.BOLD, 30));
        label.setForeground(Color.PINK);
        jpDichVu.add(label);


//       Column Names
        String[] columnNames = {"Mã dịch vụ", "Loại dịch vụ", "Tên dịch vụ", "Giá", "Số lượng còn"};
        String[] row = new String[5];

        JTable jTable = new JTable();
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columnNames);
        jTable.setModel(model);
        //jcrollpanel
        JScrollPane sp = new JScrollPane();
        sp.setBounds(120, 100, 600, 300);
        sp.add(jTable);
        sp.setViewportView(jTable);
        jpDichVu.add(sp);

        //button
        jbtDV.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.setRowCount(0);
                String fileName = "dichvu.txt";
                try {
                    BufferedReader in = new BufferedReader(new FileReader(fileName));

                    row[0] = in.readLine();
                    row[1] = in.readLine();
                    row[2] = in.readLine();
                    row[3] = in.readLine();
                    row[4] = in.readLine();
                    while (row[0] != null) {
                        model.addRow(row);
                        row[0] = in.readLine();
                        row[1] = in.readLine();
                        row[2] = in.readLine();
                        row[3] = in.readLine();
                        row[4] = in.readLine();
                    }
                    in.close();
                } catch (IOException iox) {
                    System.out.println("Problem reading " + fileName);
                }

            }

        });

        JPanel pButton = new JPanel();
        pButton.setBounds(130, 430, 150, 100);

        JButton jbtChon = new JButton("Chọn dịch vụ");
        JLabel lbThongBao = new JLabel();
        lbThongBao.setForeground(Color.RED);

        pButton.add(jbtChon);
        pButton.add(lbThongBao);
        jpDichVu.add(pButton);
    }

    public void panelHoaDon() {
        jpHoaDon.setLayout(null);

        JPanel pTrai = new JPanel();
        pTrai.setBounds(100, 100, 100, 400);
        pTrai.setLayout(new GridLayout(10, 1, 5, 5));

        JPanel pPhai = new JPanel();
        pPhai.setBounds(250, 100, 100, 400);
        pPhai.setLayout(new GridLayout(10, 1, 5, 5));

        JLabel lbNV = new JLabel("Nhân viên");
        JTextField txNV = new JTextField();
        txNV.setText(tenNV);
        txNV.setEditable(false);

        JLabel lbTG = new JLabel("Thời Gian");
        JTextField txTG = new JTextField(String.valueOf(java.time.LocalDate.now()));
        txTG.setEditable(false);

        JComboBox<String> cbKH = new JComboBox<>();

        JLabel lbTenKH =new JLabel("Tên khách hàng");
        JTextField txTenKh = new JTextField();
        txTenKh.setEditable(false);

        JLabel lbSDT = new JLabel("SDT");
        JTextField txSDT = new JTextField();
        txSDT.setEditable(false);

        JTextField txSLM = new JTextField();

        pTrai.add(lbNV);
        pTrai.add(txNV);
        pPhai.add(lbTG);
        pPhai.add(txTG);
        pTrai.add(cbKH);
        pPhai.add(lbTenKH);
        pPhai.add(txTenKh);
        pPhai.add(lbSDT);
        pPhai.add(txSDT);

        jpHoaDon.add(pPhai);
        jpHoaDon.add(pTrai);

        String fileName = "khachhang.txt";
        String ma, ten, gtinh, sdt, slm;
        try {
            BufferedReader in = new BufferedReader(new FileReader(fileName));
            FileWriter writer = new FileWriter(fileName, true);
            ma = in.readLine();
            cbKH.addItem(null);
            while (ma != null) {
                cbKH.addItem(ma);
                ten = in.readLine();
                gtinh = in.readLine();
                sdt = in.readLine();
                slm = in.readLine();
                ma = in.readLine();

            }
            in.close();
        } catch (IOException iox) {
            System.out.println("Problem reading " + fileName);
        }

       cbKH.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               String fileName = "khachhang.txt";
               String ma, ten, gtinh, sdt, slm;
               try {
                   BufferedReader in = new BufferedReader(new FileReader(fileName));
                   FileWriter writer = new FileWriter(fileName, true);
                   ma = in.readLine();
                   while (ma != null) {
                       ten = in.readLine();
                       gtinh = in.readLine();
                       sdt = in.readLine();
                       slm = in.readLine();
                       if(ma.equals(cbKH.getSelectedItem()))
                       {
                           txTenKh.setText(ten);
                           txSDT.setText(sdt);
                       }
                       ma = in.readLine();

                   }
                   in.close();
               } catch (IOException iox) {
                   System.out.println("Problem reading " + fileName);
               }
           }
       });

        String[] columnNames = {"Mã sản phẩm", "Loại DV", "Tên dịch vụ", "Số lượng", "Giá"};
        String[] row = new String[5];

        JTable jTable = new JTable();
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columnNames);
        jTable.setModel(model);
        //jcrollpanel
        JScrollPane sp = new JScrollPane();
        sp.setBounds(350, 100, 400, 300);
        sp.add(jTable);
        sp.setViewportView(jTable);
        jpHoaDon.add(sp);

    }

    public void panelTrangchu(){
        jpTrangchu.setVisible(true);
        jpTrangchu.setBackground(Color.blue);
        jpTrangchu.setLayout(null);


    }


    public void panelthongKe() {

    }


}
