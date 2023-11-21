import {FontAwesomeIcon} from "@fortawesome/react-fontawesome";
import {faFire, faSearch} from "@fortawesome/free-solid-svg-icons";
import Button from "react-bootstrap/Button";
import Container from "react-bootstrap/Container"
import Nav from "react-bootstrap/Nav";
import Navbar from "react-bootstrap/Navbar";
import {NavLink} from "react-router-dom";

const Header = () => {

  // const [searchTerm, setSearchTerm] = useState("");
  // const [suggestions, setSuggestions] = useState([]);
  //
  // useEffect(() => {
  //   Make API call when searchTerm changes
  //   Use debounce/throttle to avoid making too many requests
  //   Update the suggestions state with the fetched data
  //   Example using fetch:
  //   fetch(`/api/search?term=${searchTerm}`)
  //     .then(response => response.json())
  //     .then(data => setSuggestions(data))
  //     .catch(error => console.error('Error fetching suggestions:', error));
  // }, [searchTerm]);

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

            {/* Centered Search Bar */}
            <div className="mx-auto d-flex">
              <input
                  type="text"
                  placeholder="Search FlixVerse"
                  className="form-control me-2"
                  style={{ width: '500px', border: 0, height: '35px' }}
              />
              <Button variant="outline-light">
                <FontAwesomeIcon icon={faSearch} />
              </Button>
            </div>

            <Nav className="ms-auto">
              <NavLink className="nav-link" to="/login" >Login</NavLink>
              <NavLink className="nav-link" to="/register" >Register</NavLink>
            </Nav>

          </Navbar.Collapse>
        </Container>
      </Navbar>
  )
}

export default Header