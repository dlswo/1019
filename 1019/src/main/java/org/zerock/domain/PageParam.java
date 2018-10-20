package org.zerock.domain;

import org.springframework.web.util.UriComponentsBuilder;

import lombok.Data;

@Data
public class PageParam {

	private static final double PER = 5.0;
	private int page;
	private int display;
	
	private int total, start, end, bno;
	private boolean prev, next;
	
	public PageParam() {
		this.page = 1;
		this.display = 20;
	}
	
	public int getSkip() {
		return (this.page - 1) * this.display;
	}
	
	public void setTotal(int total) {
		this.total = total;
		
		this.end = (int)(Math.ceil(this.page/PER) * 5);
		this.start = this.end - 4 ;
		
		if((this.end * this.display) >= total) {
			this.end = (int)(Math.ceil(total/20.0));
			this.next = false;
		}else {
			this.next = true;
		}
		
		this.prev = this.start != 1;
	}
	
	public String getLink(String path) {
		
		return UriComponentsBuilder.fromPath(path)
		.queryParam("bno", this.bno)
		.queryParam("page", this.page)
		.toUriString();
	}
	
	public static void main(String[] args) {
		
		PageParam obj = new PageParam();
		obj.setBno(123);
		obj.setPage(7);
		
		System.out.println(obj);
		System.out.println(obj.getLink("redirect:/board/read"));
		
	}
	
	
}
