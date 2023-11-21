import React, { useState } from "react";
import "./LoginRegister.css";
import {Login} from "./Login";

export const Register = (props) => {
    const [email, setEmail] = useState("");
    const [pass, setPass] = useState("");
    const [name, setName] = useState("");

    const handleSubmit = async (e) => {
        e.preventDefault();

        try {
            const response = await fetch('http://localhost:8080/api/v1/register', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify({ userId: email, password: pass, name }),
            });

            const data = await response.json();

            if (data.success) {
                console.log('Registration successful');
                // Handle successful registration, e.g., redirect or show success message
            } else {
                console.error('Registration failed:', data.message);
                // Handle failed registration, e.g., show error message
            }
        } catch (error) {
            console.error('Error during registration:', error);
        }
    };

    return (
        <div className="auth-form-container login-page">
            <h2>Register</h2>
            <form className="register-form" onSubmit={handleSubmit}>
                <label htmlFor="name">Full name</label>
                <input
                    value={name}
                    name="name"
                    onChange={(e) => setName(e.target.value)}
                    id="name"
                    placeholder="full name"
                />
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
                <label htmlFor="password"> </label>
                <button type="submit">Register</button>
            </form>
            <button className="link-btn" onClick={Login}>
                Already have an account? Login here.
            </button>
        </div>
    );
};
