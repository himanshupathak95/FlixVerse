import {FontAwesomeIcon} from "@fortawesome/react-fontawesome";
import {faFire} from "@fortawesome/free-solid-svg-icons";
import Button from "react-bootstrap/Button";
import Container from "react-bootstrap/Container"
import Nav from "react-bootstrap/Nav";
import Navbar from "react-bootstrap/Navbar";
import {NavLink} from "react-router-dom";

const Header = () => {

  return (
      <Navbar bg="dark" variant="dark" expand="lg">
        <Container fluid>
          <Navbar.Brand href="/" style={{"color": 'gold'}}>
            <FontAwesomeIcon icon={faFire} /> FlixVerse
          </Navbar.Brand>
          <Navbar.Toggle aria-controls="navbarScroll"/>
          <Navbar.Collapse id="navbarScroll">
            <Nav
                className="me-auto my-2 my-lg-0"
                style={{maxHeight: '100px'}}
                navbarScroll
            >
              <NavLink className="nav-link" to="/">Trending #10</NavLink>
              <NavLink className="nav-link" to="/explore" >Explore</NavLink>
            </Nav>
            <Button variant="outline-info" className="me-2">Sign in</Button>
            <Button variant="outline-info" className="me-2">Register</Button>
          </Navbar.Collapse>
        </Container>
      </Navbar>
  )
}

export default Header