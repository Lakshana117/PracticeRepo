import React from "react";

export default function ListofIndianPlayers({ IndianPlayers = [] }) {
  return (
    <ul>
      {IndianPlayers.map((player, index) => (
        <li key={index}>{player}</li>
      ))}
    </ul>
  );
}

