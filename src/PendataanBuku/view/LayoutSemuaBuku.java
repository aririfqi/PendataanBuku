package PendataanBuku.view;

import javax.swing.*;

import PendataanBuku.model.DataBuku;

import java.awt.*;
import java.util.ArrayList;

public class LayoutSemuaBuku  extends PanelDataBuku{
    private JLabel viewJudul ;
    private JLabel viewJenis;
    private JLabel viewJumlah;
    private final ArrayList<DataBuku> data;
    int indeks = 0;

    public LayoutSemuaBuku(ArrayList<DataBuku> data){
        super();
        this.data=data;
        initUserInterface();
    }

    void initUserInterface() {
        this.setLayout(new BorderLayout(20,20));
        JPanel gridLayoutCenter= new JPanel();
        gridLayoutCenter.setLayout(new GridLayout(3,1,20,20));
        JLabel viewTittle = new JLabel("SEMUA DATA", SwingConstants.CENTER);
        JButton buttonNext = new JButton("Lanjut");
        JButton buttonPrev = new JButton("Kembali");
        String[] dt;
        dt = getData(indeks);

        viewJudul = new JLabel("Judul : "+dt[0], SwingConstants.CENTER);
        viewJenis = new JLabel("Jenis : "+dt[1], SwingConstants.CENTER);
        viewJumlah = new JLabel("Jumlah : "+dt[2], SwingConstants.CENTER);

        gridLayoutCenter.add(viewJudul);
        gridLayoutCenter.add(viewJenis);
        gridLayoutCenter.add(viewJumlah);

        JPanel gridLayoutBottom = new JPanel();
        gridLayoutBottom.setLayout(new GridLayout(1,2,20,20));
        gridLayoutBottom.add(buttonPrev);
        gridLayoutBottom.add(buttonNext);

        this.add(viewTittle, BorderLayout.NORTH);
        this.add(gridLayoutCenter, BorderLayout.CENTER);
        this.add(gridLayoutBottom, BorderLayout.SOUTH);
        this.add(this.empty, BorderLayout.WEST);
        this.add(this.empty, BorderLayout.EAST);

        buttonPrev.addActionListener(e -> {
            if(indeks ==0){
                errorMessage("Anda berada di data paling awal");
            }
            else{
                indeks--;
                viewBook(indeks);
            }
        });
        buttonNext.addActionListener(e ->{
            if(indeks>=data.size()-1){
                errorMessage("Anda Berada di data Paling Akhir");
            }else{
                indeks++;
                viewBook(indeks);
            }
        });
    }
    void viewBook(int indeks) {
        String[] dt;
        dt = getData(indeks);
        viewJudul.setText("Judul: "+dt[0]);
        viewJenis.setText("Jenis: "+dt[1]);
        viewJumlah.setText("Jumlah: "+dt[2]);

    }

    String[] getData(int indeks){
        String[] dt = new String[3];
        dt[0] = data.get(indeks).getNama();
        dt[1] = data.get(indeks).getJenis();
        int jumlah = data.get(indeks).getJumlah();
        dt[2] = Integer.toString(jumlah);
        return dt;
    }
    void errorMessage(String message){
        JOptionPane.showMessageDialog(this, message, "ERROR", JOptionPane.ERROR_MESSAGE);
    }
    
}
