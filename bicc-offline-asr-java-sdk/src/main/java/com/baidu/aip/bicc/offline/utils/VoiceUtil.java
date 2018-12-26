package com.baidu.aip.bicc.offline.utils;

import com.baidu.aip.bicc.offline.asr.BICCAsrUploadClient;
import com.baidu.aip.bicc.offline.common.beans.upload.UpLoadRequest;
import com.baidu.aip.bicc.offline.common.beans.upload.UpLoadResponse;
import org.apache.log4j.Logger;

/**
 * @author qiudm
 * @date 2018/12/25 10:04
 * @desc
 */
public class VoiceUtil {

    private static final Logger LOGGER = Logger.getLogger(VoiceUtil.class);

    /**
     * 百度云->人工智能->智能呼叫中心,申请的应用appId,必填
     */
    private static final String appId = "15260718";

    /**
     * 百度云->人工智能->智能呼叫中心,申请的应用apiKey,必填
     */
    private static final String apiKey = "ALQ12Bck9dAPolZU3xbucoru";

    /**
     * 百度云->人工智能->智能呼叫中心,申请的应用secretKey,必填
     */
    private static final String secretKey = "c3UDpg35xwvm1FGp6M9bf4CS3Z0hnQ9j";

    /**
     * 公司名称
     */
    private static final String companyName = "百度";

    /**
     * 文件流格式,pcm或wav二选一,必填
     * 支持8000HZ采样率,16bits位深,非压缩pcm或wav流
     */
    private static final String suffix = "pcm";//wav


    /**
     * 客户侧录音可公网下载的URL地址,http或https,建议使用http,非必填
     * 支持8000HZ采样率,16bits位深,非压缩pcm或wav流
     */
    private static final String clientFileUrl = null;

    /**
     * 识别结果回调地址,请保证地址可被公网访问,http或https,建议使用http,非必填
     */
    private static final String callbackUrl = null;


    private static BICCAsrUploadClient getBICCAsrUploadClient() {
        return new BICCAsrUploadClient(appId, apiKey, secretKey);
    }


    /**
     * 上传录音文件
     * @param callId
     * @param agentFileUrl
     * @return
     * @throws Exception
     */
    public static UpLoadResponse upLoadRequest(String callId, String agentFileUrl) throws Exception {
        UpLoadRequest upLoadRequest = new UpLoadRequest(callId, companyName, agentFileUrl,
                clientFileUrl, suffix, callbackUrl);

        UpLoadResponse upLoadResponse = getBICCAsrUploadClient().asr(upLoadRequest);
        LOGGER.debug(String.format("upLoadResponse:[%s]", upLoadResponse));
        return upLoadResponse;
    }


    /**
     * 获取上传的结果
     * @param callId
     * @return
     * @throws Exception
     */
    public static UpLoadResponse getUploadResponse(String callId) throws Exception {
        UpLoadResponse searchResponse = getBICCAsrUploadClient().search(callId);
        return searchResponse;
    }









}
