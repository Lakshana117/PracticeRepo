import React from "react";

export default function OddPlayers({ players = [] }) {
  return (
    <div>
      {players
        .filter((_, index) => index % 2 === 0)
        .map((player, index) => (
          <div key={index}>Odd Player: {player}</div>
        ))}
    </div>
  );
}

