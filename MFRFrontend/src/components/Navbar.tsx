import { AppBar, Toolbar, Typography, Button } from "@mui/material";

const Navbar: React.FC = () => {
    return (
        <>
            <AppBar position="static" sx={{ bgcolor: "primary.main" }}>
                <Toolbar>
                    <Typography variant="h6" sx={{flexGrow: 1}}>My Favourite Recipe | By Raymond Chandra</Typography>
                    <Button>Login</Button>
                </Toolbar>
            </AppBar>
        </>
    );
};

export default Navbar;