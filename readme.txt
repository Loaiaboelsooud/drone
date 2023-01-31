post request to create new drone  "http://localhost:8080/drone/init/100" 100 is the drone weight

post request to create new medication and loaded to a drone "http://localhost:8080/medication/load?name=test1&weight=30&code=120"

get request to find all drones "http://localhost:8080/drone/findAll"

get request to get drone battery level with serial number "http://localhost:8080/drone/1/battery" 1 is the drone serial number

get request to get available drones "http://localhost:8080/drone/available"

get request to get medications loaded to certain drone "http://localhost:8080/drone/2/medications" 2 is the drone serial number


Design assumptions

Drone trip takes exactly 25 minutes each 5 minutes the drone states is updated and the battery capacity also is decreased by 5% each 5 minutes by Scheduled task
Drone is recharged if it is in idle status by sechduled task


