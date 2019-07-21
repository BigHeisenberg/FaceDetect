package utils;


import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pojo.FaceV3DetectBean;

import java.util.HashMap;
import java.util.Map;

/**
 * 人脸检测与属性分析
 */
public class FaceDetectUtils {
    private static Logger LOG = LoggerFactory.getLogger(FaceDetectUtils.class);

    public static String detect(String image_type,String image) {
        // 请求url
        String url = GetProperties.BAIDU_FACEAPI_FACEDETECTURL;//百度人脸识别API请求URL
        try {
            Map<String, Object> map = new HashMap<>();
            map.put("image_type",image_type);//图片类型
            map.put("image",image);//图片地址
            map.put("max_face_num",10);//最多处理人脸的数目，默认值为1，仅检测图片中面积最大的那个人脸；最大值10，检测图片中面积最大的几张人脸。
            map.put("face_field", "age,beauty,expression,face_shape,gender,glasses,landmark,landmark150,race,quality,eye_status,emotion,face_type");//返回参数
            map.put("face_type","LIVE");//人脸类型为生活照
            String param = JSON.toJSONString(map);

            // 可以为了简化编码每一次请求都去获取access_token，线上环境access_token有过期时间， 客户端可自行缓存，过期后重新获取。
            String accessToken = AuthServiceUtils.getAuth();//获取access_token
            String result = BaiduHttpUtils.post(url, accessToken, "application/json", param);
            LOG.info("\n" + result);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public static void ScoreResult(String image_type,String image){
        String result = detect(image_type,image);
        JSON json = JSON.parseObject(result);
        FaceV3DetectBean bean = JSON.toJavaObject(json, FaceV3DetectBean.class);
        if (bean.getError_code()==0 && bean.getError_msg().equals("SUCCESS")) {
            LOG.info("照片中人脸数量：" + bean.getResult().getFace_num()+"\n");
            for (int i = 0; i < bean.getResult().getFace_list().size(); i++) {
                int j =i+1;
                LOG.info("照片中第"+ j +"位人脸测评开始：-----------------" );
                // 获取年龄
                LOG.info("年龄：" + bean.getResult().getFace_list().get(i).getAge());
                // 获取性别 male(男)、female(女)
                String sex = bean.getResult().getFace_list().get(i).getGender().getType();
                if (sex.equals("male")) {
                    LOG.info("性别：男");
                } else if (sex.equals("female")) {
                    LOG.info("性别：女");
                }
                // 获取美丑打分
                double beauty = bean.getResult().getFace_list().get(i).getBeauty();
                LOG.info("颜值评分：" + beauty);
                if (beauty>70 && beauty<80 && sex.equals("female")){
                    LOG.info("颜值评语：校花、模特、网红级别，脸小会打扮，就连皮肤身材也是极好的，应该是很多男生暗恋搭讪的对象");
                }else if (beauty>80 && beauty<90 && sex.equals("female")){
                    LOG.info("颜值评语：形象，颜值，身材气场都特别突出，自带气场！体态优雅！有形象方面的荣誉加持。追求者实力雄厚，上市公司二代，豪门贵族等富二代等。从小到大，执着的追求者不低于百人。");
                }else if (beauty>90 && beauty<95 && sex.equals("female")){
                    LOG.info("颜值评语：五官精致，肤若凝脂！合照杀手，360度毫无死角！脸头比例完美！国民级别女神！");
                }else if (beauty>95 && beauty<100 && sex.equals("female")){
                    LOG.info("颜值评语：每个人心中的十分女完美标准都不一样，但一定是拯救了全宇宙永远青春的仙女！才有机会成为这四海八荒，三生三世最完美的女神！");
                }

                // 获取是否带眼镜: none-无眼镜，common-普通眼镜，sun-墨镜
                String glasses = bean.getResult().getFace_list().get(i).getGlasses().getType();
                if (glasses.equals("none")) {
                    LOG.info("是否佩戴眼镜：否");
                } else if (glasses.equals("common")) {
                    LOG.info("是否佩戴眼镜：是，佩戴普通眼镜");
                } else if (glasses.equals("sun")) {
                    LOG.info("是否佩戴眼镜：是，佩戴墨镜");
                }
                // 获取是否微笑: none-不笑，smile-微笑，laugh-大笑
                String expression = bean.getResult().getFace_list().get(i).getExpression().getType();
                if (expression.equals("none")) {
                    LOG.info("面部表情：普通");
                } else if (expression.equals("smile")) {
                    LOG.info("面部表情：微笑");
                } else if (expression.equals("laugh")) {
                    LOG.info("面部表情：大笑");
                }
                // 获取脸型: square-正方形，triangle-三角形，oval-椭圆，heart-心形，round-圆形
                String face_shape = bean.getResult().getFace_list().get(i).getFace_shape().getType();
                if (face_shape.equals("square")) {
                    LOG.info("脸型：正方形");
                } else if (face_shape.equals("triangle")) {
                    LOG.info("脸型：三角形");
                } else if (face_shape.equals("oval")) {
                    LOG.info("脸型：椭圆");
                } else if (face_shape.equals("heart")) {
                    LOG.info("脸型：心形");
                } else if (face_shape.equals("round")) {
                    LOG.info("脸型：圆形");
                }
                // 获取情绪: angry-愤怒，disgust-厌恶，fear-恐惧，happy-高兴，sad-伤心，surprise-惊讶，neutral-无情绪
                String emotion = bean.getResult().getFace_list().get(i).getEmotion().getType();
                if (emotion.equals("angry")) {
                    LOG.info("情绪：愤怒");
                } else if (emotion.equals("disgust")) {
                    LOG.info("情绪：厌恶");
                } else if (emotion.equals("fear")) {
                    LOG.info("情绪：恐惧");
                } else if (emotion.equals("happy")) {
                    LOG.info("情绪：高兴");
                } else if (emotion.equals("sad")) {
                    LOG.info("情绪：伤心");
                } else if (emotion.equals("surprise")) {
                    LOG.info("情绪：惊讶");
                } else if (emotion.equals("neutral")) {
                    LOG.info("情绪：无情绪");
                }
                // 获取人脸类型: human-真实人脸，cartoon-卡通人脸
                String face_type = bean.getResult().getFace_list().get(i).getFace_type().getType();
                if (face_type.equals("human")) {
                    LOG.info("人脸类型：真实人脸");
                } else if (face_type.equals("cartoon")) {
                    LOG.info("人脸类型：卡通人脸");
                }
                // 获取人种类别: yellow-黄种人，white-白种人，black-黑种人，arabs-阿拉伯人
                String race = bean.getResult().getFace_list().get(i).getRace().getType();
                if (race.equals("yellow")) {
                    LOG.info("人种类别：黄种人");
                } else if (race.equals("white")) {
                    LOG.info("人种类别：白种人");
                } else if (race.equals("black")) {
                    LOG.info("人种类别：黑种人");
                } else if (race.equals("arabs")) {
                    LOG.info("人种类别：阿拉伯人");
                }
                LOG.info("照片中第"+ j +"位人脸测评结束：-----------------\n" );
            }
        }else if (bean.getError_msg().equals("pic not has face") && bean.getResult() == null) {
                LOG.info("该图片不是有效的人脸图片，请重新选择！");
        }else {
            LOG.info("参数有误，请重新选择！");
        }
    }

}