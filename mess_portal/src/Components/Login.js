import React, { useState } from 'react';

const Login = () => {
  const [selectedOption, setSelectedOption] = useState(null);

  const handleOptionClick = (option) => {
    setSelectedOption(option);
  };

  const handleFormSubmit = (e) => {
    e.preventDefault();
    // Add your form submission logic here
  };

  const renderLoginForm = () => {
    return (
      <form onSubmit={handleFormSubmit}>
        <div className="form-group">
          <label htmlFor="username">Username:</label>
          <input type="text" className="form-control" id="username" name="username" required />
        </div>
        <div className="form-group">
          <label htmlFor="password">Password:</label>
          <input type="password" className="form-control" id="password" name="password" required />
        </div>
        <button type="submit" className="btn btn-primary">
          Submit 
        </button>
      </form>
    );
  };

  return (
    <div className="container mt-5">
      <div className="row">
        <div className="col-md-6 offset-md-3">
          <div className="btn-group btn-block">
            <button
              type="button"
              className={`btn btn-primary ${selectedOption === 'Vendor' ? 'active' : ''}`}
              onClick={() => handleOptionClick('Vendor')}
            >
              Login as Vendor
            </button>
            <button
              type="button"
              className={`btn btn-secondary ${selectedOption === 'Customer' ? 'active' : ''}`}
              onClick={() => handleOptionClick('Customer')}
            >
              Login as Customer
            </button>
          </div>

          {selectedOption && renderLoginForm()}
        </div>
      </div>
    </div>
  );
};

export default Login;
