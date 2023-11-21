import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import "./LoginRegister.css";
import {Register} from "./Register";
import { useAuth } from '../../AuthenticationContext';

export const Login = (props) => {
    const [email, setEmail] = useState("");
    const [pass, setPass] = useState("");
    const [errorMessage, setErrorMessage] = useState("");
    const navigate = useNavigate(); // Use useNavigate hook to get the navigation function

    const handleSubmit = async (e) => {
        e.preventDefault();

        try {
            const response = await fetch('http://localhost:8080/api/v1/login', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify({ userId: email, password: pass }),
            });

            const data = await response.json();

            if (data.success) {
                console.log('Login successful');
                navigate('/', { state: { fromLogin: true } });
                props.userId
            } else {
                console.error('Login failed:', data.message);
                setErrorMessage('Incorrect credentials');
            }
        } catch (error) {
            console.error('Error during login:', error);
            setErrorMessage('An error occurred during login');
        }
    };

    return (
        <div className="auth-form-container login-page">
            <h2>Login</h2>
            {errorMessage && <p className="error-message">{errorMessage}</p>}
            <form className="login-form" onSubmit={handleSubmit}>
                <label htmlFor="email">Email</label>
                <input
                    value={email}
                    onChange={(e) => setEmail(e.target.value)}
                    type="email"
                    placeholder="youremail@gmail.com"
                    id="email"
                    name="email"
                />
                <label htmlFor="password">Password</label>
                <input
                    value={pass}
                    onChange={(e) => setPass(e.target.value)}
                    type="password"
                    placeholder="********"
                    id="password"
                    name="password"
                />
                <label htmlFor="password"></label>
                <button type="submit">Log In</button>
            </form>
            <button className="link-btn" onClick={Register}>
                Don't have an account? Register here
            </button>
        </div>
    );
};
