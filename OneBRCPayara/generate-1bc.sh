#!/bin/bash
tail --lines=+3 data/weather_stations.csv > ../weather_stations.csv-headless
cp data/weather_stations.csv ../weather_stations.csv
# should run to 2300
for i in {1..25000}
do
    echo "${i}/25000"
    cat ../weather_stations.csv-headless >> ../weather_stations.csv
    # wc -l ../weather_stations.csv
done
wc -l ../weather_stations.csv
