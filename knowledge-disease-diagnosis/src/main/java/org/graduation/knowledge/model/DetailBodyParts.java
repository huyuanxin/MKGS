package org.graduation.knowledge.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 详细部位
 *
 * @author huyuanxin
 * <p>
 * 此枚举类中定义的静态List<String>集合通过 ArrayList<>()进行包装的原因是
 * 通过Arrays.asList()创建的List不能使用remove,add/clear会抛出UnsupportedOperationException异常
 * 为了以后方便拓展，因此使用ArrayList<>()包装一下
 * </p>
 * @see <a href="https://snailclimb.gitee.io/javaguide/#/docs/java/basis/Java%E5%9F%BA%E7%A1%80%E7%9F%A5%E8%AF%86%E7%96%91%E9%9A%BE%E7%82%B9?id=_21-arraysaslist%e4%bd%bf%e7%94%a8%e6%8c%87%e5%8d%97">文档</a>
 */
public enum DetailBodyParts {

    /**
     * enum实现的单例
     */
    INSTANCE;

    public static List<String> headDetailBodyList = new ArrayList<>(
            Arrays.asList(
                    "头部", "头额颞部", "眼睛", "头颈部", "额部", "面部", "耳", "耳朵",
                    "上下牙列", "眼睑", "上颌", "鼻孔", "喉咽", "腕部", "眼窝", "头项",
                    "口", "颞后及枕部", "牙齿", "颈前", "下颌", "鼻咽部", "面",
                    "眼眶", "眼球"
            )
    );

    public static List<String> shoulderAndNeckDetailBodyList = new ArrayList<>(
            Arrays.asList(
                    "口咽部", "呼吸道", "颈肩", "颈部", "肩关节", "喉部", "喉", "声带",
                    "锁骨上", "肩胛", "肩"
            )
    );

    public static List<String> chestDetailBodyList = new ArrayList<>(
            Arrays.asList(
                    "胸部", "心脏", "眼睛和颜面等", "肺", "肋软骨交界", "乳房", "胸肌",
                    "乳晕", "乳头", "乳突", "胸大肌", "胸骨", "肋骨", "胸椎"
            )
    );

    public static List<String> abdomenDetailBodyList = new ArrayList<>(
            Arrays.asList(
                    "腹部", "躯干", "胃", "颈及躯干上部", "下腹部", "腋窝", "腹腔",
                    "盆腔", "肩甲部"
            )
    );

    public static List<String> backDetailBodyList = new ArrayList<>(
            Arrays.asList(
                    "脊柱", "躯干背部", "腰背部", "上背部", "腰", "腰椎"
            )
    );
    public static List<String> buttocksDetailBodyList = new ArrayList<>(
            Arrays.asList(
                    "肛门", "臀部", "肛周", "股臀", "股骨", "排便出口附近"
            )
    );
    public static List<String> upperLimbsDetailBodyList = new ArrayList<>(
            Arrays.asList(
                    "四肢末端", "骨关节", "关节", "手", "前臂", "肘", "四肢",
                    "手小关节", "手足暴露部位", "上肢伸侧面", "舟骨结节", "小指", "环指",
                    "拇指", "中指(其次在中)", "手指", "手背", "四肢肌", "手指关节",
                    "肘关节", "手掌"
            )
    );
    public static List<String> genitalsDetailBodyList = new ArrayList<>(
            Arrays.asList(
                    "会阴", "阴部", "外阴部", "外生殖器", "腹股沟", "外阴", "阴茎",
                    "龟头", "睾丸"
            )
    );
    public static List<String> lowerLimbsDetailBodyList = new ArrayList<>(
            Arrays.asList(
                    "双下肢", "小腿屈面", "四肢末端", "下肢", "骨关节", "足", "关节",
                    "踝", "膝", "四肢", "髌骨", "足和肌肉", "手足暴露部位", "足趾", "小腿",
                    "四肢肌", "小腿伸侧", "大腿", "膝关节"
            )
    );

    /**
     * 获得头部的详细部位
     *
     * @return 头部的详细部位
     */
    public List<String> getDetailBodyOnHead() {
        return headDetailBodyList;
    }

    /**
     * 获得肩颈部的详细部位
     *
     * @return 肩颈部的详细部位
     */
    public List<String> getDetailBodyOnShoulderAndNeck() {
        return shoulderAndNeckDetailBodyList;
    }

    /**
     * 获得胸部的详细部位
     *
     * @return 胸部的详细部位
     */
    public List<String> getDetailBodyOnChest() {
        return chestDetailBodyList;
    }

    /**
     * 获得腹部的详细部位
     *
     * @return 腹部的详细部位
     */
    public List<String> getDetailBodyOnAbdomen() {
        return abdomenDetailBodyList;
    }

    /**
     * 获得背部的详细部位
     *
     * @return 背部的详细部位
     */
    public List<String> getDetailBodyOnBack() {
        return backDetailBodyList;
    }

    /**
     * 获得臀部的详细部位
     *
     * @return 臀部的详细部位
     */
    public List<String> getDetailBodyOnButtocks() {
        return buttocksDetailBodyList;
    }

    /**
     * 获得双上肢的详细部位
     *
     * @return 双上肢的详细部位
     */
    public List<String> getDetailBodyOnUpperLimbs() {
        return upperLimbsDetailBodyList;
    }

    /**
     * 获得生殖器的详细部位
     *
     * @return 生殖器的详细部位
     */
    public List<String> getDetailBodyOnGenitals() {
        return genitalsDetailBodyList;
    }

    /**
     * 获得双下肢的详细部位
     *
     * @return 双下肢的详细部位
     */
    public List<String> getDetailBodyOnLowerLimbs() {
        return lowerLimbsDetailBodyList;
    }
}
