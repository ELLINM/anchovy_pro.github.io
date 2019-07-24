package com.test.web.vo;

import lombok.Data;

@Data
public class ReplyVO {
	private int replyNum;
	private int boardNum;
	private String userid;
	private String replytext;
	private String	inputdate;
}
