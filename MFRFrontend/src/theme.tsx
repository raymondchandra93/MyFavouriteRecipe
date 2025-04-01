import { createTheme } from "@mui/material/styles";

const themeRayOne = createTheme({
    palette: {
        primary: { main: "#FFF" },       // White color
        secondary: { main: "#ff4081" },     // Pink Color
        text: { primary: "#424242" },       // Deep Charcoal
        background: { default: "#F5F5F5", paper: "#FFFFFF" }, // Light Grey
    },
    typography: {
        fontFamily: "'Poppins', sans-serif",
    },
    components: {
        MuiButton: {
            styleOverrides: {
                root: {
                    backgroundColor: '#32373c', // Fiery Red
                    color: '#FFF', // White text
                    padding: '8px 16px',
                    borderRadius: '8px',
                    fontWeight: 'bold',
                    '&:hover': {
                        backgroundColor: '#4e5b62', // Accent color on hover
                    },
                },
            },
        },
    }
});

export default themeRayOne;