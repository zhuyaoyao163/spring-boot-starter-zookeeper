package me.douboo.springboot.zookeeper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@EnableZookeeper
@PropertySource("classpath:application.properties")
public class ApplicationTests {

	protected final Logger LOG = LoggerFactory.getLogger(ApplicationTests.class);

	@Autowired
	private ZookeeperUtils zookeeperUtils;

	@Test
	public void testZk() throws Exception {
		String path = "/zk-test";
		String node = System.currentTimeMillis() + "";
		zookeeperUtils.createNode(path, node);
		assert zookeeperUtils.exists(path, node);
	}

	@Test
	public void testClient() throws Exception {
		assert zookeeperUtils.getClientIndex() == 0;
		assert zookeeperUtils.getClientNum() == 1;
	}
}
