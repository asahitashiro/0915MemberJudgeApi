package jp.co.netprotections.dto;

import java.util.List;
import java.util.ArrayList;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class memberCandidatesListDto {
	private List<MemberJudgeRequestDto> memberCandidatesList;
	
	public memberCandidatesListDto() {
			memberCandidatesList = new ArrayList<MemberJudgeRequestDto>();
	}
	
	public MemberJudgeRequestDto getRequestListData(int index) {
		return memberCandidatesList.get(index);
	}
}