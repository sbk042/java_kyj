import {BrowserRouter, Routes, Route} from 'react-router-dom'
import Home from './Home';
import Header from './Header';
import Insert from './Insert';
import {useState} from 'react'

function App() {
  let [list, setList] = useState([{
    num : 1,
    title : '공지사항',
    writer : 'admin'
  },{
    num : 2,
    title : '첫번재 게시글',
    writer : 'qwer'
  }]);
  // deleteBoard
  const deleteBoard = (num)=>{
    // 내가 삭제 하려는 번호와 갖지 않다면 하나의 tmpList로 만들어 버림
    let tmpList = list.filter(item=>item.num != num);
    setList(tmpList);
  }
  const addBoard = (board)=>{
    setList([board, ...list]);
  }
  return (
    <BrowserRouter>
      <Header/>
      <Routes>
        <Route path="/" exact element={<Home list={list} deleteBoard={deleteBoard} add={addBoard}/>} />
        <Route path='/insert' element={<Insert/>}/>
      </Routes>
    </BrowserRouter>
  );
}

export default App;
