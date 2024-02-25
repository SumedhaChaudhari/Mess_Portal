import React from 'react'


const Footerr = () => {
    return (
    
<footer style={styles.footer}>
      <p>&copy; 2024 Happy Meal Mess Portal</p>
    </footer>
  );
};

const styles = {
  footer: {
    backgroundColor: 'black',
    color: '#fff',
    padding: '10px',
    textAlign: 'center',
    position: 'fixed',
    bottom: '0',
    width: '100%',
  },
};


export default Footerr

