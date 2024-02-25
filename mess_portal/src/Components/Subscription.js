import React,{useState,useEffect} from 'react'
import Button from 'react-bootstrap/Button';
import ButtonGroup from 'react-bootstrap/ButtonGroup';
import axios from 'axios'
import { useNavigate } from 'react-router-dom';
import  {Dropdown, DropdownButton} from 'react-bootstrap';
import Col from 'react-bootstrap/Col';
import Form from 'react-bootstrap/Form';
import InputGroup from 'react-bootstrap/InputGroup';
import Row from 'react-bootstrap/Row';
import Header1 from './Header1';
import Footerr from './Footerr';
import { useParams } from 'react-router-dom';

const Subscription = () => {
  var type=[{id:0,description:"Weekly"},
            {id:1,description:"Monthly"}]
  
  const [menu, setMenu] = useState({});

  const Subscription ={
    
    menuId: menu.id,
    vendorId: menu.vendorId,
    menuPrice: menu.price,
    menuUpdateDate:menu.updated_time,
    subscriptionType:0
  };



  const inputchangehandler = (event) => {
    const { type, name, value } = event.target;
      setMenu({ ...menu, [name]: value });
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

  const saveSubscription = (event) => {
    event.preventDefault();   
    console.log(Subscription);
    axios.post(`http://localhost:8089/messportal/subscription/add`, Subscription).then(() => {
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
      <Form onSubmit={saveSubscription}>
        <Row className="mb-3 mt-3">
          <Form.Group as={Col} controlId="formGridEmail">
            <Form.Label>Menu Name  : </Form.Label>
            <Form.Control type="text" name='description' required value={menu.description}  />
          </Form.Group>

          <Form.Group as={Col} controlId="formGridPassword">
            <Form.Label>Original Price  : </Form.Label>
            <Form.Control type="number" name='price'  required value={menu.price} />
          </Form.Group>
        </Row>

        <Row>
        <select
          name='subscription_type'
          className='form-control'
          onChange={inputchangehandler}
          
        >
          <option  >Select Your subscription type(monthly/weekly)</option>
          {type.map((val, index) => (
            <option key={index} value={val.id}  >
              {val.description}
            </option>
          ))} 
        </select>
          
        

        
        {console.log(menu.subscription_type)}
        {menu.subscription_type === '0' ? (
        
        <Row className="mb-3 mt-3">
         {/* Weekly subscription */}
         <Form.Group as={Col} controlId="formGridEmail">
           <Form.Label>Total price: </Form.Label>
           <Form.Control type="number" name='total_amount' required value={menu.price *7 } />
         </Form.Group>
       </Row>
     ) : (
       <Row className="mb-3 mt-3">
         {/* Monthly subscription */}
         <Form.Group as={Col} controlId="formGridEmail">
           <Form.Label>Total price: </Form.Label>
           <Form.Control type="number" name='total_amount' required value={menu.price * 30} />
         </Form.Group>
       </Row>
     )}
      </Row>
        
        <Row className="mb-3 mt-3">
          <Form.Group as={Col} controlId="formGridPassword">
            <Form.Label>Subscription expire Date : </Form.Label>
            <Form.Control type="text" name='subscription_expire_date' required value={new Date().getDate() + 7  } readOnly />
          </Form.Group>
        </Row>
        
        <Button className="mt-4" variant="primary" type="submit" > Confirm </Button>
      </Form>
      </div>



      <Footerr />
    </div>
  )
}



export default Subscription
