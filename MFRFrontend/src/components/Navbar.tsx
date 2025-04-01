import { AppBar, Toolbar, Typography, Button, Box } from "@mui/material";
import { Link, useNavigate } from "react-router-dom";

const Navbar: React.FC = () => {
    // Declate Navigate - to make it short for userNavigate() hooks
    const navigate = useNavigate();

    // Redirects to the login page
    const handleLogin = () => {
      navigate("/login");               
    };

    // Return
    return (
        <>
            <AppBar sx={{ bgcolor: "primary.main", position:"fixed", width: "100%", margin: 0, mb: 6 }}>
                <Toolbar>
                    {/* Logo on the left */}
                    <Box component={Link} to="/" sx={{ display: "flex", alignItems: "center" }}>
                        <img
                        src="/logo/tfj_logo.png" // Adjust the path to your logo image
                        style={{ height: "100px", marginRight: "8px" }}
                        />
                    </Box>
                    
                    {/* Website Text */}
                    <Typography 
                        component={Link} to="/"
                        variant="h2" 
                        sx={{flexGrow: 1, 
                            fontFamily: "Berkshire Swash, cursive",
                            textDecoration: "none",
                            color: "#424242"}}
                    >
                            The Food Journey
                    </Typography>
                    
                    {/* Login button */}
                    <Button onClick={handleLogin}>Login</Button>
                </Toolbar>
            </AppBar>
        </>
    );
};

export default Navbar;