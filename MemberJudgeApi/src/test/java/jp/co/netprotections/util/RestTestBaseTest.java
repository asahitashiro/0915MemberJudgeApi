package jp.co.netprotections.util;

public class RestTestBaseTest {
	
	RestTestBase test = new RestTestBase();
	
	public String getData() {
		String document = test.readForObject("test001.json");
		return document;
	}
	
	public void showDocument() {
		System.out.print(getData());
	}
}
