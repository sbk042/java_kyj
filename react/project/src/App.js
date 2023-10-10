// Header.js로 부터 Header를 가져오겠다.
import Header from "./Header";
import Main from "./Main";
import Footer from "./Footer";

function App() {
  return (
    // 부모가 여러개이면 빨간 줄이 뜨기 때문에 하나의 닫는 태그 감싸 져야 한다.
    <div className="App">
      <Header/>
      <Main/>
      <Footer/>
    </div>
  );
}

// export default 내보내기를 해야 다른 js가 쓸 수 있음
export default App;
