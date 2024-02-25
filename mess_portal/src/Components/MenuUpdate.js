import {React,useState,useEffect} from 'react'
import{Row,Col,Form,Button} from 'react-bootstrap';
import Footerr from './Footerr';
import Header1 from './Header1';
import axios from 'axios'
const MenuUpdate = () => {

  const[item,setItem]=useState([])        

    


    useEffect(()=>{                                     
        fetchData();
        
        
    },[])

    
    const fetchData=()=>{
        axios.post("http://localhost:8089/messportal/menu/menudetails/add").then((res)=>{
            
           
        }).catch((err)=>{})
    }

    
    return (
        <div >
          <Header1/>
            <h1>Update Today's Menu</h1>

            <Row className='justify-content-center'>
            <Col md="4">
            <Form>
        <Row className="mb-3 mt-5">
          <Form.Group as={Col} controlId="formGridEmail">
            <Form.Label>Menu  : </Form.Label>
            <Form.Control type="text" placeholder="Enter Menu . . . " />
          </Form.Group>
        </Row>

        <Row className="mb-3 mt-3">
        <Form.Group as={Col} controlId="formGridPassword">
            <Form.Label>Price  : </Form.Label>
            <Form.Control type="number" placeholder="Enter price. . ." />
          </Form.Group>
          </Row>

        

        <Row className="mb-3 mt-3">
        <Form.Group as={Col} controlId="formGridPassword">
            <Form.Label>Enter Date  : </Form.Label>
            <Form.Control type="date" />
          </Form.Group>
          </Row>

        

        <Button className="mt-4" variant="primary" type="submit">
          Update
        </Button>
      </Form>
      </Col>
      </Row>

            
      <Footerr/>
        </div>
    )
}

export default MenuUpdate
