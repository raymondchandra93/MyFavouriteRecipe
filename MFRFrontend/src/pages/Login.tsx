import { TextField, Button, Container, Card, CardContent, Typography } from "@mui/material";

const Login: React.FC = () => {
    // Use State
    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");
    const navigate = useNavigate(); // For navigation
  

    // Runs after the initial render
    const handleSubmit = (event: React.FormEvent) => {
        event.preventDefault();
        console.log("Login attempt with:", email, password);
        
        // Mock authentication (Replace with real API call)
        if (email === "admin@example.com" && password === "password") {
          alert("Login Successful!");
          navigate("/dashboard"); // Redirect after login
        } else {
          alert("Invalid email or password!");
        }
    };

    // Return
    return (
        <>
            <Container maxWidth="md">
                <Card variant="outlined" sx={{ mt: 10, p: 3, textAlign: "center" }}>
                    <CardContent>
                        <Typography variant="h5" gutterBottom>
                            Login
                        </Typography>
                        <form onSubmit={handleSubmit}>
                            <TextField
                                fullWidth
                                label="Email"
                                margin="normal"
                                variant="outlined"
                                value={email}
                                onChange={(e) => setEmail(e.target.value)}
                            />
                            <TextField
                                fullWidth
                                label="Password"
                                type="password"
                                margin="normal"
                                variant="outlined"
                                value={password}
                                onChange={(e) => setPassword(e.target.value)}
                            />
                            <Button type="submit" variant="contained" color="primary" fullWidth sx={{ mt: 2 }}>
                                Login
                            </Button>
                        </form>
                    </CardContent>
                </Card>
            </Container>
        </>
    );
};

export default Login;