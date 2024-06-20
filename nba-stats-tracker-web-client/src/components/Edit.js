import React, { useState, useEffect } from 'react';
import axiosWithAuth from '../services/axiosWithAuth';

function Edit() {
    const [players, setPlayers] = useState([]);
    const [selectedPlayerName, setSelectedPlayerName] = useState('');
    const [playerUrl, setPlayerUrl] = useState('');

    // Fetch players when the component mounts
    useEffect(() => {
        axiosWithAuth.get(process.env.REACT_APP_API_URL + '/api/active-players')
            .then(response => {
                setPlayers(response.data);
                if (response.data.length > 0) {
                    setSelectedPlayerName(response.data[0].name);
                    setPlayerUrl(response.data[0].url);
                }
            })
            .catch(error => console.error('There was an error fetching the players!', error));
    }, []);

    const handlePlayerChange = (event) => {
        const selectedName = event.target.value;
        const selectedPlayer = players.find(player => player && player.name && player.name === selectedName);

        if (selectedPlayer) {
            setSelectedPlayerName(selectedName);
            setPlayerUrl(selectedPlayer.url);
        } else {
            console.log('Selected player is undefined or missing an Name');
            setPlayerUrl('');
        }
    };

    const handleSubmit = (event) => {
        event.preventDefault();

        axiosWithAuth.put(process.env.REACT_APP_API_URL + '/api/active-player', {
          name: selectedPlayerName,
          url: playerUrl
        })
        .then(response => {
          alert('Player updated successfully');
          console.log('Player updated:', response.data);
        })
        .catch(error => {
          if (error.response && error.response.status === 401) {
            // Specific error handling for 401 Unauthorized
            alert("You don't have permission to update this player.");
          } else {
            // Generic error handling for all other errors
            alert('Failed to update a player');
          }
          console.error('Error updating player:', error);
        });
    };

    return (
        <div>
            <h2>Edit Player URL</h2>
            <form onSubmit={handleSubmit}>
                <label>
                    Select Player:
                    <select value={selectedPlayerName} onChange={handlePlayerChange} required>
                        {players.map(player => (
                            <option key={player.Name} value={player.Name}>
                                {player.name}
                            </option>
                        ))}
                    </select>
                </label>
                <label>
                    Player URL:
                    <input
                        type="text"
                        value={playerUrl}
                        onChange={(e) => setPlayerUrl(e.target.value)}
                        required
                    />
                </label>
                <button type="submit">Update URL</button>
            </form>
        </div>
    );
}

export default Edit;
