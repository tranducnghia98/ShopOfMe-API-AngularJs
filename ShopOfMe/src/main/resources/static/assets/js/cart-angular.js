const app = angular.module("app", []);

app.controller("ctrl", function ($scope, $http) {



    $scope.cart = {
        items: [],
        //create
        add(id) {
            /* alert(id)*/
            var item = this.items.find(item => item.id === id);
            if (item) {
                item.quantity++;
                this.saveToLocalStorage();
            } else {
                $http.get(`/rest/products/${id}`).then(response => {
                    response.data.quantity = 1;
                    this.items.push(response.data);
                    this.saveToLocalStorage();
                }
                )
            }
        },
        //delete
        remove(id) { 
            var index = this.items.findIndex(item => item.id == id);
            this.items.splice(index, 1);
            this.saveToLocalStorage();
        },
        //clear
        clear() { 
            this.items = [];
            this.saveToLocalStorage();
        },
        //total a product
        amt_of(item) { },
        // total product in cart
        get count() {
            return this.items
            .map(item => item.quantity)
            .reduce((total, quantity) => total += quantity,0);
         },
        //total price
        get amount() { 
            return this.items
            .map(item => item.quantity*item.price)
            .reduce((total, quantity) => total += quantity,0);
        },
        //save cart in local storage
        saveToLocalStorage() { 
            var json = JSON.stringify(angular.copy(this.items));
            localStorage.setItem("cart",json);
        },
        //read cart in local storage
        loadFromLocalStorage() {
            var json = localStorage.getItem("cart");
            this.items = json ? JSON.parse(json):[];
        }
    }
    $scope.cart.loadFromLocalStorage();

    $scope.order ={
        
        createDate: new Date(),
        address:"",
        account:{username:$("#username").text()},
        get orderDetails(){
            return $scope.cart.items.map(item =>{
                return {
                    product:{id:item.id},
                    quantity:item.quantity,
                    price:item.price
                }
            });
           
        },
        purchase(){
            var order= angular.copy(this);
            //order
            $http.post("/rest/orders",order).then(response =>{
                alert("Purchase successful");
                $scope.cart.clear();
                location.href = "/order/detail/"+response.data.id;
            }).catch(error =>{
                alert(error);
                console.log(error);
            });

        }
    }
})