import React from "react";

export default function ListofPlayers({ players = [] }) {
  return (
    <ul>
      {players.map((player, index) => (
        <li key={index}>
          {player.name} - Score: {player.score}
        </li>
      ))}
    </ul>
  );
}



