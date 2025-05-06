public class Phone {
    public String band;
    public int price;

    public Phone(String band,int price){
        this.band=band;
        this.price=price;
    }

    public void call(){
        System.out.println("我正在打电话");
    }

    public void playGame(){
        System.out.println("我正在玩游戏");
    }


}
