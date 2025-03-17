import { BottomNavigation, Box, Typography } from "@mui/material";

const Footer: React.FC = () => {
    return (
        <>
            <Box sx={{ bgcolor: "#E53935" }}>
                <Typography variant="body2" sx={{color: "white"}}>Copyright © Raymond Chandra 2025</Typography>
            </Box>
        </>
    );
};

export default Footer;