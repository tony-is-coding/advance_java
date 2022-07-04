package org.cnc.protobuf.protos;


import org.junit.Test;

/**
 * org.cnc.protobuf.protos - UserProtoTest
 *
 * @author tony-is-coding
 * @date 2022/6/28 10:35
 */
public class UserProtoTest {

    @Test
    public void testUserSerialize() {
        UserProto.User.Builder builder = UserProto.User.newBuilder();
        UserProto.User user = builder.setId(10010)
                .setCode("10010")
                .setName("tony")
                .setNickName(
                        UserProto.NickName.newBuilder()
                                .setNickName("tony")
                                .build())
                .build();
        System.out.println(user);


    }

}