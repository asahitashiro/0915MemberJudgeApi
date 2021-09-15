package jp.co.netprotections.util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class RestTestBase {

	private String resourceDir;


		public void setRestTestBase() {
			resourceDir = "src/test/resources/jp/co/netprotections/controller/";
		}

		/**
		 * テスト資源のディレクトリを返却します。
		 */
		private String getResourceDir() {
			return this.resourceDir;
		}

		/**
		 * JSONファイルの内容をStringオブジェクトに書き出します。
		 * @param jsonFileName
		 * @return String
		 * @throws IOException
		 */
		public String readForObject(String jsonFileName) throws IOException {
			InputStreamReader filereader = new InputStreamReader(new FileInputStream(getResourceDir() + jsonFileName));
	        
			//InputStreamReader型(デフォルトの文字セットを使う)をBufferedReader型(文字型入力ストリーム) へ変換
			BufferedReader br = new BufferedReader(filereader);	
			
	        StringBuilder sb = new StringBuilder();

	        String str = br.readLine();
	        
	        //Buffered Reader が読み込むデータ（str = br.readLine();）が
	        //『無くなるまで(＝！ null)』繰り返す
	        while (str != null) {
	        	//一文字づつのデータを複数文字のデータに結合
	            sb.append(str);
	        }

	        filereader.close();
	        br.close();

	        return sb.toString();
		}
		
}