import './css/App.css';
import './css/Footer.css';
import Menu from './Menu.js';
import Footer from './footer.js';
import Body from './Body.js';


function App() {
  
  return (
    <div className="menu">
      <Menu/>
      <Body/>
      <Footer/>
    </div>
  );
}

// App을 내보내는 코드
export default App;
