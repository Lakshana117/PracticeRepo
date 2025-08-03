import React from 'react';
import officeImg from './office.jpg'; // make sure office.jpg is in src/

function App() {
  const itemName = {
    Name: "DBS",
    Rent: 50000,
    Address: "Chennai"
  };

  return (
    <div>
      <h1>Office Space, at Affordable Range</h1>
      <img
        src={officeImg}
        alt="Office Space"
        width="25%"
        height="25%"
      />
      <h1>Name: {itemName.Name}</h1>
      <h3 style={{ color: itemName.Rent <= 60000 ? "red" : "green" }}>
        Rent: Rs. {itemName.Rent}
      </h3>
      <h3>Address: {itemName.Address}</h3>
    </div>
  );
}

export default App;


