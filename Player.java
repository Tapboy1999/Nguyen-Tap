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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author Tap-Pc
 */
public class Player extends JPanel {

    private static int x1 = 310; // tọa độ ban đầu của player
    private static int y1 = 780;
    private BufferedImage mb;

    public static int getX1() {
        return x1;
    }

    public static int getY1() {
        return y1;
    }

    public void BanHung(Graphics g) {
        try {
            //        g.setColor(Color.red);
            //        g.fillRect(x1, 780, 100, 20);

            mb = ImageIO.read(new File("imageGame\\shipGreen1.png"));
            g.drawImage(mb, x1, 780, null);
        } catch (IOException ex) {
            Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void DiChuyenTrai() {
        if (x1 >= 10) { // khi x nằm trong khoảng > 10 thì mới có thể di chuyển -- player ko vượt qua biên
            x1 = x1 - 10;
        }

    }

    public void DiChuyenPhai() {
        if (x1 <= 581) {// khi x nằm trong khoảng <580 thì mới có thể di chuyển -- player ko vượt qua biên
            x1 = x1 + 10;
        }
    }

    public void SetViTri() {
        x1 = 310; // set lại vị trí ban đầu cho player
        y1 = 780;
    }
}
