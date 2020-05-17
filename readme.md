1.搭建maven工程，创建父项目和子moudle (common/dao/service)
2.在common项目中
    a.新增统一返回值 
    b.全局异常处理 @RestControllerAdvice
    c.参数校验处理 validator
    d.引入lombok类
         <!--lombok的jar包-->
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <optional>true</optional>
        </dependency>
 