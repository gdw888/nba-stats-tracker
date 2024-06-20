import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import { useAuth } from '../AuthContext';

function Login() {
  const [username, setUsername] = useState('');
  const [password, setPassword] = useState('');
  const navigate = useNavigate();
  const { login } = useAuth();

const handleSubmit = async (event) => {
  event.preventDefault();
  try {
    const response = await fetch(process.env.REACT_APP_API_URL+'/auth/login', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify({ username, password }),
    });

    if (response.status === 401) {
      // Handle 401 Unauthorized error
      alert('Unauthorized access. Please check your username and password.');
      return;
    }

    const data = await response.json();
    if (data.token) {
      localStorage.setItem('token', data.token); // Store token in localStorage
      login(username);
      navigate('/');
    } else {
      console.error('Login failed', data.message || 'No error message provided by the server.');
      alert('Login failed: ' + (data.message || 'Please try again later.'));
    }
  } catch (error) {
    console.error('Error:', error);
    alert('An error occurred while processing your login request.');
  }
};


  return (
    <div className="Login">
      <h2>Login</h2>
      <form onSubmit={handleSubmit}>
        <div>
          <label>
            Username:
            <input
              type="text"
              value={username}
              onChange={(e) => setUsername(e.target.value)}
            />
          </label>
        </div>
        <div>
          <label>
            Password:
            <input
              type="password"
              value={password}
              onChange={(e) => setPassword(e.target.value)}
            />
          </label>
        </div>
        <button type="submit">Login</button>
      </form>
    </div>
  );
}

export default Login;
