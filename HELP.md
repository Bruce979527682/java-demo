生成mysql文件: mvn mybatis-generator:generate
清除: mvn clean
依赖报错清理包:mvn -e -Dmaven.test.skip=true clean package -U
打包：mvn -Dmaven.test.skip=true clean package
swagger： http://localhost:8082/swagger-ui.html


CREATE TABLE `account`  (
  `Id` int(0) NOT NULL AUTO_INCREMENT COMMENT '序号',
  `PlatformId` int(0) NULL DEFAULT NULL COMMENT '平台ID',
  `UserId` int(0) NULL DEFAULT NULL COMMENT '用户ID',
  `UserName` varchar(120) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '用户名',
  `PassWord` varchar(120) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '密码',
  `RoleType` int(0) NULL DEFAULT NULL COMMENT '角色类型',
  `AddTime` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `LastLoginTime` datetime(0) NULL DEFAULT NULL COMMENT '最后登录时间',
  `Status` int(0) NULL DEFAULT NULL COMMENT '状态(-4:删除 0:禁用 1:正常)',
  PRIMARY KEY (`Id`) USING BTREE,
  UNIQUE INDEX `Key_Unique`(`UserId`, `RoleType`, `Status`) USING BTREE,
  INDEX `Key_UserId`(`UserId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;






