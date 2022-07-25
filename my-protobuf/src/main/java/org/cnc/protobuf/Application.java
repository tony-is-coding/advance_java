package org.cnc.protobuf;

import com.google.protobuf.InvalidProtocolBufferException;
import org.cnc.protobuf.protos.UserProto;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * <p>
 * #TODO: desc
 * </p>
 *
 * @author zhiyong.tan
 * @since 2022-07-25
 */
public class Application {
    public static class MyUser implements Serializable {
        private static final long serialVersionUID = 1L;

        private final Integer id;
        private final String code;
        private final String name;

        public MyUser(Integer id, String code, String name) {
            this.id = id;
            this.code = code;
            this.name = name;
        }
    }


    @Test
    public void testProtoBufCodec() {
        UserProto.User user = UserProto.User.newBuilder()
                .setId(10086)
                .setCode("2022")
                .setName("tony")
                .build();
        byte[] b = user.toByteArray();
        System.out.println("序列化后字节大小: " + b.length);

        try {
            user = UserProto.User.parseFrom(b);
            System.out.println(user);
        } catch (InvalidProtocolBufferException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testJdkCodec() {
        MyUser user = new MyUser(10086, "2022", "tony");
        try (ByteArrayOutputStream os = new ByteArrayOutputStream(); ObjectOutputStream out = new ObjectOutputStream(os)) {
            out.writeObject(user);
            out.flush();
            byte[] b = os.toByteArray();
            System.out.println("序列化后字节大小: " + b.length);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
