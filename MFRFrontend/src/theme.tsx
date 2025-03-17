import { createTheme } from "@mui/material/styles";

const themeRayOne = createTheme({
    palette: {
        primary: { main: "#E53935" }, // Fiery Red
        secondary: { main: "#FFC107" }, // Golden Yellow
        text: { primary: "#424242" }, // Deep Charcoal
        background: { default: "#F5F5F5", paper: "#FFFFFF" }, // Light Grey
    },
    typography: {
        fontFamily: "'Poppins', sans-serif",
    },
    components: {
        MuiButton: {
            styleOverrides: {
                root: {
                    backgroundColor: '#FFC107', // Fiery Red
                    color: '#000', // White text
                    padding: '8px 16px',
                    borderRadius: '8px',
                    fontWeight: 'bold',
                    '&:hover': {
                        backgroundColor: '#FFB300', // Accent color on hover
                    },
                },
            },
        },
    }
});

export default themeRayOne;