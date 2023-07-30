import React, { useState, useEffect } from 'react'
import { Dropdown } from 'semantic-ui-react'

import Banner from './Banner'
import '../styles/App.css'

var resp = {}

function handleClick(lang) {
  const xhr = new XMLHttpRequest()
  
  xhr.open('GET', 'http://192.168.1.60:9090/' + lang)
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
  const [freq, setFreq] = useState(500)

  useEffect(() => {
    const xhr1 = new XMLHttpRequest()
    const arr = []
    
    xhr1.open('GET', 'http://192.168.1.60:9090/')
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
  }, [])

  const [count, setCount] = useState(0)
  useEffect(() => {
    const xhr2 = new XMLHttpRequest()
    const timer = setTimeout(() => {
      setCount((count) => count + 1)
    }, freq)

    var timeElapsed = Date.now()
    xhr2.open('GET', 'http://192.168.1.60:8080/')
    xhr2.onload = function() {
      if (xhr2.status === 200) {
        timeElapsed -= Date.now()
        var notOK = ''
        if (timeElapsed < -1000) {
          notOK = 'NOT OK'
        }
        resp = xhr2.responseText
        document.getElementById("loadTest").innerHTML = 'Web service: ' + resp + ' and ' + count + ' times at speed: ' + (-timeElapsed) + ' <b style="color:red;">' + notOK + '</b>'
      }
    }
    xhr2.send()

    return () => clearTimeout(timer)
  })
  
  
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
      <div>
        <input
          type="number" 
          value={freq}
          onChange={(e) => setFreq(e.target.value)}
        />
        <span> millisecond a time</span>
      </div>
      <div id='loadTest'>OK</div>
    </div>
  )
}
export default App


