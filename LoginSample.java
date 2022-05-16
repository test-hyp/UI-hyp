package test.maven.HypMavenFirst;

public class LoginSample {
	public String resultMSG = "";

	public boolean login(String ln, String pwd) {
		if (ln != null && pwd != null) {
			if (ln.length() > 2 && ln.length() < 17 && pwd.length() > 2 && pwd.length() < 17) {
				if (ln.equals("Roy") && pwd.equals("123456")) {
					resultMSG = "恭喜您，登录成功";
					System.out.println("恭喜您，登录成功");
					return true;
				}
				if (ln.equals("Will")) {
					resultMSG = "不好意思用户名重复";
					System.out.println("不好意思用户名重复");
					return false;
				} else {
					resultMSG = "用户名或密码错误！";
					System.out.println("用户名或密码错误！");
					return false;
				}

			} else {
				resultMSG = "用户名密码长度应是3-16位！";
				System.out.println("用户名密码长度应是3-16位！");
				return false;
			}
		} else {
			resultMSG = "用户名密码不能为空！";
			System.out.println("用户名密码不能为空！");
			return false;
		}
	}

	public String getResult() {
		return resultMSG;
	}

}