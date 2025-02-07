import { useState } from "react";


const Home: React.FC = () => {
    // Use State
    const [num, setNum] = useState(0);

    // Return
    return (
        <>
            <h1>Hello, this is Home</h1>
            <h2>Number is: {num}</h2>
            <button onClick={() => setNum(num + 1)}>Increase</button>
            <button onClick={() => setNum(num - 1)}>Decrease</button>
        </>
    );
};

export default Home;