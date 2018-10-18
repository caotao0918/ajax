package json;

import java.util.ArrayList;
import java.util.List;



import bean.Stock;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
//��Java����ת��Ϊjson�ַ���
public class JsonTest {
	
	public static void test1(){
		Stock s = new Stock();
		s.setCode("1868");
		s.setName("caotao����");
		s.setPrice(10);
		//ʹ��json-lib�ṩ�Ĺ�����ת��
		JSONObject jsonObject = JSONObject.fromObject(s);
		String jsonStr = jsonObject.toString();
		System.out.println(jsonStr);
	}
	
	public static void test2(){
		List<Stock> stocks = new ArrayList<Stock>();
		for(int i = 0; i < 10; i++){
			Stock s = new Stock();
			s.setCode("1868" + i);
			s.setName("caotao����" + i);
			s.setPrice(10 + i);
			stocks.add(s);
		}
		JSONArray jsonArray = JSONArray.fromObject(stocks);
		String jsonStrs = jsonArray.toString();
		System.out.println(jsonStrs);
	}
	public static void main(String[] args) {
		test2();
	}
}
