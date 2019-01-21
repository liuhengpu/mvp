package me.kaede.mvp.util;


public class TastUtil {

    //接口回调的一般操作类，

    public  static   TestHuiDiao  mphoneI;
    public static  void setCallBack(TestHuiDiao  phoneI){
        mphoneI = phoneI;
    }

    public static void doPlayphone(){
        //需要传递的数据
        String info = "111112";
        mphoneI.playPhone(info);
    }

}
