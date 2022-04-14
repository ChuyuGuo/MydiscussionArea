package com.mycode.SpringBootdemo;

import com.mycode.SpringBootdemo.dao.AlphaDao;
import com.mycode.SpringBootdemo.service.AplhaService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = SpringBootdemoApplication.class)
//实现ApplicationContextAware接口就得到了对应的Spring容器
class SpringBootdemoApplicationTests implements ApplicationContextAware {
	private ApplicationContext applicationContext;

	@Test
	void contextLoads() {
	}

	//通过组合的方式得到Spring容器对象
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}

	//测试Spring容器对象
	@Test
	public void testApplicationContext(){
		System.out.println(applicationContext);

		AlphaDao alphaDao = applicationContext.getBean(AlphaDao.class);

		System.out.println(alphaDao.select());

		alphaDao = applicationContext.getBean("alphaMybatis",AlphaDao.class);
		System.out.println(alphaDao.select());
	}

	@Test
	public void testBeanManagement(){
		//被Spring容器管理的对象默认是单例的
		//可以通过 @Scope() 修改对象的作用域
		AplhaService aplhaService = applicationContext.getBean(AplhaService.class);

		System.out.println(aplhaService);
	}

	@Test
	public void testBeanConfig(){
		SimpleDateFormat simpleDateFormat = applicationContext.getBean(SimpleDateFormat.class);

		System.out.println(simpleDateFormat.format(new Date()));
	}

	//依赖注入
	@Autowired //自动注入 先byType再byName
	@Qualifier("alphaMybatis")	//指定哪个Bean(通过Name)
	private AlphaDao alphaDao;
	@Autowired
	private AplhaService aplhaService;
	@Autowired
	private SimpleDateFormat simpleDateFormat;

	@Test
	public void testDI(){
		System.out.println(alphaDao);
		System.out.println(aplhaService);
		System.out.println(simpleDateFormat);
	}
}
