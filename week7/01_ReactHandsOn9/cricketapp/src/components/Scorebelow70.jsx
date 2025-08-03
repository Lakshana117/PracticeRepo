import React from "react";

export default function Scorebelow70({ players = [] }) {
  return (
    <ul>
      {players
        .filter((player) => player.score < 70)
        .map((player, index) => (
          <li key={index}>
            {player.name} - Score: {player.score}
          </li>
        ))}
    </ul>
  );
}

