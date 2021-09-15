package jp.co.netprotections.service;

//import static org.hamcrest.CoreMatchers.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import jp.co.netprotections.dto.*;
import jp.co.netprotections.service.util.MemberJudgeServiceUtil;

//Testメソッド：int値について、正常なリスエストか判定するメソッド
public class MemberJudgeServiceUtilCheckRequestTest {
	
	@Test
	public void normalCheckRequest(){
		
		//引数（（）の中）にすると、リクエストもらってない！となる。
		//インスタンス（空き箱）を作って、そこに自分の調べたい設定を詰める。
		MemberJudgeRequestDto request = new MemberJudgeRequestDto();
		
		//testしたいクラス（ServiceUtilクラス）を呼び出し、インスタンスを作成
		//but, staticメソッドはインスタンスを必要としないんでスキップ
		//MemberJudgeServiceUtil test = new MemberJudgeServiceUtil();
		
		//通常のリクエスト
		request.setMemberName("tas");
		request.setCoordination(2);
		request.setCogitation(3);
		request.setEventPlanning(3);
		request.setInfrastructureKnowledge(3);
		request.setProgrammingAbility(2);
		
		boolean check = MemberJudgeServiceUtil.checkRequest(request);
		
		assertTrue(check);
		
	}
	
	@Test
	public void nullNamecheckRequest(){
		
		MemberJudgeRequestDto request = new MemberJudgeRequestDto();
		
		//名前がnull
		request.setMemberName(null);
		request.setCoordination(2);
		request.setCogitation(3);
		request.setEventPlanning(3);
		request.setInfrastructureKnowledge(3);
		request.setProgrammingAbility(2);
		
		boolean check = MemberJudgeServiceUtil.checkRequest(request);
		
		assertTrue(check);
		
	}
	
	@Test
	public void smallCogCheckRequest() {
MemberJudgeRequestDto request = new MemberJudgeRequestDto();
		
		//cogitation < 0
		request.setMemberName("tas");
		request.setCoordination(-1);
		request.setCogitation(3);
		request.setEventPlanning(3);
		request.setInfrastructureKnowledge(3);
		request.setProgrammingAbility(2);
		
		boolean check = MemberJudgeServiceUtil.checkRequest(request);
		
		assertFalse(check);
	}
	
	@Test
	public void largeCogCheckRequest() {
MemberJudgeRequestDto request = new MemberJudgeRequestDto();
		
		//cogitation > 5
		request.setMemberName("tas");
		request.setCoordination(2);
		request.setCogitation(7);
		request.setEventPlanning(3);
		request.setInfrastructureKnowledge(3);
		request.setProgrammingAbility(2);
		
		boolean check = MemberJudgeServiceUtil.checkRequest(request);
		
		assertFalse(check);
	}
	@Test
	public void smallCoordinarionCheckRequest() {
MemberJudgeRequestDto request = new MemberJudgeRequestDto();
		
		//coordination < 0
		request.setMemberName("tas");
		request.setCoordination(-2);
		request.setCogitation(3);
		request.setEventPlanning(3);
		request.setInfrastructureKnowledge(3);
		request.setProgrammingAbility(2);
		
		boolean check = MemberJudgeServiceUtil.checkRequest(request);
		
		assertFalse(check);
	}
	
	@Test
	public void largeCoordinarionCheckRequest() {
MemberJudgeRequestDto request = new MemberJudgeRequestDto();
		
		//coordination > 5
		request.setMemberName("tas");
		request.setCoordination(7);
		request.setCogitation(3);
		request.setEventPlanning(3);
		request.setInfrastructureKnowledge(3);
		request.setProgrammingAbility(2);
		
		boolean check = MemberJudgeServiceUtil.checkRequest(request);
		
		assertFalse(check);
	}
	
	@Test
	public void smallEventPlanningCheckRequest() {
MemberJudgeRequestDto request = new MemberJudgeRequestDto();
		
		//eventPlanning < 0
		request.setMemberName("tas");
		request.setCoordination(3);
		request.setCogitation(3);
		request.setEventPlanning(-1);
		request.setInfrastructureKnowledge(3);
		request.setProgrammingAbility(2);
		
		boolean check = MemberJudgeServiceUtil.checkRequest(request);
		
		assertFalse(check);
	}
	
	@Test
	public void largeEventPlanningCheckRequest() {
MemberJudgeRequestDto request = new MemberJudgeRequestDto();
		
		//eventPlanning > 5
		request.setMemberName("tas");
		request.setCoordination(4);
		request.setCogitation(3);
		request.setEventPlanning(8);
		request.setInfrastructureKnowledge(3);
		request.setProgrammingAbility(2);
		
		boolean check = MemberJudgeServiceUtil.checkRequest(request);
		
		assertFalse(check);
	}
	
	@Test
	public void smallInfrastructureKnowledgeCheckRequest() {
MemberJudgeRequestDto request = new MemberJudgeRequestDto();
		
		//infrastructureKnowledge < 0
		request.setMemberName("tas");
		request.setCoordination(5);
		request.setCogitation(3);
		request.setEventPlanning(3);
		request.setInfrastructureKnowledge(-1);
		request.setProgrammingAbility(2);
		
		boolean check = MemberJudgeServiceUtil.checkRequest(request);
		
		assertFalse(check);
	}
	
	@Test
	public void largeInfrastructureKnowledgeCheckRequest() {
MemberJudgeRequestDto request = new MemberJudgeRequestDto();
		
		//infrastructureKnowledge > 5
		request.setMemberName("tas");
		request.setCoordination(5);
		request.setCogitation(3);
		request.setEventPlanning(3);
		request.setInfrastructureKnowledge(7);
		request.setProgrammingAbility(2);
		
		boolean check = MemberJudgeServiceUtil.checkRequest(request);
		
		assertFalse(check);
	}
	
	@Test
	public void smallProgrammimgAbilityCheckRequest() {
MemberJudgeRequestDto request = new MemberJudgeRequestDto();
		
		//ProgrammimgAbility < 0
		request.setMemberName("tas");
		request.setCoordination(5);
		request.setCogitation(3);
		request.setEventPlanning(3);
		request.setInfrastructureKnowledge(5);
		request.setProgrammingAbility(-9);
		
		boolean check = MemberJudgeServiceUtil.checkRequest(request);
		
		assertFalse(check);
	}
	
	@Test
	public void largeProgrammimgAbilityCheckRequest() {
MemberJudgeRequestDto request = new MemberJudgeRequestDto();
		
		//ProgrammimgAbility > 5
		request.setMemberName("tas");
		request.setCoordination(5);
		request.setCogitation(3);
		request.setEventPlanning(3);
		request.setInfrastructureKnowledge(4);
		request.setProgrammingAbility(8);
		
		boolean check = MemberJudgeServiceUtil.checkRequest(request);
		
		assertFalse(check);
	}

	private void assertFalse(boolean check) {
		// TODO 自動生成されたメソッド・スタブ
		
	}
	
}
