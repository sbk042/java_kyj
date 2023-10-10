import {useLocation} from 'react-router-dom'

function Home({list, deleteBoard, add}){
	//자식클래스에서는 부모로부터 가져온 내용이 수정이 안됨
	// 받아오기
	const location = useLocation();
	let board = location.state;
	if(board != null){
		add(board);
		location.state = null;
	}
	return(
		<main>
			<table>
				<thead>
					<tr>
						<th>번호</th>
						<th>제목</th>
						<th>작성자</th>
						<th>기능</th>
					</tr>
				</thead>
				<tbody>
					{list.length == 0 ? 
						<tr><th colSpan={4}><h1>등록된 게시글이 없습니다.</h1></th></tr> :
						list.map(item=>{
							return(
								<tr key={item.num}>
									<td>{item.num}</td>
									<td>{item.title}</td>
									<td>{item.writer}</td>
									<td><button onClick={()=>{deleteBoard(item.num)}}>삭제</button></td>
								</tr>
							)
						})
					}
				</tbody>
			</table>
		</main>
	)
}

export default Home;