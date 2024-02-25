import {React,useState,useEffect} from 'react'
import axios from 'axios'
import Header1 from './Header1'
import Footerr from './Footerr'

const DailyDelivery = () => {
    const[user,setuser]=useState([]);


    useEffect(()=>{                                     
        fetchData();    
        
    },[])

    
    const fetchData=()=>{
        const token = localStorage.getItem('token');
        console.log('token = ' + token);
        const headers = {
          'Access-Control-Allow-Credentials': true,
          'Content-Type': 'application/json',
          'Authorization': token
        };
        console.log(headers);
        axios.defaults.headers.common['Authorization'] = token;
        axios.get("http://localhost:8089/messportal/orders/delivery", {
        }).then((res)=>{
            console.log(res.data);
            setuser(res.data);
        }).catch((err)=>{})
    }

    return (
        <div className='mt-4'>
            <Header1/>
            <h3 style ={{color:"Gray"}}>TODAY'S Deliveries  !! </h3>
            
        
        <table className='container table table-hover table-striped mt-4'>
        <thead>
            <tr className='table table-dark'>
                <th>Sr.No</th><th>Details</th>
            </tr>
        </thead>
        <tbody>
            {user.map((val,index)=>{
                return <tr key={index}>
                    <td>{index+1}</td>              
                    <td>{val}</td>  

                </tr>
            })}
        </tbody>
        </table>


        

        
        

        <Footerr/>
        </div>
    )
}
export default DailyDelivery