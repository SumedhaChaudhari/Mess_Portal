import React from 'react'

import CustomerDeliveryComp from './CustomerDeliveryComp'
import { BrowserRouter , Routes,Route  } from 'react-router-dom';
import IndividualVendorComp from './IndividualVendorComp';
import VendorsComp from './VendorsComp';

function RouterComp() {
  return (
    <div>
        <BrowserRouter>
        {/* <IndividualVendorComp></IndividualVendorComp> */}
        <VendorsComp></VendorsComp>
        <Routes>
            <Route path='delivery' element={<CustomerDeliveryComp/>}></Route>
            <Route path='booking' element={<IndividualVendorComp></IndividualVendorComp>}></Route>
        </Routes>
        </BrowserRouter>
</div>




  )
}

export default RouterComp