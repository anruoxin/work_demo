package cn.weicelove.util.other;

import static java.lang.String.format;

import com.alibaba.fastjson.JSON;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author QIU PANWEI Create in 2019/10/26 15:59
 */
public class ObjectSerializeUtil {

    private static final Logger log = LoggerFactory.getLogger(ObjectSerializeUtil.class);

    public static Object unSerialize(byte[] data) {
        try(ObjectInputStream objectInputStream =
                new ObjectInputStream(new ByteArrayInputStream(data))) {
            return objectInputStream.readObject();
        } catch (Exception e) {
            log.error("反序列化操作失败. ", e);
            return null;
        }

    }


    public static byte[] serialize(Object object) {
        if (!(object instanceof Serializable)) {
            log.error("当前实体类未继承序列化接口 Object: {}", JSON.toJSONString(object));
            throw new UnsupportedOperationException("该实体类未继承序列化接口");
        }
        ByteArrayOutputStream byteArrayOutputStream = null;
        try(ObjectOutputStream oss = new ObjectOutputStream(byteArrayOutputStream = new ByteArrayOutputStream())) {
            oss.writeObject(object);
            byte[] bytes = byteArrayOutputStream.toByteArray();
            return bytes;
        } catch (Exception e) {
            log.error("序列化操作失败. ", e);
            return null;
        }
    }

}
