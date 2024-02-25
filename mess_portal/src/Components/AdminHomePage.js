import { useState, React, useEffect } from 'react'
import axios from 'axios'
import { Link } from 'react-router-dom'
import { Button, Modal } from 'react-bootstrap'
import Footerr from './Footerr'
import Header1 from './Header1'


const AdminHomePage = () => {


    const [user, setuser] = useState([])
    const [item, setItem] = useState({})
    const [show, setShow] = useState(false);
    const handleClose = () => setShow(false);
    const handleShow = (val) => {
        console.log(val.id);
        console.log(val.customerId);
        setItem(val);
        fetchData(val.id);
        setShow(true);

    };

    useEffect(() => {

        getData();
        //  getData2();
    }, [])



    const getData = async () => {
        const token = localStorage.getItem('token');
        console.log('token = ' + token);
        const headers = {
            'Access-Control-Allow-Credentials': true,
            'Content-Type': 'application/json',
            'Authorization': token
        };
        console.log(headers);
        axios.defaults.headers.common['Authorization'] = token;
        axios.get("http://localhost:8089/messportal/users/vendors").then((res) => {
            // console.log(res.data);
            setuser(res.data);
        }).catch((err) => { console.log(err) })
    }








    const fetchData = (vendorId) => {
        axios.get(`http://localhost:8089/messportal/users/vendors/${vendorId}`).then((res) => {
            console.log(res.data);

        }).catch((err) => { })
    }



    return (
        <div className='mt-4'>
            <Header1 />
            <h3 style={{ color: "Gray" }}>LIST OF MESS VENDORS !! </h3>


            <table className='container table table-hover table-striped mt-4'>
                <thead>
                    <tr className='table table-dark'>
                        <th>Sr.No</th><th>Name</th><th>Action</th>
                    </tr>
                </thead>
                <tbody>
                    {user.map((val, index) => {
                        return <tr key={index}>
                            <td>{index + 1}</td>
                            <td>{val.userName}</td>


                            <td>

                                <button className="btn btn-outline-warning btn-sm" type="button" onClick={() => handleShow(val)}> View Details</button> {" "}

                            </td>
                        </tr>
                    })}
                </tbody>
            </table>








            <Modal
                show={show}
                onHide={handleClose}
                backdrop="static"
                keyboard={false}
            >
                <Modal.Header closeButton>
                    <Modal.Title>{item.userName}</Modal.Title>
                </Modal.Header>
                <Modal.Body>

                    <table className='container table table-hover table-striped mt-4'>
                        <thead>
                            <tr className='table table-dark'>
                                <th>Sr.No</th><th>Name</th><th>Contact</th><th>Address</th>
                            </tr>
                        </thead>
                        <tbody>
                            {user.map((val, index) => {
                                return <tr key={index}>
                                    <td>{index + 1}</td>
                                    <td>{val.userName}</td>
                                    <td>{val.userPhone}</td>
                                    <td>{val.addresses.map((adr, index) => {

                                        return <td>{adr.addressDescription}</td>


                                    })}</td>


                                </tr>
                            })}
                        </tbody>
                    </table>

                </Modal.Body>
                <Modal.Footer>
                    <Button variant="secondary" onClick={handleClose}>
                        Close
                    </Button>
                    <Button variant="primary" onClick={handleClose}>OK</Button>

                </Modal.Footer>
            </Modal>








            <Footerr />
        </div>

    )

}

export default AdminHomePage