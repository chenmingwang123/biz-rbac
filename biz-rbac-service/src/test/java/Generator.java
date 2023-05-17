import com.cciet.mybatis.CodeGenerator;

/**
 * 简易代码生成
 *
 * @author huanghui
 * @since 2023/5/4 09:21
 */
public class Generator {
    public static void main(String[] args) {

        String url = "jdbc:mysql://127.0.0.1:3306/rbac?characterEncoding=utf-8&useSSL=false&serverTimezone=UTC";
        String username = "root";
        String password = "123";
        // 作者
        String author = "cmw";
        // 模块名称
        String moduleName = "rbac";
        // 包名称
        String packageName = "com.cciet.biz";
        // 是否覆盖mapper false: 不覆盖  true 覆盖
        Boolean mapperFileOverride = false;
        // 表前缀
        String tablePrefix = "t_sys";
        // 生成的表列表
        String[] tables = new String[]{"t_sys_account"};
        // 项目更目录
        System.setProperty("user.dir","D:\\javaCode\\biz-rbac\\biz-rbac-service");

        CodeGenerator.builder().url(url)
                .username(username).password(password)
                .author(author).moduleName(moduleName).packageName(packageName).mapperFileOverride(mapperFileOverride)
                .tablePrefix(tablePrefix).tables(tables)
                .build().generator();

    }


}
