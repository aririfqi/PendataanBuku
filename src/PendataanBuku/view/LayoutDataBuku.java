package PendataanBuku.view;

import javax.swing.*;

import PendataanBuku.model.DataBuku;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class LayoutDataBuku extends PanelDataBuku {
    private JTextField textFrameNama;
    private JTextField textFrameJenis;
    private JTextField textFrameJumlah;
    private ArrayList<DataBuku> data;

    public LayoutDataBuku(){
        super();
        data = new ArrayList<>();
        initUserInterface();
    }



    void errorMessage(String message){
        JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
    }
    void successAdd(String message){
        JOptionPane.showMessageDialog(this, "Data Buku"+message+" berhasil ditambahkan", 
        "Informasi", JOptionPane.INFORMATION_MESSAGE);
    }
    void dataEmpty(){
        JOptionPane.showMessageDialog(this, "Data Buku Kosong", 
        "Informasi", JOptionPane.INFORMATION_MESSAGE);
    }
    void deleteMessage(){
        JOptionPane.showMessageDialog(this, "Data Semua Buku Berhasil dihapus", 
        "Informasi", JOptionPane.INFORMATION_MESSAGE);
    }
    boolean isEmpty(String data){
        return data.equals("");

    }
    void resetField(){
        textFrameNama.setText("");
        textFrameJenis.setText("");
        textFrameJumlah.setText("");
    }
    void addData(){
        String nama = textFrameNama.getText();
        String jenis = textFrameJenis.getText();
        String jumlah = textFrameJumlah.getText();
        if(!isEmpty(nama) && !isEmpty(jenis) && !isEmpty(jumlah)){
            DataBuku buku = new DataBuku();
            buku.setNama(textFrameNama.getText());
            buku.setJenis(textFrameJenis.getText());
            try {
                int jmlh = Integer.parseInt(jumlah);
                buku.setJumlah(jmlh);
                data.add(buku);
                successAdd(buku.getNama());
                resetField();
            } catch (NumberFormatException e) {
                errorMessage("Jumlah Harus Berupa Angka!!!");
                resetField();
                addData();
            }
        }else{
            if(isEmpty(nama) && isEmpty(jumlah) && isEmpty(jenis)){
                errorMessage("Nama, Jenis dan Jumlah Tidak Boleh Kosong");
            }else if(isEmpty(nama) && isEmpty(jumlah)) {
                errorMessage("Nama dan Jumlah Tidak Boleh Kosong");
            }else if(nama.equals("") && isEmpty(jenis)) {
                errorMessage("Nama dan Jenis Tidak Boleh Kosong");
            }else if(isEmpty(jumlah) && isEmpty(jenis)) {
                errorMessage("Jenis dan Jumlah Tidak Boleh Kosong");
            }else if(isEmpty(nama)){
                errorMessage("Nama Tidak Boleh Kosong");
            }else if(isEmpty(jumlah)){
                errorMessage("Jumlah Tidak Boleh Kosong");
            }else{
                errorMessage("Jenis Tidak Boleh Kosong");
            }
        }

    }
    void enter(JTextField tks){
        tks.addKeyListener(new KeyAdapter(){
            @Override
            public void keyPressed(KeyEvent e){
                super.keyTyped(e);
                if(e.getKeyCode()==KeyEvent.VK_ENTER){
                    addData();
                }
            }
        });
    }
    void initUserInterface(){

        this.setLayout(new BorderLayout(20,20));
        JPanel gridLayoutCenter = new JPanel();
        gridLayoutCenter.setLayout(new GridLayout(3,1,20,20));

        JPanel gridLayoutRight = new JPanel();
        gridLayoutRight.setLayout(new GridLayout(3,1,20,20));

        JPanel gridLayoutLeft = new JPanel();
        gridLayoutLeft.setLayout(new GridLayout(3,1,20,20));

        JLabel labelNama = new JLabel("Judul : ", SwingConstants.CENTER);
        JLabel labelJenis = new JLabel("Jenis : ", SwingConstants.CENTER);
        JLabel labelJumlah = new JLabel("Jumlah : ", SwingConstants.CENTER);
        JButton buttonOK = new JButton("OK");
        JButton buttonReset = new JButton("RESET");
        JButton buttonView = new JButton("VIEW");

        textFrameNama = new JTextField();
        textFrameJenis = new JTextField();
        textFrameJumlah = new JTextField();
        textFrameNama.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        textFrameJenis.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        textFrameJumlah.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

                
        //buat layout, layout apa yg mau dipake
        //buat komponen2 yang bakalan dipake
        //masukkan ke layout

        //baris --> kolom

        //baris ke-1
        //kolom k-1
        gridLayoutLeft.add(labelNama);
        //kolom2
        gridLayoutCenter.add(textFrameNama);
        //kolom 3
        gridLayoutRight.add(buttonOK);

        gridLayoutLeft.add(labelJenis);
        gridLayoutCenter.add(textFrameJenis);
        gridLayoutRight.add(buttonReset);

        gridLayoutLeft.add(labelJumlah);
        gridLayoutCenter.add(textFrameJumlah);
        gridLayoutRight.add(buttonView);

        this.add(this.empty, BorderLayout.NORTH);
        this.add(gridLayoutCenter, BorderLayout.CENTER);
        this.add(this.empty, BorderLayout.SOUTH);
        this.add(gridLayoutLeft, BorderLayout.WEST);
        this.add(gridLayoutRight, BorderLayout.EAST);

        buttonOK.addActionListener(e -> addData());
        buttonReset.addActionListener(e -> {
            int pilihan = JOptionPane.showConfirmDialog(this, "Apakah anda Yakin untuk Mereset Data?");
            
            if(pilihan==JOptionPane.YES_OPTION){
                data.clear();
                deleteMessage();
            }
        });
        buttonView.addActionListener(e ->{
            if (data.size()==0) {
                dataEmpty();
            } else {
                new FrameSemuaBuku(data);
            }
        });
        enter(textFrameNama);
        enter(textFrameJenis);
        enter(textFrameJumlah);




    }
}
