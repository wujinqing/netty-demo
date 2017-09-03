package com.jin.nio;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

public class MyNioTest13 {
    public static void main(String[] args) {


        String s = String.valueOf("吴");

        Charset charset = Charset.forName("utf-8");

        ByteBuffer byteBuffer = charset.encode(s);


        byte[] bs = byteBuffer.array();

        for(int i = 0; i < bs.length; i++)
        {
            System.out.println(Integer.toHexString(bs[i]));
            System.out.println(Integer.toBinaryString(bs[i]).substring(24));
        }

        System.out.println("=================");

        Charset charset2 = Charset.forName("iso-8859-1");

        ByteBuffer byteBuffer2 = charset2.encode(s);


        byte[] bs2 = byteBuffer2.array();

        for(int i = 0; i < bs2.length; i++)
        {
            System.out.println(Integer.toHexString(bs2[i]));
            System.out.println(Integer.toBinaryString(bs2[i]));
        }

    }
}
