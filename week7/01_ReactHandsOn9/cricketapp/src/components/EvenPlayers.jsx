import React from "react";

export default function EvenPlayers({ players = [] }) {
  return (
    <div>
      {players
        .filter((_, index) => index % 2 === 1)
        .map((player, index) => (
          <div key={index}>Even Player: {player}</div>
        ))}
    </div>
  );
}
