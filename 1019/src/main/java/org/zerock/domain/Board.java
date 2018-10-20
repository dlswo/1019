package org.zerock.domain;

import java.util.Date;

import lombok.Data;

@Data
public class Board {

	private Integer bno;
	private String title, content, writer;
	private Date regdate, updatedate;
}
