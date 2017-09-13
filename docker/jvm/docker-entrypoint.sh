#!/bin/bash
set -e

function finish {
	kill $pid
}

trap 'finish' SIGTERM

failed="0"
while [ $failed -lt 10 ]; do echo "Restarting JVM..."; java -jar app/target/*.jar || failed=$[$failed+1]; sleep 15; done &
pid=$!

wait
