package utils;

import java.io.IOException;
import java.io.Serializable;
import java.util.Properties;

public class GetProperties implements Serializable {
    public static String BAIDU_FACEAPI_APPKEY="";//百度人脸识别APIKEY
    public static String BAIDU_FACEAPI_SECREKEY="";   //百度人脸识别APISecretKey
    public static String BAIDU_FACEAPI_FACEDETECTURL="";//百度人脸识别API请求URL
    public static String BAIDU_FACEAPI_ACCESSTOKENURL="";  //百度人脸识别AccessToken请求Url

    static {
        try {
            Properties props = new Properties();
            props.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("config.properties"));
            BAIDU_FACEAPI_APPKEY = props.getProperty("BAIDU_FACEAPI_APPKEY");
            BAIDU_FACEAPI_SECREKEY = props.getProperty("BAIDU_FACEAPI_SECREKEY");
            BAIDU_FACEAPI_FACEDETECTURL = props.getProperty("BAIDU_FACEAPI_FACEDETECTURL");
            BAIDU_FACEAPI_ACCESSTOKENURL = props.getProperty("BAIDU_FACEAPI_ACCESSTOKENURL");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
