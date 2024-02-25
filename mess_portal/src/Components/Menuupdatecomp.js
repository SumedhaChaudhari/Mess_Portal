import React, { Component } from 'react'
import { Tabs,Form ,Button,Nav} from 'react-bootstrap';

export class Menuupdatecomp extends Component {

    nextpage=()=>{
        

    }
 
    render() {

        return (
            <div>
                <h1>Form to update daily Menu</h1>
                <Nav className="justify-content-end" activeKey="/home">
        <Nav.Item>
          <Nav.Link href="/home">ViewMembers</Nav.Link>
        </Nav.Item>
        <Nav.Item>
          <Nav.Link eventKey="link-1">Delivery</Nav.Link>
        </Nav.Item>
        <Nav.Item>
          <Nav.Link eventKey="link-2">Monthly Report</Nav.Link>
        </Nav.Item>
      </Nav>
                <Form>
      <Form.Group className="mb-3" controlId="formBasicName">
        <Form.Label>Please enter today's menu here</Form.Label>
        <Form.Control type="text" placeholder="Enter Menu" />
      </Form.Group>
      <Form.Group className="mb-3" controlId="formBasicName">
        <Form.Label>Price</Form.Label>
        <Form.Control type="number" placeholder="Enter price" />
      </Form.Group>
      <Button variant="primary" type="submit">
        Update
      </Button>
      </Form>
            </div>
        )
    }
}

export default Menuupdatecomp
