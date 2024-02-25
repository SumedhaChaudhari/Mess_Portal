import React, { Component } from 'react'
import Col from 'react-bootstrap/Col';
import Form from 'react-bootstrap/Form';
import Row from 'react-bootstrap/Row';
import Button from 'react-bootstrap/Button';

 class CustomerDeliveryComp extends Component {
  render() {
    return (
      <div>
        <h4>Customer Delivery Details</h4>
        <Form>
            
        <Form.Group as={Row} className="mb-3" >
        <Form.Label column sm="2">
          Customer Name:
        </Form.Label>
        <Col sm="10">
          <Form.Control type="text" placeholder="Enter name" />

        </Col>
        <Form.Label column sm="2">
          Phone number:
        </Form.Label>
        <Col sm="10">
          <Form.Control type="text" placeholder="Enter number" />
          
        </Col>

        <Form.Label column sm="2">
          Address:
        </Form.Label>
        <Col sm="10">
          <Form.Control type="text" placeholder="Enter address" />
          
        </Col>
      </Form.Group>

      <Button>Submit</Button>
    </Form>

      </div>
    )
  }
}
export default CustomerDeliveryComp;