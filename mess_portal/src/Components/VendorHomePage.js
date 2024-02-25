import React from 'react'
import {Navbar, Nav, NavDropdown,FormControl} from 'react-bootstrap';
import {Link} from 'react-router-dom';
import { Container, Table,Row,Col } from 'react-bootstrap';
import {Form,Button} from 'react-bootstrap';
import Header1 from './Header1';
import Footerr from './Footerr';
const VendorHomePage = () => {
    return (
        <div>
          <Header1/>
            {/* <Navbar bg="light" expand="lg">
      
      <Navbar.Toggle aria-controls="basic-navbar-nav" />
      <Navbar.Collapse id="basic-navbar-nav">
        <Nav className="links ms-5">
          <Link to="/" className="nav-link ms-4 ">Home</Link>
          <Link to="/about" className="nav-link ms-4">About</Link>
          <Link to="/contact" className="nav-link ms-4 ">Contact</Link>
        </Nav>
        
        <Nav className="ml-auto ms-auto me-5">
          <Link to="/signup" className="btn btn-secondary me-4">Sign Up</Link>{" "}{" "}
          <Link to="/signin" className="btn btn-secondary">Sign In</Link>
        </Nav>
      </Navbar.Collapse>
    </Navbar> */}

        <h1>Welcome !!</h1>
        <br/>




    <Form className='form1 mt-1 '>
              <Form.Group as={Row} className="mt-1" controlId="formHorizontalEmail">
                
                <Col sm={12}>
                <Link to="/menu" className="btn btn-secondary btn-lg me-4 shadow-lg p-3 mb-5 rounded w-50">Menu update</Link>
                </Col>
              </Form.Group>

              <Form.Group as={Row} className=" mt-1" controlId="formHorizontalEmail">
                
                <Col sm={12}>
                <Link to="/members" className="btn btn-secondary btn-lg me-4 shadow-lg p-3 mb-5 rounded w-50">View Members</Link>
                </Col>
              </Form.Group>
              
              <Form.Group as={Row} className=" mt-1" controlId="formHorizontalEmail">
                
                <Col sm={12}>
                <Link to="/dailyorder" className="btn btn-secondary btn-lg me-4 shadow-lg p-3 mb-5 rounded w-50">Today's Orders</Link>
                </Col>
              </Form.Group>


              <Form.Group as={Row} className=" mt-1" controlId="formHorizontalEmail">
                
                <Col sm={12}>
                <Link to="/dailydelivery" className="btn btn-secondary btn-lg me-4 shadow-lg p-3 mb-5 rounded w-50">Today's Delivery Orders</Link>
                </Col>
              </Form.Group>

              <Form.Group as={Row} className=" mt-1" controlId="formHorizontalEmail">
                
                <Col sm={12}>
                <Link to="/report" className="btn btn-secondary btn-lg me-4 shadow-lg p-3 mb-5 rounded w-50">Monthly Report</Link>
                </Col>
              </Form.Group>
              


            </Form>
            <Footerr/>
            

        </div>
    )
}

export default VendorHomePage
