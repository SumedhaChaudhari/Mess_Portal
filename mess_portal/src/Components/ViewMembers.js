import {React,useState,useEffect} from 'react'
import axios from 'axios'
import Header1 from './Header1'
import Footerr from './Footerr'

const ViewMembers = () => {
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
        axios.get("http://localhost:8089/messportal/subscription/get", {
        }).then((res)=>{
            console.log(res.data);
            setuser(res.data);
        }).catch((err)=>{})
    }

    return (
        <div >
            <Header1/>
            <h3 style ={{color:"Gray"}}>Subscription Details </h3>
            
        
        <table className='container table table-hover table-striped mt-4'>
        <thead>
            <tr className='table table-dark'>
                <th>Sr.No</th><th>Details</th>
            </tr>
        </thead>
        <tbody>
            {user.map((val,index)=>{
               // var data=val.split('');
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

export default ViewMembers