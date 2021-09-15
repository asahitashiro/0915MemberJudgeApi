package jp.co.netprotections.service;

//import static org.hamcrest.CoreMatchers.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import jp.co.netprotections.dto.*;
import jp.co.netprotections.service.util.MemberJudgeServiceUtil;

//Testメソッド：点数について、合否判定するメソッド
public class MemberJudgeServiceUtilJudgeTest {
	@Test
	public void normalJudge(){
		
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
		
		boolean result = MemberJudgeServiceUtil.judge(request);
		
		assertTrue(result);
		
	}
	
public void cog1Judge(){
		
		MemberJudgeRequestDto request = new MemberJudgeRequestDto();
		
		//cog=1
		request.setMemberName("tas");
		request.setCoordination(2);
		request.setCogitation(1);
		request.setEventPlanning(3);
		request.setInfrastructureKnowledge(3);
		request.setProgrammingAbility(2);
		
		boolean result = MemberJudgeServiceUtil.judge(request);
		
		assertFalse(result);
		
	}

public void coordination1Judge(){
	
	MemberJudgeRequestDto request = new MemberJudgeRequestDto();
	
	//coordination=1
	request.setMemberName("tas");
	request.setCoordination(1);
	request.setCogitation(4);
	request.setEventPlanning(3);
	request.setInfrastructureKnowledge(3);
	request.setProgrammingAbility(2);
	
	boolean result = MemberJudgeServiceUtil.judge(request);
	
	assertFalse(result);
	
}

public void eventPlanning1Judge(){
	
	MemberJudgeRequestDto request = new MemberJudgeRequestDto();
	
	//eventPlanning=1
	request.setMemberName("tas");
	request.setCoordination(2);
	request.setCogitation(4);
	request.setEventPlanning(1);
	request.setInfrastructureKnowledge(3);
	request.setProgrammingAbility(2);
	
	boolean result = MemberJudgeServiceUtil.judge(request);
	
	assertFalse(result);
	
}

public void totalScore8Judge(){
	
	MemberJudgeRequestDto request = new MemberJudgeRequestDto();
	
	//totalScore <= 10
	request.setMemberName("tas");
	request.setCoordination(2);
	request.setCogitation(2);
	request.setEventPlanning(2);
	request.setInfrastructureKnowledge(1);
	request.setProgrammingAbility(1);
	
	boolean result = MemberJudgeServiceUtil.judge(request);
	
	assertFalse(result);
	
}

}