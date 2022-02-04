package com.big_fish.oa.dao;

import com.big_fish.oa.entity.Node;
import com.big_fish.oa.utils.MybatisUtils;

import java.util.List;

/**
 * ClassName: RbacDao
 * Description:
 * date: 2022/2/4 21:54
 *
 * @author: 孟家宝
 * @version:
 * @since: JDK 1.8
 */
public class RbacDao {
    public List<Node> selectNodeById(Long userId){
        return(List) MybatisUtils.executeQuery(sqlSession -> sqlSession.selectList("rbac_mapper.selectNodeByUserId",userId));

    }
}
