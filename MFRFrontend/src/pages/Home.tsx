import { useState, useEffect } from "react";
import { Box, Typography } from "@mui/material";
import { publicApi } from "../../src/api/api";

const Home: React.FC = () => {
    // Use State
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
            <Box sx={{ marginTop: "100px" }}>
                <Typography variant="h4">{demo}</Typography>
            </Box>
        </>
    );
};

export default Home;