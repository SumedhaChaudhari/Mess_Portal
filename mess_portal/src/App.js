import logo from './logo.svg';
import './App.css';

import Subscribecomp from './Components/Subscribecomp';
import Menuupdatecomp from './Components/Menuupdatecomp';
import vendorsignupcomp, { Vendorsignupcomp } from './Components/vendorsignupcomp';
import VendorsComp from './Components/VendorsComp';
import IndividualVendorComp from './Components/IndividualVendorComp';
import CustomerDeliveryComp from './Components/CustomerDeliveryComp';
import RouterComp from './Components/RouterComp';
import RoutingComp from './Components/RoutingComp';

function App() {
  return (
    <div className="App">
      {/* <Subscribecomp></Subscribecomp> */}
      {/* <Menuupdatecomp></Menuupdatecomp> */}
      {/* <Vendorsignupcomp></Vendorsignupcomp> */}

    
      {/* <VendorsComp/> */}
      {/* <IndividualVendorComp/> */}

      {/* <CustomerDeliveryComp/> */}

      <RoutingComp/>
    </div>
  );
}

export default App;
