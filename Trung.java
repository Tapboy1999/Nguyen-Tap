/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hungtrung;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author Tap-Pc
 */
public class Trung extends JPanel {

    private static int y1 = 0, y2 = -100, y3 = -200, y4 = -300, y5 = -250; // tọa độ y ban đầu của các đối tg
    private static int x1, x2, x3, x4, x5; // tọa độ x ban đầu (x cần random nên ko gán giá trị cố định)
    private static int tt1 = 1, tt2 = 1, tt3 = 1, tt4 = 1, tt5 = 1; // tt1 : trạng thái sang phải  tt2 : trạng thái sang trái   
    private static boolean b1 = false, b2 = false, b3 = false, b4 = false, b5 = false; // sử dụng khi random chạy 1 lần khi 1 vòng lặp chạy xong
    private BufferedImage a1, a2, a3, a4, a5; // lưu những bức ảnh được load để sử dụng trong chương trình

//    KiemTra kiemtra = new KiemTra();
    public static int getX1() {
        return x1;
    }

    public static int getX2() {
        return x2;
    }

    public static int getX3() {
        return x3;
    }

    public static int getX4() {
        return x4;
    }

    public static int getX5() {
        return x5;
    }

    public static int getY1() {
        return y1;
    }

    public static int getY2() {
        return y2;
    }

    public static int getY3() {
        return y3;
    }

    public static int getY4() {
        return y4;
    }

    public static int getY5() {
        return y5;
    }

    public void NgauNhien() {
        Random rd = new Random();
        int so = 600 - 3 + 1; // nằm trong khoảng từ 3 - 600 px
        if (b1 == false) { // kiểm tra đúng bằng false thì sinh ngẫu nhiên
            x1 = rd.nextInt(so); // sinh ngẫu nhiên trong khoảng 3 - 600px
            b1 = true; // không lặp lại hàm ngẫu nhiên nữa
        }
        if (b2 == false) {
            x2 = rd.nextInt(so);
            b2 = true;
        }
        if (b3 == false) {
            x3 = rd.nextInt(so);
            b3 = true;
        }
        if (b4 == false) {
            x4 = rd.nextInt(so);
            b4 = true;
        }
        if (b5 == false) {
            x5 = rd.nextInt(so);
            b5 = true;
        }
    }

    public void Trung1(Graphics g) {
        try {
            NgauNhien();
//        g.setColor(Color.red); // vẽ ra một hình có màu đỏ
//        g.fillRect(x1, y1, 40, 40); // cài đặt tọa độ cho hình và độ dài rộng của hình
            a1 = ImageIO.read(new File("imageGame\\food1.png"));
            g.drawImage(a1, x1, y1, null);
        } catch (IOException ex) {
            Logger.getLogger(Trung.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void Trung2(Graphics g) {
//        g.setColor(Color.red);
//        g.fillRect(x2, y2, 40, 40);
        try {
            NgauNhien();
            a2 = ImageIO.read(new File("imageGame\\food2.png"));
            g.drawImage(a2, x2, y2, null);
        } catch (IOException ex) {
            Logger.getLogger(Trung.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void Trung3(Graphics g) {
//        g.setColor(Color.red);
//        g.fillRect(x3, y3, 40, 40);
        try {
            NgauNhien();
            a3 = ImageIO.read(new File("imageGame\\food3.png"));
            g.drawImage(a3, x3, y3, null);
        } catch (IOException ex) {
            Logger.getLogger(Trung.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void Trung4(Graphics g) {
//        g.setColor(Color.red);
//        g.fillRect(x4, y4, 40, 40);
        try {
            NgauNhien();
            a4 = ImageIO.read(new File("imageGame\\food4.png"));
            g.drawImage(a4, x4, y4, null);
        } catch (IOException ex) {
            Logger.getLogger(Trung.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void Trung5(Graphics g) {
//        g.setColor(Color.red);
//        g.fillRect(x5, y5, 40, 40);
        try {
            NgauNhien();
            a5 = ImageIO.read(new File("imageGame\\food5.png"));
            g.drawImage(a5, x5, y5, null);
        } catch (IOException ex) {
            Logger.getLogger(Trung.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void Trung1Bay() {
        if (tt1 == 1) {
            y1 = y1+1; // di chuyển xuống
            x1 = x1 + 2; // di chuyển sang phải
        }
        if (tt1 == 2) {
            y1++;
            x1 = x1 - 2;
        }
    }

    public void Trung2Bay() {
        if (tt2 == 1) {
            y2++;
            x2 = x2 - 2;

        }
        if (tt2 == 2) {
            y2++;
            x2 = x2 + 2;
        }
    }

    public void Trung3Bay() {
        if (tt3 == 1) {
            y3 = y3 + 2;
            // x3 = x3+2;
        }
        if (tt3 == 2) {
            y3 = y3 + 2;
            //x3 = x3 - 2;
        }
    }

    public void Trung4Bay() {
        if (tt4 == 1) {
            y4++;
            x4 = x4 + 1;
        }
        if (tt4 == 2) {
            y4++;
            x4 = x4 - 2;
        }
    }

    public void Trung5Bay() {
        if (tt5 == 1) {
            y5++;
            // x5 = x5+1;
        }
        if (tt5 == 2) {
            y5++;
            // x5 = x5 - 2;
        }
    }

    public void lapLai() {
        //cham đay
        if (y1 >= 800) { // nếu y của chim chạm đáy tức là = 800 thì set lại y về y ban đầu
            y1 = -50;
            tt1 = 1; // set trạng thái về ban đầu
            b1 = false; // sau khi qua biên thì sinh ngẫu nhiên để lặp lại
        }

        if (y2 >= 800) {
            y2 = -50;
            tt2 = 1;
            b2 = false;
        }
        if (y3 >= 800) {
            y3 = -50;
            tt3 = 1;
            b3 = false;
        }
        if (y4 >= 800) {
            y4 = -50;
            tt4 = 1;
            b4 = false;
        }
        if (y5 >= 800) {
            y5 = -50;
            tt5 = 1;
            b5 = false;
        }
        // Cham bien ngang
        if (x1 >= 630 || x1 <= 0) {
            if (x1 <= 0) {
                tt1 = 1;
            } else {
                tt1 = 2;
            }
        }
        if (x2 >= 630 || x2 <= 0) { // nếu chạm 2 biên thì đổi trạng thái
            if (x2 <= 0) {
                tt2 = 2;
            } else {
                tt2 = 1;
            }
        }
        if (x3 >= 630 || x3 <= 0) {
            if (x3 <= 0) {
                tt3 = 1;
            } else {
                tt3 = 2;
            }
        }
        if (x4 >= 630 || x4 <= 0) {
            if (x4 <= 0) {
                tt4 = 1;
            } else {
                tt4 = 2;
            }
        }
        if (x5 >= 630 || x5 <= 0) {
            if (x5 <= 0) {
                tt5 = 1;
            } else {
                tt5 = 2;
            }
        }
    }

    public void VaCham1() {
        y1 = 0;
        tt1 = 1; // set trạng thái về ban đầu
        b1 = false;
    }

    public void VaCham2() {
        y2 = -100;
        tt2 = 1; // set trạng thái về ban đầu
        b2 = false;
    }

    public void VaCham3() {
        y3 = -200;
        tt3 = 1; // set trạng thái về ban đầu
        b3 = false;
    }

    public void VaCham4() {
        y4 = -300;
        tt4 = 1; // set trạng thái về ban đầu
        b4 = false;
    }

    public void VaCham5() {
        y5 = -250;
        tt5 = 1; // set trạng thái về ban đầu
        b5 = false;
    }

}
