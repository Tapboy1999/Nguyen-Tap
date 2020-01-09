/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hungtrung;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author Tap-Pc
 */
public class ManHinh extends JFrame {

    HienThi HT = new HienThi();
    Player PL = new Player();

    public ManHinh() { 
        setSize(700, 835); // set size hiển thị trên màn hình
        setVisible(true); // cho phép hiển thị khung lên màn hình
        setDefaultCloseOperation(EXIT_ON_CLOSE); // nhấn phím exit trên giao diện sẽ dừng hẳn chương trình
        setLocation(610, 140); // set vị trí mà giao diện hiển thị
        add(HT); // thêm lớp HienThi vào --> hiển thị các đối tượng được tạo
        setResizable(false); // Không cho người dùng thay đổi kích thước size
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent ke) { // sự kiện nhấn phím
                if (ke.getKeyCode() == KeyEvent.VK_A) {
                    PL.DiChuyenTrai();
                }
                if (ke.getKeyCode() == KeyEvent.VK_D) {
                    PL.DiChuyenPhai();
                }
                if (ke.getKeyCode() == KeyEvent.VK_LEFT) {
                    PL.DiChuyenTrai();
                }
                if (ke.getKeyCode() == KeyEvent.VK_RIGHT) {
                    PL.DiChuyenPhai();
                }
                if(ke.getKeyCode() == KeyEvent.VK_S){
                    HT.pause = false;
                }
                if (ke.getKeyCode() == KeyEvent.VK_SPACE){
                    
                    if (HT.replay == false){
                        HT.Replay();
                    }
                    if (HT.pause == false){
                        HT.pause();
                }
                }
                if (ke.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    System.exit(0);
                }
            }
        });

    }

    public static void main(String[] args) {
        ManHinh mh = new ManHinh();
    }

}
