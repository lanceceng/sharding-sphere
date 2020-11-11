package com.example.shardingSphere;

import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.ArrayList;
import java.util.List;

/**
 * cat 自动生成代码
 */
public class CodeGenerator {


    public static void main(String[] args) {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        gc.setOutputDir(projectPath + "/src/main/java");
        gc.setAuthor("cat");
        gc.setOpen(false);
        // gc.setSwagger2(true); 实体属性 Swagger2 注解

        gc.setBaseColumnList(true);				//开启 baseColumnList 默认false
        gc.setBaseResultMap(true);				//开启 BaseResultMap 默认false
        gc.setEntityName("%sEntity");			//实体命名方式  默认值：null 例如：%sEntity 生成 UserEntity
//        gc.setEntityName("%s");
//        gc.setMapperName("%sMapper");			//mapper 命名方式 默认值：null 例如：%sDao 生成 UserDao
        gc.setMapperName("%sDao");
        gc.setXmlName("%sMapper");				//Mapper xml 命名方式   默认值：null 例如：%sDao 生成 UserDao.xml
        gc.setServiceName("%sService");			//service 命名方式   默认值：null 例如：%sBusiness 生成 UserBusiness
        gc.setServiceImplName("%sServiceImpl");	//service impl 命名方式  默认值：null 例如：%sBusinessImpl 生成 UserBusinessImpl
        gc.setControllerName("%sController");

        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://localhost:3306/ds0?useUnicode=true&useSSL=false&characterEncoding=utf8&serverTimezone=UTC");
        // dsc.setSchemaName("public");
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("root");
        mpg.setDataSource(dsc);

        List<String> list = new ArrayList<>();
        list.add("sys_user");
//        list.add("role");
        for(String tablename:list){

            // 包配置
            PackageConfig pc = new PackageConfig();
            pc.setModuleName("modules");
            pc.setParent("com.cat.admin");
            mpg.setPackageInfo(pc);

            // 自定义配置
            InjectionConfig cfg = new InjectionConfig() {
                @Override
                public void initMap() {
                    // to do nothing
                    /*Map<String, Object> map = new HashMap<>();
                    map.put("abc", this.getConfig().getGlobalConfig().getAuthor() + "-mp");
                    this.setMap(map);*/
                }
            };

            // 如果模板引擎是 freemarker
            String templatePath = "/templates/mapper.xml.ftl";
            // 如果模板引擎是 velocity
            // String templatePath = "/templates/mapper.xml.vm";

            // 自定义输出配置
            List<FileOutConfig> focList = new ArrayList<>();
            // 自定义配置会被优先输出
            focList.add(new FileOutConfig(templatePath) {
                @Override
                public String outputFile(TableInfo tableInfo) {
                    // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                    return projectPath + "/src/main/resources/mapper/" /*+ pc.getModuleName()*/
                            + "/" + tableInfo.getEntityName().replaceAll("Entity", "") + "Mapper" + StringPool.DOT_XML;
                }
            });

            cfg.setFileOutConfigList(focList);
            mpg.setCfg(cfg);

            // 配置模板
            TemplateConfig templateConfig = new TemplateConfig();

            // 配置自定义输出模板
            //指定自定义模板路径，注意不要带上.ftl/.vm, 会根据使用的模板引擎自动识别
            // templateConfig.setEntity("templates/entity2.java");
            // templateConfig.setService();
            // templateConfig.setController();

            templateConfig.setXml(null);
            mpg.setTemplate(templateConfig);


            // 策略配置
            StrategyConfig strategy = new StrategyConfig();
            strategy.setNaming(NamingStrategy.underline_to_camel);
            strategy.setColumnNaming(NamingStrategy.underline_to_camel);

//            strategy.setSuperEntityClass("com.tt.springboot_redis.common.BaseEntity");

            strategy.setEntityLombokModel(true);
            strategy.setRestControllerStyle(true);

//            strategy.setSuperControllerClass("com.tt.springboot_redis.common.BaseController");
//            strategy.setInclude(tablename);
//            strategy.setSuperEntityColumns("id");
            strategy.setControllerMappingHyphenStyle(true);
            strategy.setTablePrefix(pc.getModuleName() + "_");
            mpg.setStrategy(strategy);
            mpg.setTemplateEngine(new FreemarkerTemplateEngine());
            mpg.execute();
        }
    }
}
