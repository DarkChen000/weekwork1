package com.itdr.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class NameDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    public int selectByUserNameAndPassword(String username, String password) {

        String sql = "select id,username,password from user where username = ? and password = ?";

        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql, username, password);

        if (maps.size() != 0){
            return 1;
        }
        return 0;

    }

    public int insertByUserNameAndPassword(String username, String password) {

        String sql = "insert into user values(null,?,?)";

        int update = jdbcTemplate.update(sql, username, password);

        return update;
    }

    public String selectByShengxiao(String shengxiao) {

        String sql = "select first from name_first where shengxiao = ?";

        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql, shengxiao);

        for (Map<String, Object> map : maps) {
            for (String s : map.keySet()){
                return (String) map.get(s);
            }
        }

        return null;
    }

    public String selectByMonth(String month) {

        String sql = "select second from name_second where month = ?";

        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql, month);

        for (Map<String, Object> map : maps) {
            for (String s : map.keySet()){
                return (String) map.get(s);
            }
        }

        return null;
    }

    public String selectByXingzuo(String xingzuo) {

        String sql = "select third from name_third where xingzuo = ?";

        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql, xingzuo);

        for (Map<String, Object> map : maps) {
            for (String s : map.keySet()){
                return (String) map.get(s);
            }
        }

        return null;
    }
}
