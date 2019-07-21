package pojo;

import java.util.List;

/**
 * @description:
 * @program: javatopcn
 * @return: $
 * @Param: $
 * @Author: Heisenberg
 * @create: 2019-07-21 22:50
 */
public class FaceV3DetectBean {
    private int error_code;
    private String error_msg;
    private long log_id;
    private long timestamp;
    private int cached;
    private Result result;

    /**
     * Result
     */
    public static class Result {
        private int face_num;
        private List<Face_list> face_list;
        public void setFace_num(int face_num) {
            this.face_num = face_num;
        }
        public int getFace_num() {
            return face_num;
        }

        public void setFace_list(List<Face_list> face_list) {
            this.face_list = face_list;
        }
        public List<Face_list> getFace_list() {
            return face_list;
        }
    }

    /**
     * Face_list
     */
    public static class Face_list {
        private String face_token;
        private Location location;
        private int face_probability;
        private Angle angle;
        private int age;
        private double beauty;
        private Expression expression;
        private Face_shape face_shape;
        private Gender gender;
        private Glasses glasses;
        private List<Landmark> landmark;
        private List<Landmark72> landmark72;
        private Race race;
        private Emotion emotion;
        private Face_type face_type;

        public void setFace_token(String face_token) {
            this.face_token = face_token;
        }
        public String getFace_token() {
            return face_token;
        }

        public void setLocation(Location location) {
            this.location = location;
        }
        public Location getLocation() {
            return location;
        }

        public void setFace_probability(int face_probability) {
            this.face_probability = face_probability;
        }
        public int getFace_probability() {
            return face_probability;
        }

        public void setAngle(Angle angle) {
            this.angle = angle;
        }
        public Angle getAngle() {
            return angle;
        }

        public void setAge(int age) {
            this.age = age;
        }
        public int getAge() {
            return age;
        }

        public void setBeauty(double beauty) {
            this.beauty = beauty;
        }
        public double getBeauty() {
            return beauty;
        }

        public void setExpression(Expression expression) {
            this.expression = expression;
        }
        public Expression getExpression() {
            return expression;
        }

        public void setFace_shape(Face_shape face_shape) {
            this.face_shape = face_shape;
        }
        public Face_shape getFace_shape() {
            return face_shape;
        }

        public void setGender(Gender gender) {
            this.gender = gender;
        }
        public Gender getGender() {
            return gender;
        }

        public void setGlasses(Glasses glasses) {
            this.glasses = glasses;
        }
        public Glasses getGlasses() {
            return glasses;
        }

        public void setLandmark(List<Landmark> landmark) {
            this.landmark = landmark;
        }
        public List<Landmark> getLandmark() {
            return landmark;
        }

        public void setLandmark72(List<Landmark72> landmark72) {
            this.landmark72 = landmark72;
        }
        public List<Landmark72> getLandmark72() {
            return landmark72;
        }

        public void setRace(Race race) {
            this.race = race;
        }
        public Race getRace() {
            return race;
        }

        public Emotion getEmotion() { return emotion; }
        public void setEmotion(Emotion emotion) { this.emotion = emotion; }

        public Face_type getFace_type() { return face_type; }
        public void setFace_type(Face_type face_type) { this.face_type = face_type; }
    }

    /**
     * Rece
     */
    public static class Race{
        private String type;
        private double probability;

        public void setType(String type) {
            this.type = type;
        }
        public String getType() {
            return type;
        }

        public void setProbability(double probability) {
            this.probability = probability;
        }
        public double getProbability() {
            return probability;
        }
    }

    /**
     * Landmark72
     */
    public static class Landmark72{
        private double x;
        private double y;
        public void setX(double x) {
            this.x = x;
        }
        public double getX() {
            return x;
        }

        public void setY(double y) {
            this.y = y;
        }
        public double getY() {
            return y;
        }
    }

    /**
     * Landmark
     */
    public static class Landmark {
        private double x;
        private double y;
        public void setX(double x) {
            this.x = x;
        }
        public double getX() {
            return x;
        }

        public void setY(double y) {
            this.y = y;
        }
        public double getY() {
            return y;
        }
    }

    /**
     * Glasses
     */
    public static class Glasses {
        private String type;
        private double probability;
        public void setType(String type) {
            this.type = type;
        }
        public String getType() {
            return type;
        }
        public void setProbability(double probability) {
            this.probability = probability;
        }
        public double getProbability() {
            return probability;
        }
    }

    /**
     * Gender
     */
    public static class Gender {
        private String type;
        private double probability;
        public void setType(String type) {
            this.type = type;
        }
        public String getType() {
            return type;
        }
        public void setProbability(double probability) {
            this.probability = probability;
        }
        public double getProbability() {
            return probability;
        }
    }


    /**
     * Face_shape
     */
    public static class Face_shape {
        private String type;
        private double probability;
        public void setType(String type) {
            this.type = type;
        }
        public String getType() {
            return type;
        }

        public void setProbability(double probability) {
            this.probability = probability;
        }
        public double getProbability() {
            return probability;
        }
    }

    /**
     * Expression
     */
    public static class Expression {
        private String type;
        private double probability;
        public void setType(String type) {
            this.type = type;
        }
        public String getType() {
            return type;
        }
        public void setProbability(double probability) {
            this.probability = probability;
        }
        public double getProbability() {
            return probability;
        }
    }

    /**
     * Angle
     */
    public static class Angle {
        private double yaw;
        private double pitch;
        private double roll;
        public void setYaw(double yaw) {
            this.yaw = yaw;
        }
        public double getYaw() {
            return yaw;
        }

        public void setPitch(double pitch) {
            this.pitch = pitch;
        }
        public double getPitch() {
            return pitch;
        }

        public void setRoll(double roll) {
            this.roll = roll;
        }
        public double getRoll() {
            return roll;
        }
    }

    /**
     * Location
     */
    public static class Location {
        private double left;
        private double top;
        private int width;
        private int height;
        private int rotation;
        public void setLeft(double left) {
            this.left = left;
        }
        public double getLeft() {
            return left;
        }

        public void setTop(double top) {
            this.top = top;
        }
        public double getTop() {
            return top;
        }

        public void setWidth(int width) {
            this.width = width;
        }
        public int getWidth() {
            return width;
        }

        public void setHeight(int height) {
            this.height = height;
        }
        public int getHeight() {
            return height;
        }

        public void setRotation(int rotation) {
            this.rotation = rotation;
        }
        public int getRotation() {
            return rotation;
        }
    }

    /**
     * Emotion
     */
    public static class Emotion {
        private String type;
        private double probability;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public double getProbability() {
            return probability;
        }

        public void setProbability(double probability) {
            this.probability = probability;
        }
    }

    /**
     * Face_type
     */
    public static class Face_type {
        private String type;
        private double probability;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public double getProbability() {
            return probability;
        }

        public void setProbability(double probability) {
            this.probability = probability;
        }
    }

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public String getError_msg() {
        return error_msg;
    }

    public void setError_msg(String error_msg) {
        this.error_msg = error_msg;
    }

    public long getLog_id() {
        return log_id;
    }

    public void setLog_id(long log_id) {
        this.log_id = log_id;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public int getCached() {
        return cached;
    }

    public void setCached(int cached) {
        this.cached = cached;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }
}