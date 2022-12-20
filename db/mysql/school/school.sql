-- --------------------------------------------------------
-- 主机:                           192.168.1.6
-- 服务器版本:                        8.0.31 - MySQL Community Server - GPL
-- 服务器操作系统:                      Linux
-- HeidiSQL 版本:                  12.1.0.6537
-- --------------------------------------------------------

-- 导出  表 maku_boot.edu_clazz 结构
DROP TABLE IF EXISTS `edu_clazz`;
CREATE TABLE IF NOT EXISTS `edu_clazz`
(
    `id`            bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
    `name`          varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '行政班级',
    `entrance_year` smallint                                                     DEFAULT NULL COMMENT '入学年',
    `grade_id`      bigint                                                       DEFAULT NULL COMMENT '年级id',
    `semester_id`   bigint                                                       DEFAULT NULL COMMENT '学期id',
    `headmaster_id` bigint                                                       DEFAULT NULL COMMENT '班主任id',
    `headmaster`    varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '班主任',
    `is_enabled`    tinyint                                                      DEFAULT NULL COMMENT '是否启用',
    `deleted`       tinyint                                                      DEFAULT NULL COMMENT '是否删除',
    `version`       tinyint                                                      DEFAULT NULL COMMENT '乐观锁',
    `creator`       bigint                                                       DEFAULT NULL COMMENT '创建人',
    `create_time`   datetime                                                     DEFAULT NULL COMMENT '创建时间',
    `updater`       bigint                                                       DEFAULT NULL COMMENT '更新人',
    `update_time`   datetime                                                     DEFAULT NULL COMMENT '更新时间',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 6
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci COMMENT ='班级信息表';

-- 数据导出被取消选择。

-- 导出  表 maku_boot.edu_course 结构
DROP TABLE IF EXISTS `edu_course`;
CREATE TABLE IF NOT EXISTS `edu_course`
(
    `id`          bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
    `name`        varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '课程名称',
    `is_enabled`  tinyint                                                      DEFAULT NULL COMMENT '是否启用',
    `deleted`     tinyint                                                      DEFAULT NULL COMMENT '是否删除',
    `version`     tinyint                                                      DEFAULT NULL COMMENT '乐观锁',
    `creator`     bigint                                                       DEFAULT NULL COMMENT '创建人',
    `create_time` datetime                                                     DEFAULT NULL COMMENT '创建时间',
    `updater`     bigint                                                       DEFAULT NULL COMMENT '更新人',
    `update_time` datetime                                                     DEFAULT NULL COMMENT '更新时间',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci COMMENT ='课程信息表';

-- 数据导出被取消选择。

-- 导出  表 maku_boot.edu_exam 结构
DROP TABLE IF EXISTS `edu_exam`;
CREATE TABLE IF NOT EXISTS `edu_exam`
(
    `id`          bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
    `name`        varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci  DEFAULT NULL COMMENT '考试名称',
    `type`        varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci  DEFAULT NULL COMMENT '考试类型',
    `start_time`  datetime                                                      DEFAULT NULL COMMENT '考试开始时间',
    `end_time`    datetime                                                      DEFAULT NULL COMMENT '考试结束时间',
    `clazz_id`    bigint                                                        DEFAULT NULL COMMENT '考试年级',
    `remark`      varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '备注',
    `is_enabled`  tinyint                                                       DEFAULT NULL COMMENT '是否启用',
    `deleted`     tinyint                                                       DEFAULT NULL COMMENT '是否删除',
    `version`     tinyint                                                       DEFAULT NULL COMMENT '乐观锁',
    `creator`     bigint                                                        DEFAULT NULL COMMENT '创建人',
    `create_time` datetime                                                      DEFAULT NULL COMMENT '创建时间',
    `updater`     bigint                                                        DEFAULT NULL COMMENT '更新人',
    `update_time` datetime                                                      DEFAULT NULL COMMENT '更新时间',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci COMMENT ='考试信息表';

-- 数据导出被取消选择。

-- 导出  表 maku_boot.edu_exam_score 结构
DROP TABLE IF EXISTS `edu_exam_score`;
CREATE TABLE IF NOT EXISTS `edu_exam_score`
(
    `id`           bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
    `exam_id`      bigint                                                       DEFAULT NULL COMMENT '考试id',
    `student_id`   bigint                                                       DEFAULT NULL COMMENT '学生id',
    `student_no`   varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '学生学号',
    `student_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '学生姓名',
    `course_id`    bigint                                                       DEFAULT NULL COMMENT '课程id',
    `course_name`  varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '课程名称',
    `score`        decimal(20, 2)                                               DEFAULT NULL COMMENT '成绩',
    `is_enabled`   tinyint                                                      DEFAULT NULL COMMENT '是否启用',
    `deleted`      tinyint                                                      DEFAULT NULL COMMENT '是否删除',
    `version`      tinyint                                                      DEFAULT NULL COMMENT '乐观锁',
    `creator`      bigint                                                       DEFAULT NULL COMMENT '创建人',
    `create_time`  datetime                                                     DEFAULT NULL COMMENT '创建时间',
    `updater`      bigint                                                       DEFAULT NULL COMMENT '更新人',
    `update_time`  datetime                                                     DEFAULT NULL COMMENT '更新时间',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci COMMENT ='考试成绩表';

-- 数据导出被取消选择。

-- 导出  表 maku_boot.edu_grade 结构
DROP TABLE IF EXISTS `edu_grade`;
CREATE TABLE IF NOT EXISTS `edu_grade`
(
    `id`          bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
    `name`        varchar(50) COLLATE utf8mb4_general_ci                       DEFAULT NULL COMMENT '年级',
    `stage`       varchar(50) COLLATE utf8mb4_general_ci                       DEFAULT NULL COMMENT '阶段',
    `is_enabled`  tinyint                                                      DEFAULT NULL COMMENT '是否启用',
    `deleted`     tinyint                                                      DEFAULT NULL COMMENT '是否删除',
    `version`     tinyint                                                      DEFAULT NULL COMMENT '乐观锁',
    `creator`     varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '创建人',
    `create_time` datetime                                                     DEFAULT NULL COMMENT '创建时间',
    `updater`     varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '更新人',
    `update_time` datetime                                                     DEFAULT NULL COMMENT '更新时间',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 45
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci COMMENT ='年级信息表';

INSERT INTO `edu_grade` (`id`, `name`, `stage`, `is_enabled`, `deleted`, `version`, `creator`, `create_time`, `updater`, `update_time`) VALUES (1, '一年级', '1', NULL, 0, 0, '10000', '2022-12-18 16:31:05', '10000', '2022-12-18 16:31:05');
INSERT INTO `edu_grade` (`id`, `name`, `stage`, `is_enabled`, `deleted`, `version`, `creator`, `create_time`, `updater`, `update_time`) VALUES (2, '二年级', '1', NULL, 0, 0, '10000', '2022-12-18 16:31:05', '10000', '2022-12-18 16:31:05');
INSERT INTO `edu_grade` (`id`, `name`, `stage`, `is_enabled`, `deleted`, `version`, `creator`, `create_time`, `updater`, `update_time`) VALUES (3, '三年级', '1', NULL, 0, 0, '10000', '2022-12-18 16:31:05', '10000', '2022-12-18 16:31:05');
INSERT INTO `edu_grade` (`id`, `name`, `stage`, `is_enabled`, `deleted`, `version`, `creator`, `create_time`, `updater`, `update_time`) VALUES (4, '四年级', '1', NULL, 0, 0, '10000', '2022-12-18 16:31:05', '10000', '2022-12-18 16:31:05');
INSERT INTO `edu_grade` (`id`, `name`, `stage`, `is_enabled`, `deleted`, `version`, `creator`, `create_time`, `updater`, `update_time`) VALUES (5, '五年级', '1', NULL, 0, 0, '10000', '2022-12-18 16:31:05', '10000', '2022-12-18 16:31:05');
INSERT INTO `edu_grade` (`id`, `name`, `stage`, `is_enabled`, `deleted`, `version`, `creator`, `create_time`, `updater`, `update_time`) VALUES (6, '六年级', '1', NULL, 0, 0, '10000', '2022-12-18 16:31:05', '10000', '2022-12-18 16:31:05');
INSERT INTO `edu_grade` (`id`, `name`, `stage`, `is_enabled`, `deleted`, `version`, `creator`, `create_time`, `updater`, `update_time`) VALUES (7, '七年级', '2', NULL, 0, 0, '10000', '2022-12-18 16:31:05', '10000', '2022-12-18 16:31:05');
INSERT INTO `edu_grade` (`id`, `name`, `stage`, `is_enabled`, `deleted`, `version`, `creator`, `create_time`, `updater`, `update_time`) VALUES (8, '八年级', '2', NULL, 0, 0, '10000', '2022-12-18 16:31:05', '10000', '2022-12-18 16:31:05');
INSERT INTO `edu_grade` (`id`, `name`, `stage`, `is_enabled`, `deleted`, `version`, `creator`, `create_time`, `updater`, `update_time`) VALUES (9, '九年级', '2', NULL, 0, 0, '10000', '2022-12-18 16:31:05', '10000', '2022-12-18 16:31:05');
INSERT INTO `edu_grade` (`id`, `name`, `stage`, `is_enabled`, `deleted`, `version`, `creator`, `create_time`, `updater`, `update_time`) VALUES (10, '高一', '3', NULL, 0, 0, '10000', '2022-12-18 16:31:05', '10000', '2022-12-18 16:31:05');
INSERT INTO `edu_grade` (`id`, `name`, `stage`, `is_enabled`, `deleted`, `version`, `creator`, `create_time`, `updater`, `update_time`) VALUES (11, '高二', '3', NULL, 0, 0, '10000', '2022-12-18 16:31:05', '10000', '2022-12-18 16:31:05');
INSERT INTO `edu_grade` (`id`, `name`, `stage`, `is_enabled`, `deleted`, `version`, `creator`, `create_time`, `updater`, `update_time`) VALUES (12, '高三', '3', NULL, 0, 0, '10000', '2022-12-18 16:31:05', '10000', '2022-12-18 16:31:05');


-- 导出  表 maku_boot.edu_semester 结构
DROP TABLE IF EXISTS `edu_semester`;
CREATE TABLE IF NOT EXISTS `edu_semester`
(
    `id`          bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
    `name`        varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '标题',
    `year`        varchar(50) COLLATE utf8mb4_general_ci                       DEFAULT NULL COMMENT '学年',
    `semester`    varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '学期',
    `start_date`  date                                                         DEFAULT NULL COMMENT '开始时间',
    `end_date`    date                                                         DEFAULT NULL COMMENT '结束时间',
    `is_enabled`  tinyint                                                      DEFAULT NULL COMMENT '是否启用',
    `deleted`     tinyint                                                      DEFAULT NULL COMMENT '是否删除',
    `version`     tinyint                                                      DEFAULT NULL COMMENT '乐观锁',
    `creator`     bigint                                                       DEFAULT NULL COMMENT '创建人',
    `create_time` datetime                                                     DEFAULT NULL COMMENT '创建时间',
    `updater`     bigint                                                       DEFAULT NULL COMMENT '更新人',
    `update_time` datetime                                                     DEFAULT NULL COMMENT '更新时间',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 8
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci COMMENT ='学期信息表';

-- 数据导出被取消选择。

-- 导出  表 maku_boot.edu_student 结构
DROP TABLE IF EXISTS `edu_student`;
CREATE TABLE IF NOT EXISTS `edu_student`
(
    `id`          bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
    `no`          varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '学号',
    `name`        varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '姓名',
    `gender`      varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '性别',
    `clazz_id`    bigint                                                       DEFAULT NULL COMMENT '班级id',
    `sys_user_id` bigint                                                       DEFAULT NULL COMMENT 'sys_user id',
    `is_enabled`  tinyint                                                      DEFAULT NULL COMMENT '是否启用',
    `deleted`     tinyint                                                      DEFAULT NULL COMMENT '是否删除',
    `version`     tinyint                                                      DEFAULT NULL COMMENT '乐观锁',
    `creator`     bigint                                                       DEFAULT NULL COMMENT '创建人',
    `create_time` datetime                                                     DEFAULT NULL COMMENT '创建时间',
    `updater`     bigint                                                       DEFAULT NULL COMMENT '更新人',
    `update_time` datetime                                                     DEFAULT NULL COMMENT '更新时间',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci COMMENT ='学生信息表';

-- 数据导出被取消选择。

-- 导出  表 maku_boot.edu_teacher 结构
DROP TABLE IF EXISTS `edu_teacher`;
CREATE TABLE IF NOT EXISTS `edu_teacher`
(
    `id`          bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
    `no`          varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '工号',
    `name`        varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '姓名',
    `gender`      varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '性别',
    `phone`       varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '联系方式',
    `sys_user_id` bigint                                                       DEFAULT NULL COMMENT 'sys_user id',
    `is_enabled`  tinyint                                                      DEFAULT NULL COMMENT '是否启用',
    `deleted`     tinyint                                                      DEFAULT NULL COMMENT '是否删除',
    `version`     tinyint                                                      DEFAULT NULL COMMENT '乐观锁',
    `creator`     bigint                                                       DEFAULT NULL COMMENT '创建人',
    `create_time` datetime                                                     DEFAULT NULL COMMENT '创建时间',
    `updater`     bigint                                                       DEFAULT NULL COMMENT '更新人',
    `update_time` datetime                                                     DEFAULT NULL COMMENT '更新时间',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 2
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci COMMENT ='教师信息表';

-- 数据导出被取消选择。

-- 导出  表 maku_boot.edu_teacher__clazz__course 结构
DROP TABLE IF EXISTS `edu_teacher__clazz__course`;
CREATE TABLE IF NOT EXISTS `edu_teacher__clazz__course`
(
    `teacher_id`  bigint   DEFAULT NULL COMMENT '教师id',
    `clazz_id`    bigint   DEFAULT NULL COMMENT '班级id',
    `course_id`   bigint   DEFAULT NULL COMMENT '课程id',
    `is_enabled`  tinyint  DEFAULT NULL COMMENT '是否启用',
    `deleted`     tinyint  DEFAULT NULL COMMENT '是否删除',
    `version`     tinyint  DEFAULT NULL COMMENT '乐观锁',
    `creator`     bigint   DEFAULT NULL COMMENT '创建人',
    `create_time` datetime DEFAULT NULL COMMENT '创建时间',
    `updater`     bigint   DEFAULT NULL COMMENT '更新人',
    `update_time` datetime DEFAULT NULL COMMENT '更新时间',
    KEY `TEACHER_KEY` (`teacher_id`),
    KEY `clazz_id` (`clazz_id`),
    KEY `course_id` (`course_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci COMMENT ='教师_班级_课程关联表';

-- 数据导出被取消选择。
