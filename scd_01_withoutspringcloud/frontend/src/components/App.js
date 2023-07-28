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
      resp = xhr.responseText
      document.getElementById("greeting_result").innerHTML = resp
    }
  };
  xhr.send();
}

function App() {
  const [lang, setLang] = useState('')
  const [langOptions, setLangOptions] = useState([])

  useEffect(() => {
    const xhr1 = new XMLHttpRequest()
    const xhr2 = new XMLHttpRequest()
    const arr = []
    
    xhr1.open('GET', 'http://localhost:9090/')
    xhr1.onload = function() {
      if (xhr1.status === 200) {
        resp = JSON.parse(xhr1.responseText)
        //resp = xhr.responseText
        resp.map((greeting) => {
          return arr.push({key: greeting, text: greeting, value: greeting})
        });
        setLangOptions(arr)
      }
    }
    xhr1.send()
    
    xhr2.open('GET', 'http://localhost:8080/')
    xhr2.onload = function() {
      if (xhr2.status === 200) {
        resp = xhr2.responseText
        document.getElementById("loadTest").innerHTML = resp
      }
    }
    xhr2.send()
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

      <p>_________________________________________________</p>
      <p>Load test</p>
      <div> - 1 per second +</div><div id='loadTest'>OK</div>
    </div>
  )
}
export default App


