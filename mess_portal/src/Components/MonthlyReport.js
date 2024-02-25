import React from 'react'
import {Row,Col,Form,Button} from 'react-bootstrap';
import Header1 from './Header1';
import Footerr from './Footerr';
const MonthlyReport = () => {
    return (
        <div >
          <Header1/>
            <h3> Monthly Report </h3>
            <Row className='justify-content-center'>
            <Col md="4">
            <Form>
        <Row className="mb-3 mt-5">
          <Form.Group as={Col} controlId="formGridEmail">
            <Form.Label>From Date  : </Form.Label>
            <Form.Control type="date"  />
          </Form.Group>
        </Row>

        <Row className="mb-3 mt-3">
        <Form.Group as={Col} controlId="formGridPassword">
            <Form.Label>To Date : </Form.Label>
            <Form.Control type="date" />
          </Form.Group>
          </Row>



          <Button className="mt-4" variant="primary" type="submit">
          Submit
        </Button>

        <Row className="mb-3 mt-3">
          <Form.Group as={Col} controlId="formGridEmail">
            <Form.Label>Count : </Form.Label>
            <Form.Control type="number"  readonly />
          </Form.Group>
        </Row>

       

        

        
      </Form>
      </Col>
      </Row>
      <Footerr/>
            
        </div>
    )
}

export default MonthlyReport
