package PendataanBuku.view;

import javax.swing.*;
import javax.swing.BorderFactory;

import PendataanBuku.model.DataBuku;

import java.awt.*;
import java.util.ArrayList;

public class FrameSemuaBuku extends JFrame{
    public FrameSemuaBuku(ArrayList<DataBuku>dataBuku){
        super("ALL DATA");
        LayoutSemuaBuku layoutBuku = new LayoutSemuaBuku(dataBuku);
        layoutBuku.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        this.setMinimumSize(new Dimension(300,220));
        this.setContentPane(layoutBuku);
        this.setVisible(true);
        this.pack();
        this.setLocationRelativeTo(null);

    }
}
