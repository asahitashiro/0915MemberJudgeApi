package jp.co.netprotections.service.impl;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;

import jp.co.netprotections.service.*;
import jp.co.netprotections.dto.*;
import jp.co.netprotections.service.util.*;

@Service
public class MemberJudgeServiceImpl implements MemberJudgeService {
	
	
	@Override
	//判定クラス
	public MemberJudgeResponseDto finalJudge(MemberJudgeRequestDto request) {
		
		MemberJudgeResponseDto response = new MemberJudgeResponseDto();
		
		if(request.getMemberName()==null||
				request.getMemberName()== "") {
			//例外処理１：名前がおかしいやつは判定しない
			response.setMemberName(null);
			response.setEnlistedProperiety(false);
			return response;
		}
		//例外処理２：値がおかしいやつは判定しない
		//値の判定は　servive.util package　で独立に定義
		else if(MemberJudgeServiceUtil.checkRequest(request) == false) {
			response.setMemberName(null);
			response.setEnlistedProperiety(false);
			return response;
		}
		else {
			//まともなやつはきちんと判定
			response.setMemberName(request.getMemberName());
			//判定ロジックは　servive.util package　で独立に定義
			response.setEnlistedProperiety(MemberJudgeServiceUtil.judge(request));
			return response;
		}
			
		
		
	}
	
	@Override
	//Controllerから呼び出すクラス
	//リクエストの「リスト」についてレスポンスの「リスト」を作成する
	public memberCandidatesResultListDto makeResponse(memberCandidatesListDto requestList) {
		List<MemberJudgeResponseDto> JudgedList = new ArrayList<MemberJudgeResponseDto>();
		memberCandidatesResultListDto judgedCandidatesResultList = new memberCandidatesResultListDto();
	
		
		for (int i =0; i < requestList.getMemberCandidatesList().size() ; i++) {
			
			MemberJudgeRequestDto request = requestList.getRequestListData(i);
				//個々の処理は前述のメソッドで個別に定義
				MemberJudgeResponseDto response = finalJudge(request);
				JudgedList.add(response);
			}
		
		judgedCandidatesResultList.setJudgedCandidatesResultList(JudgedList);
		return judgedCandidatesResultList;
	}
}
