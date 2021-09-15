package jp.co.netprotections.dto;

import java.util.List;
import java.util.ArrayList;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class memberCandidatesResultListDto {

	private List<MemberJudgeResponseDto> judgedCandidatesResultList;
	public memberCandidatesResultListDto() {
			judgedCandidatesResultList = new ArrayList<MemberJudgeResponseDto>();
			}
	
}
