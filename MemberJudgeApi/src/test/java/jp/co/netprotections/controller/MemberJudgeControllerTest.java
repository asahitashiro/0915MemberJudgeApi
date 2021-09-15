package jp.co.netprotections.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.web.context.WebApplicationContext;

import jp.co.netprotections.util.RestTestBase;

@SpringBootTest
@ExtendWith(SpringExtension.class)

//型 MemberJudgeControllerTest はパッケージと一致しません？？->パッケージにクラス名を使うな
public class MemberJudgeControllerTest extends RestTestBase{
	
	

	@Autowired
	public WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    private String targetUrl = "http://localhost:8080/api";

    // モック対象のControllerインスタンスを生成
    //まずここ！！
  	@Before
  	public void setupMock() {
  		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
  	}
  	/**
	 * 001
	 * @throws Exception
	 *リクエストチェックメソッドがfalseの時、setnullがちゃんと機能しているか
	 *（レスポンスがname:null、enlistedPropriety：falseであるかどうか）
	 */
  	
	@Test
	public void test001() throws Exception {
		// モック対象へのリクエスト文字列を取得
		String body = super.readForObject("test001.json");

		// Controllerにリクエストを送り、結果を取得
		ResultActions result = mockMvc.perform(post(targetUrl)
				.contentType(org.springframework.http.MediaType.APPLICATION_JSON)
				.content(body));

		// 結果の検査。
		result.andExpect(status().is(HttpStatus.OK.value()));
		result.andExpect(jsonPath("$.judgedCandidatesResultList[0].memberName", is(nullValue())));
		result.andExpect(jsonPath("$.judgedCandidatesResultList[0].enlistedPropriety",is(false)));
	}
  	/**
	 * 002
	 * @throws Exception
	 *リクエストチェックメソッドがtrueの時、スコアジャッジ(false)がちゃんと機能しているかどうか
	 *（レスポンスがname:name、enlistedPropriety：falseであるかどうか)
	 */
	@Test
	public void test002() throws Exception {
		// モック対象へのリクエスト文字列を取得
		String body = super.readForObject("test002.json");

		// Controllerにリクエストを送り、結果を取得
		ResultActions result = mockMvc.perform(post(targetUrl)
				.contentType(org.springframework.http.MediaType.APPLICATION_JSON)
				.content(body));

		// 結果の検査。ステータスがOKであること、および文字列の文字数が6であることを確認します
		result.andExpect(status().is(HttpStatus.OK.value()))
		.andExpect(jsonPath("$.judgedCandidatesResultList[0].memberName",is("haruhi")))
		.andExpect(jsonPath("$.judgedCandidatesResultList[0].enlistedPropriety",is(false)));
	}
  	/**
	 * 003
	 * @throws Exception
	 *リクエストチェックメソッドがtrueの時、スコアジャッジ(true)がちゃんと機能しているかどうか
	 *（レスポンスがname:name、enlistedPropriety：trueであるかどうか)
	 */	@Test
	public void test003() throws Exception {
		// モック対象へのリクエスト文字列を取得
		String body = super.readForObject("test003.json");

		// Controllerにリクエストを送り、結果を取得
		ResultActions result = mockMvc.perform(post(targetUrl)
				.contentType(org.springframework.http.MediaType.APPLICATION_JSON)
				.content(body));

		// 結果の検査。ステータスがOKであること、および文字列の文字数が6であることを確認します
		result.andExpect(status().is(HttpStatus.OK.value()))
		.andExpect(jsonPath("$.judgedCandidatesResultList[0].memberName",is("haruhi")))
		.andExpect(jsonPath("$.judgedCandidatesResultList[0].enlistedPropriety",is(true)));
	}
  	/**
	 * 004
	 * @throws Exception
	 *リクエストにリストが無い時、レスポンスがnullであるかどうか
	 */
	@Test
	public void test004() throws Exception {
		// モック対象へのリクエスト文字列を取得
		String body = super.readForObject("test004.json");

		// Controllerにリクエストを送り、結果を取得
		ResultActions result = mockMvc.perform(post(targetUrl)
				.contentType(org.springframework.http.MediaType.APPLICATION_JSON)
				.content(body));

		// 結果の検査。ステータスがOKであること、および文字列の文字数が6であることを確認します
		result.andExpect(status().is(HttpStatus.OK.value()))
		.andExpect(jsonPath("$",is(nullValue())));
	}
}
