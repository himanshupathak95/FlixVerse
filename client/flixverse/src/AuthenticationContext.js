// AuthenticationContext.js
import React, { createContext, useContext, useState } from 'react';
import { useNavigate } from 'react-router-dom';

// Create a context to manage authentication state
const AuthContext = createContext();

// Custom hook to access the authentication context
export const useAuth = () => {
    return useContext(AuthContext);
};

// AuthProvider component to wrap your app and provide authentication context
export const AuthProvider = ({ children }) => {
    const [user, setUser] = useState(null);
    const navigate = useNavigate(); // Access the navigate function

    const login = (userId) => {
        // Set the user after successful login
        setUser(userId);
        // Additional actions to perform on successful login
        onLoginSuccess(userId);
    };

    const logout = () => {
        // Clear the user on logout
        setUser(null);
    };

    // Provide the authentication context value
    const authContextValue = {
        user,
        login,
        logout,
    };

    // Function to handle actions on successful login
    const onLoginSuccess = (userId) => {
        // Example: You can perform additional actions here
        console.log(`User ${userId} logged in successfully.`);
        // Redirect to the home page with the username displayed on top right
        navigate('/', { state: { fromLogin: true } });
    };

    return <AuthContext.Provider value={authContextValue}>{children}</AuthContext.Provider>;
};
