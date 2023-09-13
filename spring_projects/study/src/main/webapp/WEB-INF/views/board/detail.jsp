<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>게시글 상세</h1>
	<h3>제목 : ${board.bo_title }</h3>
	<h3>작성자 : ${board.bo_me_id }</h3>
	<h3>조회수 : ${board.bo_views }</h3>
	<hr>
	<div>${board.bo_contents }</div>
	<h3>첨부파일</h3>
	<c:forEach items="${fileList}" var="file">
		<a  href="<c:url 
			value='/download${file.fi_name}'/>" 
			download="${file.fi_ori_name }"
		>${file.fi_ori_name }</a> <br>
	</c:forEach>
	<div>${board.bo_contents }</div>
	<a href="<c:url value='/board/update?bo_num=${board.bo_num}'/>">수정</a>
	<a href="<c:url value='/board/delete?bo_num=${board.bo_num}'/>">삭제</a>
	<!-- 댓글 등록 시작 -->
	<hr>
	<h2>댓글</h2>
	<textarea rows="" cols="" placeholder="댓글 등록" id="inputComment"></textarea>
	<button id="btnCommentInsert">댓글 등록</button>
	<div class="box-comment">
		<ul class="comment-list">
			<li class="comment-item">
				<span class="comment-contents">댓글1</span>
				<span class="comment-writer">[작성자]</span>
				<button>수정</button>
				<button>삭제</button>
			</li>
		</ul>
		<div class="pagination">
			<a href="#"> 이전</a>
			<a href="#"> 1</a>
			<a href="#"> 다음</a>
		</div>
	</div>
	
	
	<script type="text/javascript" src="//code.jquery.com/jquery-3.6.1.js"></script>
	<script type="text/javascript">
		$('#btnCommentInsert').click(function(){
			let co_contents = $('#inputComment').val();
			let co_me_id = '${user.me_id}';
			let co_bo_num = '${board.bo_num}';
			
			// 만약 로그인 정보가 없으면 로그인을 해야하는 안내창을 띄운다.
			if(co_me_id == ''){
				if(confirm('로그인이 필요한 서비스입니다. 로그인하시겠습니까?')){
					// 로그인창으로 넘어가는 url입력
					location.href = '<c:url value="/member/login"/>'
				}
				return;
			}
			// 만약 댓글을 아무것도 입력을 안 하고 등록을 누르면 안내창이 뜬다.
			if(co_contents.trim() == ''){
				alert('댓글 내용을 입력하세요.');
				$('#inputComment').focus();
				return;
			}
			
			let comment = {
					co_contents : co_contents,
					co_me_id : co_me_id,
					co_bo_num : co_bo_num
			}
			/* 객체를 만들고 ajax로 보내준다. */
			$.ajax({
				async : false,
				method : 'post',
				url : '<c:url value="/comment/insert"/>',
				data: JSON.stringify(comment),
				contentType : 'application/json; charset=utf-8',
				dataType : 'json',
				success : function(data){ /*<= 이름을 꼭 data로 할 필요는 없다.  */
					if(data.res){
						alert('댓글 등록 성공');
						$('#inputComment').val('');
						cri.page = 1;
						getCommentList(cri);
					}else{
						alert('댓글 등록 실패');
					}
				}
			})
		});
		// 댓글을 삭제하는 버튼 기능실현
		// 중복이 안되므로 document로 만들어줘야한다.
		$(document).on('click', '.btn-del',function(){
			
			let comment = {
					// 내가 클릭한 버튼 중에 num이라는 데이터를 가져와주세요
					co_num : $(this).data('num')
			}
			
			// ajax로 서버에 전송
			$.ajax({
				async : false,
				method : 'post',
				url : '<c:url value="/comment/delete"/>',
				data: JSON.stringify(comment),
				contentType : 'application/json; charset=utf-8',
				dataType : 'json',
				success : function(data){ /*<= 이름을 꼭 data로 할 필요는 없다.  */
					if(data.res){
						alert('댓글 삭제 성공!')
						getCommentList(cri);
					}else{
						alert('댓글 삭제 실패!');
					}
				}
			});
		})
		// 댓글수정하기
		// 클래스는 . 을 붙여준다. => .btn-update
		$(document).on('click','.btn-update',function(){
			// 내가 클릭한수정 버튼에 부모중에서 comment item을 찾아서 comment-contents를 숨긴다. 
			// 자주 쓰기 위해서 item으로 저장해둔다.
			let item = $(this).parents('.comment-item');
			
			item.find('.comment-contents').hide();
			//작성자,수정버튼,삭제버튼 hide시키기
			item.find('.comment-writer').hide();
			item.find('.btn-update').hide();
			item.find('.btn-del').hide();
			
			// 내가 클릭한 수정완료 버튼의 co_num을 가져온다.
			let co_num = $(this).data('num');
			// 기존에 적어 놨던 댓글을 그대로 가져온다.
			let co_contents = item.find('.comment-contents').text();
			// 수정할 요소가 사라진 뒤 댓글을 수정할 수 있는 창이 뜬다.
			item.find('.comment-contents').after(`<textarea class="comment-update">\${co_contents}</textarea>`);
			// 수정 완료 버튼 추가
			item.find('.btn-del').after(`<button class="btn-complete" data-num="\${co_num}">수정완료</button>`);
			
		});
		// 수정완료버튼 btn-copmplete를 클릭 했을 때
		$(document).on('click','.btn-complete',function(){
			// 내가 클릭한 data의 num을 가져온다.( 댓글 번호 )
			let co_num = $(this).data('num');
			let co_contents = $(this).parents('.comment-item').find('.comment-update').val(); // val() : value값을 가져온다.
			let comment = {
				co_num : co_num,
				co_contents : co_contents
				// ajax로 넘길 준비 완료
			}
			$.ajax({
				async : false,
				method : 'post',
				url : '<c:url value="/comment/update"/>',
				data: JSON.stringify(comment),
				contentType : 'application/json; charset=utf-8',
				dataType : 'json',
				success : function(data){ /*<= 이름을 꼭 data로 할 필요는 없다.  */
					console.log(data)
					if(data.res){
						alert('댓글 수정 성공!')
						getCommentList(cri);
					}else{
						alert('댓글 수정 실패!');
					}
				}
			});
		})
		
		let cri ={
				page : 1, // 기본 페이지
				perPageNum : 3, // 한번에 몇페이지 까지 볼 수 있는지 정하기
				
		}
		getCommentList(cri);
		
		// 현재 페이지 정보(Cri)를 주면서 
		function getCommentList(cri){
			$.ajax({
				async : false,
				method : 'post',
				url : '<c:url value="/comment/list/"/>'+'${board.bo_num}',
				data: JSON.stringify(cri), //cri를 넣어준다.(현재페이지 정보를 보내줌)
				contentType : 'application/json; charset=utf-8',
				dataType : 'json',
				success : function(data){ /*<= 이름을 꼭 data로 할 필요는 없다.  */
					// 빈 문자열 선언해주고
					let str = '';
					for(comment of data.list){
						let btnStr = '';
						if('${user.me_id}' == comment.co_me_id){
							btnStr = `
								<button class="btn-update" data-num="\${comment.co_num}">수정</button>
								<button class="btn-del" data-num="\${comment.co_num}">삭제</button>
							`;
						}
						str += `
						<li class="comment-item">
							<span class="comment-contents">\${comment.co_contents}</span>
							<span class="comment-writer">[\${comment.co_me_id}]</span>
							\${btnStr}
						</li>`
					}
					$('.comment-list').html(str);
					//< 페이지네이션 배치하기 >
					let pm = data.pm;
					//( 위에서 빈문자열로 선언해주고 썼음) 밑에서 다시 초기화해서 선언해준다.
					str = '';
					// 이전 버튼을 배치
					if(pm.prev){
					// 클릭 했을 때 페이지를 바꿔야 하므로 역다운표를 넣었다.
					// += : 이어붙이기
					// #을 이용하면 클릭 할 때마다 위로 올라가기 때문에 javascript:void(0)를 선언해서 c:url을 쓰지 않겠다는 뜻이다
						str += `<a href="javascript:void(0);" onclick="changePage(\${pm.startPage-1})">이전</a>`;
					}
					// 숫자 버튼을 배치( 여러개니까 숫자는 반복문 )
					for(i = pm.startPage; i<=pm.endPage; i++){
						str += `<a href="javascript:void(0);" onclick="changePage(\${i})"> \${i}</a>`
					}
					// 다음 버튼을 배치
					if(pm.next){
						str += `<a href="javascript:void(0);" onclick="changePage(\${pm.endPage+1})">다음</a>`
					}
					$('.pagination').html(str);
				}
			})
		}
		function changePage(page){
			cri.page = page;
			getCommentList(cri);
		}
	</script>
</body>
</html>