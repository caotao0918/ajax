package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Stock;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class ActionServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		Random random = new Random();
		System.out.println("service()");
		String uri = request.getRequestURI();
		StringBuffer url = request.getRequestURL();
		System.out.println("uri：" + uri);
		System.out.println("url:" + url);
		String action = uri.substring(uri.lastIndexOf("/"),uri.indexOf("."));
		System.out.println("action:" + action);
		if("/quoto".equals(action)){
			//模拟生成几只股票的信息
			List<Stock> stocks = new ArrayList<Stock>();
			for(int i = 0; i < 8; i++){
				Stock s = new Stock();
				s.setCode("60087" + random.nextInt(10));
				s.setName("万集科技" + random.nextInt(10));
				s.setPrice(random.nextInt(1000));
				stocks.add(s);
			}
			JSONArray jsonArray = JSONArray.fromObject(stocks);
			String jsonStr = jsonArray.toString();
			System.out.println(jsonStr);
			out.println(jsonStr);
		}
		//用load方法获取辛运数字
		if("/luck".equals(action)){
			int number = random.nextInt(1000);
			System.out.println(number);
			out.println(number);
		}
		//用$.ajax()方法获取辛运数字
		if("/luck2".equals(action)){
			int number = random.nextInt(1000);
			System.out.println(number);
			out.println(number);
		}
			
	}
}
