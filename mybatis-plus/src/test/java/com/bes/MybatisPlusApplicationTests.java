package com.bes;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bes.mapper.UserMapper;
import com.bes.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sound.midi.Soundbank;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
class MybatisPlusApplicationTests {
	@Autowired
	UserMapper userMapper;

	@Test
	void contextLoads() {
		List<User> users = userMapper.selectList(null);
		for (User user : users) {
			System.out.println(user);
		}
	}

	@Test
    void insertTest() {
	    User user = new User();
	    user.setName("彭高历1");
	    user.setAge(23);
        int insert = userMapper.insert(user);
        System.out.println(insert);
        System.out.println(user);
    }

    @Test
    void updateTest() {
		User user = userMapper.selectById(1);
		User user1 = userMapper.selectById(1);
		user.setName("hououhou");
		user.setAge(23);
        int update = userMapper.updateById(user);
        user1.setAge(34);
        int update1 = userMapper.updateById(user1);
        System.out.println(update);
    }

//    批量查询
	@Test
	void selectBatchId() {
		List<User> users = userMapper.selectBatchIds(Arrays.asList(1, 2, 3, 4));
		users.forEach(System.out::println);
	}


//	map条件查询
	@Test
	void selectByMap() {
		Map<String, Object> queryMap = new HashMap<>();
		queryMap.put("name", "彭高历");
		queryMap.put("age", "22");
		List<User> users = userMapper.selectByMap(queryMap);
		users.forEach(System.out::println);
	}

//	分页查询
	@Test
	void selectPage() {
		Page<User> page = new Page<>(2, 4);
		IPage<User> userIPage = userMapper.selectPage(page, null);
		System.out.println(userIPage.getTotal());
		userIPage.getRecords().forEach(System.out::println);
	}

//	删除操作
	@Test
	void deleteById() {
		int i = userMapper.deleteById(4L);
		System.out.println(i);
	}

//	批量删除
	@Test
	void deleteBatchId() {
		int i = userMapper.deleteBatchIds(Arrays.asList(1326107720750809089L, 1326345091773734913L));
		System.out.println(i);
	}

	@Test
	void deleteByMap() {
		Map<String, Object> deleteMap  = new HashMap<>();
		deleteMap.put("name", "jack");
		deleteMap.put("age", 20);
		int i = userMapper.deleteByMap(deleteMap);
		System.out.println(i);
	}

}
