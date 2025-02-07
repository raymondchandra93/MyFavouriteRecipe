import { AppBar, Toolbar, Typography } from "@mui/material";

const Navbar: React.FC = () => {
    return (
        <>
            <AppBar position="static">
                <Toolbar>
                    <Typography variant="h6">My Favourite Recipe | By Raymond Chandra</Typography>
                </Toolbar>
            </AppBar>
        </>
    );
};

export default Navbar;