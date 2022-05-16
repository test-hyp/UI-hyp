package test.maven.HypMavenFirst;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
//声明这个类使用junit的参数化运行方式
@RunWith(Parameterized.class)
public class LoginParamTest {
	private static LoginSample ls;
	//成员变量接收初始化
	private String username;
	private String pwd;
	private String actual;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		ls=new LoginSample();
	}
	
	//构造方法用和@parameters的二维数组中同样的参数列表来接收每一行的数据。
	public LoginParamTest(String user,String password,String actual) {
		username=user;
		pwd=password;
		this.actual=actual;
	}

	//@test方法调用成员变量完成执行。
	@Test
	public void test() {
		boolean result=ls.login(username, pwd);
		//assertTrue(result);
		assertEquals(actual, ls.getResult());
	}
	
	//返回一个二维数组，二维数组是需要使用的测试数据，即初始化数据。
	@Parameters(name = "输入为 {0}和{1}的时候，结果是{2}")
	public static Object[][] logindatas(){
		return new Object[][] {
			{null, "123456","用户名密码不能为空！"},
			{"ro", "123456","用户名密码长度应是3-16位！"},
			{"Roy", "r","用户名密码长度应是3-16位！"},
			{"Roy", "123456","恭喜您，登录成功"},	
			{"Will", "123456","不好意思用户名重复"}	
		};
		
		
	}

}