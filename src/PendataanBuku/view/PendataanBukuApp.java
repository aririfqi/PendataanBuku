package PendataanBuku.view;

import javax.swing.JFrame;
import javax.swing.BorderFactory;
import java.awt.*;

public class PendataanBukuApp extends JFrame{
    public PendataanBukuApp(){
        super("PENDATAAN BUKU");
        LayoutDataBuku dataBukuLayout = new LayoutDataBuku();
        dataBukuLayout.setBorder(BorderFactory.createEmptyBorder());
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        this.setMinimumSize(new Dimension(350,250));
        this.setContentPane(dataBukuLayout);
        this.setVisible(true);
        this.pack();
        this.setLocationRelativeTo(null);

    }
}
