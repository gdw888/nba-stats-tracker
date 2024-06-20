import React, { useState, useEffect } from 'react';
import axiosWithAuth from '../services/axiosWithAuth';

function Remove() {
    const [players, setPlayers] = useState([]);
    const [selectedPlayerId, setSelectedPlayerId] = useState('');

    // Fetch players when the component mounts
    useEffect(() => {
        axiosWithAuth.get(process.env.REACT_APP_API_URL + '/api/active-players')
            .then(response => {
                setPlayers(response.data);
                if (response.data.length > 0) {
                    setSelectedPlayerId(response.data[0].id);
                }
            })
            .catch(error => console.error('There was an error fetching the players!', error));
    }, []);

    const handlePlayerChange = (event) => {
        setSelectedPlayerId(event.target.value);
    };

    const handleRemove = (event) => {
        event.preventDefault();
        if (!selectedPlayerId) {
            console.error('No player selected');
            return;
        }

        axiosWithAuth.delete(`${process.env.REACT_APP_API_URL}/api/active-players/${selectedPlayerId}`)
            .then(() => {
                alert('Player removed successfully');
                // Optionally refresh the list of players
                setPlayers(players.filter(player => player.id !== selectedPlayerId));
            })
            .catch(error => {
              if (error.response && error.response.status === 401) {
                // Specific error handling for 401 Unauthorized
                alert("You don't have permission to remove this player.");
              } else {
                // Generic error handling for all other errors
                alert('Failed to remove a player');
              }
              console.error('Error removing player:', error);
            });
    };

    return (
        <div>
            <h2>Remove Player</h2>
            <form onSubmit={handleRemove}>
                <label>
                    Select Player to Remove:
                    <select value={selectedPlayerId} onChange={handlePlayerChange} required>
                        {players.map(player => (
                            <option key={player.id} value={player.id}>
                                {player.name}
                            </option>
                        ))}
                    </select>
                </label>
                <button type="submit">Remove Player</button>
            </form>
        </div>
    );
}

export default Remove;
