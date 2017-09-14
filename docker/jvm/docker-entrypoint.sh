#!/bin/bash
set -e

function finish {
	kill $pid
}

trap 'finish' SIGTERM

while true; do
	if [ -f ${JAR_NAME} ]; then
		java -jar ${JAR_NAME} &
	  PID=$!
	fi
  inotifywait -e modify -e delete -e create -e attrib ${JAR_NAME}
	echo "\nRestarting JVM in 10 seconds\n"
	sleep 10
	if [ -f ${JAR_NAME} ]; then
	  kill $PID
	fi
done
pid=$!

wait
