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
  // const [subscriptionType, setSubscriptionType] = useState('');

  const Subscription ={
    
    menuId: menu.id,
    vendorId: menu.vendorId,
    menuPrice: menu.price,
    menuUpdateDate:menu.updated_time,
    subscriptionType:0
  };

  // setBooking({
  //   DELIVERY_TYPE:0,
  //   AddressId:menu.vendorId,
  //   menuId:menu.id,
  //   vendorId:menu.vendorId
  // })


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
    event.preventDefault();   //to prevent page loading
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


      


      {/* <select name='roleId' className='form-control' onChange={inputchangehandler} >
                        <option value="">Select Your role</option>
                        {
                           ucourses.map((val,index)=>{
                                return <option key={index} value={val.id} >{val.description}</option>
                            })
                        }
                    </select> */}

      
        
        <Row className="mb-3 mt-3">
          <Form.Group as={Col} controlId="formGridPassword">
            <Form.Label>Subscription expire Date : </Form.Label>
            <Form.Control type="text" name='subscription_expire_date' required value={new Date().getDate() + 7  } readOnly />
          </Form.Group>
        </Row>
        {/*    
        new Date().getDate() + 7   / new Date().getMonth()+1    
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
//   var type=[{id:0,description:"Weekly"},
//             {id:1,description:"Monthly"}]

//   const[menu, setMenu]=useState({});

//   const[subscription, setSubscription]=useState({
//     DELIVERY_TYPE:1,
//     menuId:0,
//   });

//   // setBooking({
//   //   DELIVERY_TYPE:0,
//   //   AddressId:menu.vendorId,
//   //   menuId:menu.id,
//   //   vendorId:menu.vendorId
//   // })
//   const inputchangehandler = (event) => {
    
//     const { type, name, value } = event.target;
//     setSubscription({ ...subscription, [name]: value })
//   }

//   const [formData, setFormData] = useState({
//     userName: '',
//     address: '',
//     menuItem: '',
//   });

//   const handleSubmit = async (event) => {
//     event.preventDefault();

//     // You can access readonly values from state (formData)
//     const { userName, address, menuItem } = formData;

//     // Assuming you have an API endpoint for posting data
//     const apiUrl = '/api/postData';

//     try {
//       const response = await fetch(apiUrl, {
//         method: 'POST',
//         headers: {
//           'Content-Type': 'application/json',
//         },
//         body: JSON.stringify({ userName, address, menuItem }),
//       });

//       if (response.ok) {
//         console.log('Data successfully posted to the database.');
//         // You can perform additional actions, like resetting the form or navigating to another page
//       } else {
//         console.error('Failed to post data to the database.');
//       }
//     } catch (error) {
//       console.error('Error while posting data:', error);
//     }
//   };

//   const handleChange = (event) => {
//     const { name, value } = event.target;
//     setFormData({
//       ...formData,
//       [name]: value,
//     });
//   };

//   let {id}=useParams();
// // console.log(id);
// const  fetchData= (id)=>{
//   console.log(id);
//   const token=localStorage.getItem('token');
//   console.log('token = '+token);
//   const headers = { 'Access-Control-Allow-Credentials': true,
//       'Content-Type': 'application/json',
//       'Authorization': token };
//       console.log(headers);
//      axios.defaults.headers.common['Authorization'] = token;
//   axios.get(`http://localhost:8089/messportal/menu/menudetails/${id}`).then((res)=>{
//       console.log(res.data);
//      setMenu(res.data);
//      setSubscription();
//   }).catch((err)=>{ console.log(err)})
// }

// const saveSubscription = (event) => {
//   event.preventDefault();   //to prevent page loading
//   console.log(subscription);
//   axios.post(`http://localhost:8089/messportal/orders/delivery/add/${id}`).then(() => {
//     window.alert("details added successfully");
//     //nav("/signin");
//   }).catch((err) => { })
// }
// useEffect(()=>{ 

//   fetchData(id);
// },[])

//     return (
//         <div >
//           <Header1/>
//           <div className='container'>
//           <Form onSubmit={handleSubmit}>


//               <Row className="mb-3 mt-3">
//                 <Form.Group as={Col} controlId="formGridEmail">
//                   <Form.Label>MenuID  : </Form.Label>
//                 <Form.Control type="number" name='id'  required value={menu.id} onLoad={handleChange} readOnly/>
//                 </Form.Group>

//                 <Form.Group as={Col} controlId="formGridPassword">
//                   <Form.Label>Menu Name  : </Form.Label>
//                   <Form.Control type="number"   required value={menu.id} onLoad={handleChange} readOnly/>
//                 </Form.Group>
//               </Row>

//               <Row className="mb-3 mt-3">
//                 {/* <Form.Group as={Col} controlId="formGridEmail">
//                   <Form.Label>Subscription Type  : </Form.Label>
//                   <Form.Control type="number" name="subscription_type"  required value={1} onLoad={inputchangehandler}  readOnly />
//                 </Form.Group> */}
//                 <select name='type' className='form-control' onChange={handleChange} >
//                         <option value="">Select Your subscription type(monthly/weekly)</option>
//                         {
//                            type.map((val,index)=>{
//                                 return <option key={index} value={val.id} >{val.description}</option>
//                             })
//                         }
//                     </select>
//                 </Row>
//                 <Row className="mb-3 mt-3">
//                   <Form.Group as={Col} controlId="formGridPassword">
//                     <Form.Label>CustomerID : </Form.Label>
//                     <Form.Control type="number"  required value={menu.vendorId} onLoad={handleChange} readOnly />
//                   </Form.Group>
//                 </Row>
//               {/*           
//                         <table className='container table table-hover table-striped mt-4'>
//                       <thead>
//                           <tr className='table table-dark'>
//                               <th>Sr.No</th><th>Type</th><th>Menu</th><th>Price</th>
//                           </tr>
//                       </thead>
//                       <tbody>
//                             <tr >          
//                             <td >{menu.id}</td>    
//                                   <td onChange={}>{menu.type}</td>
//                                   <td >{menu.description}</td>
//                                   <td >{menu.price}</td>
//                                   menu.
//                                   {/* <td>
                                  
//                                   <button name='delivery' className="btn  btn-outline-success btn-sm" type="button" >Confirm</button>{" "}
                
//                                   </td> 
                                  
//                               </tr>     
//                       </tbody>
//                       </table> */}
                
//                 <Button className="mt-4" variant="primary" type="submit" >
//                         Confirm 
//                       </Button>
//               </Form>
//           </div>


      
//             <Footerr/>
//         </div>
    
//   )
}



export default Subscription
