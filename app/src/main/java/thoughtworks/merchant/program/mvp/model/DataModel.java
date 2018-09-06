package thoughtworks.merchant.program.mvp.model;

/**
 * DataModel负责数据请求的分发,利用反射机制直接找到对应的Model,减少新建model的麻烦还可以统一管理
 * <p>
 * Created by Liao on 2018/4/28 0027.
 */

public class DataModel {
    public static BaseModel request(String token) {
        // 声明一个空的BaseModel
        BaseModel model = null;
        try {
            //利用反射机制获得对应Model对象的引用
            model = (BaseModel) Class.forName(token).newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return model;
    }
}
