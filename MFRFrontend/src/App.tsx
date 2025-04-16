import './App.css'
import MainLayout from './layouts/MainLayout';
import Home from './pages/Home';
import Login from './pages/Login';
import NotFound from './pages/NotFound';
import About from './pages/About';
import { Route, Routes } from "react-router-dom";
import { BrowserRouter as Router} from "react-router-dom";
import { ThemeProvider } from '@mui/material';
import themeRayOne from './theme';

//function App() {
const App: React.FC = () => {
  return (
    <>
      <ThemeProvider theme={themeRayOne}>
        <Router>
          <Routes>
            <Route element={<MainLayout />}>
              <Route path="/" element={<Home />} />
              <Route path="/about" element={<About />} />
              <Route path="/login" element={<Login />} />
              <Route path="*" element={<NotFound />} />
            </Route>
          </Routes>
        </Router>
      </ThemeProvider>
    </>
  )
}

export default App;
