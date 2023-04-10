app.controller("product-ctrl", function ($scope,$http){
    
    $scope.items = [];
    $scope.cates =[];
    $scope.form = {};

    $scope.intialize = function(){
		//load product
        $http.get("/rest/products").then(
            resp =>{
                $scope.items = resp.data;
                $scope.items.forEach(item => {
                    item.createDate = new Date(item.createDate)
                })
            })
           
      //load category
      $http.get("/rest/categories").then(
            resp =>{
                $scope.cates = resp.data;
                
            })
    };

    $scope.intialize();

    //reset form
    $scope.reset=function(){
        $scope.form = {
            createDate: new Date(),
            image: 'cloud-upload.jpg',
            available: true
        };
        
    }
//edit product
    $scope.edit = function(item){
       $scope.form = angular.copy(item);
        $(".nav-tabs a:eq(0)").tab('show')
    
    }
    $scope.create = function(){
        var item = angular.copy($scope.form);
        $http.post("/rest/products", item).then(
            resp =>{
                $scope.items.push(resp.data);
                $scope.reset();
                alert("Product created")
            }).catch(err =>{
                alert('Error creating');
                console.log(err);
            })
    }
    $scope.update = function(){
        var item = angular.copy($scope.form);
        $http.put(`/rest/products/${item.id}`, item).then(
            resp =>{
                var index = $scope.items.findIndex(p => p.id === item.id);
                $scope.items[index] = item;
                alert("Product updated")
            }).catch(err =>{
                alert('Error updating');
                console.log("err",err);
            });
        
    }
    $scope.delete = function(item){
       
        $http.delete(`/rest/products/${item.id}`).then(
            resp =>{
                var index = $scope.items.findIndex(p => p.id === item.id);
                $scope.items.splice(index,1);
                alert("Product deleted")
            }).catch(err =>{
                alert('Error deleting');
                console.log(err);
            })
    }
    //upload images
    $scope.imageChanged = function(files){
       var data = new FormData();

       data.append('file', files[0]);
       
       $http.post('/rest/upload/images', data, {
        transformRequest: angular.identity,
        headers: {'Content-Type': undefined}
       }).then(response =>{
        $scope.form.image = response.data.name;
       }).catch(err=>{
        alert('Error uploading');
        console.log(err);
       })
    }
    //phan trang
    $scope.pager = {     
     	page:0,
     	size:10,
     	get items(){
			 
			var start = this.page * this.size; 
			return $scope.items.slice(start,start + this.size); 
		 },
 
        get count(){
            return Math.ceil(1.0*$scope.items.length/this.size)
        },
        first(){
			this.page = 0;
		},
		prev(){
			this.page--;
			if(this.page<0){
				this.last()
			}
		},
		next(){
			this.page++;
		if(this.page >= this.count){
				this.first()
			}
		},
		last(){
			this.page = this.count-1;
		}
        
    }
});











