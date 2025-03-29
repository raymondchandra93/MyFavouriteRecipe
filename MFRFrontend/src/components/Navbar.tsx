import { AppBar, Toolbar, Typography, Button } from "@mui/material";
import { useNavigate } from "react-router-dom";

const Navbar: React.FC = () => {
    const navigate = useNavigate();     // Hook for navigation
    const handleLogin = () => {
      navigate("/login");               // Redirects to the login page
    };

    // Return
    return (
        <>
            <AppBar position="static" sx={{ bgcolor: "primary.main" }}>
                <Toolbar>
                    <Typography variant="h6" sx={{flexGrow: 1}}>My Favourite Recipe | By Raymond Chandra</Typography>
                    <Button onClick={handleLogin}>Login</Button>
                </Toolbar>
            </AppBar>
        </>
    );
};

export default Navbar;