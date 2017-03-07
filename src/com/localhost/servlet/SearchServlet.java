package com.localhost.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.localhost.service.UserService;
import com.localhost.service.Impl.UserServiceImpl;

import net.sf.json.JSONArray;

/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
     * @see HttpServlet#HttpServlet()
     */
    public SearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 首先获得客户端发送来的数据(keyword)
		String keyword = request.getParameter("keyword");
		System.out.println(keyword);
		// 获得关键字之后进行处理，得到关联数据
		UserService service = new UserServiceImpl();
		List<String> listData = null;
		if (!"".equals(keyword)) {
			listData = service.search(keyword);
		}
		if (listData == null) {
			response.getWriter().write(JSONArray.fromObject("无匹配结果").toString());
		}
		// 返回json格式
		response.getWriter().write(JSONArray.fromObject(listData).toString());
	}
	
}
