import React,{useState} from 'react'
import {Form,Button,Col,Row} from 'react-bootstrap';
import InputGroup from 'react-bootstrap/InputGroup';
import axios from 'axios';
import { Dropdown,DropdownButton } from 'react-bootstrap';
import Footerr from './Footerr';
import Header from './Header';
import { useNavigate } from 'react-router-dom';
import{Router,Switch,Route,Routes} from 'react-router-dom';
const Signup_Customer_vendor = () => {
   
  var ucourses=[{id:1,description:"Cutomer"},
                {id:2,description:"Vendor"},
                {id:3,description:"Admin"}]

  const nav= useNavigate();
  const[item,setItem]=useState({
      email:" ",
      password:" ",
      userName:" ",
      userPhone:" ",
      userIdProof:" ",
      addresses:[{addressDescription:" ",}],
      roleId:0,
      roleDescription:" "
  });
  

    const inputchangehandler = (event) => {
      const { type, name, value } = event.target;

      if (name === 'addressDescription') {
        setItem({...item, addresses: [{ ...item.addresses[0], [name]: value }]});
      } 
      else 
      {
        setItem({ ...item, [name]: value });
      }
    };

  const addUser=(event)=>{
      event.preventDefault();           //to prevent page loading
       console.log(item);
      console.log("roleid state method"+item.roleId);
      axios.post(`http://localhost:8089/messportal/users/reg/add`,item).then(()=>{
          window.alert("details added successfully");
          nav("/signin");
          // if(selectedOption=="Customer")
          // {
            
          //   nav("/homepage1");
          // }
          // else{
          //   nav("/homepage2");
          // }
          
      }).catch((err)=>{})
  }


  return (
    <div className='register'>
      <Header/>
    <div>
      <h2 style={{color: "Gray"}}>Register</h2>

        <div class="container">
        <Form onSubmit={addUser}>

        <Row className="mb-3 mt-3">
              {/* <Dropdown name="roleId">
                
                  <DropdownButton   title={item.roleId ? Selected: ${item.roleId} : 'Sign in as '} onChange={inputchangehandler}>
                 { ucourses.map((val,index)=>{
                                return <Dropdown.Item  key={index} value={val} >{val}</Dropdown.Item>
                            })
                          }
                   
                    {/* <Dropdown.Item  eventKey="1" >Customer</Dropdown.Item>
                    <Dropdown.Item eventKey="2">Vendor</Dropdown.Item>
                    <Dropdown.Item eventKey="3">Admin</Dropdown.Item> */}
                  {/* </DropdownButton>
                </Dropdown> */} 
                <select name='roleId' className='form-control' onChange={inputchangehandler} >
                        <option value="">Select Your role</option>
                        {
                           ucourses.map((val,index)=>{
                                return <option key={index} value={val.id} >{val.description}</option>
                            })
                        }
                    </select>
        </Row>
        <Row className="mb-3 mt-3">
          <Form.Group as={Col} controlId="formGridEmail">
            <Form.Label>Email ID  : </Form.Label>
            <Form.Control type="email" name='email' placeholder="Enter email ID . . . " required value={item.email} onChange={inputchangehandler} />
          </Form.Group>
  
          <Form.Group as={Col} controlId="formGridPassword">
            <Form.Label>Password : </Form.Label>
            <Form.Control type="password" name='password' placeholder="Enter Password . . ." required value={item.password} onChange={inputchangehandler} />
          </Form.Group>
        </Row>


        <Row className="mb-3 mt-3">
          <Form.Group as={Col} controlId="formGridEmail">
            <Form.Label>Full Name  : </Form.Label>
            <Form.Control type="text" name='userName' placeholder="Enter full name  . . . " required value={item.userName} onChange={inputchangehandler} />
          </Form.Group>
  
          <Form.Group as={Col} controlId="formGridPassword">
            <Form.Label>Phone : </Form.Label>
            <Form.Control type="number" name='userPhone' placeholder="Enter phone number. . ." required value={item.userPhone} onChange={inputchangehandler} />
          </Form.Group>
        </Row>

        

        <Row className="mb-3 mt-3">

        <Form.Group as={Col} controlId="formGridPassword">
            <Form.Label>Address : </Form.Label>
            <Form.Control type="text" name='addressDescription' placeholder="Enter full address. . ." required value={item.addresses[0].addressDescription} onChange={inputchangehandler}/>
          </Form.Group>
        </Row>

        <Row>
        <Form.Group as={Col} controlId="formGridAddress2">
          <Form.Label>Government ID Proof  : </Form.Label>
          <Form.Control type= "number" name='userIdProof'  placeholder="Enter Adhar/PAN no.  . . . "  value={item.userIdProof} onChange={inputchangehandler}/>
        </Form.Group>
        </Row>

 

        <Button className="mt-4" variant="primary" type="submit">
          Submit
        </Button>
      </Form>
      </div>

</div>
    <Footerr/>
    </div>
     );
    };
    
    
    export default Signup_Customer_vendor