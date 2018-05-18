package cn.edu.nyist.bookmanv1.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.nyist.bookmanv1.biz.AdminBiz;
import cn.edu.nyist.bookmanv1.biz.impl.AdminBizImpl;



@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1 获取参数
		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		String vcode = request.getParameter("vcode");
		
		// 执行验证码
		HttpSession session = request.getSession();
		String serverVcode = (String) session.getAttribute("validateCode");
		// 验证码不对
		if (!serverVcode.equalsIgnoreCase(vcode)) {
			// 记录错误信息
			request.setAttribute("msg", "验证码错误");
			request.setAttribute("name", name);
			request.getRequestDispatcher("login.jsp").forward(request, response);
			return;
		}
		// 2 调用业务层
		AdminBiz adminBiz = new AdminBizImpl();
		boolean ret = adminBiz.findAdminByNameAndPwd(name, pwd);
		// 3 给用户一个响应  根据业务层 调用结果返回对应视图
		if (ret) {
			response.sendRedirect("main.jsp");
		} else {
			// 登陆失败
			request.setAttribute("msg", "用户名或者密码错误");
			request.setAttribute("name", name);
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}

	}

}
