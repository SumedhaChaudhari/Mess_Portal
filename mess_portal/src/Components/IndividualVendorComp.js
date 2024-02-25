import React, { Component } from 'react'
import Form from 'react-bootstrap/Form';
import InputGroup from 'react-bootstrap/InputGroup';
import Col from 'react-bootstrap/Col';
import Row from 'react-bootstrap/Row';
import Container from 'react-bootstrap/Container';
import Button from 'react-bootstrap/Button';
import ButtonGroup from 'react-bootstrap/ButtonGroup';
import { Link } from 'react-router-dom';
import CustomerDeliveryComp from './CustomerDeliveryComp';
import { withRouter } from 'react-router-dom';

import useHistory from 'react-router-dom';

const IndividualVendorComp = () => {

    return (
        <div>

            <Container fluid="md">
                <Row>
                    <Col>
                        <Form>
                            <Button>Subscription</Button>
                            <InputGroup>
                                <InputGroup.Text>Todays Menu:</InputGroup.Text>
                                <Form.Control as="textarea" aria-label="With textarea" />
                            </InputGroup>


                            <Form.Group as={Row} className="mb-3" >
                                <Form.Label column sm="2">
                                    Price:
                                </Form.Label>
                                <Col sm="10">
                                    <Form.Control plaintext readOnly defaultValue="60" />
                                </Col>
                            </Form.Group>

                            <ButtonGroup size="lg" className="mb-2">
                                <Button>Confirm Booking</Button>
                                <Link to="/delivery" className='btn btn-primary'>Delivery Booking</Link>

                            </ButtonGroup>
                        </Form>
                    </Col>
                </Row>
            </Container>
        </div>
    )

}

export default (IndividualVendorComp);