package kr.kh.app.pagination;

import lombok.Data;

// 현재 페이지 정보를 나타내는 클래스
// 현재 몇 페이지인지, 어떤 검색어인지, 게시글 정렬 방법은 무엇인지 등등...
// 현재 페이지에 대한 정보를 다 가지고 있는 클래스이다.

@Data //간단하게 하기 위해서 data 어노테이션
public class Criteria {
	// 현재 페이지가 몇 페이지인지
	private int page;
	// 한 페이지에 게시글 수
	private int perPageNum;
	
	// 한 페이지에 게시글이 5개가 있고, 현재 페이지가 3페이지이면 
	// limit을 이용할 때 limit 10번지 부터, 5를 입력해야 하는데,
	// limit에서 시작 번지를 계산하는 getter
	public int getPageStart() {
		return (page -1) * perPageNum; // page가 1이면 0번지 부터 몇까지
	}

	public Criteria(int page, int perPageNum) {
		this.page = page;
		this.perPageNum = perPageNum;
	}
}
