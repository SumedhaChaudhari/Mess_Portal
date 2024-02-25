import { React, useState, useEffect } from 'react'
import Button from 'react-bootstrap/Button';
import ButtonGroup from 'react-bootstrap/ButtonGroup';

import Col from 'react-bootstrap/Col';
import Form from 'react-bootstrap/Form';
import InputGroup from 'react-bootstrap/InputGroup';
import Row from 'react-bootstrap/Row';
import Header1 from './Header1';
import Footerr from './Footerr';
import CustomerHomePage from './CustomerHomePage';
import { useParams } from 'react-router-dom';
import axios from 'axios';

const Delivery = () => {
  const [menu, setMenu] = useState({});

  const Delivery ={
    deliveryType:1,
    menuId: menu.id,
    vendorId: menu.vendorId,
    addressId: menu.vendorId
  };

  


  let { id } = useParams();
  // console.log(id);
  const fetchData = (id) => {
    console.log(id);
    const token = localStorage.getItem('token');
    console.log('token = ' + token);
    const headers = {
      'Access-Control-Allow-Credentials': true,
      'Content-Type': 'application/json',
      'Authorization': token
    };
    console.log(headers);
    axios.defaults.headers.common['Authorization'] = token;
    axios.get(`http://localhost:8089/messportal/menu/menudetails/${id}`).then((res) => {
      console.log(res.data);
      setMenu(res.data);
    }).catch((err) => { console.log(err) })
  }

  const saveDelivery = (event) => {
    event.preventDefault();   
    console.log(Delivery);
    axios.post(`http://localhost:8089/messportal/orders/add`, Delivery).then(() => {
      window.alert("details added successfully");
    }).catch((err) => { })
  }
  useEffect(() => {

    fetchData(id);
  }, [])


  return (
    <div >
      <Header1 />
      <div class="container">
      <Form onSubmit={saveDelivery}>
      <Row className="mb-3 mt-3">
          <Form.Group as={Col} controlId="formGridEmail">
            <Form.Label>Menu ID  : </Form.Label>
            <Form.Control type="number" name='id'  required value={menu.id}  />
          </Form.Group>

          
        </Row>

        <Row className="mb-3 mt-3">
          <Form.Group as={Col} controlId="formGridEmail">
            <Form.Label>Menu Name  : </Form.Label>
            <Form.Control type="text" name='vendorId'  required value={menu.description}  />
          </Form.Group>
        </Row>
        <Row className="mb-3 mt-3">
          <Form.Group as={Col} controlId="formGridPassword">
            <Form.Label>Price : </Form.Label>
            <Form.Control type="number"  required value={menu.price + 10} readOnly />
          </Form.Group>
        </Row>
        
        <Button className="mt-4" variant="primary" type="submit" > Confirm </Button>
      </Form>
      </div>



      <Footerr />
    </div>
  )
}

export default Delivery