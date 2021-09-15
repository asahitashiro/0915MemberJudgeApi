package jp.co.netprotections.service.util;

import jp.co.netprotections.dto.MemberJudgeRequestDto;

public class MemberJudgeServiceUtil {
	public static boolean checkRequest(MemberJudgeRequestDto request) {
		if (request.getCogitation()<0||
				request.getCogitation()>5||
				request.getCoordination()<0||
				request.getCoordination()>5||
				request.getEventPlanning()<0||
				request.getEventPlanning()>5||
				request.getInfrastructureKnowledge()<0||
				request.getInfrastructureKnowledge()>5||
				request.getProgrammingAbility()<0||
				request.getProgrammingAbility()>5) {
			return false;
		}
		else {
			return true;
		}
	}
	
	public static int totalScore(MemberJudgeRequestDto request) {
		int Score = request.getCogitation()+request.getCoordination()+request.getEventPlanning()+request.getInfrastructureKnowledge()+request.getProgrammingAbility();
		return Score;
	}
	
	public static boolean judge(MemberJudgeRequestDto request) {
		if (request.getEventPlanning() > 1 &&
				request.getCogitation() > 1 &&
				request.getCoordination() > 1 &&
				totalScore(request) > 10
				){
				return true;
			}
			else {
			return false;
			}
	}
	
}