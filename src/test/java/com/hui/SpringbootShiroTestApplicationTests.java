package com.hui;

import com.hui.mapper.UserMapper;
import com.hui.pojo.Account;
import com.hui.pojo.AccountPerm;
import com.hui.pojo.Role;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Set;

@SpringBootTest
class SpringbootShiroTestApplicationTests {

    @Autowired
    DataSource dataSource;
    @Resource
    UserMapper userMapper;

    @Test
    void contextLoads() throws SQLException {
        System.out.println(dataSource.getClass());
        System.out.println("=======");
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
        connection.close();
    }


    @Test
    public void testFindAccountByName() {
        //   Account account = userMapper.findAccountByName("admin");
        // System.out.println(account);
//        Role role = userMapper.findRoleByAccountId(1);
//        System.out.println(role);

        Set<String> accountPerms = userMapper.findAccountPerById(1);
        for (String acc : accountPerms ) {
            System.out.println(acc);
        }

    }
}
