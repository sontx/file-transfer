package com.blogspot.sontx.tut.filetransfer.bean;

import java.io.File;

/**
 * Copyright 2016 by sontx
 * Created by sontx on 8/5/2016.
 */
public class FileHeader {
    private String who;
    private String fileName;
    private long fileLength;

    public FileHeader() {}

    public FileHeader(File file, String who) {
        this.who = who;
        this.fileName = file.getName();
        this.fileLength = file.length();
    }

    public String getWho() {
        return who;
    }

    public void setWho(String who) {
        this.who = who;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public long getFileLength() {
        return fileLength;
    }

    public void setFileLength(long fileLength) {
        this.fileLength = fileLength;
    }

    public byte[] getBytes() {
        String extra = String.format("%s|%s|%d", who, fileName, fileLength);
        return extra.getBytes();
    }

    public static FileHeader parse(byte[] extra) {
        String rawString = new String(extra);
        String[] parts = rawString.split("|");
        FileHeader fileHeader = new FileHeader();
        fileHeader.who = parts[0];
        fileHeader.fileName = parts[1];
        fileHeader.fileLength = Long.parseLong(parts[2]);
        return fileHeader;
    }
}
