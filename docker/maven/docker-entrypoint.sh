#!/bin/bash

function finish {
	kill $pid
}

trap 'finish' SIGTERM

cd /app
cat | mvn clean install fizzed-watcher:run &
pid=$!

wait
