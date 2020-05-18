<!doctype html>
<!-- update 20200512 
	Front end file with BootStrap support
-->
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

    <title>Upload files</title>
  </head>
  <body>
    <div class="container">
      <div class="row justify-content-md-center">
        <div class="col-sm-4">
          <h1 class="col">Upload files</h1>
        </div>
	  </div>	
      <div class="row">
        <div class="col-sm-4">
          <img src="https://images2.imgbox.com/01/40/FMYCOvKr_o.png" width="75%"/>
        </div>
        <div class="col-sm-4">
		  <form  class="form-inline"  method="POST" action="upload" enctype="multipart/form-data">
		    <div class="form-group">
              <label>File 1: </label>
		      <input type="file" name="file">
			</div>
		    <div class="form-group">
              <label>File 2: </label>
		      <input type="file" name="file">
			</div>
		    <div class="form-group">
              <label>File 3: </label>
		      <input type="file" name="file">
			</div>
			<input type="submit">
		  </form>
        </div>
        <div class="col-sm-4">
          <img src="https://images2.imgbox.com/b5/35/6U1Ksso6_o.jpg" />
        </div>
      </div>
    </div>

    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
  </body>
</html>

