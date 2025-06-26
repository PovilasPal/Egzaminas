import { useState } from "react";
import api, { setAuth, clearAuth } from "../api/api";

export default function Login({ onLoginSuccess }) {
  const [credentials, setCredentials] = useState({ username: "", password: "" });
  const [error, setError] = useState("");

  const handleChange = (e) => {
    setCredentials({ ...credentials, [e.target.name]: e.target.value });
    setError("");
  };

  const handleLogin = async (e) => {
    e.preventDefault();
    try {
      setAuth(credentials.username, credentials.password);
      await api.get("/login/client");
      alert("Login successful!");
      onLoginSuccess();
    } catch (err) {
      clearAuth();
      setError("Login failed: " + (err.response?.data || err.message));
    }
  };

  return (
    <div className="min-h-screen flex items-center justify-center bg-gray-100 p-4">
      <form
        onSubmit={handleLogin}
        className="bg-white p-8 rounded shadow-md w-full max-w-sm"
      >
        <h2 className="text-2xl font-bold mb-6 text-center">Login</h2>

        <label htmlFor="username" className="block mb-2 font-medium text-gray-700">
          Slapyvardis
        </label>
        <input
          id="username"
          name="username"
          value={credentials.username}
          onChange={handleChange}
          placeholder="Username"
          required
          className="w-full px-4 py-2 mb-4 border border-gray-300 rounded focus:outline-none focus:ring-2 focus:ring-blue-500"
        />

        <label htmlFor="password" className="block mb-2 font-medium text-gray-700">
          Slaptažodis
        </label>
        <input
          id="password"
          name="password"
          type="password"
          value={credentials.password}
          onChange={handleChange}
          placeholder="Password"
          required
          className="w-full px-4 py-2 mb-6 border border-gray-300 rounded focus:outline-none focus:ring-2 focus:ring-blue-500"
        />

        {error && <p className="text-red-600 mb-4 text-center">{error}</p>}

        <button
          type="submit"
          className="w-full bg-blue-600 text-white py-2 rounded hover:bg-blue-700 transition"
        >
          Prisijungti
        </button>
      </form>
    </div>
  );
}
