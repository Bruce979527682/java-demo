生成mysql文件: mvn mybatis-generator:generate
清除: mvn clean
依赖报错清理包:mvn -e -Dmaven.test.skip=true clean package -U
打包：mvn -Dmaven.test.skip=true clean package
swagger： http://localhost:8082/swagger-ui.html
