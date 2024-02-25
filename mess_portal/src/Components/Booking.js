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

const Booking = () => {
  const [menu, setMenu] = useState({});

  const Booking ={
    deliveryType:0,
    menuId: menu.id,
    vendorId: menu.vendorId,
    addressId: menu.vendorId
  };

  // setBooking({
  //   DELIVERY_TYPE:0,
  //   AddressId:menu.vendorId,
  //   menuId:menu.id,
  //   vendorId:menu.vendorId
  // })
  


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

  const saveBooking = (event) => {
    event.preventDefault();   //to prevent page loading
    console.log(Booking);
    axios.post(`http://localhost:8089/messportal/orders/add`, Booking).then(() => {
      window.alert("details added successfully");
      //nav("/signin");
    }).catch((err) => { })
  }
  useEffect(() => {

    fetchData(id);
  }, [])

  // const inputchangehandler = (event) => {
  //   const { type, name, value } = event.target;
  //   setBooking({ ...Booking, [name]: value })
  // }

  return (
    <div >
      <Header1 />
      <div class="container">
      <Form onSubmit={saveBooking}>
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
            <Form.Control type="number"  required value={menu.price} readOnly />
          </Form.Group>
        </Row>
        {/*           
          <table className='container table table-hover table-striped mt-4'>
        <thead>
            <tr className='table table-dark'>
                <th>Sr.No</th><th>Type</th><th>Menu</th><th>Price</th>
            </tr>
        </thead>
        <tbody>
               <tr >          
               <td >{menu.id}</td>    
                    <td onChange={}>{menu.type}</td>
                    <td >{menu.description}</td>
                    <td >{menu.price}</td>
                    menu.
                    {/* <td>
                    
                    <button name='delivery' className="btn  btn-outline-success btn-sm" type="button" >Confirm</button>{" "}
   
                    </td> 
                    
                </tr>     
        </tbody>
        </table> */}
        <Button className="mt-4" variant="primary" type="submit" > Confirm </Button>
      </Form>
      </div>



      <Footerr />
    </div>
  )
}

export default Booking