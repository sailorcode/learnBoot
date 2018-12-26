package com.qianyufeni.learnBoot;

import com.qianyufeni.learnBoot.dao.QyfUserMapper;
import com.qianyufeni.learnBoot.entity.QyfUser;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LearnBootApplicationTests {
	@Autowired
	private QyfUserMapper qyfUserMapper;

	@Test
	public void testSelect() {
		System.out.println(("----- selectAll method test ------"));
		List<QyfUser> userList = qyfUserMapper.selectList(null);
		Assert.assertEquals(5, userList.size());
		userList.forEach(System.out::println);
	}

	@Test
	public void contextLoads() {
		ConcurrentHashMap<String,String> map = new ConcurrentHashMap<>();
		map.put("1","1");
		map.put("1","2");
	}

}
