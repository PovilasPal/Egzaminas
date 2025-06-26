import { Link, useNavigate } from "react-router-dom";
import { clearAuth } from "../api/api";

export default function NavBar({ isLoggedIn, onLogout }) {
  const navigate = useNavigate();

  const handleLogout = () => {
    clearAuth();
    onLogout();
    navigate("/login");
  };

  return (
    <nav className="fixed top-0 left-0 w-full bg-gradient-to-r from-blue-800 to-blue-900 shadow-lg z-50">
      <div className="container mx-auto px-6 py-4 flex justify-between items-center">
        <Link
          to="/"
          className="text-white text-2xl font-extrabold hover:text-blue-300 transition"
        >
          ManoApp
        </Link>

        <div className="flex items-center space-x-6">
          <Link
            to="/"
            className="text-white font-semibold hover:text-blue-300 transition"
          >
            Pagrindinis
          </Link>

          {isLoggedIn ? (
            <button
              onClick={handleLogout}
              className="bg-red-600 hover:bg-red-700 text-white font-semibold px-4 py-2 rounded-md shadow-md transition"
            >
              Atsijungti
            </button>
          ) : (
            <Link
              to="/login"
              className="bg-blue-600 hover:bg-blue-700 text-white font-semibold px-4 py-2 rounded-md shadow-md transition"
            >
              Prisijungti
            </Link>
          )}
        </div>
      </div>
    </nav>
  );
}
