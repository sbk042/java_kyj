import { useState } from "react";
import ContentsA from "./ContentsA";
import ContentsB from "./ContentsB";
import Box from "./Box";

function Body(){
	return(
		<div className="body">
			<Box className={"left"} maxPage={13} Contents={ContentsA}/>
			<Box className={"right"} maxPage={6} Contents={ContentsB}/>
		</div>
	);
}

/*
function Left(){
	// 최대 페이지를 13으로 maxPage라고 지정한다.
	const maxPage = 13;
	// 초기값이1로 시작하는 useState page를 만들었다.
	let[page, setPage] = useState(1);
	// pageUp이라는 이벤트 등록
	// prev 변수값임 변수이름은 아무거나 설정해도 상관이 없음
	// prev가 maxPage(13)과 같다면 다시 1로 돌아가고 아니면 prev+1인 값이 된다.
	const pageUp = ()=> setPage((prev)=>prev == maxPage ? 1 : prev+1);
	// prev가 1과 같다면 maxPage(13)으로 돌아가고 아니면 prev-1인 값이 된다.
	const pageDown = ()=> setPage((prev)=>prev == 1 ? maxPage : prev-1);
	return(
		<div className="left">
			<PageBox page={page} maxPage={maxPage} pageDown={pageDown} pageUp={pageUp}/>
			<div className="contents"></div>
			<PageBox page={page} maxPage={maxPage} pageDown={pageDown} pageUp={pageUp}/>
		</div>
	);
}
function PageBox({page, maxPage, pageDown, pageUp}){
	return(
		<div className="page-box">
				<a href="javascript:void(0);" className="page-btn" onClick={pageDown}>&lt;</a>
				<span className="page">{page} / {maxPage}</span>
				<a href="javascript:void(0);" className="page-btn" onClick={pageUp}>&gt;</a>
		</div>
	);
}
function Right(){
	// 최대 페이지를 6으로 만든다.
	const maxPage = 6;
	// 초기값이 1인 useState를 만든다.
	let [page, setPage] = useState(1);
	// pageUp, pageDown 이벤트 등록하기
	const pageUp = ()=> setPage((prev)=> prev == maxPage ? 1 : prev+1)
	const pageDown = ()=> setPage((prev)=>prev == 1 ? maxPage : prev-1)
	return(
		<div className="right">
			<PageBox page={page} maxPage={maxPage} pageDown={pageDown} pageUp={pageUp}/>
			<div className="contents"></div>
			<PageBox page={page} maxPage={maxPage} pageDown={pageDown} pageUp={pageUp}/>
		</div>
	);
}
*/
export default Body;