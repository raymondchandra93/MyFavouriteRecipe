import { useState } from "react";
import { Box, Button, Typography } from "@mui/material";

const Home: React.FC = () => {
    // Use State
    const [num, setNum] = useState(0);

    // Return
    return (
        <>
            <Box>
                <Typography variant="h4">Hello, this is Home</Typography>
                <Typography variant="h6">Number is: <strong>{num}</strong></Typography>
                <Button onClick={() => setNum(num + 1)}>Increase</Button>
                <Button onClick={() => setNum(num - 1)}>Decrease</Button>
            </Box>
        </>
    );
};

export default Home;