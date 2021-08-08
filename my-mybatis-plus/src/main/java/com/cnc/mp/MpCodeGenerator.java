package com.cnc.mp;

import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.config.*;

import java.util.Scanner;

public class MpCodeGenerator {
    /**
     * <p>
     * 读取控制台内容
     * </p>
     */
    public static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder help = new StringBuilder();
        help.append("请输入").append(tip).append("：");
        System.out.println(help.toString());
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StringUtils.isNotBlank(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }

    /**
     * RUN THIS
     */
    public static void main(String[] args) {
        // 代码生成器

        // 全局配置
        String projectPath = System.getProperty("user.dir");

        GlobalConfig gc = new GlobalConfig.Builder()
                .outputDir(projectPath + "/mybatis-plus-sample-generator/src/main/java")
                .openDir(true)
                .author("tony-tan")
                .build();


        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig.Builder(
                "jdbc:mysql://localhost:3306/ant?useUnicode=true&serverTimezone=GMT&useSSL=false&characterEncoding=utf8",
                "root",
                "1q2w3e4r"

        ).build();

        // 包配置
        PackageConfig pc = new PackageConfig
                .Builder()
                .moduleName(scanner("模块名"))
                .parent("com.cnc.mp")
                .build();

        // 自定义配置
        InjectionConfig cfg = new InjectionConfig();


    }
}
