import React, { Component } from 'react';
import { Tab } from 'bootstrap';
import { Tabs,Form ,Button} from 'react-bootstrap';

export class Subscribecomp extends Component {
    render() {
        return  (<div>

         <form className='mb-3 mt-5'>
          <Tabs
      defaultActiveKey="profile"
      id="justify-tab-example"
      className="mb-3"
       justify
    >
      <Tab eventKey="weekly" title="Weekly">
      <Form>
      <Form.Group className="mb-3" controlId="formBasicName">
        <Form.Label>Fullname</Form.Label>
        <Form.Control type="text" placeholder="Enter fullname" />
        {/* <Form.Text className="text-muted">
          We'll never share your email with anyone else.
        </Form.Text> */}
      </Form.Group>

      <Form.Group className="mb-3" controlId="formBasicNumber">
        <Form.Label>Number</Form.Label>
        <Form.Control type="tel" placeholder="Number" />
      </Form.Group>
      {/* <Form.Group className="mb-3" controlId="formBasicCheckbox">
        {/* <Form.Check type="checkbox" label="Check me out" /> 
      </Form.Group> */}
      <Form.Group className="mb-3" controlId="formBasicAddress">
        <Form.Label>Address</Form.Label>
        <Form.Control type="text" placeholder="Enter Address" />
      </Form.Group>
      <Form.Group className="mb-3">
          <Form.Label htmlFor="Select">Select menu</Form.Label>
          <Form.Select id="disabledSelect">
            <option>Delivery</option>
            <option>Dine In</option>
          </Form.Select>
          </Form.Group>
      <Button variant="primary" type="submit">
        Submit
      </Button>
    </Form>
      </Tab>
      <Tab eventKey="Monthly" title="Monthly">
      <Form>
      <Form.Group className="mb-3" controlId="formBasicName">
        <Form.Label>Fullname</Form.Label>
        <Form.Control type="text" placeholder="Enter fullname" />
        {/* <Form.Text className="text-muted">
          We'll never share your email with anyone else.
        </Form.Text> */}
      </Form.Group>

      <Form.Group className="mb-3" controlId="formBasicNumber">
        <Form.Label>Number</Form.Label>
        <Form.Control type="tel" placeholder="Number" />
      </Form.Group>
      {/* <Form.Group className="mb-3" controlId="formBasicCheckbox">
        {/* <Form.Check type="checkbox" label="Check me out" /> 
      </Form.Group> */}
      <Form.Group className="mb-3" controlId="formBasicAddress">
        <Form.Label>Address</Form.Label>
        <Form.Control type="text" placeholder="Enter Address" />
      </Form.Group>
      <Form.Group className="mb-3">
          <Form.Label htmlFor="Select">Select menu</Form.Label>
          <Form.Select id="disabledSelect">
            <option>Delivery</option>
            <option>Dine In</option>
          </Form.Select>
          </Form.Group>
      <Button variant="primary" type="submit">
        Submit
      </Button>
    </Form>
      </Tab>
    </Tabs>
    </form>
       
   </div>)
    }
}

export default Subscribecomp
