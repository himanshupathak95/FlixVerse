import React from "react";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faFire, faSearch } from "@fortawesome/free-solid-svg-icons";
import Button from "react-bootstrap/Button";
import Container from "react-bootstrap/Container";
import Nav from "react-bootstrap/Nav";
import Navbar from "react-bootstrap/Navbar";
import { NavLink, useNavigate } from "react-router-dom";
import { useAuth } from "../../AuthenticationContext"; // Replace with the actual path to your AuthenticationContext

const Header = () => {
  const { user, logout } = useAuth(); // Use the useAuth hook to get user info and logout function
  const navigate = useNavigate();

  const handleLogout = () => {
    logout(); // Call the logout function from the authentication context
    navigate('/'); // Redirect to the home page after logout
  };

  return (
      <Navbar bg="dark" variant="dark" expand="lg">
        <Container fluid>
          <Navbar.Brand href="/" style={{ color: "gold" }}>
            <FontAwesomeIcon icon={faFire} /> FlixVerse
          </Navbar.Brand>
          <Navbar.Toggle aria-controls="navbarScroll" />
          <Navbar.Collapse id="navbarScroll">
            <Nav className="me-auto my-2 my-lg-0" style={{ maxHeight: "100px" }} navbarScroll>
              <NavLink className="nav-link" to="/">
                Trending #10
              </NavLink>
              <NavLink className="nav-link" to="/explore">
                Explore
              </NavLink>
            </Nav>

            {/* Centered Search Bar */}
            <div className="mx-auto d-flex">
              <input
                  type="text"
                  placeholder="Search FlixVerse"
                  className="form-control me-2"
                  style={{ width: "500px", border: 0, height: "35px" }}
              />
              <Button variant="outline-light">
                <FontAwesomeIcon icon={faSearch} />
              </Button>
            </div>

            <Nav className="ms-auto">
              {user ? (
                  // Render user info and logout button if the user is logged in
                  <>
                    <span className="nav-link">Welcome, {user}</span>
                    <Button variant="outline-light" onClick={handleLogout}>
                      Logout
                    </Button>
                  </>
              ) : (
                  // Render login and register links if the user is not logged in
                  <>
                    <NavLink className="nav-link" to="/login">
                      Login
                    </NavLink>
                    <NavLink className="nav-link" to="/register">
                      Register
                    </NavLink>
                  </>
              )}
            </Nav>
          </Navbar.Collapse>
        </Container>
      </Navbar>
  );
};

export default Header;
