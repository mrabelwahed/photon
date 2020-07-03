# Photon
 is an image loading library for Android. Photon is easy,fast and light library 


<h2>features</h2>

<ul>
 <li>Image downloading</li>
 <li>In Memory Caching</li>
 <li>Disk Caching</li>
</ul>



<h3>Sample App</h3>
<div style="display:inline;width:5px;">
<img src ="https://github.com/mrabelwahed/photon/blob/master/art/device-2019-04-06-203503.png"  width="39%"style="display:inline;">
<img src ="https://github.com/mrabelwahed/photon/blob/master/art/device-2019-04-06-203423.png" width="39%" 
       style="display:inline;">
</div>

<h3>How to use Photon </h3>
       
        val imageLoader = Photon.getInstance(this)

        imageLoader.displayImage(URL1,image1 , R.drawable.place_holder)
	
<h3>manage cache </h3>
  
  <h4> setup maximum cache </h4>
  
  
   val cacheSize =4194304 //4MiB
   
   val imageLoader = Photon.getInstance(this  , cacheSize)
   
  <h4> clear cache </h4>
  
   imageLoader.clearcache()
   
   <h4>cancel Loading </h4>
    - to cancel certain image loading task 
   
    imageLoader.cancel(url)
    
  
   -to cancel all tasks
    
    imageLoader.cancelAll()

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
	       implementation 'com.github.mrabelwahed:photon:1.0.3'
	  }
	

	
<h3>How to contribute </h3>	
<ul>
<li> fork the repository </li>
<li>create branch and add feature or fix bug</li>
<li> create pull request </li>
</ul>


	<a href="https://www.buymeacoffee.com/ramadan" target="_blank"><img src="https://cdn.buymeacoffee.com/buttons/default-orange.png" alt="Buy Me A Coffee" style="height: 51px !important;width: 217px !important;" ></a>
