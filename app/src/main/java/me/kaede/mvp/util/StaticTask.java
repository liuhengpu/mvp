package me.kaede.mvp.util;

import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public  class StaticTask extends Thread{

        //读写流方法的抽取;
        InputStream in;
        OutputStream out;
        public void  StaticTask(InputStream in, OutputStream out) {
            this.in=in;
            this.out=out;
        }
        @Override
        public void run() {
            byte[] buf=new byte[1024*2];
            int len;

            try {
                while ((len=in.read(buf)) > 0) {
                    out.write(buf, 0, len);
                }
                in.close();
                out.close();
            }
            catch (IOException e) {
                Log.e(getClass().getSimpleName(),
                        "Exception transferring file", e);
            }
        }

}
