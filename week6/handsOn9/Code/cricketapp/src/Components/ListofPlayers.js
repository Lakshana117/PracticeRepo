import React from 'react';

const players = [
  { name: 'Virat', score: 100 },
  { name: 'Rohit', score: 0 },
  { name: 'Dhoni', score: 100 },
  { name: 'Rahul', score: 100 },
  { name: 'Hardik', score: 100 },
  { name: 'Jadeja', score: 70 },
  { name: 'Shami', score: 60 },
  { name: 'Bumrah', score: 55 },
  { name: 'Gill', score: 73 },
  { name: 'Sudharshan', score: 60 },
  { name: 'Surya', score: 40 },
];

const ListOfPlayers = () => {
  const lowScorers = players.filter(player => player.score < 70);

  return (
    <div>
      <h2>List of Players</h2>
      <ul>
        {players.map((player, i) => (
          <li key={i}>Mr. {player.name} {player.score}</li>
        ))}
      </ul>

      <h2>List of Players having Scores Less than 70</h2>
      <ul>
        {lowScorers.map((player, i) => (
          <li key={i}>Mr. {player.name} {player.score}</li>
        ))}
      </ul>
    </div>
  );
};

export default ListOfPlayers;
