# Photon
 is an image loading library for Android. Photon is easy,fast and light library 

<h2>features</h2>

<ul>
 <li>Image downlaoding</li>
 <li>In Memory Caching</li>
 <li>Disk Caching</li>
</ul>



<h3>Sample App</h3>
<div style="display:inline;width:5px;">
<img src ="https://github.com/mrabelwahed/photon/blob/master/art/device-2019-03-09-141234.png" width="49%" style="display:inline;">
<img src ="https://github.com/mrabelwahed/photon/blob/master/art/device-2019-03-09-141320.png" width="49%" style="display:inline;">
</div>

<h3>How to use Photon </h3>
       
        val imageLoader = ImageLoader.getInstance(this)

        imageLoader.displayImage(URL1,image1)
	


<h3>how to add Photon to your Android Project </h3>

Add it in your root build.gradle at the end of repositories:

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
  
  
Step 2. Add the dependency

	dependencies {
	  dependencies {
	        implementation 'com.github.mrabelwahed:photon:1.0.0'
	  }
	}
	
	
<h3>How to contribute </h3>	
<ul>
<li> fork the repository </li>
<li>create branch and add feature or fix bug</li>
<li> create pull request </li>
</ul>
