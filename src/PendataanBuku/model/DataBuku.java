package PendataanBuku.model;

public class DataBuku {
    private String nama, jenis;
    private int jumlah;
    public void setNama(String nama){
        this.nama = nama;
    }
    public void setJenis(String jenis){
        this.jenis = jenis;
    }
    public void setJumlah(int jumlah){
        this.jumlah = jumlah;
    }
    public String getNama(){
        return nama;
    }
    
    public int getJumlah(){
        return jumlah;
    }
    public String getJenis(){
        return jenis;
    }
}
