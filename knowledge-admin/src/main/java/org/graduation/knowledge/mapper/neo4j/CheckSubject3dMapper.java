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
public interface CheckSubject3dMapper {
    /**
     * 初始化检查科目
     */
    void initCheckSubject();

    /**
     * 查询指定名字的检查科目的个数
     *
     * @param checkSubjectName 检查科目的名字
     * @return 个数
     */
    long isExits(@Param("checkSubjectName") String checkSubjectName);

    /**
     * 插入检查科目
     *
     * @param checkSubjectName 检查科目的名字
     */
    void insertCheckSubject(@Param("checkSubjectName") String checkSubjectName);
}
