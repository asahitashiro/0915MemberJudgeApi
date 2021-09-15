package jp.co.netprotections.controller;

import java.util.Collections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;

import jp.co.netprotections.dto.*;
import jp.co.netprotections.service.*;

@RestController
public class MemberJudgeController {
	@Autowired
 	private MemberJudgeService memberJudgeService;

	@RequestMapping(value = "/api", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
 	
	@ResponseBody
		public memberCandidatesResultListDto execute(@RequestBody memberCandidatesListDto requestList) {
			try {
					return memberJudgeService.makeResponse(requestList);
				}
	
		catch(Exception e){
			return (memberCandidatesResultListDto) Collections.EMPTY_LIST;
		}
	}
}
