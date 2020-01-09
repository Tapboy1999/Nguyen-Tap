// Vẽ ra các đối tượng lên giao diện
package hungtrung;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class HienThi extends JPanel implements Runnable { // kế thừa từ các interfaces -- interface Runable cần overloading hàm run
     
    // gọi ra các đối tượng
    Trung htTrung = new Trung(); 
    Player htPlayer = new Player();
    Bom htBom = new Bom();
    KiemTra Kt = new KiemTra();

    private static int Diem = 0;
    private BufferedImage nen, press,score; // BufferedImage 1 lớp chuyên làm việc với hình ảnh
    boolean replay = true , pause = true; 
    Thread ThreadHT; // tạo 1 luồng thread
    int a = 2;
    public HienThi() {
            Thread threadHT = new Thread(this);
            threadHT.start(); // Khi luồng thread chạy sẽ gọi đến hàm run
    }

    public void paint(Graphics g) { 
        try {
            // nền:
//        g.setColor(Color.WHITE);
//        g.fillRect(0, 0, 700, 800);
            nen = ImageIO.read(new File("imageGame\\nen.png")); // load file ảnh vào chương trình
            g.drawImage(nen, 0, 0, null); // hiển thị file ảnh lên giao diện
        } catch (IOException ex) {
        }

        // Hiển Thị các đối tượng trong game
        htTrung.Trung1(g);
        htTrung.Trung2(g);
        htTrung.Trung3(g);
        htTrung.Trung4(g);
        htTrung.Trung5(g);
        htBom.Bom1(g);
        htBom.Bom2(g);
        htBom.Bom3(g);
        htPlayer.BanHung(g);
        g.setColor(Color.yellow);
        g.setFont(new Font("Time new Romans", Font.BOLD, 40)); // cài đặt font 
        g.drawString("" + Diem, 120, 45); // Hiển thị điểm số lên giao diện
        try {
            // hiển thị điểm số:
            score = ImageIO.read(new File("imageGame\\score2.png"));
            g.drawImage(score, 10, 15, null);
        } catch (IOException ex) {
            Logger.getLogger(HienThi.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            
            score = ImageIO.read(new File("imageGame\\pause1.png"));
            g.drawImage(score, 350, 15, null);
        } catch (IOException ex) {
            Logger.getLogger(HienThi.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if (Kt.AnBom1() == true) {
            try {
                press = ImageIO.read(new File("imageGame\\press1.png"));
                g.drawImage(press, 90, 270, null);
            } catch (IOException ex) {
                Logger.getLogger(HienThi.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (Kt.AnBom2() == true) {
            try {
                press = ImageIO.read(new File("imageGame\\press1.png"));
                g.drawImage(press, 90, 270, null);
            } catch (IOException ex) {
                Logger.getLogger(HienThi.class.getName()).log(Level.SEVERE, null, ex);
            }
//            g.setColor(Color.yellow);
//            g.fillRect(100, 270, 500, 150);
        }
        if (Kt.AnBom3() == true) {
            try {
                press = ImageIO.read(new File("imageGame\\press1.png"));
                g.drawImage(press, 90, 270, null);
            } catch (IOException ex) {
                Logger.getLogger(HienThi.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (pause == false){
            try {
                press = ImageIO.read(new File("imageGame\\pause.png"));
                g.drawImage(press, 90, 270, null);
            } catch (IOException ex) {
                Logger.getLogger(HienThi.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    @Override
    public void run() {
        while (true) {
            repaint(); // gọi lại hàm paint
            htTrung.Trung1Bay();
            htTrung.Trung2Bay();
            htTrung.Trung3Bay();
            htTrung.Trung4Bay();
            htTrung.Trung5Bay();
            htBom.Bom1Bay();
            htBom.Bom2Bay();
            htBom.Bom3Bay();
            try {
                Thread.sleep(10); // cú cách 10 ms thì gọi lại vòng lặp
            } catch (InterruptedException ex) {
            }
            //Kt.AnTrung();
            if (Kt.AnTrung1() == true) {
                htTrung.VaCham1();
                Diem = Diem + 100;
            }
            if (Kt.AnTrung2() == true) {
                htTrung.VaCham2();
                Diem = Diem + 100;
            }
            if (Kt.AnTrung3() == true) {
                htTrung.VaCham3();
                Diem = Diem + 100;
            }
            if (Kt.AnTrung4() == true) {
                htTrung.VaCham4();
                Diem = Diem + 100;
            }
            if (Kt.AnTrung5() == true) {
                htTrung.VaCham5();
                Diem = Diem + 100;
            }
            // Kiem tra an Bom
            if (Kt.AnBom1() == true) {
                replay = false;
                ThreadHT.stop(); // kết thúc luồng thread
            }
            if (Kt.AnBom2() == true) {
                replay = false;
                ThreadHT.stop();
            }
            if (Kt.AnBom3() == true) {
                replay = false;
                ThreadHT.stop();
            }
            if (pause == false){
                ThreadHT.stop();
            }
            htTrung.lapLai();
            htBom.lapLai();
        }
    }
    public void Replay() {
        Thread rpl = new Thread(this);
        rpl.start();  // tạo 1 luồng thread mới và bắt đầu chạy
        htTrung.VaCham1();
        htTrung.VaCham2();
        htTrung.VaCham3();
        htTrung.VaCham4();
        htTrung.VaCham5();
        htBom.VaCham1();
        htBom.VaCham2();
        htBom.VaCham3();
        htPlayer.SetViTri();
        replay = true; // trả lại giá trị mặc định của biến replay
        Diem = 0;
    }
   
    public void pause(){
        pause = true;
        Thread rp2 = new Thread(this);
        rp2.start();
    }
    
}
