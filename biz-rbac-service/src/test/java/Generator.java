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
        String[] tables = new String[]{"t_sys_role","t_sys_res","t_sys_role_res","t_sys_account_role","t_sys_account_role"};

        // 项目根目录
        String rootPath = "D:/javaCode/biz-rbac";
        // API工程名称
        String apiProject = "biz-rbac-api";
        // 服务实现工程名称
        String serviceProject = "biz-rbac-service";
        CodeGenerator.builder().url(url)
                .username(username).password(password)
                .rootPath(rootPath).apiProject(apiProject).serviceProject(serviceProject)
                .author(author).moduleName(moduleName).packageName(packageName).mapperFileOverride(mapperFileOverride)
                .tablePrefix(tablePrefix).tables(tables)
                .build().generator();

    }


}
