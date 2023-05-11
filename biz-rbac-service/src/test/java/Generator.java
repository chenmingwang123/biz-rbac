import com.cciet.mybatis.CodeGenerator;

/**
 * 简易代码生成
 *
 * @author huanghui
 * @since 2023/5/4 09:21
 */
public class Generator {
    public static void main(String[] args) {

        String url = "jdbc:dm://127.0.0.1:15236?zeroDateTimeBehavior=convertToNull&useUnicode=true&characterEncoding=UTF-8&localTimezone=480";
        String username = "cciet";
        String password = "1qazxsw23edc";
        // 作者
        String author = "huanghui";
        // 模块名称
        String moduleName = "rbac";
        // 包名称
        String packageName = "com.cciet.biz";
        // 是否覆盖mapper false: 不覆盖  true 覆盖
        Boolean mapperFileOverride = false;
        // 表前缀
        String tablePrefix = "t_sys";
        // 生成的表列表
        String[] tables = new String[]{"T_SYS_ACCOUNT"};
        // 项目更目录
        System.setProperty("user.dir","D:\\Workspace\\Project\\services\\cciet\\cciet-bizs\\biz-rbac\\biz-rbac-service");


        CodeGenerator.builder().url(url)
                .username(username).password(password)
                .author(author).moduleName(moduleName).packageName(packageName).mapperFileOverride(mapperFileOverride)
                .tablePrefix(tablePrefix).tables(tables)
                .build().generator();

    }


}
