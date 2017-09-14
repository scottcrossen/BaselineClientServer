#!/bin/bash
set -e

function finish {
	kill $pid
}

trap 'finish' SIGTERM

failed="0"
java -jar app/target/${JAR_NAME} &
pid=$!

wait
