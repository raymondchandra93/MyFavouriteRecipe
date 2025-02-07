import Navbar from "../components/Navbar";
import Footer from "../components/Footer";
import { Outlet } from "react-router-dom";

const MainLayout: React.FC = () => {
    return (
      <>
        <Navbar />
        <main>
            <Outlet />
        </main>
        <Footer />
      </>
    );
};

export default MainLayout;