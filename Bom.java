/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hungtrung;

import java.awt.Color;
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
public class Bom extends JPanel {

    private static int y1 = 0, y2 = -100, y3 = -200;
    private static int x1, x2, x3; // tọa độ x ban đầu
    private static int tt1 = 1, tt2 = 1, tt3 = 1; // tt1 : trạng thái sang phải  tt2 : trạng thái sang trái   
    private static boolean b1 = false;
    private static boolean b2 = false; // dùng ngẫu nhiên 1 lần
    private static boolean b3 = false;
    private BufferedImage bm1, bm2, bm3;

    public static int getY1() {
        return y1;
    }

    public static int getY2() {
        return y2;
    }

    public static int getY3() {
        return y3;
    }

    public static int getX1() {
        return x1;
    }

    public static int getX2() {
        return x2;
    }

    public static int getX3() {
        return x3;
    }

    public void NgauNhien() {
        Random rd = new Random();

        if (b1 == false) { // kiểm tra đúng bằng false thì sinh ngẫu nhiên
            int so = 600 - 3 + 1;
            x1 = rd.nextInt(so);
            b1 = true; // chỉ ngẫu nhiên 1 lần
        }
        if (b2 == false) {
            int so = 600 - 3 + 1;
            x2 = rd.nextInt(so);
            b2 = true;
        }
        if (b3 == false) {
            int so = 600 - 3 + 1;
            x3 = rd.nextInt(so);
            b3 = true;
        }
    }

    public void Bom1(Graphics g) {
        try {
            NgauNhien();
//        g.setColor(Color.yellow); // vẽ ra một hình có màu đỏ
//        g.fillRect(x1, y1, 40, 40); // cài đặt tọa độ cho hình và độ dài rộng của hình
            bm1 = ImageIO.read(new File("imageGame\\bom1.png"));
            g.drawImage(bm1, x1, y1, null);
        } catch (IOException ex) {
            Logger.getLogger(Bom.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void Bom2(Graphics g) {
            NgauNhien();
        try {
            
//        g.setColor(Color.yellow); // vẽ ra một hình có màu đỏ
//        g.fillRect(x1, y1, 40, 40); // cài đặt tọa độ cho hình và độ dài rộng của hình
            bm2 = ImageIO.read(new File("imageGame\\bom2.png"));
            g.drawImage(bm2, x2, y2, null);
        } catch (IOException ex) {
            Logger.getLogger(Bom.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void Bom3(Graphics g) {
        NgauNhien();
        try {
            
//        g.setColor(Color.yellow); // vẽ ra một hình có màu đỏ
//        g.fillRect(x1, y1, 40, 40); // cài đặt tọa độ cho hình và độ dài rộng của hình
            bm3 = ImageIO.read(new File("imageGame\\bom3.png"));
            g.drawImage(bm3, x3, y3, null);
        } catch (IOException ex) {
            Logger.getLogger(Bom.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void Bom1Bay() {
        if (tt1 == 1) {
            y1++; // di chuyển xuống
            x1 = x1 + 3; // di chuyển sang phải
        }
        if (tt1 == 2) {
            y1++;
            x1 = x1 - 3;
        }
    }

    public void Bom2Bay() {
        if (tt2 == 1) {
            y2++;
            x2 = x2 - 1;

        }
        if (tt2 == 2) {
            y2++;
            x2 = x2 + 1;
        }
    }

    public void Bom3Bay() {
        if (tt3 == 1) {
            y3 = y3 + 3;
            // x3 = x3+2;
        }
        if (tt3 == 2) {
            y3 = y3 + 3;

            // x3 = x3 - 2;
        }
    }

    public void lapLai() {
        //cham đay
        if (y1 >= 800) { // nếu y của chim chạm đáy tức là = 800 thì set lại y về y ban đầu
            y1 = -50;
            tt1 = 1; // set trạng thái về ban đầu
            b1 = false; // sau khi đi hết biên thì lại sinh ngẫu nhiên
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

}
