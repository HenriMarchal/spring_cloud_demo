import React, { useState, useEffect } from 'react'
import { Dropdown } from 'semantic-ui-react'

import Banner from './Banner'
import '../styles/App.css'

var resp = {}

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

function App() {
  const [lang, setLang] = useState('')
  const [langOptions, setLangOptions] = useState([])

  useEffect(() => {
    const xhr = new XMLHttpRequest()
    const arr = []
    
    xhr.open('GET', 'http://localhost:9090/')
    xhr.onload = function() {
      if (xhr.status === 200) {
        resp = JSON.parse(xhr.responseText)
        //resp = xhr.responseText
        resp.map((greeting) => {
          return arr.push({key: greeting, text: greeting, value: greeting})
        });
        setLangOptions(arr)
      }
    }
    xhr.send()
  }, [])
  
  
  return (
    <div>
      <Banner/>
      <p>Greeting for</p>
      <div id='dropdownLang'>
        <Dropdown selection placeholder='Select Language'
        value={lang} options={langOptions} onChange={(event) => setLang(event.target.innerText)}
        />
      </div>
      <button onClick={() => handleClick(lang)}>Get Greeting</button>
      <div id='greeting_result'>'Waiting...'</div>
    </div>
  )
}
export default App


