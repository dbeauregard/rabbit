#!/bin/bash

if [ "$#" -ne 1 ]; then
    echo "Usage: $0 <Server Number>"
    exit 1
fi

echo "Starting RabbitMQ Server# $1"
export RABBITMQ_CONF_ENV_FILE="/Users/dbeauregard/Workspace/rabbit/rmq-servers/rabbitmq$1-env.conf"
echo "Config File: $RABBITMQ_CONF_ENV_FILE"

/opt/homebrew/opt/rabbitmq/sbin/rabbitmq-server