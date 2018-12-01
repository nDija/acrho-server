docker run --name mongotest -p 127.0.0.1:27017:27017 -p 127.0.0.1:28017:28017 -d mongo
docker exec -it api bash

//TODO: use compose, configure database host port
//TODO: configure env

