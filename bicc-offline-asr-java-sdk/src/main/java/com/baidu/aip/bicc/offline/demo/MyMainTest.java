package com.baidu.aip.bicc.offline.demo;

import com.baidu.aip.bicc.offline.common.beans.upload.AsrContent;
import com.baidu.aip.bicc.offline.common.beans.upload.UpLoadResponse;
import com.baidu.aip.bicc.offline.common.consts.StatusCodeCategory;
import com.baidu.aip.bicc.offline.utils.VoiceUtil;
import org.apache.log4j.Logger;
import org.json.JSONObject;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author qiudm
 * @date 2018/12/25 10:14
 * @desc
 */
public class MyMainTest {

    private static final Logger LOGGER = Logger.getLogger(MyMainTest.class);

    public static void main(String[] args)  {

        //上传
//       String agentFileUrl = "http://file.blog.codermi.cn/20170701090136362.wav";
////        String agentFileUrl = "http://file.blog.codermi.cn/12-24.mp3";
//        agentFileUrl = "http://file.blog.codermi.cn/16k.pcm";
//        upload(agentFileUrl);

//        //查询上传结果
            String callId = "5db33c3a-3279-4291-a757-9d8378d9df1a";
//            callId = "3d206563-ec2b-4003-ac56-05a68d268b3e";
        while (true) {
            callId = "4eef4446-ec27-4ef5-a6c8-4ec7bc883d9f";
            boolean isOk = getResponse(callId);
            String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
            LOGGER.info(String.format("time:%s", format));
            if (isOk) {
                break;
            }
            try {
                TimeUnit.MINUTES.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }



    private static void upload(String agentFileUrl) {
        String callId = UUID.randomUUID().toString();
        LOGGER.info(String.format("url:%s, callId:%s", agentFileUrl, callId));
        try {
             VoiceUtil.upLoadRequest(callId, agentFileUrl);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private static boolean getResponse(String callId) {
        boolean isOK = false;
        try {
            File file = new File("F://voice.txt");
//            OutputStream outputStream = new FileOutputStream(file);
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            UpLoadResponse uploadResponse = VoiceUtil.getUploadResponse(callId);
            if(uploadResponse.getStatusCode() != StatusCodeCategory.ERR_NONE) {
                return isOK;
            }
            List<AsrContent> asrContents = uploadResponse.getAsrContents();
            for(AsrContent asrContent : asrContents) {
                String sentence = asrContent.getSentence();
                bufferedWriter.write("===" + sentence + "\r\n");
//                bufferedWriter.newLine();
            }
            bufferedWriter.close();
            fileWriter.close();
            JSONObject jsonObject = new JSONObject(uploadResponse);
            isOK = true;
            LOGGER.info(String.format("response: %s", jsonObject.toString()));
        } catch (Exception e ){
            e.printStackTrace();
        }

        return isOK;
    }









}
