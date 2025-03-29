import { useState, useEffect } from "react";
import { Box, Button, Typography } from "@mui/material";
import { publicApi } from "../../src/api/api";

const Home: React.FC = () => {
    // Use State
    const [num, setNum] = useState(0);
    const [demo, setDemo] = useState("");

    // Runs after the initial render
    useEffect(() => {

        // Fetch from public API
        publicApi.get("/demo")
          .then(response => setDemo(response.data))
          .catch(error => console.error("Error fetching public data:", error));

        // Console log the response
        console.log("The response data: ");
        console.log(demo);
    }, []);

    // Return
    return (
        <>
            <Box>
                <Typography variant="h4">Hello, this is Home</Typography>
                <br></br>
                <Typography variant="h6">Number is: <strong>{num}</strong></Typography>
                <Button onClick={() => setNum(num + 1)}>Increase</Button>
                <Button onClick={() => setNum(num - 1)}>Decrease</Button>
                <br></br>
                <Typography variant="h6">{demo}</Typography>
            </Box>
        </>
    );
};

export default Home;