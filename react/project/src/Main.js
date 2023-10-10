import {useState} from "react";

function Main(){
	// 컴포넌트에서 유지되는 배열을 선언 (렌더링(새로고침) 할 때 마다 그 값을 유지 할 수 있다.)
	let [page, setPage] = useState(10); // [10,f]page에는 10을 집어넣어주고 setPage에는 function을 집어 넣어준다.

	const leftBtnClick = ()=> {
		// setPage를 이용하면 클릭 할 때 마다 렌더링이 일어난다.
		setPage(page == 1 ? 13 : page-1);
	}
	const rightBtnClick = ()=> {
		setPage(page == 13 ? 1 : page+1);
	}

  return(
    <main>
			<div>
				<button onClick={leftBtnClick}>-</button>
				<span>{page} /13</span>
				<button onClick={rightBtnClick}>+</button>
			</div>
		</main>
  )
}

export default Main;