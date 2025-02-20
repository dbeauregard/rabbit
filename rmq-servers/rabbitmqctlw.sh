#!/bin/bash

if [ "$#" -lt 2 ]; then
    echo "Usage: $0 <Server Number> <arg2> [optional more args...]"
    exit 1
fi

echo "Running rabbitmqctl against RMQ Server# $1"
export RABBITMQ_CONF_ENV_FILE="/Users/dbeauregard/Workspace/rabbit/rmq-servers/rabbitmq$1-env.conf"
echo "Config File: $RABBITMQ_CONF_ENV_FILE"

shift
echo "args" $@
/opt/homebrew/opt/rabbitmq/sbin/rabbitmqctl $@