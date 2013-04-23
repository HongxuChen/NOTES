#!/bin/bash

MAX=20

for (( i = 0; i < $MAX; i++ )); do
  SPC=$(($MAX-$i))
  printf "=%${i}s"|tr " " "="
  printf ">%${SPC}s%3s|"
  printf $(bc <<< "scale=2;100*$i/$MAX")
  printf "\r"
  sleep 0.1
done
