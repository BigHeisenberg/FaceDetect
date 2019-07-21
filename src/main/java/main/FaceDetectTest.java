package main;

import utils.FaceDetectUtils;

/**
 * @description:
 * @program: FaceDetect
 * @return: $
 * @Param: $
 * @Author: Heisenberg
 * @create: 2019-07-22 01:43
 */
public class FaceDetectTest {
    public static void main(String[] args) {
        FaceDetectUtils.ScoreResult("URL","https://p1.pstatp.com/large/28fa60009610b3bcd3d54.jpg");//调用网络图片：图片URL地址,图片类型为URL地址
//        FaceDetectUtils.ScoreResult("BASE64",Base64ImageUtils.GetImageStrFromPath("D:/Development/Study/DouYinFace/img/1.jpg"));//调用本地图片

    }
}
