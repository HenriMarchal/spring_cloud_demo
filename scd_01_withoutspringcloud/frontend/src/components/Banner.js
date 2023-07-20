import React from 'react'
import logo from '../assets/logo.png'
import '../styles/Banner.css'

function Banner() {
	const title = 'Spring Cloud Demo'
	return (
		<div className='lmj-banner'>
			<img src={logo} alt='Spring Cloud Demo' className='lmj-logo' />
			<h1 className='lmj-title'>{title}</h1>
		</div>
	)
}

export default Banner
