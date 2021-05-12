package org.graduation.knowledge.mapper.neo4j;

import com.baomidou.dynamic.datasource.annotation.DS;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author huyuanxin
 */
@Mapper
@DS("3D")
@Repository
public interface Subject3dMapper {
    /**
     * 初始化Subject,设置Subject的name为唯一值
     */
    void initSubject();

    /**
     * 插入所属科目
     *
     * @param subjectName 名称
     */
    void insertSubject(@Param("subjectName") String subjectName);

    /**
     * 返回特点名称所属科目的数量,作为是否存在的判断
     *
     * @param subjectName 所属科目名称
     * @return 存在的数量
     */
    long isExits(@Param("subjectName") String subjectName);
}
