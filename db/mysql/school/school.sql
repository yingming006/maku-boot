-- 导出  表 school.clazz 结构
DROP TABLE IF EXISTS `edu_clazz`;
CREATE TABLE IF NOT EXISTS `edu_clazz`
(
    `id`          bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
    `grade`       varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '年级',
    `clazz`       varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '班级',
    `is_enabled`  tinyint                                                      DEFAULT NULL COMMENT '是否启用',
    `deleted`     tinyint                                                      DEFAULT NULL COMMENT '是否删除',
    `version`     tinyint                                                      DEFAULT NULL COMMENT '乐观锁',
    `creator`     varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '创建人',
    `create_time` datetime                                                     DEFAULT NULL COMMENT '创建时间',
    `updater`     varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '更新人',
    `update_time` datetime                                                     DEFAULT NULL COMMENT '更新时间',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci COMMENT ='班级信息表';

-- 正在导出表  school.clazz 的数据：~0 rows (大约)

-- 导出  表 school.course 结构
DROP TABLE IF EXISTS `edu_course`;
CREATE TABLE IF NOT EXISTS `edu_course`
(
    `id`          bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
    `name`        varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '课程名称',
    `is_enabled`  tinyint                                                      DEFAULT NULL COMMENT '是否启用',
    `deleted`     tinyint                                                      DEFAULT NULL COMMENT '是否删除',
    `version`     tinyint                                                      DEFAULT NULL COMMENT '乐观锁',
    `creator`     varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '创建人',
    `create_time` datetime                                                     DEFAULT NULL COMMENT '创建时间',
    `updater`     varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '更新人',
    `update_time` datetime                                                     DEFAULT NULL COMMENT '更新时间',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci COMMENT ='课程信息表';

-- 正在导出表  school.course 的数据：~0 rows (大约)

-- 导出  表 school.exam 结构
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
    `creator`     varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci  DEFAULT NULL COMMENT '创建人',
    `create_time` datetime                                                      DEFAULT NULL COMMENT '创建时间',
    `updater`     varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci  DEFAULT NULL COMMENT '更新人',
    `update_time` datetime                                                      DEFAULT NULL COMMENT '更新时间',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci COMMENT ='考试信息表';

-- 正在导出表  school.exam 的数据：~0 rows (大约)

-- 导出  表 school.exam_score 结构
DROP TABLE IF EXISTS `edu_exam_score`;
CREATE TABLE IF NOT EXISTS `edu_exam_score`
(
    `id`           bigint                                                       DEFAULT NULL AUTO_INCREMENT COMMENT 'id',
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
    `creator`      varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '创建人',
    `create_time`  datetime                                                     DEFAULT NULL COMMENT '创建时间',
    `updater`      varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '更新人',
    `update_time`  datetime                                                     DEFAULT NULL COMMENT '更新时间'
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci;

-- 正在导出表  school.exam_score 的数据：~0 rows (大约)

-- 导出  表 school.student 结构
DROP TABLE IF EXISTS `edu_student`;
CREATE TABLE IF NOT EXISTS `edu_student`
(
    `id`          bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
    `no`          varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '学号',
    `name`        varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '姓名',
    `gender`      varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '性别',
    `clazz_id`    bigint                                                       DEFAULT NULL COMMENT '班级id',
    `is_enabled`  tinyint                                                      DEFAULT NULL COMMENT '是否启用',
    `deleted`     tinyint                                                      DEFAULT NULL COMMENT '是否删除',
    `version`     tinyint                                                      DEFAULT NULL COMMENT '乐观锁',
    `creator`     varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '创建人',
    `create_time` datetime                                                     DEFAULT NULL COMMENT '创建时间',
    `updater`     varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '更新人',
    `update_time` datetime                                                     DEFAULT NULL COMMENT '更新时间',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci COMMENT ='学生信息表';

-- 正在导出表  school.student 的数据：~0 rows (大约)

-- 导出  表 school.teacher 结构
DROP TABLE IF EXISTS `edu_teacher`;
CREATE TABLE IF NOT EXISTS `edu_teacher`
(
    `id`          bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
    `no`          varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '工号',
    `name`        varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '姓名',
    `gender`      varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '性别',
    `phone`       varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '联系方式',
    `is_enabled`  tinyint                                                      DEFAULT NULL COMMENT '是否启用',
    `deleted`     tinyint                                                      DEFAULT NULL COMMENT '是否删除',
    `version`     tinyint                                                      DEFAULT NULL COMMENT '乐观锁',
    `creator`     varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '创建人',
    `create_time` datetime                                                     DEFAULT NULL COMMENT '创建时间',
    `updater`     varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '更新人',
    `update_time` datetime                                                     DEFAULT NULL COMMENT '更新时间',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci COMMENT ='教师信息表';

-- 正在导出表  school.teacher 的数据：~0 rows (大约)

-- 导出  表 school.teacher__clazz__course 结构
DROP TABLE IF EXISTS `edu_teacher__clazz__course`;
CREATE TABLE IF NOT EXISTS `edu_teacher__clazz__course`
(
    `teacher_id`  bigint                                                       DEFAULT NULL COMMENT '教师id',
    `clazz_id`    bigint                                                       DEFAULT NULL COMMENT '班级id',
    `course_id`   bigint                                                       DEFAULT NULL COMMENT '课程id',
    `is_enabled`  tinyint                                                      DEFAULT NULL COMMENT '是否启用',
    `deleted`     tinyint                                                      DEFAULT NULL COMMENT '是否删除',
    `version`     tinyint                                                      DEFAULT NULL COMMENT '乐观锁',
    `creator`     varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '创建人',
    `create_time` datetime                                                     DEFAULT NULL COMMENT '创建时间',
    `updater`     varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '更新人',
    `update_time` datetime                                                     DEFAULT NULL COMMENT '更新时间',
    KEY `TEACHER_KEY` (`teacher_id`),
    KEY `clazz_id` (`clazz_id`),
    KEY `course_id` (`course_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci COMMENT ='教师_班级_课程关联表';

-- 正在导出表  school.teacher__clazz__course 的数据：~0 rows (大约)
