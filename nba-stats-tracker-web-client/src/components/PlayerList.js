import React, { useState, useEffect } from 'react';
import { Link } from 'react-router-dom';
import axiosWithAuth from '../services/axiosWithAuth';

const PlayerList = () => {
  const [players, setPlayers] = useState([]);

  useEffect(() => {
    axiosWithAuth.get(`${process.env.REACT_APP_API_URL}/api/active-players`)
      .then(response => setPlayers(response.data))
      .catch(error => console.error('There was an error fetching the data!', error));
  }, []);

  return (
    <div>
      <h1>NBA Active Players</h1>
      <ul>
        {players.map(player => (
          <li key={player.name}>
            <Link to={`/player/${player.name}`}>{player.name}</Link>
          </li>
        ))}
      </ul>
    </div>
  );
};

export default PlayerList;
