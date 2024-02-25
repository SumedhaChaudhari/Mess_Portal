import React from 'react'
import {Link} from 'react-router-dom'
const NavComp = () => {
    return (
        <div>
            <Link to="/login" className='btn btn-outline-dark btn-sm'>Sign in</Link>{" "}
            
        </div>
    )
}

export default NavComp
