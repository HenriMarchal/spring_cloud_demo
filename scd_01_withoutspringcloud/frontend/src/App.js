import React, { useState } from 'react'
import { Dropdown } from 'semantic-ui-react'

import './App.css';

//TODO retrieve from database
const friendOptions = [
  {
    key: 'en',
    text: 'en',
    value: 'en',
  },
  {
    key: 'de',
    text: 'de',
    value: 'de',
  },
  {
    key: 'es',
    text: 'es',
    value: 'es',
  },
]
var resp = ''

function handleClick(lang) {
  const xhr = new XMLHttpRequest();
  xhr.open('GET', 'http://localhost:9090/' + lang)
  xhr.onload = function() {
    if (xhr.status === 200) {
      resp = JSON.parse(xhr.responseText)
      document.getElementById("greeting_result").innerHTML = resp.greeting;
    }
  };
  xhr.send();
}

function Main() {
  const [lang, setLang] = useState('')
  
  return (
    <div>
      <p>Greeting for</p>
      <div id='dropdownLang'>
        <Dropdown
          value={lang}
          placeholder='Select language'
          fluid
          selection
          options={friendOptions}
          onChange={(e) => setLang(e.target.innerText)}
        />
      </div>
      <button onClick={() => handleClick(lang)}>Get Greeting</button>
      <div id='greeting_result'>'Waiting...'</div>
    </div>
  )
}
export default Main
