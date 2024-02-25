import React from 'react'
import { Link } from 'react-router-dom';
const PageNotFound = () => {
    return (
        <div className="error-page">
        <div class="error">404</div>
        <br />
        <br />
        <span class="info">File not found</span>
        
        <div className="home-button">
          <Link to="/">Go To Home</Link>
        </div>
      </div>
    
  );
}

export default PageNotFound
