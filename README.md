sysctl -w vm.max_map_count=262144



curl -v 'http://localhost:8080/api/payment?fname=Ravi&lname=Soni&amount=25'
curl -v 'http://localhost:8080/api/user/list'