package giaodienchinh;

import javax.swing.*;
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
    JButton jbtNV = new JButton("Nhân viên");
    //panel
    JPanel jpTrangchu = new JPanel();
    JPanel jpHoaDon = new JPanel();
    JPanel jpThongKe = new JPanel();
    JPanel jpDichVu = new JPanel();
    JPanel jpKhachHang = new JPanel();
    JPanel jpNhanVien = new JPanel();
    int soNV = 0, soKH = 0;
    String maNV, tenNV, tenKH;

    public GiaoDien(String ms) {

        maNV = ms;

        if (ms.equals("quanly")) {
            tenNV = "Quản lý";
        } else {
            String fileName = "nhanvien.txt";
            String ma, ten, nsinh, diachi, sdt, luong;
            try {
                BufferedReader in = new BufferedReader(new FileReader(fileName));
                ma = in.readLine();
                while (ma != null) {
                    ten = in.readLine();
                    nsinh = in.readLine();
                    diachi = in.readLine();
                    sdt = in.readLine();
                    luong = in.readLine();
                    if (ma.equals(maNV)) {
                        tenNV = ten;
                    }
                    ma = in.readLine();
                }
                in.close();
            } catch (IOException iox) {
                System.out.println("Problem reading " + fileName);
            }
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

        jbtNV.setFont(font1);
        jbtNV.setBackground(Color.GRAY);

        panelKhachHang();
        panelthongKe();
        panelDichVu();
        panelHoaDon();
        if (maNV.equals("quanly"))
            panelNhanvien();
        reset();
        panelTrangchu();

        jpKhachHang.setBounds(150, 0, 850, 700);
        jpDichVu.setBounds(150, 0, 850, 700);
        jpHoaDon.setBounds(150, 0, 850, 700);
        jpThongKe.setBounds(150, 0, 850, 700);
        jpTrangchu.setBounds(150, 0, 850, 700);
        jpNhanVien.setBounds(150, 0, 850, 700);


        //hover cho button

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

        jbtNV.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                reset();
                jpNhanVien.setVisible(true);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                jbtNV.setBackground(Color.CYAN);
                jbtNV.setForeground(Color.YELLOW);
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
                jbtNV.setBackground(Color.GRAY);
                jbtNV.setForeground(Color.BLACK);
                jbtTrangChu.setBackground(Color.GRAY);
                jbtTrangChu.setForeground(Color.PINK);
            }
        });

        this.add(jpTrangchu);
        this.add(jpThongKe);
        this.add(jpHoaDon);
        this.add(jpDichVu);
        this.add(jpKhachHang);
        this.add(jpNhanVien);

        panelChinh.add(jbtTrangChu);
        panelChinh.add(jbtHD);
        panelChinh.add(jbtTK);
        panelChinh.add(jbtDV);
        panelChinh.add(jbtKH);
        if (maNV.equals("quanly"))
            panelChinh.add(jbtNV);

        JLabel label = new JLabel("Tên " + tenNV);
        label.setForeground(Color.YELLOW);
        panelChinh.add(label);


        this.add(panelChinh);

    }

    public void reset() {
        jpHoaDon.setVisible(false);
        jpThongKe.setVisible(false);
        jpDichVu.setVisible(false);
        jpKhachHang.setVisible(false);
        jpNhanVien.setVisible(false);
        jpTrangchu.setVisible(false);
    }

    public void panelKhachHang() {
        jpKhachHang.setLayout(null);
        JLabel label = new JLabel("KHÁCH HÀNG");
        label.setBounds(300, 20, 250, 45);
        label.setFont(new Font("Tahoma", Font.BOLD, 30));
        label.setForeground(Color.RED);
        jpKhachHang.add(label);

        //Column Names
        String[] columnNames = {"Mã Khách hàng", "Tên khách hàng", "Giới tính", "Số điện thoại", "Số lần mua"};
        String[] row = new String[5];

        JTable jTable = new JTable();
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columnNames);
        jTable.setModel(model);
        //jcrollpanel
        JScrollPane sp = new JScrollPane();
        sp.setBounds(100, 100, 650, 200);
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
                        soKH++;
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
        pThongTin.setBounds(120, 350, 200, 200);

        JLabel lbID = new JLabel("Mã khách hàng:");
        JTextField txID = new JTextField();
        pThongTin.add(lbID);
        pThongTin.add(txID);
        //
        JLabel lbTen = new JLabel("Tên khách hàng:");
        JTextField txTen = new JTextField();
        pThongTin.add(lbTen);
        pThongTin.add(txTen);
        //
        JLabel lbNS = new JLabel("Giới tính:");
        JTextField txNS = new JTextField();
        pThongTin.add(lbNS);
        pThongTin.add(txNS);
        //
        JLabel lbQQ = new JLabel("Số điện thoại:");
        JTextField txQQ = new JTextField();
        pThongTin.add(lbQQ);
        pThongTin.add(txQQ);
        //
        JLabel lbSDT = new JLabel("Số lần mua:");
        JTextField txSDT = new JTextField();
        pThongTin.add(lbSDT);
        pThongTin.add(txSDT);

        txID.setEditable(false);
        txTen.setEditable(false);
        txNS.setEditable(false);
        txQQ.setEditable(false);
        txSDT.setEditable(false);


        JPanel pButton = new JPanel(new GridLayout(5, 1, 5, 5));
        pButton.setBounds(500, 350, 100, 200);

        JPanel pThongBao = new JPanel();
        pThongBao.setBounds(120, 530, 200, 50);

        JLabel lbThongBao = new JLabel();
        lbThongBao.setForeground(Color.RED);


        JButton jbtthem = new JButton("Thêm");
        jbtthem.setFont(new Font("Tahoma", Font.BOLD, 10));

        JButton jbtluu = new JButton("Lưu");
        jbtluu.setFont(new Font("Tahoma", Font.BOLD, 10));
        jbtluu.setVisible(false);

        JButton jbtkluu = new JButton("Không lưu");
        jbtkluu.setFont(new Font("Tahoma", Font.BOLD, 10));
        jbtkluu.setVisible(false);

        JButton jbtsua = new JButton("Sửa");
        jbtsua.setFont(new Font("Tahoma", Font.BOLD, 10));

        JButton jbtxoa = new JButton("Xóa");
        jbtxoa.setFont(new Font("Tahoma", Font.BOLD, 10));

        pButton.add(jbtthem);

        final int[] a = {0};
        jbtthem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                a[0] = 2;
                jbtluu.setVisible(true);
                jbtkluu.setVisible(true);
                txID.setEditable(true);
                txTen.setEditable(true);
                txNS.setEditable(true);
                txQQ.setEditable(true);
                txSDT.setEditable(true);
            }
        });

        pButton.add(jbtsua);

        jbtsua.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int n = -1;
                n = jTable.getSelectedRow();

                if (n != -1) {
                    a[0] = 1;
                    jbtkluu.setVisible(true);
                    jbtluu.setVisible(true);
                    txTen.setEditable(true);
                    txNS.setEditable(true);
                    txQQ.setEditable(true);
                    txSDT.setEditable(true);

                    String fileName = "khachhang.txt";
                    String ma, ten, nsinh, que, sdt;
                    File ofile = new File(fileName);
                    try {
                        BufferedReader in = new BufferedReader(new FileReader(ofile));

                        ma = in.readLine();
                        while (ma != null) {
                            ten = in.readLine();
                            nsinh = in.readLine();
                            que = in.readLine();
                            sdt = in.readLine();
                            if (ma.equals(model.getValueAt(n, 0).toString())) {
                                txID.setText(ma);
                                txTen.setText(ten);
                                txNS.setText(nsinh);
                                txQQ.setText(que);
                                txSDT.setText(sdt);
                                break;
                            }
                            ma = in.readLine();
                        }
                        in.close();
                    } catch (IOException iox) {
                        System.out.println("Problem reading " + fileName);
                    }
                } else lbThongBao.setText("Hãy chọn dòng cần sửa");
            }
        });

        jbtluu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (a[0] == 2) {
                    row[0] = txID.getText();
                    row[1] = txTen.getText();
                    row[2] = txNS.getText();
                    row[3] = txQQ.getText();
                    row[4] = txSDT.getText();

                    String fileName = "khachhang.txt";
                    String ma, ten, nsinh, que, sdt;
                    int c = 0;
                    try {
                        BufferedReader in = new BufferedReader(new FileReader(fileName));
                        FileWriter writer = new FileWriter(fileName, true);
                        ma = in.readLine();
                        ten = in.readLine();
                        nsinh = in.readLine();
                        que = in.readLine();
                        sdt = in.readLine();
                        while (ma != null) {
                            if (ma.equals(row[0])) {
                                c = 1;
                                break;
                            } else {
                                ma = in.readLine();
                                ten = in.readLine();
                                nsinh = in.readLine();
                                que = in.readLine();
                                sdt = in.readLine();
                            }
                        }
                        in.close();
                        if (c == 1) lbThongBao.setText("trùng mã nhân viên");
                        else {
                            writer.write(row[0] + "\n");
                            writer.write(row[1] + "\n");
                            writer.write(row[2] + "\n");
                            writer.write(row[3] + "\n");
                            writer.write(row[4] + "\n");
                            soKH++;
                            lbThongBao.setText("Lưu thành công.");
                            writer.close();
                            model.addRow(row);
                        }
                    } catch (IOException ex) {
                        System.out.println("Problem reading " + fileName);
                    }
                    a[0] = 0;
                }
                if (a[0] == 1) {
                    int i = 0;
                    String fileName = "khachhang.txt";
                    String fileMoi = "khachhangtam.txt";
                    String ma, ten, nsinh, que, sdt;
                    File nfile = new File(fileMoi);
                    File ofile = new File(fileName);
                    try {
                        FileWriter writer = new FileWriter(fileMoi, true);
                        BufferedReader in = new BufferedReader(new FileReader(ofile));
                        int n = jTable.getSelectedRow();
                        String manv = model.getValueAt(n, 0).toString();
                        ma = in.readLine();
                        ten = in.readLine();
                        nsinh = in.readLine();
                        que = in.readLine();
                        sdt = in.readLine();
                        while (ma != null) {
                            if (ma.equals(manv)) {
                                writer.write(ma + "\n");
                                writer.write(txTen.getText() + "\n");
                                writer.write(txNS.getText() + "\n");
                                writer.write(txQQ.getText() + "\n");
                                writer.write(txSDT.getText() + "\n");
                            } else {
                                writer.write(ma + "\n");
                                writer.write(ten + "\n");
                                writer.write(nsinh + "\n");
                                writer.write(que + "\n");
                                writer.write(sdt + "\n");
                            }
                            ma = in.readLine();
                            ten = in.readLine();
                            nsinh = in.readLine();
                            que = in.readLine();
                            sdt = in.readLine();
                            if (i == soKH - 1)
                                break;
                            i++;
                        }

                        writer.close();
                        in.close();
                        ofile.delete();
                        nfile.renameTo(new File(fileName));
                    } catch (IOException ex) {
                        System.out.println("Problem reading " + fileName);
                    }

                    model.setRowCount(0);
                    String fileName1 = "khachhang.txt";
                    try {
                        BufferedReader in = new BufferedReader(new FileReader(fileName1));

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
                        lbThongBao.setText("Lưu thành công.");
                        in.close();
                    } catch (IOException iox) {
                        System.out.println("Problem reading " + fileName1);
                    }
                    a[0] = 0;

                }

            }
        });

        jbtkluu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txID.setText("");
                txTen.setText("");
                txNS.setText("");
                txQQ.setText("");
                txSDT.setText("");
                txID.setEditable(false);
                txTen.setEditable(false);
                txNS.setEditable(false);
                txQQ.setEditable(false);
                txSDT.setEditable(false);
                jbtluu.setVisible(false);
                jbtkluu.setVisible(false);
            }
        });

        pButton.add(jbtxoa);
        jbtxoa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int n = -1;
                n = jTable.getSelectedRow();
                if (n != -1) {
                    String fileName = "khachhang.txt";
                    String filemoi = "khachhang.txt";
                    String ma, ten, nsinh, que, sdt;
                    File nfile = new File(filemoi);
                    File ofile = new File(fileName);
                    try {
                        FileWriter writer = new FileWriter(filemoi, true);
                        BufferedReader in = new BufferedReader(new FileReader(ofile));

                        ma = in.readLine();
                        ten = in.readLine();
                        nsinh = in.readLine();
                        que = in.readLine();
                        sdt = in.readLine();

                        while (ma != null) {
                            if (!ma.equals(model.getValueAt(n, 0).toString())) {
                                writer.write(ma + "\n");
                                writer.write(ten + "\n");
                                writer.write(nsinh + "\n");
                                writer.write(que + "\n");
                                writer.write(sdt + "\n");
                            } else {
                                ma = in.readLine();
                                ten = in.readLine();
                                nsinh = in.readLine();
                                que = in.readLine();
                                sdt = in.readLine();
                            }
                        }
                        lbThongBao.setText("Đã xóa");
                        writer.close();
                        in.close();
                        ofile.delete();
                        nfile.renameTo(new File(fileName));
                        if (n >= 0)
                            model.removeRow(n);

                    } catch (IOException iox) {
                        System.out.println("Problem reading " + fileName);
                    }
                } else lbThongBao.setText("Hãy chọn dòng cần xóa");
            }
        });

        pButton.add(jbtluu);
        pButton.add(jbtkluu);

        pThongBao.add(lbThongBao);

        jpKhachHang.add(pThongBao);
        jpKhachHang.add(pThongTin);
        jpKhachHang.add(pButton);

    }

    public void panelDichVu() {
        jpDichVu.setLayout(null);
        JLabel label = new JLabel("DỊCH VỤ");
        label.setBounds(300, 20, 250, 45);
        label.setFont(new Font("Tahoma", Font.BOLD, 30));
        label.setForeground(Color.RED);
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
        sp.setBounds(100, 100, 550, 300);
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

        JPanel pThongTin = new JPanel(new GridLayout(2, 2, 5, 5));
        pThongTin.setBounds(100, 400, 300, 80);

        JLabel lbTenDV = new JLabel("Mã dịch vụ");
        JTextField tvtenDV = new JTextField();
        pThongTin.add(lbTenDV);
        pThongTin.add(tvtenDV);

        JLabel lbSoluong = new JLabel("Số lượng");
        JTextField tvSoLuong = new JTextField();
        pThongTin.add(lbSoluong);
        pThongTin.add(tvSoLuong);


        JLabel lbThongBao = new JLabel();
        lbThongBao.setBounds(200, 225, 200, 25);
        lbThongBao.setFont(new Font("Tahoma", Font.ITALIC, 12));
        lbThongBao.setForeground(Color.RED);

        JPanel pButton = new JPanel(new GridLayout(2, 1, 5, 5));
        pButton.setBounds(450, 400, 200, 80);

        JButton jbtChon = new JButton("Chọn dịch vụ");
        JButton jbtLuu = new JButton("Lưu thông tin");

        pButton.add(jbtChon);
        pButton.add(jbtLuu);

        tvtenDV.setEditable(false);
        tvSoLuong.setEditable(false);
        jbtLuu.setVisible(false);

        jbtChon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int n = -1;
                n = jTable.getSelectedRow();
                if (n != -1) {
                    String maDV = model.getValueAt(n, 0).toString();
                    String fileName = "dichvu.txt";
                    String ma, loai = null, ten = null, soluong, gia = null;
                    try {
                        BufferedReader in = new BufferedReader(new FileReader(fileName));

                        ma = in.readLine();
                        while (ma != null) {
                            loai = in.readLine();
                            ten = in.readLine();
                            soluong = in.readLine();
                            gia = in.readLine();
                            if (ma.equals(maDV)) {
                                tvtenDV.setText(ma);
                                tvSoLuong.setEditable(true);
                                jbtLuu.setVisible(true);
                                break;
                            }
                            ma = in.readLine();
                        }
                        in.close();
                    } catch (IOException iox) {
                        System.out.println("Problem reading " + fileName);
                    }
                }
                else lbThongBao.setText("Hãy chọn dịch vụ");
            }
        });

        jbtLuu.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String maDV = tvtenDV.getText();
                String so = tvSoLuong.getText();

                String fileName = "dichvu.txt";
                String ma, loai = null, ten = null, soluong, gia = null;
                try {
                    BufferedReader in = new BufferedReader(new FileReader(fileName));

                    ma = in.readLine();
                    while (ma != null) {
                        loai = in.readLine();
                        ten = in.readLine();
                        gia = in.readLine();
                        soluong = in.readLine();
                        if (ma.equals(maDV)) {
                            break;
                        }
                        ma = in.readLine();
                    }
                    in.close();
                    String file = "dichvukhachhang.txt";
                    FileWriter writer = new FileWriter(file, true);
                    int giatien = Integer.parseInt(so) * Integer.parseInt(gia);
                    writer.write(maDV + "\n");
                    writer.write(loai + "\n");
                    writer.write(ten + "\n");
                    writer.write(so + "\n");
                    writer.write(giatien + "\n");
                    writer.close();
                    lbThongBao.setText("Thành công!!!");
                    tvtenDV.setText("");
                    tvSoLuong.setText("");
                    jbtLuu.setVisible(false);

                } catch (IOException iox) {
                    System.out.println("Problem reading " + fileName);
                }
            }
        });

        jpDichVu.add(pThongTin);
        jpDichVu.add(pButton);
        jpDichVu.add(lbThongBao);


    }

    public void panelHoaDon() {
        jpHoaDon.setLayout(null);
        jpDichVu.setLayout(null);
        JLabel label = new JLabel("HÓA ĐƠN");
        label.setBounds(300, 20, 250, 45);
        label.setFont(new Font("Tahoma", Font.BOLD, 30));
        label.setForeground(Color.RED);
        jpHoaDon.add(label);

        JPanel pTrai = new JPanel();
        pTrai.setBounds(100, 100, 100, 400);
        pTrai.setLayout(new GridLayout(10, 1, 5, 5));

        JPanel pPhai = new JPanel();
        pPhai.setBounds(210, 100, 100, 400);
        pPhai.setLayout(new GridLayout(10, 1, 5, 5));

        JLabel lbNV = new JLabel("Nhân viên");
        JTextField txNV = new JTextField();
        txNV.setText(tenNV);
        txNV.setEditable(false);

        JLabel lbTG = new JLabel("Thời Gian");
        JTextField txTG = new JTextField(String.valueOf(java.time.LocalDate.now()));
        txTG.setEditable(false);

        JComboBox<String> cbKH = new JComboBox<>();

        JLabel lbTenKH = new JLabel("Tên khách hàng");
        JTextField txTenKh = new JTextField(" ");
        txTenKh.setEditable(false);

        JLabel lbSDT = new JLabel("SDT");
        JTextField txSDT = new JTextField();
        txSDT.setEditable(false);

        JLabel lbThongBao = new JLabel();
        lbThongBao.setBounds(100,500,200,50);
        jpHoaDon.add(lbThongBao);

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
                    ma = in.readLine();
                    while (ma != null) {
                        ten = in.readLine();
                        gtinh = in.readLine();
                        sdt = in.readLine();
                        slm = in.readLine();
                        if (ma.equals(cbKH.getSelectedItem())) {
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

        int gia = 0;
        JLabel lbTongTien = new JLabel("Tổng tiền: ");
        JTextField tvTT = new JTextField();
        lbTongTien.setBounds(350, 450, 100, 30);
        tvTT.setBounds(450, 450, 100, 30);
        tvTT.setEditable(false);

        JButton jthanhtoan = new JButton("Thanh Toán");
        jthanhtoan.setBounds(450, 550, 120, 30);
        jpHoaDon.add(jthanhtoan);

        jthanhtoan.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String tenKH = txTenKh.getText();
                if(tenKH==" ") {
                    lbThongBao.setText("Nhập đầy đủ thông tin");
                }
                else {
                    String fileName = "dichvukhachhang.txt";
                    String filemoi = "tam.txt";
                    File nfile = new File(filemoi);
                    File ofile = new File(fileName);
                    String fileTK = "thongke.txt";

                    String ma, loai, ten, so, gia;
                    try {
                        BufferedReader in = new BufferedReader(new FileReader(fileName));
                        FileWriter writer = new FileWriter(fileTK, true);
                        ma = in.readLine();
                        while (ma != null) {
                            loai = in.readLine();
                            ten = in.readLine();
                            so = in.readLine();
                            gia = in.readLine();

                            writer.write(java.time.LocalDate.now() + "\n");
                            writer.write(txTenKh.getText() + "\n");
                            writer.write(ten + "\n");
                            writer.write(so + "\n");
                            writer.write(gia + "\n");

                            ma = in.readLine();
                        }
                        lbThongBao.setText("Thanh toán thàng công.");


                        writer.close();
                        in.close();
                        ofile.delete();
                        nfile.renameTo(new File(fileName));


                    } catch (IOException iox) {
                        System.out.println("Problem reading " + fileName);
                    }

                    model.setRowCount(0);
                    String fileName1 = "dichvukhachhang.txt";
                    try {
                        BufferedReader in = new BufferedReader(new FileReader(fileName1));

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
                        System.out.println("Problem reading " + fileName1);
                    }

                }
            }
        });

        jbtHD.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                int tien = 0;
                String t;
                model.setRowCount(0);
                String fileName = "dichvukhachhang.txt";
                try {
                    BufferedReader in = new BufferedReader(new FileReader(fileName));

                    row[0] = in.readLine();
                    while (row[0] != null) {
                        row[1] = in.readLine();
                        row[2] = in.readLine();
                        row[3] = in.readLine();
                        t = in.readLine();
                        row[4] = t;
                        tien = tien + Integer.parseInt(t);
                        model.addRow(row);
                        row[0] = in.readLine();
                    }
                    tvTT.setText(String.valueOf(tien));
                    in.close();
                } catch (IOException iox) {
                    System.out.println("Problem reading " + fileName);
                }
            }
        });

        jpHoaDon.add(lbTongTien);
        jpHoaDon.add(tvTT);

    }

    public void panelTrangchu() {
        jpTrangchu.setVisible(true);
        jpTrangchu.setLayout(null);
        jpTrangchu.setBackground(Color.yellow);

        JLabel lbtc = new JLabel();
        lbtc.setText("SHOP THÚ CƯNG");
        lbtc.setFont(new Font("Tahoma", Font.BOLD, 30));
        lbtc.setBounds(300, 300, 300, 80);
        lbtc.setForeground(Color.red);

        JLabel lbnd = new JLabel("Lựa chọn tốt nhất cho thú cưng của bạn.");
        lbnd.setFont(new Font("Tahoma", Font.ITALIC, 18));
        lbnd.setBounds(250, 400, 500, 50);
        jpTrangchu.add(lbnd);
        jpTrangchu.add(lbtc);


    }

    public void panelthongKe() {
        jpThongKe.setLayout(null);
        JLabel label = new JLabel("THỐNG KÊ");
        label.setBounds(300, 20, 250, 45);
        label.setFont(new Font("Tahoma", Font.BOLD, 30));
        label.setForeground(Color.RED);
        jpThongKe.add(label);

        String[] columnNames = {"Ngày", "Tên Khách hàng", "Tên dịch vụ", "số lượng", "Giá"};
        String[] row = new String[5];

        JTable jTable = new JTable();
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columnNames);
        jTable.setModel(model);
        //jcrollpanel
        JScrollPane sp = new JScrollPane();
        sp.setBounds(100, 100, 550, 300);
        sp.add(jTable);
        sp.setViewportView(jTable);
        jpThongKe.add(sp);

        //button
        jbtTK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.setRowCount(0);
                String fileName = "thongke.txt";
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
    }

    public void panelNhanvien() {
        jpNhanVien.setLayout(null);
        JLabel label = new JLabel("NHÂN VIÊN");
        label.setBounds(300, 20, 250, 45);
        label.setFont(new Font("Tahoma", Font.BOLD, 30));
        label.setForeground(Color.PINK);
        jpNhanVien.add(label);

        //Column Names
        String[] columnNames = {"Mã NV", "Tên nhân viên", "Ngày sinh", "Quê quán", "Số điện thoại", "Lương"};
        String[] row = new String[6];

        JTable jTable = new JTable();
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columnNames);
        jTable.setModel(model);
        //jcrollpanel
        JScrollPane sp = new JScrollPane();
        sp.setBounds(100, 100, 650, 200);
        sp.add(jTable);
        sp.setViewportView(jTable);
        jpNhanVien.add(sp);

        //button
        jbtNV.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.setRowCount(0);
                String fileName = "nhanvien.txt";
                try {
                    BufferedReader in = new BufferedReader(new FileReader(fileName));

                    row[0] = in.readLine();
                    row[1] = in.readLine();
                    row[2] = in.readLine();
                    row[3] = in.readLine();
                    row[4] = in.readLine();
                    row[5] = in.readLine();
                    while (row[0] != null) {
                        soNV++;
                        model.addRow(row);
                        row[0] = in.readLine();
                        row[1] = in.readLine();
                        row[2] = in.readLine();
                        row[3] = in.readLine();
                        row[4] = in.readLine();
                        row[5] = in.readLine();
                    }
                    in.close();
                } catch (IOException iox) {
                    System.out.println("Problem reading " + fileName);
                }
            }
        });

        JPanel pThongTin = new JPanel(new GridLayout(6, 2, 5, 5));
        pThongTin.setBounds(120, 350, 200, 200);

        JLabel lbID = new JLabel("Mã nhân viên:");
        JTextField txID = new JTextField();
        pThongTin.add(lbID);
        pThongTin.add(txID);
        //
        JLabel lbTen = new JLabel("Tên Nhân viên:");
        JTextField txTen = new JTextField();
        pThongTin.add(lbTen);
        pThongTin.add(txTen);
        //
        JLabel lbNS = new JLabel("Ngày sinh:");
        JTextField txNS = new JTextField();
        pThongTin.add(lbNS);
        pThongTin.add(txNS);
        //
        JLabel lbQQ = new JLabel("Quê quán:");
        JTextField txQQ = new JTextField();
        pThongTin.add(lbQQ);
        pThongTin.add(txQQ);
        //
        JLabel lbSDT = new JLabel("Số điện thoại:");
        JTextField txSDT = new JTextField();
        pThongTin.add(lbSDT);
        pThongTin.add(txSDT);
        //
        JLabel lbluong = new JLabel("Lương:");
        JTextField txluong = new JTextField();

        txID.setEditable(false);
        txTen.setEditable(false);
        txNS.setEditable(false);
        txQQ.setEditable(false);
        txSDT.setEditable(false);
        txluong.setEditable(false);

        pThongTin.add(lbluong);
        pThongTin.add(txluong);


        JPanel pButton = new JPanel(new GridLayout(5, 1, 5, 5));
        pButton.setBounds(500, 350, 100, 200);

        JPanel pThongBao = new JPanel();
        pThongBao.setBounds(120, 530, 200, 50);

        JLabel lbThongBao = new JLabel();
        lbThongBao.setForeground(Color.RED);


        JButton jbtthem = new JButton("Thêm");
        jbtthem.setFont(new Font("Tahoma", Font.BOLD, 10));

        JButton jbtluu = new JButton("Lưu");
        jbtluu.setFont(new Font("Tahoma", Font.BOLD, 10));
        jbtluu.setVisible(false);

        JButton jbtkluu = new JButton("Không lưu");
        jbtkluu.setFont(new Font("Tahoma", Font.BOLD, 10));
        jbtkluu.setVisible(false);

        JButton jbtsua = new JButton("Sửa");
        jbtsua.setFont(new Font("Tahoma", Font.BOLD, 10));

        JButton jbtxoa = new JButton("Xóa");
        jbtxoa.setFont(new Font("Tahoma", Font.BOLD, 10));

        pButton.add(jbtthem);

        final int[] a = {0};
        jbtthem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                a[0] = 2;
                jbtluu.setVisible(true);
                jbtkluu.setVisible(true);
                txID.setEditable(true);
                txTen.setEditable(true);
                txNS.setEditable(true);
                txQQ.setEditable(true);
                txSDT.setEditable(true);
                txluong.setEditable(true);
            }
        });

        pButton.add(jbtsua);

        jbtsua.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int n = -1;
                n = jTable.getSelectedRow();

                if (n != -1) {
                    a[0] = 1;
                    jbtkluu.setVisible(true);
                    jbtluu.setVisible(true);
                    txTen.setEditable(true);
                    txNS.setEditable(true);
                    txQQ.setEditable(true);
                    txSDT.setEditable(true);
                    txluong.setEditable(true);

                    String fileName = "nhanvien.txt";
                    String ma, ten, nsinh, que, sdt, luong;
                    File ofile = new File(fileName);
                    try {
                        BufferedReader in = new BufferedReader(new FileReader(ofile));

                        ma = in.readLine();
                        while (ma != null) {
                            ten = in.readLine();
                            nsinh = in.readLine();
                            que = in.readLine();
                            sdt = in.readLine();
                            luong = in.readLine();
                            if (ma.equals(model.getValueAt(n, 0).toString())) {
                                txID.setText(ma);
                                txTen.setText(ten);
                                txNS.setText(nsinh);
                                txQQ.setText(que);
                                txSDT.setText(sdt);
                                txluong.setText(luong);
                                break;
                            }
                            ma = in.readLine();
                        }
                        in.close();
                    } catch (IOException iox) {
                        System.out.println("Problem reading " + fileName);
                    }
                } else lbThongBao.setText("Hãy chọn dòng cần sửa");
            }
        });

        jbtluu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (a[0] == 2) {
                    row[0] = txID.getText();
                    row[1] = txTen.getText();
                    row[2] = txNS.getText();
                    row[3] = txQQ.getText();
                    row[4] = txSDT.getText();
                    row[5] = txluong.getText();

                    String fileName = "nhanvien.txt";
                    String ma, ten, nsinh, que, sdt, luong;
                    int c = 0;
                    try {
                        BufferedReader in = new BufferedReader(new FileReader(fileName));
                        FileWriter writer = new FileWriter(fileName, true);
                        ma = in.readLine();
                        ten = in.readLine();
                        nsinh = in.readLine();
                        que = in.readLine();
                        sdt = in.readLine();
                        luong = in.readLine();
                        while (ma != null) {
                            if (ma.equals(row[0])) {
                                c = 1;
                                break;
                            } else {
                                ma = in.readLine();
                                ten = in.readLine();
                                nsinh = in.readLine();
                                que = in.readLine();
                                sdt = in.readLine();
                                luong = in.readLine();
                            }
                        }
                        in.close();
                        if (c == 1) lbThongBao.setText("trùng mã nhân viên");
                        else {
                            writer.write(row[0] + "\n");
                            writer.write(row[1] + "\n");
                            writer.write(row[2] + "\n");
                            writer.write(row[3] + "\n");
                            writer.write(row[4] + "\n");
                            writer.write(row[5] + "\n");
                            lbThongBao.setText("Lưu thành công.");
                            soNV++;
                            writer.close();
                            model.addRow(row);
                        }
                    } catch (IOException ex) {
                        System.out.println("Problem reading " + fileName);
                    }
                    a[0] = 0;
                }
                if (a[0] == 1) {
                    int i = 0;
                    String fileName = "nhanvien.txt";
                    String fileMoi = "nhanvientam.txt";
                    String ma, ten, nsinh, que, sdt, luong;
                    File nfile = new File(fileMoi);
                    File ofile = new File(fileName);
                    try {
                        FileWriter writer = new FileWriter(fileMoi, true);
                        BufferedReader in = new BufferedReader(new FileReader(ofile));
                        int n = jTable.getSelectedRow();
                        String manv = model.getValueAt(n, 0).toString();
                        ma = in.readLine();
                        ten = in.readLine();
                        nsinh = in.readLine();
                        que = in.readLine();
                        sdt = in.readLine();
                        luong = in.readLine();
                        while (ma != null) {
                            if (ma.equals(manv)) {
                                writer.write(ma + "\n");
                                writer.write(txTen.getText() + "\n");
                                writer.write(txNS.getText() + "\n");
                                writer.write(txQQ.getText() + "\n");
                                writer.write(txSDT.getText() + "\n");
                                writer.write(txluong.getText() + "\n");
                            } else {
                                writer.write(ma + "\n");
                                writer.write(ten + "\n");
                                writer.write(nsinh + "\n");
                                writer.write(que + "\n");
                                writer.write(sdt + "\n");
                                writer.write(luong + "\n");
                            }
                            ma = in.readLine();
                            ten = in.readLine();
                            nsinh = in.readLine();
                            que = in.readLine();
                            sdt = in.readLine();
                            luong = in.readLine();
                            if (i == soNV - 1)
                                break;
                            i++;
                        }

                        writer.close();
                        in.close();
                        ofile.delete();
                        nfile.renameTo(new File(fileName));
                    } catch (IOException ex) {
                        System.out.println("Problem reading " + fileName);
                    }

                    model.setRowCount(0);
                    String fileName1 = "nhanvien.txt";
                    try {
                        BufferedReader in = new BufferedReader(new FileReader(fileName1));

                        row[0] = in.readLine();
                        row[1] = in.readLine();
                        row[2] = in.readLine();
                        row[3] = in.readLine();
                        row[4] = in.readLine();
                        row[5] = in.readLine();
                        while (row[0] != null) {
                            soNV++;
                            model.addRow(row);
                            row[0] = in.readLine();
                            row[1] = in.readLine();
                            row[2] = in.readLine();
                            row[3] = in.readLine();
                            row[4] = in.readLine();
                            row[5] = in.readLine();
                        }
                        lbThongBao.setText("Lưu thành công.");
                        in.close();
                    } catch (IOException iox) {
                        System.out.println("Problem reading " + fileName1);
                    }
                    a[0] = 0;

                }

            }
        });

        jbtkluu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txID.setText("");
                txTen.setText("");
                txNS.setText("");
                txQQ.setText("");
                txSDT.setText("");
                txluong.setText("");
                txID.setEditable(false);
                txTen.setEditable(false);
                txNS.setEditable(false);
                txQQ.setEditable(false);
                txSDT.setEditable(false);
                txluong.setEditable(false);
                jbtluu.setVisible(false);
                jbtkluu.setVisible(false);
            }
        });

        pButton.add(jbtxoa);
        jbtxoa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int n = -1;
                n = jTable.getSelectedRow();
                if (n != -1) {
                    String fileName = "nhanvien.txt";
                    String filemoi = "nhanvientam.txt";
                    String ma, ten, nsinh, que, sdt, luong;
                    File nfile = new File(filemoi);
                    File ofile = new File(fileName);
                    try {
                        FileWriter writer = new FileWriter(filemoi, true);
                        BufferedReader in = new BufferedReader(new FileReader(ofile));

                        ma = in.readLine();
                        ten = in.readLine();
                        nsinh = in.readLine();
                        que = in.readLine();
                        sdt = in.readLine();
                        luong = in.readLine();

                        while (ma != null) {
                            if (!ma.equals(model.getValueAt(n, 0).toString())) {
                                writer.write(ma + "\n");
                                writer.write(ten + "\n");
                                writer.write(nsinh + "\n");
                                writer.write(que + "\n");
                                writer.write(sdt + "\n");
                                writer.write(luong + "\n");
                            } else {
                                ma = in.readLine();
                                ten = in.readLine();
                                nsinh = in.readLine();
                                que = in.readLine();
                                sdt = in.readLine();
                                luong = in.readLine();
                            }
                        }
                        lbThongBao.setText("Đã xóa");
                        writer.close();
                        in.close();
                        ofile.delete();
                        nfile.renameTo(new File(fileName));
                        if (n >= 0)
                            model.removeRow(n);

                    } catch (IOException iox) {
                        System.out.println("Problem reading " + fileName);
                    }
                } else lbThongBao.setText("Hãy chọn dòng cần xóa");
            }
        });

        pButton.add(jbtluu);
        pButton.add(jbtkluu);

        pThongBao.add(lbThongBao);

        jpNhanVien.add(pThongBao);
        jpNhanVien.add(pThongTin);
        jpNhanVien.add(pButton);

    }

}