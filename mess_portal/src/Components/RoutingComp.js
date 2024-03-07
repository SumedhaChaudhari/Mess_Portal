import React from 'react'
import { BrowserRouter ,Routes,Route, Link } from 'react-router-dom';



import WelcomeComp from './WelcomeComp';

import Signin_Customer_Vendor from './Signin_Customer_Vendor';
import Signup_Customer_vendor from './Signup_Customer_vendor';
import CustomerHomePage from './CustomerHomePage';
import Delivery from './Delivery';
import Subscription from './Subscription';
import VendorHomePage from './VendorHomePage';
import MenuUpdate from './MenuUpdate';
import ViewMembers from './ViewMembers';
import DailyOrder from './DailyOrder';
import DailyDelivery from './DailyDelivery';
import MonthlyReport from './MonthlyReport';
import PageNotFound from './PageNotFound';
import Booking from './Booking';
import AdminHomePage from './AdminHomePage';
import About from './About';
import Contact from './Contact';


const RoutingComp = () => {
    return (
        <BrowserRouter>
        
        <div>
             <Routes>
                 <Route path='/' element={<WelcomeComp/>}></Route>
                 
                 <Route path='signup' element={<Signup_Customer_vendor/>}></Route>
                 <Route path='signin' element={<Signin_Customer_Vendor/>}></Route>
                 <Route path='homepage1' element={<CustomerHomePage/>}></Route>
                 <Route path='delivery/:id' element={<Delivery/>}></Route>
                 <Route path='booking/:id' element={<Booking/>}></Route>
                 <Route path='subscription/:id' element={<Subscription/>}></Route>
                 <Route path='homepage2' element={<VendorHomePage/>}></Route>
                 <Route path='menu' element={<MenuUpdate/>}></Route>
                 <Route path='members' element={<ViewMembers/>}></Route>
                 <Route path='dailyorder' element={<DailyOrder/>}></Route>
                 <Route path='dailydelivery' element={<DailyDelivery/>}></Route>
                 <Route path='report' element={<MonthlyReport/>}></Route>
                 <Route path='homepage3' element={<AdminHomePage/>}></Route>
                 <Route path='about' element={<About/>}></Route>
                 <Route path='contact' element={<Contact/>}></Route>
                 <Route path='/*' element={<PageNotFound/>}></Route>
                 
                 
                 
             </Routes>
        </div>
        </BrowserRouter>
    )
}

export default RoutingComp