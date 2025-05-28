
import { useAuth0 } from '@auth0/auth0-react';
import './App.css';

function App() {
  const {loginWithPopup,loginWithRedirect
    ,logout, user, isLoading, error, getAccessTokenSilently, getIdTokenClaims,isAuthenticated
  } =useAuth0();
  return (
    <div className="App">
      <header className="App-header">
       
        <p>
          Auth with Auth0
        </p>
        <ul>
          <li>
            <button onClick={loginWithPopup}>Login with popups</button>
          </li>
        </ul>
         <li>
        <button onClick={loginWithRedirect}>Login with Redirect</button>
      </li>
      <li>
        <button onClick={() => logout({ returnTo: window.location.origin })}>
          Logout
        </button>
      </li>
       
      </header>
    </div>
  );
}

export default App;
