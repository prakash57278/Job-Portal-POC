import axios from 'axios';

import { useAuth0 } from '@auth0/auth0-react';
import './App.css';

function App() {
  const {loginWithPopup,loginWithRedirect
    ,logout, user, isLoading, error, getAccessTokenSilently, getIdTokenClaims,isAuthenticated
  } =useAuth0();

  function callApi(){
   axios.get("http://localhost:4000/").then(response=>console.log(response.data))
  }

 async function callProtectedApi(){
  try {
const token = await getAccessTokenSilently();
const response = await  axios.get("http://localhost:4000/",{
  headers: {
    authoriazation:`Bearer ${token}`
}})
  } catch (error) {
    console.log(error.message)
  }
//  axios.get('http://localhost:4000/api/')
//   .then(res => console.log(res.data))
//   .catch(err => console.error(err));
  }
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
       
         <li>
        <button onClick={loginWithRedirect}>Login with Redirect</button>
      </li>
      <li>
        <button onClick={() => logout({ returnTo: window.location.origin })}>
          Logout
        </button>
      </li>
      <li>
        <button onClick={callApi}>Call Api(will work only when backend is deployed)</button>
        <button onClick={callProtectedApi}>Call protected Api(will work only when backend is deployed)</button>
      </li>
        </ul>
        <h3> User is {isAuthenticated?"Logged in":"Not logged in"}</h3>
        {isAuthenticated&&(<pre style={{textAlign:'Start'}}>
          {JSON.stringify(user, null ,2)}
        </pre>)}
      </header>
    </div>
  );
}

export default App;
