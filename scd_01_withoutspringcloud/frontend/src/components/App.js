import React, { useState } from 'react'

import Banner from './Banner'
import '../styles/App.css'

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
  const xhr = new XMLHttpRequest()
  
  xhr.open('GET', 'http://localhost:9090/' + lang)
  xhr.onload = function() {
    if (xhr.status === 200) {
      resp = JSON.parse(xhr.responseText)
      document.getElementById("greeting_result").innerHTML = resp.greeting
    }
  };
  xhr.send();
}

function Main() {
  const [lang, setLang] = useState('')
  
  return (
    <div>
      <Banner/>
      <p>Greeting for</p>
      <div id='dropdownLang'>
        <select placeholder='Select language' value={lang} onChange={event => setLang(event.target.value)}>
          {friendOptions.map(option => (
            <option key={option.key} value={option.value}>
              {option.text}
            </option>
          ))}
        </select>
      </div>
      <button onClick={() => handleClick(lang)}>Get Greeting</button>
      <div id='greeting_result'>'Waiting...'</div>
    </div>
  )
}
export default Main
