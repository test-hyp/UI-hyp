package test.maven.HypMavenFirst;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LoginSampleTest {
	
	private LoginSample ls;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("++++++++++++++++测试所有@test方法开始之前运行++++++++++++++++++++");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("++++++++++++++++测试所有@test方法结束之后运行++++++++++++++++++++");
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("++++++++++++++++每个@test方法开始前运行++++++++++++++++++++");
		ls=new LoginSample();
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("++++++++++++++++每个@test方法之后运行++++++++++++++++++++");
	}

	@Test
	public void anormaltest() {
		ls.login("Roy","123456");
		assertEquals("恭喜您，登录成功", ls.getResult());
		assertTrue(ls.getResult().contains("成功"));
		
		//直接置为执行失败。
//		fail("Not yet implemented");
	}
	
	@Test
	public void nulltest() {
		ls.login(null, "123456");
		assertTrue(ls.getResult().contains("为空"));
//		fail("Not yet implemented");
	}
	

}