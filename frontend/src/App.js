import React from 'react';
import { BrowserRouter as Router, Route, Routes, Link, useNavigate } from 'react-router-dom';
import './App.css';
import PlayerList from './components/PlayerList';
import Login from './components/Login';
import { AuthProvider, useAuth } from './AuthContext';

function Home() {
  const navigate = useNavigate();
  const { user, logout } = useAuth();

  return (
    <div>
      <PlayerList />
      {user ? (
        <div>
          <p>Welcome, {user}!</p>
          <button onClick={logout}>Logout</button>
        </div>
      ) : (
        <button onClick={() => navigate('/login')}>Login</button>
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
            <nav>
              <Link to="/">Home</Link>
              <Link to="/login">Login</Link>
            </nav>
            <Routes>
              <Route path="/" element={<Home />} />
              <Route path="/login" element={<Login />} />
            </Routes>
          </header>
        </div>
      </Router>
    </AuthProvider>
  );
}

export default App;
