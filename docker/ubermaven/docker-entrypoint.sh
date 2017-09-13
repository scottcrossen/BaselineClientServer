#!/bin/bash

# allow the container to be started with `--user`
if [ "$(id -u)" = '0' ]; then
	chown -R user:user "/home/user"
	exec gosu user "$BASH_SOURCE" "$@"
fi

function finish {
	kill $pid
}

trap 'finish' SIGTERM

cd /app
cat | mvn fizzed-watcher:run clean install &
pid=$!

wait
