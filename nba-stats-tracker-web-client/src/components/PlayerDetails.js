import React, { useState, useEffect } from 'react';
import { useParams } from 'react-router-dom';
import axiosWithAuth from '../services/axiosWithAuth';
import './PlayerDetails.css'; // Import the CSS file

const PlayerDetails = () => {
  const { playerName } = useParams();
  const [playerInfo, setPlayerInfo] = useState(null);
  const [playerStats, setPlayerStats] = useState([]);

  useEffect(() => {
    axiosWithAuth.get(`${process.env.REACT_APP_API_URL}/api/nba-players/${playerName}`)
      .then(response => setPlayerInfo(response.data))
      .catch(error => console.error('There was an error fetching the player info!', error));

    axiosWithAuth.get(`${process.env.REACT_APP_API_URL}/api/nba-player-stats/${playerName}`)
      .then(response => setPlayerStats(response.data))
      .catch(error => console.error('There was an error fetching the player stats!', error));
  }, [playerName]);

  if (!playerInfo) return <div>Loading...</div>;

  return (
    <div>
      <h1>{playerInfo.playerName}</h1>
      <p>Birth Date: {playerInfo.birthDate}</p>
      <p>Birth Year: {playerInfo.birthYear}</p>

      <h2>Statistics</h2>
      <table className="stats_table fill">
        <thead>
          <tr>
            <th>Date</th>
            <th>Team</th>
            <th>Opponent</th>
            <th>Points</th>
            <th>Assists</th>
            <th>Blocks</th>
            <th>Defensive Rebounds</th>
            <th>Field Goals</th>
            <th>Field Goal Attempts</th>
            <th>Field Goal Percentage</th>
            <th>Free Throws</th>
            <th>Free Throw Attempts</th>
            <th>Free Throw Percentage</th>
            <th>Game Score</th>
            <th>Minutes Played</th>
            <th>Offensive Rebounds</th>
            <th>Personal Fouls</th>
            <th>Plus Minus</th>
            <th>Result</th>
            <th>Steals</th>
            <th>Three Point Field Goals</th>
            <th>Three Point Field Goal Attempts</th>
            <th>Three Point Field Goal Percentage</th>
            <th>Total Rebounds</th>
            <th>Turnovers</th>
          </tr>
        </thead>
        <tbody>
          {playerStats.map((stat, index) => (
            <tr key={index}>
              <td>{stat.date}</td>
              <td>{stat.team}</td>
              <td>{stat.opponent}</td>
              <td>{stat.points}</td>
              <td>{stat.assists}</td>
              <td>{stat.blocks}</td>
              <td>{stat.defensiveRebounds}</td>
              <td>{stat.fieldGoals}</td>
              <td>{stat.fieldGoalAttempts}</td>
              <td>{stat.fieldGoalPercentage}</td>
              <td>{stat.freeThrows}</td>
              <td>{stat.freeThrowAttempts}</td>
              <td>{stat.freeThrowPercentage}</td>
              <td>{stat.gameScore}</td>
              <td>{stat.minutesPlayed}</td>
              <td>{stat.offensiveRebounds}</td>
              <td>{stat.personalFouls}</td>
              <td>{stat.plusMinus}</td>
              <td>{stat.result}</td>
              <td>{stat.steals}</td>
              <td>{stat.threePointFieldGoals}</td>
              <td>{stat.threePointFieldGoalAttempts}</td>
              <td>{stat.threePointFieldGoalPercentage}</td>
              <td>{stat.totalRebounds}</td>
              <td>{stat.turnovers}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default PlayerDetails;
