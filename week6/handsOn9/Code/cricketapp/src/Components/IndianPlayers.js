import React from 'react';

const T20players = ['Rohit', 'Kohli', 'Gill', 'Pant', 'Hardik'];
const RanjiTrophyPlayers = ['Jadeja', 'Rahane', 'Pujara', 'Sundar'];

const mergedPlayers = [...T20players, ...RanjiTrophyPlayers];

const IndianPlayers = () => {
  const oddPlayers = mergedPlayers.filter((_, index) => index % 2 !== 0);
  const evenPlayers = mergedPlayers.filter((_, index) => index % 2 === 0);

  return (
    <div>
      <h2>Odd Players</h2>
      <ul>
        {oddPlayers.map((player, index) => (
          <li key={index}>{player}</li>
        ))}
      </ul>

      <h2>Even Players</h2>
      <ul>
        {evenPlayers.map((player, index) => (
          <li key={index}>{player}</li>
        ))}
      </ul>

      <h2>List of Indian Players Merged:</h2>
      <ul>
        {mergedPlayers.map((player, index) => (
          <li key={index}>Mr. {player}</li>
        ))}
      </ul>
    </div>
  );
};

export default IndianPlayers;
