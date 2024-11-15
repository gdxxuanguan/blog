package com.blog.generator;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import org.apache.commons.lang3.StringUtils;

import java.util.Scanner;

public class CodeGenerator {

    // 数据库配置信息
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/blog?useUnicode=true&characterEncoding=UTF-8&useSSL=false&serverTimezone=UTC";
    private static final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "123456";

    // 全局配置
    private static final String AUTHOR = "zhb"; // 作者
    private static final String BASE_PACKAGE = "com.blog"; // 项目的基础包名

    public static void main(String[] args) {
        // 代码生成器
        AutoGenerator generator = new AutoGenerator();

        // 全局配置
        GlobalConfig globalConfig = new GlobalConfig();
        globalConfig.setOutputDir(System.getProperty("user.dir") + "/src/main/java"); // 生成文件的输出目录
        globalConfig.setAuthor(AUTHOR); // 作者
        globalConfig.setOpen(false); // 生成完是否打开目录
        globalConfig.setFileOverride(true); // 是否覆盖已有文件
        globalConfig.setServiceName("%sService"); // 去掉Service接口的前缀
        generator.setGlobalConfig(globalConfig);

        // 数据源配置
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setUrl(URL);
        dataSourceConfig.setDriverName(DRIVER_NAME);
        dataSourceConfig.setUsername(USERNAME);
        dataSourceConfig.setPassword(PASSWORD);
        dataSourceConfig.setDbType(DbType.MYSQL);
        generator.setDataSource(dataSourceConfig);

        // 包配置
        PackageConfig packageConfig = new PackageConfig();
        packageConfig.setParent(BASE_PACKAGE); // 基础包名
        packageConfig.setEntity("entity");
        packageConfig.setMapper("mapper");
        packageConfig.setService("service");
        packageConfig.setServiceImpl("service.impl");
        packageConfig.setController("controller");
        generator.setPackageInfo(packageConfig);

        // 策略配置
        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig.setNaming(NamingStrategy.underline_to_camel); // 数据库表映射到实体的命名策略
        strategyConfig.setColumnNaming(NamingStrategy.underline_to_camel); // 数据库表字段映射到实体的命名策略
        strategyConfig.setEntityLombokModel(true); // 是否使用lombok
        strategyConfig.setRestControllerStyle(true); // 生成 @RestController 控制器
        strategyConfig.setInclude(getAllTableNames()); // 生成所有表的代码
        strategyConfig.setControllerMappingHyphenStyle(true); // URL中驼峰转连字符
        generator.setStrategy(strategyConfig);

        // 模板引擎配置
        generator.setTemplateEngine(new FreemarkerTemplateEngine());
        generator.execute();
    }

    /**
     * 读取控制台内容
     */
    public static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入" + tip + "：");
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StringUtils.isNotEmpty(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }

    /**
     * 获取所有表名
     * @return 所有表名的数组
     */
    private static String[] getAllTableNames() {
        // 如果你想选择性地输入特定表名可以使用 scanner("表名")；
        // 否则，可以直接返回 null 表示生成所有表。
        // return new String[] { "table1", "table2" }; // 指定表名
        return null; // 生成数据库中的所有表
    }
}
