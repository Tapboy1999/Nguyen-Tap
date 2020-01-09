/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hungtrung;

/**
 *
 * @author Tap-Pc
 */
public class KiemTra {
    Trung ktTrung = new Trung();
    Player ktPlayer = new Player();
    Bom ktBom = new Bom();
    int Diem;
 
    
    public boolean AnTrung1(){
        if(ktTrung.getY1() + 40 >= ktPlayer.getY1()){
           if(ktTrung.getX1() <= 100+ ktPlayer.getX1()  && ktTrung.getX1() >= ktPlayer.getX1() - 40){
               return true;
            }
        }
        return false;
    }  
    public boolean AnTrung2(){
        if(ktTrung.getY2() + 40 >= ktPlayer.getY1()){
           if(ktTrung.getX2() <= 100+ ktPlayer.getX1() && ktTrung.getX2() >= ktPlayer.getX1() - 40){
               return true;
            }
        }
        return false;
    }  
    public boolean AnTrung3(){
        if(ktTrung.getY3() + 40 >= ktPlayer.getY1()){
           if(ktTrung.getX3() <= 100+ ktPlayer.getX1() && ktTrung.getX3() >= ktPlayer.getX1() - 40){
               return true;
            }
        }
        return false;
    }  
    public boolean AnTrung4(){
        if(ktTrung.getY4() + 40 >= ktPlayer.getY1()){
           if(ktTrung.getX4() <= 100 + ktPlayer.getX1()&& ktTrung.getX4() >= ktPlayer.getX1() - 40){
               return true;
            }
        }
        return false;
    }  
    public boolean AnTrung5(){
        if(ktTrung.getY5() + 40 >= ktPlayer.getY1() ){
           if(ktTrung.getX5() <= 100 + ktPlayer.getX1() && ktTrung.getX5() >= ktPlayer.getX1() - 40){
               return true;
            }
        }
        return false;
    }  
    public boolean AnBom1(){
        if(ktBom.getY1() + 40 >= ktPlayer.getY1() ){
           if(ktBom.getX1() <= 100 + ktPlayer.getX1() && ktBom.getX1() >= ktPlayer.getX1() - 40){
               return true;
            }
        }
        return false;
    }  
    public boolean AnBom2(){
        if(ktBom.getY2() + 40 >= ktPlayer.getY1() ){
           if(ktBom.getX2() <= 100 + ktPlayer.getX1() && ktBom.getX2() >= ktPlayer.getX1() - 40){
               return true;
            }
        }
        return false;
    }
    public boolean AnBom3(){
        if(ktBom.getY3() + 40 >= ktPlayer.getY1() ){
           if(ktBom.getX3() <= 100 + ktPlayer.getX1() && ktBom.getX3() >= ktPlayer.getX1() - 40 ){
               return true;
            }
        }
        return false;
    }  
    public void TangDiem(){
        Diem = Diem + 100;
    }
}
