package com.jin.nio;

import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

public class NioTest10 {
    public static void main(String[] args) throws Exception{
        RandomAccessFile randomAccessFile = new RandomAccessFile("NioTest10.txt", "rw");
        FileChannel fileChannel = randomAccessFile.getChannel();

        FileLock fileLock = fileChannel.lock(0, 5, true);

        System.out.println("isValid: " + fileLock.isValid());
        System.out.println("lock type: " + fileLock.isShared());

        randomAccessFile.close();

    }
}
