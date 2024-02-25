import React from 'react';
import {Link} from 'react-router-dom';
import {Nav,Navbar} from 'react-bootstrap';
const Header1 = () => {
  

  return (
    // <div style={headerStyle}>
    //   <div className="navbar">
    //     <div className="navbar-title">The Happy Meal Mess Portal</div>
    //     <div className="ml-auto ms-auto me-5">
    //     <Link to="/" className="btn btn-secondary me-4">Logout</Link>{" "}{" "}
    //     </div>
    //   </div>
    // </div>
    <Navbar bg="dark" variant="dark" className="d-flex justify-content-center navbar-title">
      <Navbar.Brand>The Happy Meal Mess Portal</Navbar.Brand>
      <Nav className="ml-auto ms-auto me-5">
          <Link to="/" className="btn btn-secondary me-4">Logout</Link>
          
        </Nav>
      
    </Navbar>
  );
};


export default Header1;
