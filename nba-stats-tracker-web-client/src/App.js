import React from 'react';
import { BrowserRouter as Router, Route, Routes, Link, useNavigate } from 'react-router-dom';
import './App.css';
import PlayerList from './components/PlayerList';
import Login from './components/Login';
import Add from './components/Add';
import Edit from './components/Edit';
import Remove from './components/Remove';
import PlayerDetails from './components/PlayerDetails'; // Import the new component
import { AuthProvider, useAuth } from './AuthContext';

function Navigation() {
  const { user, logout } = useAuth();
  const navigate = useNavigate(); // Hook to handle navigation

  const handleLogout = (e) => {
    e.preventDefault();
    logout(); // Perform logout operation
    navigate('/'); // Navigate to the home page after logout
  };

  return (
    <div className="nav-container">
      <nav className="nav-bar">
        <Link to="/" className="nav-link">Home</Link>
        {user ? (
          <>
            <a href="#" onClick={handleLogout} className="nav-link">Logout</a>
            <Link to="/add" className="nav-link">Add</Link>
            <Link to="/edit" className="nav-link">Edit</Link>
            <Link to="/remove" className="nav-link">Remove</Link>
          </>
        ) : (
          <Link to="/login" className="nav-link">Login</Link>
        )}
      </nav>
      {user && (
        <p className="welcome-message">Welcome, {user}!</p>
      )}
    </div>
  );
}

function App() {
  return (
    <AuthProvider>
      <Router>
        <div className="App">
          <header className="App-header">
            <Navigation /> {/* Using Navigation component inside the Router and AuthProvider */}
            <Routes>
              <Route path="/" element={<Home />} />
              <Route path="/login" element={<Login />} />
              <Route path="/add" element={<Add />} />
              <Route path="/edit" element={<Edit />} />
              <Route path="/remove" element={<Remove />} />
              <Route path="/player/:playerName" element={<PlayerDetails />} /> {/* New Route */}
            </Routes>
          </header>
        </div>
      </Router>
    </AuthProvider>
  );
}

function Home() {
  return (
    <div>
      <PlayerList />
    </div>
  );
}

export default App;
