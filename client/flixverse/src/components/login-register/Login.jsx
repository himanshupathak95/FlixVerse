import React, { useState } from "react";
import "./LoginRegister.css"
export const Login = (props) => {
    const [email, setEmail] = useState('');
    const [pass, setPass] = useState('');
    const [currentForm, setCurrentForm] = useState('login');
    const handleSubmit = (e) => {
        e.preventDefault();
        console.log(email);
    }

    const toggleForm = (formName) => {
        setCurrentForm(formName);
    }

    return (
        <div className="auth-form-container login-page">
            <h2>Login</h2>
            <form className="login-form" onSubmit={handleSubmit}>
                <label htmlFor="email">Email</label>
                <input value={email} onChange={(e) => setEmail(e.target.value)} type="email" placeholder="youremail@gmail.com" id="email" name="email" />
                <label htmlFor="password">Password</label>
                <input value={pass} onChange={(e) => setPass(e.target.value)} type="password" placeholder="********" id="password" name="password" />
                <label htmlFor="password"></label>
                <button type="submit">Log In</button>
            </form>
            <button className="link-btn" onClick={() => toggleForm }>Don't have an account? Register here</button>
        </div>
    )
}