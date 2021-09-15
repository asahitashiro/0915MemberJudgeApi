package jp.co.netprotections.service;

//import static org.hamcrest.CoreMatchers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import jp.co.netprotections.dto.*;
import jp.co.netprotections.service.util.MemberJudgeServiceUtil;

//Testメソッド：合計点を計算するメソッド
public class MemberJudgeServiceUtilScoreTest {
	@Test
	public void normalTotalScore(){
		
		//引数（（）の中）にすると、リクエストもらってない！となる。
		//インスタンス（空き箱）を作って、そこに自分の調べたい設定を詰める。
		MemberJudgeRequestDto request = new MemberJudgeRequestDto();
		
		//通常のリクエスト
		request.setMemberName("tas");
		request.setCoordination(2);
		request.setCogitation(3);
		request.setEventPlanning(3);
		request.setInfrastructureKnowledge(3);
		request.setProgrammingAbility(2);
		
		int score = MemberJudgeServiceUtil.totalScore(request);
		
		assertEquals(score, 13);
		
	}
	
	@Test
	public void nullNameTotalScore(){
		
		MemberJudgeRequestDto request = new MemberJudgeRequestDto();
		
		//NullName
		request.setMemberName(null);
		request.setCoordination(2);
		request.setCogitation(3);
		request.setEventPlanning(3);
		request.setInfrastructureKnowledge(3);
		request.setProgrammingAbility(2);
		
		int score = MemberJudgeServiceUtil.totalScore(request);
		
		assertEquals(score, 13);
		
	}
	
	@Test
	public void smallTotalScore(){
		
		MemberJudgeRequestDto request = new MemberJudgeRequestDto();
		
		//NullName
		request.setMemberName("tas");
		request.setCoordination(-2);
		request.setCogitation(3);
		request.setEventPlanning(3);
		request.setInfrastructureKnowledge(3);
		request.setProgrammingAbility(5);
		
		int score = MemberJudgeServiceUtil.totalScore(request);
		
		assertEquals(score, 12);
		
	}
	
	@Test
	public void largeTotalScore(){
		
		MemberJudgeRequestDto request = new MemberJudgeRequestDto();
		
		//NullName
		request.setMemberName("tas");
		request.setCoordination(20);
		request.setCogitation(3);
		request.setEventPlanning(3);
		request.setInfrastructureKnowledge(3);
		request.setProgrammingAbility(5);
		
		int score = MemberJudgeServiceUtil.totalScore(request);
		
		assertEquals(score, 34);
		
	}

}