import React, { Component } from 'react'
import Button from 'react-bootstrap/Button';
import Card from 'react-bootstrap/Card';
import { Link } from 'react-router-dom';


  class VendorsComp extends Component {
  render() {
    return (
        <div>
          <Link to="/booking">
        <Card style={{ width: '18rem' }}>
      <Card.Img variant="top" src="holder.js/100px180" />
      <Card.Body>
        <Card.Title>Vendor 1</Card.Title>
        <Card.Text>
         Vendor details...
        </Card.Text>
        <Button variant="primary">Read more</Button>
      </Card.Body>
    </Card>
</Link>

    <Card style={{ width: '18rem' }}>
      <Card.Img variant="top" src="holder.js/100px180" />
      <Card.Body>
        <Card.Title>Vendor 2</Card.Title>
        <Card.Text>
         Vendor details...
        </Card.Text>
        <Button variant="primary">Read more</Button>
      </Card.Body>
    </Card>



    <Card style={{ width: '18rem' }}>
      <Card.Img variant="top" src="holder.js/100px180" />
      <Card.Body>
        <Card.Title>Vendor 3</Card.Title>
        <Card.Text>
         Vendor details...
        </Card.Text>
        <Button variant="primary">Read more</Button>
      </Card.Body>
    </Card>

    </div>
      
    )
  }
}
export default VendorsComp;