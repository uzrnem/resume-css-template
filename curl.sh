curl -X GET https://example.com/echo -H "Cookie: name=value; name2=value2" #  --cookie "user=username;pass=hack"
curl -X POST https://example.com/echo/post/json   -H 'Content-Type: application/json'   -H 'Accept: application/json'   -d '{"Name": "Bhagyesh", "Age": 22}'
curl -X GET https://example.com/echo -H "Origin: https://example.example.com" 
curl -X POST https://example.com/echo/post/form -H "Content-Type: application/x-www-form-urlencoded" -d "param1=value1&param2=value2"
curl -X GET https://example.com/echo/get/json -H "Accept: application/json" -H "Authorization: Bearer secure.jwt.token" 
curl https://example.com/echo -u "login:password"
curl -o filename.txt https://example.com/echo
curl -H "Origin: http://example.com" --verbose https://www.example.com/# The --verbose flag prints out the entire response with request and response headers.
curl https://example.com/echo -x myproxy.com:8080 -U login:password


#!/bin/bash

arrays=(1 2 3 4)

for item in "${arrays[@]}"
do
   url="https://example.com/order/$item"
   httpCode=$(curl --write-out '%{http_code}' --location --request POST $url)
   echo "$url status code : $httpCode"
done