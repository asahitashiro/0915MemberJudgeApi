package jp.co.netprotections.service;

import org.springframework.stereotype.Service;

import jp.co.netprotections.dto.*;

@Service
public interface MemberJudgeService {
	public MemberJudgeResponseDto finalJudge(MemberJudgeRequestDto request);
	public memberCandidatesResultListDto makeResponse(memberCandidatesListDto requestList);
}