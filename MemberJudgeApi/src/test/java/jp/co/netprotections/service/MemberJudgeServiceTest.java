package jp.co.netprotections.service;

//import static org.hamcrest.CoreMatchers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import jp.co.netprotections.service.impl.*;
import jp.co.netprotections.dto.*;


//Testメソッド：個別のリクエストについて包括的に判定するメソッド
public class MemberJudgeServiceTest {
	
	//通常のリクエスト
	@Test
	public void normalFinalJudge() {
		
		//testしたいクラス（ServiceImplクラス）を呼び出し、インスタンスを作成
		MemberJudgeServiceImpl test = new MemberJudgeServiceImpl();
		
		//通常のリクエスト
		MemberJudgeRequestDto request = new MemberJudgeRequestDto();
		
				request.setMemberName("tas");
				request.setCoordination(2);
				request.setCogitation(3);
				request.setEventPlanning(3);
				request.setInfrastructureKnowledge(3);
				request.setProgrammingAbility(2);
		
		MemberJudgeResponseDto result = test.finalJudge(request);
		
		MemberJudgeResponseDto expectedResponse = new  MemberJudgeResponseDto();
		expectedResponse.setMemberName("tas");
		expectedResponse.setEnlistedProperiety(true);
		
		assertEquals(result.getMemberName(), expectedResponse.getMemberName());
		assertEquals(result.isEnlistedProperiety(), expectedResponse.isEnlistedProperiety());
	}
	
		//nullNameのリクエスト
		@Test
		public void nullFinalJudge() {
			
			//testしたいクラス（ServiceImplクラス）を呼び出し、インスタンスを作成
			MemberJudgeServiceImpl test = new MemberJudgeServiceImpl();
			
			//nullNameのリクエスト
			MemberJudgeRequestDto request = new MemberJudgeRequestDto();
			
			//check
			request.setMemberName(null);
			
			request.setCoordination(2);
			request.setCogitation(3);
			request.setEventPlanning(3);
		    request.setInfrastructureKnowledge(3);
			request.setProgrammingAbility(2);
			
			MemberJudgeResponseDto result = test.finalJudge(request);
			
			MemberJudgeResponseDto expectedResponse = new  MemberJudgeResponseDto();
			expectedResponse.setMemberName(null);
			expectedResponse.setEnlistedProperiety(false);
			
			assertEquals(result.getMemberName(), expectedResponse.getMemberName());
			assertEquals(result.isEnlistedProperiety(), expectedResponse.isEnlistedProperiety());
		
	}

		//cogitation < 0
		@Test
		public void smallCogFinalJudge() {
			
			//testしたいクラス（ServiceImplクラス）を呼び出し、インスタンスを作成
			MemberJudgeServiceImpl test = new MemberJudgeServiceImpl();
			
			//cogitation < 0 のリクエスト
			MemberJudgeRequestDto request = new MemberJudgeRequestDto();
			
			request.setMemberName("tas");
			request.setCoordination(2);
			
			//check
			request.setCogitation(-3);
			
			request.setEventPlanning(3);
			request.setInfrastructureKnowledge(3);
			request.setProgrammingAbility(2);
			
			MemberJudgeResponseDto result = test.finalJudge(request);
			
			MemberJudgeResponseDto expectedResponse = new  MemberJudgeResponseDto();
			expectedResponse.setMemberName(null);
			expectedResponse.setEnlistedProperiety(false);
			
			assertEquals(result.getMemberName(), expectedResponse.getMemberName());
			assertEquals(result.isEnlistedProperiety(), expectedResponse.isEnlistedProperiety());
		
	}
		
		//cogitation > 5
				@Test
				public void largeCogFinalJudge() {
					
			//testしたいクラス（ServiceImplクラス）を呼び出し、インスタンスを作成
			MemberJudgeServiceImpl test = new MemberJudgeServiceImpl();
					
			//cogitation > 5 のリクエスト
			MemberJudgeRequestDto request = new MemberJudgeRequestDto();
					
					request.setMemberName("tas");
					request.setCoordination(2);
					
					//check
					request.setCogitation(8);
					
					request.setEventPlanning(3);
					request.setInfrastructureKnowledge(3);
					request.setProgrammingAbility(2);
					
			MemberJudgeResponseDto result = test.finalJudge(request);
					
			MemberJudgeResponseDto expectedResponse = new  MemberJudgeResponseDto();
			expectedResponse.setMemberName(null);
			expectedResponse.setEnlistedProperiety(false);
					
			assertEquals(result.getMemberName(), expectedResponse.getMemberName());
			assertEquals(result.isEnlistedProperiety(), expectedResponse.isEnlistedProperiety());
				
			}
				
	//coordination < 0
	@Test
	public void smallCoordinationFinalJudge() {
					
		//testしたいクラス（ServiceImplクラス）を呼び出し、インスタンスを作成
		MemberJudgeServiceImpl test = new MemberJudgeServiceImpl();
					
		//cogitation < 0 のリクエスト
		MemberJudgeRequestDto request = new MemberJudgeRequestDto();
					
		request.setMemberName("tas");
		
		//check
		request.setCoordination(-2);
		
		request.setCogitation(3);
		request.setEventPlanning(3);
		request.setInfrastructureKnowledge(3);
		request.setProgrammingAbility(2);
					
		MemberJudgeResponseDto result = test.finalJudge(request);
					
		MemberJudgeResponseDto expectedResponse = new  MemberJudgeResponseDto();
		expectedResponse.setMemberName(null);
		expectedResponse.setEnlistedProperiety(false);
					
		assertEquals(result.getMemberName(), expectedResponse.getMemberName());
		assertEquals(result.isEnlistedProperiety(), expectedResponse.isEnlistedProperiety());
				
			}
				
		//coordination > 5
		@Test
		public void largeCoordinationFinalJudge() {
							
		//testしたいクラス（ServiceImplクラス）を呼び出し、インスタンスを作成
		MemberJudgeServiceImpl test = new MemberJudgeServiceImpl();
							
		//coordination > 5 のリクエスト
	    MemberJudgeRequestDto request = new MemberJudgeRequestDto();
							
		request.setMemberName("tas");
		
		//check
		request.setCoordination(9);
		
		request.setCogitation(2);
		request.setEventPlanning(3);
		request.setInfrastructureKnowledge(3);
		request.setProgrammingAbility(2);
							
		MemberJudgeResponseDto result = test.finalJudge(request);
							
		MemberJudgeResponseDto expectedResponse = new  MemberJudgeResponseDto();
		expectedResponse.setMemberName(null);
		expectedResponse.setEnlistedProperiety(false);
							
		assertEquals(result.getMemberName(), expectedResponse.getMemberName());
		assertEquals(result.isEnlistedProperiety(), expectedResponse.isEnlistedProperiety());
						
					}		
		
		
		//eventPlanning < 0
		@Test
		public void smallEvPlanFinalJudge() {
							
		//testしたいクラス（ServiceImplクラス）を呼び出し、インスタンスを作成
	    MemberJudgeServiceImpl test = new MemberJudgeServiceImpl();
							
		//eventPlanning < 0 のリクエスト
		MemberJudgeRequestDto request = new MemberJudgeRequestDto();
							
		request.setMemberName("tas");
		request.setCoordination(2);
		request.setCogitation(3);
		
		//check
		request.setEventPlanning(-3);
		
		request.setInfrastructureKnowledge(3);
		request.setProgrammingAbility(2);
							
		MemberJudgeResponseDto result = test.finalJudge(request);
							
		MemberJudgeResponseDto expectedResponse = new  MemberJudgeResponseDto();
		expectedResponse.setMemberName(null);
		expectedResponse.setEnlistedProperiety(false);
							
		assertEquals(result.getMemberName(), expectedResponse.getMemberName());
	    assertEquals(result.isEnlistedProperiety(), expectedResponse.isEnlistedProperiety());
						
	}
						
		//EventPanning > 5
		@Test
		public void largeEvPlanFinalJudge() {
									
			//testしたいクラス（ServiceImplクラス）を呼び出し、インスタンスを作成
			MemberJudgeServiceImpl test = new MemberJudgeServiceImpl();
									
			//cogitation > 5 のリクエスト
			MemberJudgeRequestDto request = new MemberJudgeRequestDto();
									
			request.setMemberName("tas");
			request.setCoordination(2);
			request.setCogitation(2);
			
			//check
			request.setEventPlanning(80);
			
			request.setInfrastructureKnowledge(3);
			request.setProgrammingAbility(2);
									
			MemberJudgeResponseDto result = test.finalJudge(request);
									
			MemberJudgeResponseDto expectedResponse = new  MemberJudgeResponseDto();
			expectedResponse.setMemberName(null);
			expectedResponse.setEnlistedProperiety(false);
									
			assertEquals(result.getMemberName(), expectedResponse.getMemberName());
			assertEquals(result.isEnlistedProperiety(), expectedResponse.isEnlistedProperiety());
								
			}			
		
			//infrastructureKnowledge < 0
			@Test
			public void smallInfraKnowledgeFinalJudge() {
									
			//testしたいクラス（ServiceImplクラス）を呼び出し、インスタンスを作成
			MemberJudgeServiceImpl test = new MemberJudgeServiceImpl();
									
			//infrastructureKnowledge < 0 のリクエスト
			MemberJudgeRequestDto request = new MemberJudgeRequestDto();
			request.setMemberName("tas");
			request.setCoordination(2);
			request.setCogitation(3);
			request.setEventPlanning(3);
			
			//check
			request.setInfrastructureKnowledge(-3);
			
			request.setProgrammingAbility(2);
									
			MemberJudgeResponseDto result = test.finalJudge(request);
									
			MemberJudgeResponseDto expectedResponse = new  MemberJudgeResponseDto();
			expectedResponse.setMemberName(null);
			expectedResponse.setEnlistedProperiety(false);
									
			assertEquals(result.getMemberName(), expectedResponse.getMemberName());
			assertEquals(result.isEnlistedProperiety(), expectedResponse.isEnlistedProperiety());
								
	 	}
			
			//infrastructureKnowledge > 5
			@Test
			public void largeInfraKnowledgeFinalJudge() {
									
			//testしたいクラス（ServiceImplクラス）を呼び出し、インスタンスを作成
			MemberJudgeServiceImpl test = new MemberJudgeServiceImpl();
									
			//infrastructureKnowledge > 5 のリクエスト
			MemberJudgeRequestDto request = new MemberJudgeRequestDto();
			request.setMemberName("tas");
			request.setCoordination(2);
			request.setCogitation(3);
			request.setEventPlanning(3);
			
			//check
			request.setInfrastructureKnowledge(30);
			
			request.setProgrammingAbility(2);
									
			MemberJudgeResponseDto result = test.finalJudge(request);
									
			MemberJudgeResponseDto expectedResponse = new  MemberJudgeResponseDto();
			expectedResponse.setMemberName(null);
			expectedResponse.setEnlistedProperiety(false);
									
			assertEquals(result.getMemberName(), expectedResponse.getMemberName());
			assertEquals(result.isEnlistedProperiety(), expectedResponse.isEnlistedProperiety());
								
	 	}	
			
			//programmingAbility < 0
			@Test
			public void smallPgAbilityFinalJudge() {
									
			//testしたいクラス（ServiceImplクラス）を呼び出し、インスタンスを作成
			MemberJudgeServiceImpl test = new MemberJudgeServiceImpl();
									
			//programmingAbility < 0 のリクエスト
			MemberJudgeRequestDto request = new MemberJudgeRequestDto();
			request.setMemberName("tas");
			request.setCoordination(2);
			request.setCogitation(3);
			request.setEventPlanning(3);
			request.setInfrastructureKnowledge(3);
			
			//check
			request.setProgrammingAbility(-2);
									
			MemberJudgeResponseDto result = test.finalJudge(request);
									
			MemberJudgeResponseDto expectedResponse = new  MemberJudgeResponseDto();
			expectedResponse.setMemberName(null);
			expectedResponse.setEnlistedProperiety(false);
									
			assertEquals(result.getMemberName(), expectedResponse.getMemberName());
			assertEquals(result.isEnlistedProperiety(), expectedResponse.isEnlistedProperiety());
								
	 	}	
		
			//programmingAbility > 5
			@Test
			public void largePgAbilityFinalJudge() {
									
			//testしたいクラス（ServiceImplクラス）を呼び出し、インスタンスを作成
			MemberJudgeServiceImpl test = new MemberJudgeServiceImpl();
									
			//programmingAbility > 5 のリクエスト
			MemberJudgeRequestDto request = new MemberJudgeRequestDto();
			request.setMemberName("tas");
			request.setCoordination(2);
			request.setCogitation(3);
			request.setEventPlanning(3);
			request.setInfrastructureKnowledge(3);
			
			//check
			request.setProgrammingAbility(20);
									
			MemberJudgeResponseDto result = test.finalJudge(request);
									
			MemberJudgeResponseDto expectedResponse = new  MemberJudgeResponseDto();
			expectedResponse.setMemberName(null);
			expectedResponse.setEnlistedProperiety(false);
									
			assertEquals(result.getMemberName(), expectedResponse.getMemberName());
			assertEquals(result.isEnlistedProperiety(), expectedResponse.isEnlistedProperiety());
								
	 	}
			
			
		//cog = 1
		@Test
		public void cog1FinalJudge() {
					
		//testしたいクラス（ServiceImplクラス）を呼び出し、インスタンスを作成
		MemberJudgeServiceImpl test = new MemberJudgeServiceImpl();
					
		//cogitation = 1のリクエスト
		MemberJudgeRequestDto request = new MemberJudgeRequestDto();
					
				request.setMemberName("tas");
				request.setCoordination(2);
				
				//check
				request.setCogitation(1);
				
				request.setEventPlanning(3);
				request.setInfrastructureKnowledge(3);
				request.setProgrammingAbility(2);
					
		MemberJudgeResponseDto result = test.finalJudge(request);
					
		MemberJudgeResponseDto expectedResponse = new  MemberJudgeResponseDto();
		expectedResponse.setMemberName("tas");
		expectedResponse.setEnlistedProperiety(false);
					
		assertEquals(result.getMemberName(), expectedResponse.getMemberName());
		assertEquals(result.isEnlistedProperiety(), expectedResponse.isEnlistedProperiety());
				
			}
				
	//coordination=1 
	@Test
	public void coordination1FinalJudge() {
					
		//testしたいクラス（ServiceImplクラス）を呼び出し、インスタンスを作成
		MemberJudgeServiceImpl test = new MemberJudgeServiceImpl();
					
		//coordination = 1のリクエスト
		MemberJudgeRequestDto request = new MemberJudgeRequestDto();
					
				request.setMemberName("tas");
				
				//check
				request.setCoordination(1);
				
				request.setCogitation(2);
				request.setEventPlanning(3);
				request.setInfrastructureKnowledge(3);
				request.setProgrammingAbility(2);
					
		MemberJudgeResponseDto result = test.finalJudge(request);
					
		MemberJudgeResponseDto expectedResponse = new  MemberJudgeResponseDto();
		expectedResponse.setMemberName("tas");
		expectedResponse.setEnlistedProperiety(false);
					
		assertEquals(result.getMemberName(), expectedResponse.getMemberName());
		assertEquals(result.isEnlistedProperiety(), expectedResponse.isEnlistedProperiety());
				
			}
			
	@Test
	public void EvPlan1FinalJudge() {
		
		//testしたいクラス（ServiceImplクラス）を呼び出し、インスタンスを作成
		MemberJudgeServiceImpl test = new MemberJudgeServiceImpl();
					
		//eventPlanning = 1のリクエスト
		MemberJudgeRequestDto request = new MemberJudgeRequestDto();
					
				request.setMemberName("tas");
				request.setCoordination(3);
				request.setCogitation(3);
				
				//check
				request.setEventPlanning(1);
				
				request.setInfrastructureKnowledge(3);
				request.setProgrammingAbility(2);
					
		MemberJudgeResponseDto result = test.finalJudge(request);
					
		MemberJudgeResponseDto expectedResponse = new  MemberJudgeResponseDto();
		expectedResponse.setMemberName("tas");
		expectedResponse.setEnlistedProperiety(false);
					
		assertEquals(result.getMemberName(), expectedResponse.getMemberName());
		assertEquals(result.isEnlistedProperiety(), expectedResponse.isEnlistedProperiety());
				
			}
			
	@Test
	public void scoreFinalJudge() {
					
		//testしたいクラス（ServiceImplクラス）を呼び出し、インスタンスを作成
		MemberJudgeServiceImpl test = new MemberJudgeServiceImpl();
					
		//totalScore <= 10のリクエスト
		MemberJudgeRequestDto request = new MemberJudgeRequestDto();
					
				request.setMemberName("tas");
				request.setCoordination(2);
				request.setCogitation(2);
				request.setEventPlanning(2);
				request.setInfrastructureKnowledge(1);
				request.setProgrammingAbility(0);
					
		MemberJudgeResponseDto result = test.finalJudge(request);
					
		MemberJudgeResponseDto expectedResponse = new  MemberJudgeResponseDto();
		expectedResponse.setMemberName("tas");
		expectedResponse.setEnlistedProperiety(false);
					
		assertEquals(result.getMemberName(), expectedResponse.getMemberName());
		assertEquals(result.isEnlistedProperiety(), expectedResponse.isEnlistedProperiety());
				
			}
				
}