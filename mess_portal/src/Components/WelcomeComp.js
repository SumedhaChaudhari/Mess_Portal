import React from 'react'
import img from '../Assets/images/logo.PNG';
import './external.css';
import { BrowserRouter,Routes,Route ,Link} from 'react-router-dom'

import RoutingComp from './RoutingComp';

import Button from 'react-bootstrap/Button';
import ButtonGroup from 'react-bootstrap/ButtonGroup';

import Col from 'react-bootstrap/Col';
import Form from 'react-bootstrap/Form';
import InputGroup from 'react-bootstrap/InputGroup';
import Row from 'react-bootstrap/Row';
import {Navbar, Nav, NavDropdown,FormControl} from 'react-bootstrap';
import { Container, Table } from 'react-bootstrap';
import img1 from '../Assets/images/img1.jpg'
import img2 from '../Assets/images/img2.jpg'
import img3 from '../Assets/images/img3.jpg'
import img4 from '../Assets/images/img4.jpg'
import img5 from '../Assets/images/img5.jpg'
import Footerr from './Footerr';



function WelcomeComp() {
    return (
        <div>
           <Navbar bg="dark" variant="dark" >
      <Link to="/" className="navbar-brand">
        <img
          src={img}
          className="d-inline-block align-top"
          alt="Logo"
          height="50px" 
          width="80px"
        />
        
      </Link>
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
    </Navbar>



        <div className='h11 '>
            <h1  id="title" style={{color:"blue"}}>The Happy Meal Mess Portal !! </h1>
            
          
        </div>
        <Container className="d-flex align-items-center justify-content-center mt-5">
      <Row>
        <Col>
          <Table>
            
            <tbody>
              <tr>
                <td><img src={img1} height="150px" width="300px" /></td>
                <td><img src={img2} height="150px" width="300px" /></td>
                <td><img src={img3} height="150px" width="300px" /></td>
              </tr>
              <tr>
                <td><img src={img4} height="150px" width="300px" /></td>
                <td><img src={img5} height="150px" width="300px" /></td>
                <td><img src={img2} height="150px" width="300px" /></td>
              </tr>
            </tbody>
          </Table>
        </Col>
      </Row>
    </Container>
    <Footerr/>


        </div>
        
    )
}

export default WelcomeComp
