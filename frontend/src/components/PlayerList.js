import React, { useState, useEffect } from 'react';
import axios from 'axios';

const PlayerList = () => {
  const [players, setPlayers] = useState([]);

  useEffect(() => {
    axios.get('http://localhost:8080/api/players')//.get('http://18.223.10.154:8080/api/players')
      .then(response => setPlayers(response.data))
      .catch(error => console.error('There was an error fetching the data!', error));
  }, []);

  return (
    <div>
      <h1>NBA Active Players</h1>
      <ul>
        {players.map(player => (
          <li key={player.name}>
            <a href={player.url} target="_blank" rel="noopener noreferrer">{player.name}</a>
          </li>
        ))}
      </ul>
    </div>
  );
};

export default PlayerList;
