package com.mhx.xmindapidemo.test;

import org.xmind.core.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * A demo of XMind API
 *
 * @author MHX
 * @date 2018/10/30
 * @link https://github.com/xmindltd/xmind
 */
public class XMindTest {
    private static final String path1 = "F:\\old.xmind";
    private static final String path2 = "F:\\new.xmind";

    public static void main(String[] args) throws Exception {
        // get workbook builder
        IWorkbookBuilder builder = Core.getWorkbookBuilder();

        // get IDeserializer
        IDeserializer deserializer = builder.newDeserializer();
        deserializer.setInputStream(new FileInputStream(path1));

        // deserialize
        deserializer.deserialize(null);

        // get workbook
        IWorkbook workbook = deserializer.getWorkbook();

        // get ISerializer
        ISerializer serializer = builder.newSerializer();
        serializer.setOutputStream(new FileOutputStream(path2));
        serializer.setWorkbook(workbook);

        // get primary sheet
        ISheet primarySheet = workbook.getPrimarySheet();

        // get root topic
        ITopic rootTopic = primarySheet.getRootTopic();

        // read root topic
        System.out.println(rootTopic.getTitleText());

        // modify root topic
        rootTopic.setTitleText("new topic title");

        // serialize
        serializer.serialize(null);
    }
}
