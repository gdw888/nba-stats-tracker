import React, { useState } from 'react';
import axiosWithAuth from '../services/axiosWithAuth';

function Add() {
  const [playerName, setPlayerName] = useState('');
  const [playerUrl, setPlayerUrl] = useState('');

  const handleSubmit = (event) => {
    event.preventDefault();

    console.log('Adding Player:', playerName, playerUrl);

    axiosWithAuth.post(process.env.REACT_APP_API_URL + '/api/active-player', {
      name: playerName,
      url: playerUrl
    })
    .then(response => {
      alert('Player added successfully');
      // Reset state to clear the form
      setPlayerName('');
      setPlayerUrl('');
    })
    .catch(error => {
      if (error.response && error.response.status === 401) {
        // Specific error handling for 401 Unauthorized
        alert("You don't have permission to add this player.");
      } else {
        // Generic error handling for all other errors
        alert('Failed to add a player');
      }
      console.error('Error adding player:', error);
    });
  };

  return (
    <div>
      <h2>Add New Player</h2>
      <form onSubmit={handleSubmit}>
        <label>
          Player Name:
          <input
            type="text"
            value={playerName}
            onChange={(e) => setPlayerName(e.target.value)}
            required
          />
        </label>
        <label>
          Reference URL:
          <input
            type="text"
            value={playerUrl}
            onChange={(e) => setPlayerUrl(e.target.value)}
            required
          />
        </label>
        <button type="submit">Add Player</button>
      </form>
    </div>
  );
}

export default Add;
